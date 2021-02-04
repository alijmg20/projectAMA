/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
/**
 *
 * @author alijm
 */
public class MDetallesOrden extends MUtilidades {



    public void agregarDetallesOrden(String codOrden, String codCotizacion, int nrorequisicion, String nombrei, int rifProveedor) {

        String codigoi = this.busquedaItems(nombrei, nrorequisicion);

        try {
            String SQL = "INSERT INTO detalles_compra (nroorden,codigocot,nrorequisicion,coditem,rifproveedor) VALUES (?,?,?,?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setString(1, codOrden);
            consulta.setString(2, codCotizacion);
            consulta.setInt(3, nrorequisicion);
            consulta.setString(4, codigoi);
            consulta.setInt(5, rifProveedor);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Item " + nombrei + " agregado a la orden de compra " + codOrden + "", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrarDetallesOrden(String codOrden) {
        String[] titulos = {"Orden", "Cotizacion", "Nro Requisicion", "codigo item ", "nombre item", "rif Proveedor", "razon social"};
        String[] registros = new String[7];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT detcom.*, i.nombrei,pro.r_social\n"
                + "FROM detalles_compra detcom,items i,proveedores pro \n"
                + "WHERE detcom.coditem=i.coditem\n"
                + "AND pro.rif=detcom.rifproveedor\n"
                + "AND detcom.nroorden='" + codOrden + "'\n"
                + "ORDER BY i.nombrei,pro.rif,detcom.nroorden";

        try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("nroorden");
                registros[1] = resultados.getString("codigocot");
                registros[2] = resultados.getString("nrorequisicion");
                registros[3] = resultados.getString("coditem");
                registros[4] = resultados.getString("nombrei");
                registros[5] = resultados.getString("rifproveedor");
                registros[6] = resultados.getString("r_social");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void actualizarDetallesOrdenDeCompra(String codOrden, String codCotizacion, int nrorequisicion, String nombrei, int rifProveedor) {
        try {
            String codigoi = this.busquedaItems(nombrei, nrorequisicion);
            String SQL = "UPDATE detalles_compra SET coditem=?  WHERE nroorden=? AND codigocot=? AND nrorequisicion=? AND rifProveedor=? ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);

            consulta.setString(1, codigoi);
            consulta.setString(2,codOrden );
            consulta.setString(3, codCotizacion);
            consulta.setInt(4, nrorequisicion);
            consulta.setInt(5, rifProveedor);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Detalle de la Orden de compra de la cotizacion " + codCotizacion + " Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    
        public void eliminarDatosDetalleOrdenCompra(String codOrden, String codCotizacion, int nrorequisicion, String codigoi, int rifProveedor) {

        
        String SQL = "DELETE FROM detalles_compra WHERE nroorden=? AND codigocot=? AND nrorequisicion=? AND coditem=? AND rifproveedor=?";

        try {
            
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setString(1, codOrden);
            consulta.setString(2, codCotizacion);
            consulta.setInt(3, nrorequisicion);
            consulta.setString(4, codigoi);
            consulta.setInt(5, rifProveedor);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Detalle de la orden de compra "+codOrden+" de la cotizacion "+codCotizacion+" Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    
    
    

    public void obtenerCotizacionesDetallesOrden(JComboBox cb, int rifProveedor) {

        try {
            String SQL = "SELECT codigocot \n"
                    + "FROM detalles_cotizacion detcot,proveedores pro \n"
                    + "                    WHERE detcot.rifproveedor=" + rifProveedor + " AND detcot.rifproveedor=pro.rif\n"
                    + "					GROUP BY codigocot\n"
                    + "                    ORDER BY codigocot ASC";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("codigocot"));
            }
        } catch (Exception ex) {

        }

    }

    public void obtenerRequisicionesDetallesOrden(JComboBox cb, String codcotizacion) {

        try {
            String SQL = "SELECT detr.nrorequisicion \n"
                    + "FROM detalles_cotizacion detcot,detalles_requisicion detr,requisiciones r \n"
                    + "WHERE detcot.codigocot='" + codcotizacion + "' AND detcot.nrorequisicion=detr.nrorequisicion  \n"
                    + "AND  r.nrorequisicion=detcot.nrorequisicion AND detr.nrorequisicion=r.nrorequisicion\n"
                    + "GROUP BY detr.nrorequisicion\n"
                    + "ORDER BY detr.nrorequisicion ASC";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nrorequisicion"));
            }
        } catch (Exception ex) {

        }
    }

    public void obtenerItemsDetallesOrden(JComboBox cb, String codcotizacion, int nrorequisicion) {
        try {
            String SQL = "SELECT i.nombrei \n"
                    + "FROM detalles_cotizacion detcot,detalles_requisicion detr,items i\n"
                    + "WHERE detcot.codigocot='" + codcotizacion + "'\n"
                    + " AND detr.nrorequisicion=" + nrorequisicion + "\n"
                    + " AND i.coditem=detcot.coditem AND i.coditem=detr.coditem \n"
                    + "GROUP BY i.nombrei\n"
                    + "ORDER BY i.nombrei ASC";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombrei"));
            }
        } catch (Exception ex) {

        }
    }

}
