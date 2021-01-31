/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author alijm
 */
public class MUtilidades {

    private final Connection conexion;

    public MUtilidades(Connection conexion) {
        this.conexion = conexion;
    }

    public Connection getConexion() {
        return conexion;
    }

    //MUESTRAS EL DROPBOX DE LA LINEA DE SUMINISTRO
    public void obtenerLinea(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM lineas ORDER BY descripcionl ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("descripcionl"));
            }
        } catch (Exception ex) {

        }
    }

    //BUSCAR CON EL NOMBRE DE LINEA DE SUMINISTRO, EL CODIGO
    public String busquedaLinea(String descripcionl) {

        String SQL = "SELECT codlineas FROM lineas WHERE descripcionl = '" + descripcionl + "'";
        try {
            String codigolinea = "";
            Statement consultaCodigo = this.conexion.createStatement();
            ResultSet resultado = consultaCodigo.executeQuery(SQL);
            resultado.next();
            return codigolinea = resultado.getString("codlineas");
        } catch (Exception e) {

        }
        return null;
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

    //Funcion para buscar el codigo
    public String busquedaUnidad(String nombreu) {

        String SQL = "SELECT codunidades FROM unidades WHERE nombreu = '" + nombreu + "'";
        try {
            String codigou = "";
            Statement consultaCodigo = this.conexion.createStatement();
            ResultSet resultado = consultaCodigo.executeQuery(SQL);
            resultado.next();
            return codigou = resultado.getString("codunidades");
        } catch (Exception e) {

        }
        return null;
    }

    //Funcion para buscar la ultima requisicion que se ingreso
    public int obtenerNroRequisicion() {
        String SQL = "SELECT nrorequisicion "
                + "FROM requisiciones "
                + "ORDER BY nrorequisicion "
                + "DESC LIMIT 1";
        int numeros = 0;
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            numeros = resultado.getInt("nrorequisicion");
            return numeros;
        } catch (SQLException ex) {
            Logger.getLogger(MRequisicion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numeros;
    }

    public void obtenerDirectores(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM empleados "
                    + "WHERE tipoe='D' and statuse='A'"
                    + "ORDER BY cedula ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("cedula"));
            }
        } catch (Exception ex) {

        }
    }

    public void obtenerJefes(JComboBox cb, String nombreu) {
        try {
            String codigou = this.busquedaUnidad(nombreu);
            String SQL = "SELECT * FROM empleados "
                    + "WHERE tipoe='J' and statuse='A' and codunidades='"+codigou+"'"
                    + "ORDER BY cedula ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("cedula"));
            }
        } catch (Exception ex) {

        }
    }

}
