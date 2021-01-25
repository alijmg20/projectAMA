package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

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
    
    public void insertarDatosJefesDirectores(int cedula, String nombre, char tipoe, String nombreu,String password) {

        try {
            //Primero hacemos una busqueda del codigo para insertar
            
            String SQL = "SELECT codunidades FROM unidades WHERE nombreu = '"+nombreu+"'";
            Statement consultaCodigo = this.conexion.createStatement();
            ResultSet resultado = consultaCodigo.executeQuery(SQL);
            System.out.println(resultado.toString());
            resultado.next();
            String codigou = resultado.getString("codunidades");
            
            System.out.println("Codigo de la unidad seleccionada : "+codigou);
            
            //Luego de conseguir el codigo insertamos en la tabla de empleados
             
            SQL = "INSERT INTO empleados(cedula,nombre,tipoe,codunidades,password) VALUES (?,?,?,?,?)";
            PreparedStatement consultaInsercion = this.conexion.prepareStatement(SQL);
            consultaInsercion.setInt(1, cedula);
            consultaInsercion.setString(2, nombre);
            consultaInsercion.setString(3, String.valueOf(tipoe));
            consultaInsercion.setString(4, codigou);
            consultaInsercion.setString(5, password);
            consultaInsercion.execute();
            
            System.out.println("Se inserto el empleado");
            
            String subSQL;
            
            if(tipoe=='J'){ //si es J se inserta como jefe
               subSQL = "INSERT INTO jefes (fichaj) VALUES (?)";
               consultaInsercion = this.conexion.prepareStatement(subSQL);
               consultaInsercion.setInt(1, cedula);
               consultaInsercion.execute();
               JOptionPane.showMessageDialog(null, "Se ha insertado el empleado Jefe de unidad ","Accion Realizada",JOptionPane.INFORMATION_MESSAGE);
            }else if(tipoe == 'D'){ //si es D se inserta como director
               subSQL = "INSERT INTO directores (fichad) VALUES (?)"; 
               consultaInsercion = this.conexion.prepareStatement(subSQL);
               consultaInsercion.setInt(1, cedula);
               consultaInsercion.execute();
               JOptionPane.showMessageDialog(null, "Se ha insertado el empleado director financiero","Accion Realizada",JOptionPane.INFORMATION_MESSAGE);
            }
            

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro del empleado" + e.getMessage(),"Accion no Realizada",JOptionPane.ERROR_MESSAGE);
        }
    }

}
