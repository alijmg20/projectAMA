package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MOrden extends MUtilidades {

    public MOrden(Connection conexion) {
        super(conexion);
    }

    public void insertarDatosOrden(String nroorden, String fecha1, char tipom, char condicionp, String r_social, String nombreD) {
        System.out.println(nombreD);

        try {

            long fechaLong1 = java.util.Date.parse(fecha1);
            Date fechaDate1 = new Date(fechaLong1);
            int fichaD = this.busquedaCDirector(nombreD);
            System.out.println(fichaD);
            int rifproveedor = this.busquedaRifProveedor(r_social);

            String SQL = "INSERT INTO ordenes(nroorden,f_orden,tipom,condicionp,rifproveedor,ficha_director) VALUES (?,?,?,?,?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, nroorden);
            consulta.setDate(2, fechaDate1);
            consulta.setString(3, String.valueOf(tipom));
            consulta.setString(4, String.valueOf(condicionp));
            consulta.setInt(5, rifproveedor);
            consulta.setInt(6, fichaD);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Se ha insertado la orden de compra correctamente", "Accion Realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro de la orden de compra:  " + e.getMessage(), "Accion no Realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrarDatosOrden() {
        String[] titulos = {"Codigo", "Fecha Emision", "Moneda", "Pago", "Fecha Entrega", "Ficha Director", "Director Financiero", "Rif Proveedor", "Proveedor"};
        String[] registros = new String[9];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT oc.nroorden, oc.f_orden, oc.tipom, oc.condicionp, oc.f_entrega, em.nombre, pr.r_social, di.fichad , pr.rif \n"
                + "FROM ordenes AS oc , empleados AS em, proveedores AS pr, directores AS di \n"
                + "WHERE pr.rif=oc.rifproveedor AND oc.ficha_director=di.fichad AND em.cedula=di.fichad \n"
                + "ORDER BY oc.f_orden DESC";
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("nroorden");
                String FormatoFecha1 = resultados.getString("f_orden");
                String fecha1 = FormatoFecha1.replace("-", "/");
                registros[1] = fecha1;
                registros[2] = resultados.getString("tipom");
                registros[3] = resultados.getString("condicionp");
                if (resultados.getString("f_entrega") != null) {
                    String FormatoFecha2 = resultados.getString("f_entrega");
                    String fecha2 = FormatoFecha2.replace("-", "/");
                    registros[4] = fecha2;
                } else {
                    registros[4] = "";
                }

                registros[5] = resultados.getString("fichad");
                registros[6] = resultados.getString("nombre");
                registros[7] = resultados.getString("rif");
                registros[8] = resultados.getString("r_social");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    public void actualizarDatosOrden(String nroorden, String fecha1, char tipom, String fecha2, char condicionp) {

        try {
            long fechaLong1 = java.util.Date.parse(fecha1);
            Date f_orden = new Date(fechaLong1);

            long fechaLong2 = java.util.Date.parse(fecha2);
            Date f_entrega = new Date(fechaLong2);


            String SQL = "UPDATE ordenes SET f_orden=? , tipom=? , f_entrega=?, condicionp=? WHERE  nroorden=?";


            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setDate(1, f_orden);
            consulta.setString(2, String.valueOf(tipom));
            consulta.setDate(3, f_entrega);
            consulta.setString(4, String.valueOf(condicionp));
            consulta.setString(5, nroorden);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Orden de Compra Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarDatosOrden(String nroorden) {

        String SQL = "DELETE FROM ordenes where nroorden=?";

        try {
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, nroorden);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orden de Compra Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

}
