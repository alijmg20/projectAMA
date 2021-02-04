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

    private final  Connection conexion;

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

    //Utilizado en MDETALLESCOTIZACION
    public void obtenerNrosRequisiciones(JComboBox cb, int rif, String codigocot) {
        try {
            String SQL = "SELECT r.nrorequisicion\n"
                    + "FROM requisiciones r,proveedores p , suministran sumi,cotizaciones cot \n"
                    + "WHERE cot.codigocot='" + codigocot + "'\n"
                    + "AND cot.codlineas=r.codlineas\n"
                    + "AND cot.codlineas=sumi.codlineas\n"
                    + "AND r.codlineas= sumi.codlineas\n"
                    + "AND p.rif=sumi.rifproveedor\n"
                    + "AND p.rif=" + rif + " "
                    + "ORDER BY r.nrorequisicion DESC ";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nrorequisicion"));
            }
        } catch (Exception ex) {

        }
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
                    + "WHERE tipoe='J' and statuse='A' and codunidades='" + codigou + "'"
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

    public void obtenerItems(JComboBox cb, int nroRequisicion) {
        try {

            String SQL = "SELECT i.nombrei FROM items i,requisiciones r \n"
                    + "WHERE r.nrorequisicion=" + nroRequisicion + "  AND r.codlineas=i.codlineas\n"
                    + "group by i.nombrei,i.coditem\n"
                    + "order by i.coditem DESC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombrei"));
            }
        } catch (Exception e) {

        }
    }

    public String busquedaItems(String nombrei, int nroRequisicion) {
        try {
            String SQL = "SELECT i.coditem "
                    + "FROM items i, requisiciones r "
                    + "WHERE r.nrorequisicion=" + nroRequisicion + " AND r.codlineas=i.codlineas AND i.nombrei='" + nombrei + "'";
            String coditem = "";
            Statement consultaCodItem = this.conexion.createStatement();
            ResultSet resultado = consultaCodItem.executeQuery(SQL);
            resultado.next();
            return coditem = resultado.getString("coditem");
        } catch (Exception e) {

        }
        return null;
    }

    public void ObtenerRazonSocialProveedoresCotizacion(JComboBox cb, String descripcionl) {
        try {
            String codlineas = this.busquedaLinea(descripcionl);
            String SQL = "SELECT r.r_social FROM proveedores r,suministran sumi "
                    + "WHERE r.rif=sumi.rifproveedor AND sumi.codlineas='" + codlineas + "' "
                    + "ORDER BY r.rif ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("r_social"));
            }
        } catch (Exception e) {

        }

    }
    //Utilizado en la razon social del proveedor para la ventana de MCotizacion
    public int busquedaRifProveedor(String r_social) {
        try {
            String SQL = "SELECT rif FROM proveedores WHERE r_social='" + r_social+"'";
            
            Statement consultaRif = this.conexion.createStatement();
            ResultSet resultado = consultaRif.executeQuery(SQL);
            resultado.next();
            int rif;
            return rif = resultado.getInt("rif");

        } catch (Exception e) {

        }
        return 0;
    }

    //PARA MOSTRAR LOS NOMBRES DE LOS DIRECTORES EN EL DROPBOX
    public void obtenerNDirectores(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM empleados "
                    + "WHERE tipoe = 'D' AND statuse = 'A' "
                    + "ORDER BY nombre ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("nombre"));
            }
        } catch (Exception ex) {

        }
        
    }

    //PARA OBTENER LOS CODIGOS DE LOS DIRECTORES SEGUN EL NOMBRE
    public int busquedaCDirector(String nombre) {

        String SQL = "SELECT di.fichad \n"
                + "FROM directores AS di, empleados AS em \n"
                + "WHERE di.fichad = em.cedula AND em.nombre = '" + nombre + "'";

        
        try {
            int rif;
            Statement consultaDirector = this.conexion.createStatement();
            ResultSet resultado = consultaDirector.executeQuery(SQL);
            resultado.next();
            return rif = resultado.getInt("fichad");
        } catch (Exception e) {

        }
        
        
        
        
        return -1;
    }

    //PARA MOSTRAR LA RAZON SOCIAL DE LOS PROVEEDORES EN EL DROPBOX
    public void obtenerNProveedores(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM proveedores "
                    + "WHERE statusp = 'A' "
                    + "ORDER BY r_social ASC";
            PreparedStatement consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("r_social"));
            }
        } catch (Exception ex) {

        }
    }

    //PARA OBTENER LOS RIF DE LOS PROVEEDORES SEGUN LA RAZON SOCIAL
    public int busquedaRProveedores(String razonsocial) {

        String SQL = "SELECT rif "
                + "FROM proveedores "
                + "WHERE r_social = '" + razonsocial + "'";
        int rifproveedor = 0;
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery(SQL);
            resultado.next();
            rifproveedor = resultado.getInt("rif");
            return rifproveedor;
        } catch (Exception e) {

        }
        return rifproveedor;
    }
}
