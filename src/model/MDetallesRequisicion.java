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

public class MDetallesRequisicion extends MUtilidades {


    public void agregarDetallesRequisicion(int nrorequisicion, String nombrei, int cantidad, float precioa) {

        String codigoi = this.busquedaItems(nombrei, nrorequisicion);

        try {
            String SQL = "INSERT INTO detalles_requisicion (nrorequisicion,coditem,cantidad,precioAprox) VALUES (?,?,?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, nrorequisicion);
            consulta.setString(2, codigoi);
            consulta.setInt(3, cantidad);
            consulta.setFloat(4, precioa);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Item agregado Exitosamente a la requisicion", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDetallesRequisicion(int nroRequisicion, String nombrei, int cantidad, float precioA) {

        String codigoi = this.busquedaItems(nombrei, nroRequisicion);

        try {

            String SQL = "UPDATE detalles_requisicion SET cantidad=?,precioAprox=? WHERE nrorequisicion=? AND coditem=?";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);

            consulta.setInt(1, cantidad);
            consulta.setFloat(2, precioA);
            consulta.setInt(3, nroRequisicion);
            consulta.setString(4, codigoi);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Detalle de la requisicion Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

    public DefaultTableModel mostrarDatosDetallesRequisicion(int nroRequisicion) {
        String[] titulos = {"Nro Requisicion", "codigo item ", "nombre item", "cantidad", "precio Aproximado"};
        String[] registros = new String[5];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT detr.*,i.nombrei\n"
                + "FROM detalles_requisicion detr,items i,requisiciones r \n"
                + "WHERE detr.nrorequisicion=" + nroRequisicion + " AND i.codlineas=r.codlineas AND detr.coditem=i.coditem\n"
                + "GROUP BY i.nombrei,detr.nrorequisicion,detr.coditem\n"
                + "ORDER BY detr.nrorequisicion ASC ";

        try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("nrorequisicion");
                registros[1] = resultados.getString("coditem");
                registros[2] = resultados.getString("nombrei");
                registros[3] = resultados.getString("cantidad");
                registros[4] = resultados.getString("precioAprox");
                tabla.addRow(registros);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

        return tabla;
    }

    public void eliminarDatosDetalleRequisicion(int nrorequisicion, String nombrei) {

        String codigoi = this.busquedaItems(nombrei, nrorequisicion);

        String SQL = "DELETE FROM detalles_requisicion where nrorequisicion=? AND coditem=?";

        try {
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, nrorequisicion);
            consulta.setString(2, codigoi);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Detalle de la requisicion Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }

}
