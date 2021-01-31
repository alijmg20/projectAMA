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

public class MRequisicion extends MUtilidades {

    public MRequisicion(Connection conexion) {
        super(conexion);
    }

    public void insertarDatosRequisicion(String fecha, char cotizada, String nombreu, int director, int jefeUnidad, String descripcionl) {

        try {

            long fechaLong = java.util.Date.parse(fecha);
            Date fechaDate = new Date(fechaLong);

            String codigou = this.busquedaUnidad(nombreu);
            String codlinea = this.busquedaLinea(descripcionl);

            String SQL = "INSERT INTO requisiciones(f_emision,cotizada,codunidades,ficha_director,ficha_jefeu,codlineas) VALUES (?,?,?,?,?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setDate(1, fechaDate);
            consulta.setString(2, String.valueOf(cotizada));
            consulta.setString(3, codigou);
            consulta.setInt(4, director);
            consulta.setInt(5, jefeUnidad);
            consulta.setString(6, codlinea);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Se ha insertado la requisicion correctamente", "Accion Realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro de la requisicion: " + e.getMessage(), "Accion no Realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrarDatosRequisicion() {
        String[] titulos = {"NroRequisicion", "Fecha Emision", "Cotizada", "Departamento", "Director Financiero", "Jefe Unidad", "Linea suministros"};
        String[] registros = new String[7];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT req.nrorequisicion , req.f_emision, req.cotizada , uni.nombreu , req.ficha_director , req.ficha_jefeu , ls.descripcionl "
                + "FROM requisiciones AS req ,unidades AS uni,lineas AS ls "
                + "WHERE req.codlineas=ls.codlineas AND uni.codunidades=req.codunidades "
                + "ORDER BY req.nrorequisicion ASC";
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("nrorequisicion");
                String FormatoFecha = resultados.getString("f_emision");
                String fecha = FormatoFecha.replace("-", "/");
                registros[1] = fecha;
                registros[2] = resultados.getString("cotizada");
                registros[3] = resultados.getString("nombreu");
                registros[4] = resultados.getString("ficha_director");
                registros[5] = resultados.getString("ficha_jefeu");
                registros[6] = resultados.getString("descripcionl");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    public void actualizarDatosRequisicion(int nrorequisicion, String Stringfecha, char cotizada, String nombreu, int director, int jefeUnidad, String descripcionl) {
        try {
            long fechaLong = java.util.Date.parse(Stringfecha);
            Date fechaDate = new Date(fechaLong);
            
            String codigou = this.busquedaUnidad(nombreu);
            String codlinea = this.busquedaLinea(descripcionl);

            String SQL = "UPDATE requisiciones SET f_emision=? , cotizada=? , codunidades=?,ficha_director=?,ficha_jefeu=?,codlineas=? "
                        + "WHERE  nrorequisicion=?";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setDate(1, fechaDate);
            consulta.setString(2, String.valueOf(cotizada));
            consulta.setString(3, codigou);
            consulta.setInt(4, director);
            consulta.setInt(5, jefeUnidad);
            consulta.setString(6, codlinea);
            consulta.setInt(7, nrorequisicion);
            consulta.execute();

            JOptionPane.showMessageDialog(null, "Requisicion Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarDatosRequisicion(int nrorequisicion) {

        String SQL = "DELETE FROM requisiciones where nrorequisicion=?";

        try {
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setInt(1, nrorequisicion);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "requisicion Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }
}
