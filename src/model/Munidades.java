package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Munidades {

    private final Connection conexion;

    //Constructor de la clase que se conecta luego con la clase conexion en controler
    public Munidades(Connection conexion) {
        this.conexion = conexion;
    }

    public void insertarDatosUnidades(String codunidades, String nombreu, float c_costo) {
        try {
            String SQL = "INSERT INTO unidades (codunidades,nombreu,c_costo) VALUES (?,?,?) ";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, codunidades);
            consulta.setString(2, nombreu);
            consulta.setFloat(3, c_costo);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Unidad registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    //Mostrar datos de las unidades
    public DefaultTableModel mostrarDatosUnidades() {
        String[] titulos = {" Codigo unidad ", " Nombre unidad ", " Centro de costo "};
        String[] registros = new String[3];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM unidades ORDER BY codunidades";

        try {
            Statement consulta = this.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("codunidades");
                registros[1] = resultados.getString("nombreu");
                registros[2] = resultados.getString("c_costo");

                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    //Actualizacion de datos de las unidades
    public void actualizarDatosUnidades(String codunidades, String nombreu, float c_costo) {
        try {
            String SQL = "UPDATE unidades SET c_costo=?,nombreu=? WHERE codunidades=? ";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            
            consulta.setFloat(1, c_costo);
            consulta.setString(2, nombreu);
            consulta.setString(3, codunidades);
            

            consulta.execute();

            JOptionPane.showMessageDialog(null, "Unidad actualizada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Eliminacion de datos de las unidades
    
    public void eliminarDatosUnidades(String codunidades){
        
        String SQL = "DELETE FROM unidades where codunidades=?";
        
        try{
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            consulta.setString(1, codunidades);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Unidad Eliminada exitosamente ","Accion realizada",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    

}
