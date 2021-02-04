/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author alijm
 */
public class MCotizacion extends MUtilidades {

    public MCotizacion(Connection conexion) {
        super(conexion);
    }

    public void insertarDatosCotizacion(String codigoCot, String fecha, String descripcionl, String r_social, String observaciones) {
        int rif = this.busquedaRifProveedor(r_social);
        
        System.out.println(r_social);
        try {

            long fechaLong = java.util.Date.parse(fecha);
            Date fechaDate = new Date(fechaLong);
            String codlinea = this.busquedaLinea(descripcionl);
            rif = this.busquedaRifProveedor(r_social);
            
            String SQL = "INSERT INTO cotizaciones(codigocot,f_emision,observaciones,codlineas,rifproveedor) VALUES (?,?,?,?,?) ";

            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, codigoCot);
            consulta.setDate(2, fechaDate);
            consulta.setString(3, observaciones);
            consulta.setString(4, codlinea);
            consulta.setInt(5, rif);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Se ha insertado la cotizacion correctamente", "Accion Realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro de la cotizacion: " + e.getMessage(), "Accion no Realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public DefaultTableModel mostrarDatosCotizacion() {
        String[] titulos = {"codigo Cotizacion", "Fecha Emision", "observaciones", "Nombre linea", "rif Proveedor","razon social Proveedor"};
        String[] registros = new String[6];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT cot.*, ls.descripcionl,p.r_social "
                + "FROM cotizaciones cot,lineas ls, proveedores p "
                + "WHERE cot.codlineas=ls.codlineas AND p.rif=cot.rifproveedor ";
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);

            while (resultados.next()) {
                registros[0] = resultados.getString("codigocot");
                String FormatoFecha = resultados.getString("f_emision");
                String fecha = FormatoFecha.replace("-", "/");
                registros[1] = fecha;
                registros[2] = resultados.getString("observaciones");
                registros[3] = resultados.getString("descripcionl");
                registros[4] = resultados.getString("rifproveedor");
                registros[5] = resultados.getString("r_social");
                tabla.addRow(registros);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    public void actualizarDatosCotizacion(String codigoCot, String fecha, String descripcionl, String r_social, String observaciones) {
        try {
            
            
            long fechaLong = java.util.Date.parse(fecha);
            Date fechaDate = new Date(fechaLong);
            String codlinea = this.busquedaLinea(descripcionl);
            int rif = this.busquedaRifProveedor(r_social);
            String SQL = "UPDATE cotizaciones SET f_emision=? , observaciones=? , codlineas=?,rifproveedor=? "
                    + "WHERE  codigocot=?";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setDate(1, fechaDate);
            consulta.setString(2, observaciones);
            consulta.setString(3, codlinea);
            consulta.setInt(4, rif);
            consulta.setString(5, codigoCot);
            consulta.execute();
            
            JOptionPane.showMessageDialog(null, "cotizacion Actualizada Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public void eliminarDatosCotizacion(String codigoCot) {

        String SQL = "DELETE FROM cotizaciones where codigocot=?";

        try {
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setString(1, codigoCot);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "cotizacion Eliminada Exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }



}
