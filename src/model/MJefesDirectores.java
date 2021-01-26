package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MJefesDirectores {

    private final Connection conexion;

    public MJefesDirectores(Connection conexion) {
        this.conexion = conexion;
    }

    // Funciones necesarias
    public void obtenerUnidades(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM unidades ORDER BY nombreu ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombreu"));
            }
        } catch (Exception ex) {

        }
    }

    //Funcion para buscar el codigo
    private String busquedaUnidad(String nombreu) {

        String SQL = "SELECT codunidades FROM unidades WHERE nombreu = '" + nombreu + "'";
        try {
            String codigou = "";
            Statement consultaCodigo = this.conexion.createStatement();
            ResultSet resultado = consultaCodigo.executeQuery(SQL);
            resultado.next();
            return codigou = resultado.getString("codunidades");
        } catch (Exception e) {

        }
        return null;
    }

    public void insertarDatosJefesDirectores(int cedula, String nombre, char tipoe, String nombreu, String password) {

        try {
            //Primero hacemos una busqueda del codigo para insertar

            String codigou = busquedaUnidad(nombreu);

            //Luego de conseguir el codigo insertamos en la tabla de empleados
            String SQL = "INSERT INTO empleados(cedula,nombre,tipoe,codunidades,password) VALUES (?,?,?,?,?)";
            PreparedStatement consultaInsercion = this.conexion.prepareStatement(SQL);
            consultaInsercion.setInt(1, cedula);
            consultaInsercion.setString(2, nombre);
            consultaInsercion.setString(3, String.valueOf(tipoe));
            consultaInsercion.setString(4, codigou);
            consultaInsercion.setString(5, password);
            consultaInsercion.execute();

            String subSQL;

            if (tipoe == 'J') { //si es J se inserta como jefe
                subSQL = "INSERT INTO jefes (fichaj) VALUES (?)";
                consultaInsercion = this.conexion.prepareStatement(subSQL);
                consultaInsercion.setInt(1, cedula);
                consultaInsercion.execute();
                JOptionPane.showMessageDialog(null, "Se ha insertado el empleado Jefe de unidad ", "Accion Realizada", JOptionPane.INFORMATION_MESSAGE);
            } else if (tipoe == 'D') { //si es D se inserta como director
                subSQL = "INSERT INTO directores (fichad) VALUES (?)";
                consultaInsercion = this.conexion.prepareStatement(subSQL);
                consultaInsercion.setInt(1, cedula);
                consultaInsercion.execute();
                JOptionPane.showMessageDialog(null, "Se ha insertado el empleado director financiero", "Accion Realizada", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro del empleado: " + e.getMessage(), "Accion no Realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDatosJefeDirectores(int cedula, String nombre, String nombreu, String password) {
        try {
            //Realizamos busqueda del codigo de la unidad

            String codigou = this.busquedaUnidad(nombreu);

            //Seguimos con la actualizacion de la tabla
            String SQL = "UPDATE empleados SET nombre=?,codunidades=?,password =? WHERE cedula=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, nombre);
            consulta.setString(2, codigou);
            consulta.setString(3, password);
            consulta.setInt(4, cedula);

            consulta.execute();

            JOptionPane.showMessageDialog(null, "Empleado actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Fallo de la actualizacion del empleado :" + e.getMessage(), "Accion no Realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrarDatosJefesDirectores(char tipo) {
        String[] titulos = {" Cedula ", " Nombre Empleado ", " Unidad Perteneciente ", "password"};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT e.cedula,e.nombre,u.nombreu,e.password "
                + "FROM empleados AS e,unidades AS u "
                + "WHERE e.tipoe='" + tipo + "' AND e.codunidades=u.codunidades "
                + "ORDER BY e.cedula ";

        try {
            Statement consulta = this.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("cedula");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("nombreu");
                registros[3] = resultados.getString("password");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;

    }

    public void eliminarJefeDirector(int cedula, char tipo) {
        String SQL = "";
        if (tipo == 'J') {
            SQL = "DELETE FROM jefes WHERE fichaj=?";
        } else if (tipo == 'D') {
            SQL = "DELETE FROM directores WHERE fichad=?";
        }
        try {
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            consulta.setInt(1, cedula);
            consulta.executeUpdate();

            SQL = "DELETE FROM empleados WHERE cedula=?";
            consulta = conexion.prepareStatement(SQL);
            consulta.setInt(1, cedula);
            consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Jefe Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);

        }
    }

    public DefaultTableModel filtrarDatos(String valor, char tipo) {
        String[] titulos = {" Cedula ", " Nombre empleado ", " Unidad Perteneciente ", "password"};
        String[] registros = new String[4];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT e.cedula,e.nombre,u.nombreu,e.password "
                + "FROM empleados AS e,unidades AS u "
                + "WHERE e.tipoe='" + tipo + "' AND e.codunidades=u.codunidades "
                + "AND nombre LIKE '%"+valor+"%'"
                + "ORDER BY e.cedula ";
        try {
            Statement consulta = conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("cedula");
                registros[1] = resultados.getString("nombre");
                registros[2] = resultados.getString("nombreu");
                registros[3] = resultados.getString("password");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos " + e.getMessage());
        }
        return tabla;
    }
    
    public  boolean ingresarJefeDirector(int cedula,String password){
        
        String SQL = "SELECT password FROM empleados WHERE cedula='"+cedula+"'";
        
        try{
            Statement consulta = conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            String pass = resultados.getString("password");
            String desencriptado = SecurityKey.Desencriptar(pass);
            
            if(desencriptado.equals(password)){
                return true;
            }
        }catch(SQLException | NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error al ingresar al sistema " + e.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(MJefesDirectores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public String ConsultarJefeDirector(int cedula){
        String SQL = "SELECT nombre FROM empleados WHERE cedula='"+cedula+"'";
        String nombre = "";
        try{
            Statement consulta = conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            nombre = resultados.getString("nombre");
            return nombre;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al ingresar al sistema " + e.getMessage(),"",JOptionPane.ERROR_MESSAGE);
        }
        return nombre;
    }
    

}
