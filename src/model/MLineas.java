package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.TipoUsuario;
public class MLineas extends MUtilidades {


    

    
    //INSERTAR DATOS EN LA LINEA DE SUMINISTROS
    public void insertarDatosLineas(String codlineas, String descripcionl) {
        try {
            String SQL = "INSERT INTO lineas (codlineas,descripcionl) VALUES (?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);

            consulta.setString(1, codlineas);
            consulta.setString(2, descripcionl);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Linea de suministros registrada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //MOSTRAR DATOS DE LA LINEA DE SUMINISTROS
    public DefaultTableModel mostrarDatosLineas() {
        String[] titulos = {" Codigo Lineas S. ", " Descripcion "};
        String[] registros = new String[2];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT * FROM lineas ORDER BY descripcionl";

        try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("codlineas");
                registros[1] = resultados.getString("descripcionl");

                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    //ACTUALIZAR DATOS DE LA LINEA DE SUMINISTROS
    public void actualizarDatosLineas(String codlineas, String descripcionl) {
        try {
            String SQL = "UPDATE lineas SET descripcionl=? WHERE codlineas=? ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            
            consulta.setString(1, descripcionl);
            consulta.setString(2, codlineas);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Linea de suministro actualizada exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //ELIMINAR DATOS DE LA LINEA DE SUMINISTROS
    public void eliminarDatosUnidades(String codlineas){
        
        String SQL = "DELETE FROM lineas where codlineas=?";
        
        try{
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setString(1, codlineas);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Linea de Suministro Eliminada exitosamente ","Accion realizada",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
