package model;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MProveedores extends MUtilidades {

    public MProveedores(Connection conexion) {
        super(conexion);
    }

    //MUESTRAS EL JLIST DE LA LINEA DE SUMINISTRO
    // DefaultListModel<String> model = new DefaultListModel<>();
    // MOSTRAR DATOS PROVEEDOR
    public DefaultTableModel mostrarDatosProveedor() {
        String[] titulos = {" Rif ", " Razon Social ", " Direccion "};
        String[] registros = new String[3];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT rif, r_social, direccion FROM proveedores  WHERE statusp ='A' ORDER BY rif ASC";
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("rif");
                registros[1] = resultados.getString("r_social");
                registros[2] = resultados.getString("direccion");
                tabla.addRow(registros);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return tabla;
    }

    //INSERTAR DATOS EN TABLA PROVEEDOR

    public void insertarDatosProveedores(int rif, String r_social, String direccion, char statuse) {
        try {

            String SQL = "INSERT INTO proveedores (rif,r_social,direccion,statusp) VALUES (?,?,?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setInt(1, rif);
            consulta.setString(2, r_social);
            consulta.setString(3, direccion);
            consulta.setString(4, String.valueOf(statuse));
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Proveedor Registrado Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    // INSERTAR DATOS EN TABLA CORREOS     
    public void insertarDatosCORREOS(int rifproveedor, String correo) {
        try {

            String SQL = "INSERT INTO correos (rifproveedor,correo) VALUES (?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setInt(1, rifproveedor);
            consulta.setString(2, correo);
            consulta.execute();

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar correo: " + e.getMessage(), "Accion no realizada correo", JOptionPane.ERROR_MESSAGE);
        }
    }

    // INSERTAR DATOS EN TABLA NUMEROS 

    public void insertarDatosTelefonos(int rifproveedor, String telefonos) {
        try {

            String SQL = "INSERT INTO telefonos (rifproveedor,telefonos) VALUES (?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setInt(1, rifproveedor);
            consulta.setString(2, telefonos);
            consulta.execute();

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar telefonos: " + e.getMessage(), "Accion no realizada telefono", JOptionPane.ERROR_MESSAGE);
        }
    }

    // INSERTAR DATOS EN TABLA SUMINISTRAN 
    public void insertarDatossuministran(int rifproveedor, String codlineas) {
        try {

            //BUSCAR EL IDENTIFICADOR DE LA LINEA DE SUMINSTROS
            String codlineasS = busquedaLinea(codlineas); // me saca de la bdd el codigo de la lnea seleccionada 

            String SQL = "INSERT INTO suministran (rifproveedor,codlineas) VALUES (?,?) ";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);

            consulta.setInt(1, rifproveedor);
            consulta.setString(2, codlineasS);
            consulta.execute();

        } catch (SQLException | HeadlessException e) {
            // JOptionPane.showMessageDialog(null,"Error al insertar linea: " + e.getMessage(), "Accion no realizada linea", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String arreglocorreo(int rif) {
        String correos = "";
        String mensaje = "\nNo posee correo registrado";
        String[] registros = new String[1];
        String SQL = "select s.correo from proveedores o, correos s where s.rifproveedor=o.rif and o.rif=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("correo");
                correos = correos + "\n" + registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        if (correos.isEmpty()) {
            return mensaje;
        }
        return correos;
    }

    public String[] dataemail(int rif) {
        String[] correos = new String[3];
        String[] registros = new String[1];
        String SQL = "select s.correo from proveedores o, correos s where s.rifproveedor=o.rif and o.rif=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i = 0;
            while (resultados.next()) {
                registros[0] = resultados.getString("correo");
                correos[i] = registros[0];
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return correos;
    }

    public String arreglotlf(int rif) {
        String telefonos = "";
        String mensaje = "\nNo posee telefonos registrados";
        String[] registros = new String[1];
        String SQL = "select tl.telefonos from telefonos tl, proveedores o where o.rif=tl.rifproveedor and o.rif=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("telefonos");
                telefonos = telefonos + "\n" + registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        if (telefonos.isEmpty()) {
            return mensaje;
        }
        return telefonos;
    }

    public String[] datatlf(int rif) {
        String[] telefonos = new String[3];
        String[] registros = new String[1];
        String SQL = "select tl.telefonos from telefonos tl, proveedores o where o.rif=tl.rifproveedor and o.rif=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i = 0;
            while (resultados.next()) {
                registros[0] = resultados.getString("telefonos");
                telefonos[i] = registros[0];
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return telefonos;
    }

    public String arreglolineas(int rif) {
        String lineas = "";
        String mensaje = "\nNo tiene linea de suministro asignada";
        String[] registros = new String[1];
        String SQL = "select l.descripcionl from lineas l, suministran w where  w.codlineas=l.codlineas and w.rifproveedor=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("descripcionl");
                lineas = lineas + "\n" + registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        if (lineas.isEmpty()) {
            return mensaje;
        }
        return lineas;
    }

    public int[] datalineas(int rif) {
        int[] linea = new int[5];
        String[] registros = new String[1];
        String SQL = "select l.descripcionl from lineas l, suministran w where  w.codlineas=l.codlineas and w.rifproveedor=" + rif;
        try {
            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i = 0;
            while (resultados.next()) {
                registros[0] = resultados.getString("descripcionl");
                if ("Alimentos".equals(registros[0])) {
                    linea[i] = 1;
                }
                if ("Limpieza".equals(registros[0])) {
                    linea[i] = 2;
                }
                if ("Papeleria".equals(registros[0])) {
                    linea[i] = 3;
                }
                if ("Tecnologia".equals(registros[0])) {
                    linea[i] = 4;
                }
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return linea;
    }
//-----------------------------------ACTUALIZACION--------------------------------------------------------------

    public void actualizarDatosProveedores(int rif, String r_social, String direccion) {
        try {
            JOptionPane.showMessageDialog(null, "entra1");
            String SQL = "UPDATE proveedores SET rif=?,r_social=?, direccion=? WHERE rif=" + rif;
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            //   JOptionPane.showMessageDialog(null, "ENTRA");
            consulta.setInt(1, rif);
            consulta.setString(2, r_social);
            consulta.setString(3, direccion);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDatosCorreos(int rif, String correo) {
        try {
            String SQL = "UPDATE correos SET correo=? WHERE rifproveedor=" + rif;
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
          //  JOptionPane.showMessageDialog(null, "ENTRA");
            //consulta.setInt(1, rif);
            // consulta.setString(1, correo);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "entra2");
            //    JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDatosTelefonos(int rif, String telefono) {
        try {
            String SQL = "UPDATE telefonos SET telefonos=? WHERE rifproveedor=" + rif;
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            //  JOptionPane.showMessageDialog(null, "ENTRA");
            //consulta.setInt(1, rif);
            consulta.setString(1, telefono);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "entra3");
            // JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDatosLineas(int rif, String linea) {
        try {
            String SQL = "UPDATE suministran SET codlineas=? WHERE rifproveedor=" + rif;
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
          //  JOptionPane.showMessageDialog(null, "ENTRA");
            //  consulta.setInt(1, rif);
            consulta.setString(1, linea);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "entra4");
            // JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarDatosProveedores(int rif) {
        try {
            String SQL = "UPDATE proveedores SET statusp = 'S' WHERE rif=?";
            PreparedStatement consulta = this.getConexion().prepareStatement(SQL);
            consulta.setInt(1, rif);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado exitosamente ", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }

    }
    // ACTUALIZAR 

    // ELIMINAR ---- OJO
    
    
    public boolean ingresarProveedores(int rif) {
        boolean inProveedor = false;
        try {
            String SQL = "SELECT * FROM proveedores WHERE rif=" + rif + " ";

            Statement consulta = this.getConexion().createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            resultados.next();
            int rifBdd = resultados.getInt("rif");
            if (rifBdd == rif) {
                inProveedor = true;
                return inProveedor;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar : " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return inProveedor;
    }

}
