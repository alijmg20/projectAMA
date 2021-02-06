package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import views.TipoUsuario;
public class MItem extends MUtilidades {
    
    
    
    
    //INSERTAR DATOS EN ITEM
    public void insertarDatosItem(String coditem, String nombrei, String descripcioni, String umedida, float preciou, String codlineas) {
        try {
            
            //BUSCAR EL IDENTIFICADOR DE LA LINEA DE SUMINSTROS
            String codarticulo = busquedaLinea(codlineas);
            
            
            String SQL = "INSERT INTO items (coditem,nombrei,descripcioni,umedida,preciou,codlineas) VALUES (?,?,?,?,?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);

            consulta.setString(1, coditem);
            consulta.setString(2, nombrei);
            consulta.setString(3, descripcioni);
            consulta.setString(4, umedida);
            consulta.setFloat(5, preciou);
            consulta.setString(6, codarticulo);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Item Registrado Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    //MOSTRAR DATOS DE ITEM
    public DefaultTableModel mostrarDatosItem() {
        String[] titulos = {" Codigo Item. ", " Nombre ", " Descripcion ", " Und Medida  ", " Precio ", " Linea de Suministro "};
        String[] registros = new String[6];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT its.coditem, its.nombrei, its.descripcioni, its.umedida, its.preciou, ls.descripcionl "
                + "FROM lineas AS ls, items AS its "
                + "WHERE its.codlineas=ls.codlineas "
                + "ORDER BY ls.descripcionl ASC, its.nombrei ASC";

        try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("coditem");
                registros[1] = resultados.getString("nombrei");
                registros[2] = resultados.getString("descripcioni");
                registros[3] = resultados.getString("umedida");
                registros[4] = resultados.getString("preciou");
                registros[5] = resultados.getString("descripcionl");

                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }
    
    //ACTUALIZAR DATOS DE ITEM
    public void actualizarDatosItem(String coditem, String nombrei, String descripcioni, String umedida, float preciou, String descripcionl) {
        try {
            String codlineas = this.busquedaLinea(descripcionl);
            String SQL = "UPDATE items SET nombrei=?, descripcioni=?, umedida=?, preciou=?,codlineas=? WHERE coditem=? ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            
            consulta.setString(1, nombrei);
            consulta.setString(2, descripcioni);
            consulta.setString(3, umedida);
            consulta.setFloat(4, preciou);
            
            consulta.setString(5, codlineas);
            consulta.setString(6, coditem);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Item Actualizado Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //ELIMINAR DATOS DE LA LINEA DE SUMINISTROS
    public void eliminarDatosItem(String coditem){
        
        String SQL = "DELETE FROM items where coditem=?";
        
        try{
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setString(1, coditem);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Item Eliminado Exitosamente ","Accion realizada",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
