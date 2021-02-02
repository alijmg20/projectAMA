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

/**
 *
 * @author alijm
 */
public class MDetallesCotizacion extends MUtilidades {

    public MDetallesCotizacion(Connection conexion) {
        super(conexion);
    }

    public void agregarDetallesCotizacion(String codigocot, int nrorequisicion, String nombrei, int rifProveedor, float precioa, int cantidad, String condicionesC) {

        String codigoi = this.busquedaItems(nombrei, nrorequisicion);

        try {
            String SQL = "INSERT INTO detalles_cotizacion (codigocot,nrorequisicion,coditem,rifproveedor,condicionesc,precioa,cantidada) VALUES (?,?,?,?,?,?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, codigocot);
            consulta.setInt(2, nrorequisicion);
            consulta.setString(3, codigoi);
            consulta.setInt(4, rifProveedor);
            consulta.setString(5, condicionesC);
            consulta.setFloat(6, precioa);
            consulta.setInt(7, cantidad);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Item de la requisicion " + nrorequisicion + " agregado Exitosamente a la Cotizacion", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void obtenerItemsDetalles(JComboBox cb, int nroRequisicion) {
        try {

            String SQL = "SELECT i.nombrei \n"
                    + "FROM Detalles_requisicion AS detr, requisiciones AS r, items AS i\n"
                    + "WHERE detr.nrorequisicion=" + nroRequisicion + " \n"
                    + "AND detr.coditem=i.coditem \n"
                    + "AND r.nrorequisicion=detr.nrorequisicion\n"
                    + "AND r.codlineas=i.codlineas\n"
                    + "ORDER BY i.nombrei DESC";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombrei"));
            }
        } catch (Exception e) {

        }
    }

    public DefaultTableModel mostrarDatosDetallesCotizacion(String codigocot) {
        String[] titulos = {"Codigo Cotizacion", "Nro requisicion", "codigo item ", "nombre item", "rif Proveedor", "Condiciones Compra", "Precio Asociado", " Cantidad"};
        String[] registros = new String[8];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT detc.*, i.nombrei\n"
                + "FROM detalles_cotizacion detc,items i,detalles_requisicion detr,requisiciones r \n"
                + "WHERE detc.coditem=detr.coditem \n"
                + "AND detr.coditem=i.coditem\n"
                + "AND detc.nrorequisicion=detr.nrorequisicion \n"
                + "AND r.nrorequisicion=detr.nrorequisicion\n"
                + "AND r.codlineas=i.codlineas \n"
                + "AND detc.codigocot='" + codigocot + "'"
                + "ORDER BY i.nombrei";

        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("codigocot");
                registros[1] = resultados.getString("nrorequisicion");
                registros[2] = resultados.getString("coditem");
                registros[3] = resultados.getString("nombrei");
                registros[4] = resultados.getString("rifproveedor");
                registros[5] = resultados.getString("condicionesc");
                registros[6] = resultados.getString("precioa");
                registros[7] = resultados.getString("cantidada");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void actualizarDetallesCotizacion(String codigocot, int nrorequisicion, String coditem, int rifProveedor, float precioa, int cantidada, String condicionesc) {
        try {

            String SQL = "UPDATE detalles_cotizacion SET condicionesc=?,precioa=?,cantidada=? WHERE codigocot=? AND nrorequisicion=? AND coditem=? AND rifproveedor=?";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);

            consulta.setString(1, condicionesc);
            consulta.setFloat(2, precioa);
            consulta.setInt(3, cantidada);
            consulta.setString(4, codigocot);
            consulta.setInt(5, nrorequisicion);
            consulta.setString(6, coditem);
            consulta.setInt(7, rifProveedor);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Detalle de la Cotizacion de la requisicion " + nrorequisicion + " Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminarDatosDetalleCotizacion(String codigocot,int nrorequisicion, String coditem,int rifProveedor) {


        String SQL = "DELETE FROM detalles_cotizacion WHERE codigocot=? AND nrorequisicion=? AND coditem=? AND rifproveedor=?";

        try {
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, codigocot);
            consulta.setInt(2, nrorequisicion);
            consulta.setString(3, coditem);
            consulta.setInt(4, rifProveedor);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Detalle de la cotizacion de la requisicion "+nrorequisicion+" Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

}
