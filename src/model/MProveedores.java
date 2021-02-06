
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
import views.TipoUsuario;

public class MProveedores extends MUtilidades {


    

    
    //MUESTRAS EL JLIST DE LA LINEA DE SUMINISTRO
    // DefaultListModel<String> model = new DefaultListModel<>();
    
    
            // MOSTRAR DATOS PROVEEDOR
    public DefaultTableModel mostrarDatosProveedor() {
        String[] titulos = {" Rif ", " Razon Social ", " Direccion "};
        String[] registros = new String[3];

        DefaultTableModel tabla = new DefaultTableModel(null, titulos);
        String SQL = "SELECT rif, r_social, direccion FROM proveedores  WHERE statusp ='A' ORDER BY rif ASC";
        try {
            Statement consulta = TipoUsuario.conexion.createStatement();
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
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, rif); 
            consulta.setString(2, r_social);
            consulta.setString(3, direccion); 
            consulta.setString(4, String.valueOf(statuse)); 
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Proveedor Registrado Exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Error al insertar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }   
    } 
        
    // INSERTAR DATOS EN TABLA CORREOS     
            public void insertarDatosCORREOS(int rifproveedor, String correo) {
        try {
                       
            String SQL = "INSERT INTO correos (rifproveedor,correo) VALUES (?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, rifproveedor);
            consulta.setString(2, correo);
            consulta.execute();
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Error al insertar correo: " + e.getMessage(), "Accion no realizada correo", JOptionPane.ERROR_MESSAGE);
        }   
    }
    // INSERTAR DATOS EN TABLA NUMEROS 
             public void insertarDatosTelefonos(int rifproveedor, String telefonos) {
       try {
                       
            String SQL = "INSERT INTO telefonos (rifproveedor,telefonos) VALUES (?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, rifproveedor);
            consulta.setString(2, telefonos); 
            consulta.execute();
            
        } catch (SQLException | HeadlessException e) {
            JOptionPane.showMessageDialog(null,"Error al insertar telefonos: " + e.getMessage(), "Accion no realizada telefono", JOptionPane.ERROR_MESSAGE);
        }   
    }     
             
    // INSERTAR DATOS EN TABLA SUMINISTRAN 
        public void insertarDatossuministran(int rifproveedor, String codlineas) {
        try {
             
            //BUSCAR EL IDENTIFICADOR DE LA LINEA DE SUMINSTROS
            String codlineasS = busquedaLinea(codlineas); // me saca de la bdd el codigo de la lnea seleccionada 
            
            String SQL = "INSERT INTO suministran (rifproveedor,codlineas) VALUES (?,?) ";
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);

            consulta.setInt(1, rifproveedor);
            consulta.setString(2,codlineasS); 
            consulta.execute();
           
        } catch (SQLException | HeadlessException e) {
           // JOptionPane.showMessageDialog(null,"Error al insertar linea: " + e.getMessage(), "Accion no realizada linea", JOptionPane.ERROR_MESSAGE);
        }   
    }    
        
    public String arreglocorreo( int rif){ 
        String correos="";
        String mensaje = "\nNo posee correo registrado"; 
            String[] registros = new String[1];
            String SQL = "select s.correo from proveedores o, correos s where s.rifproveedor=o.rif and o.rif="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("correo");
                correos=correos+"\n"+registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
            if(correos.isEmpty()) 
                return mensaje;  
        return correos;    
    }   
    
     public String [] dataemail( int rif){ 
        String [] correos= new String [3];
            String[] registros = new String[1];
            String SQL = "select s.correo from proveedores o, correos s where s.rifproveedor=o.rif and o.rif="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i=0;
            while (resultados.next()) {
                registros[0] = resultados.getString("correo");
                correos[i]=registros[0];
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        } 
        return correos;    
    }   
    
    public String arreglotlf( int rif){ 
        String telefonos="";
        String mensaje = "\nNo posee telefonos registrados"; 
            String[] registros = new String[1];
            String SQL = "select tl.telefonos from telefonos tl, proveedores o where o.rif=tl.rifproveedor and o.rif="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("telefonos");
                telefonos=telefonos+"\n"+registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
            if(telefonos.isEmpty())
                return mensaje; 
        return telefonos;    
    } 
    
    public String [] datatlf( int rif){ 
        String [] telefonos= new String [3];
            String[] registros = new String[1];
            String SQL = "select tl.telefonos from telefonos tl, proveedores o where o.rif=tl.rifproveedor and o.rif="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i=0;
            while (resultados.next()) {
                registros[0] = resultados.getString("telefonos");
                telefonos[i]=registros[0];
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        return telefonos;    
    } 
    
    public String arreglolineas( int rif){ 
        String lineas="";
        String mensaje = "\nNo tiene linea de suministro asignada";  
            String[] registros = new String[1];
            String SQL = "select l.descripcionl from lineas l, suministran w where  w.codlineas=l.codlineas and w.rifproveedor="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            while (resultados.next()) {
                registros[0] = resultados.getString("descripcionl");
                lineas=lineas+"\n"+registros[0];
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
            if(lineas.isEmpty())
                return mensaje; 
        return lineas;    
    } 
     
    public String[] datalineas( int rif){ 
        String[] linea = new String[3];
            String SQL = "select l.descripcionl from lineas l, suministran w where  w.codlineas=l.codlineas and w.rifproveedor="+rif;
            try {
            Statement consulta = TipoUsuario.conexion.createStatement();
            ResultSet resultados = consulta.executeQuery(SQL);
            int i=0;
            while (resultados.next()) {
                linea[i]= resultados.getString("descripcionl");
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al mostrar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        } 
        return linea ;    
    } 
         
         //-----------------------------------ACTUALIZACION---------------------------------- 

    public void actualizarDatosProveedores(int rif, String r_social, String direccion) {
        try { 
            String SQL = "UPDATE proveedores SET r_social='"+r_social+"', direccion='"+direccion+"' WHERE rif="+ rif; 
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                  
        } catch (SQLException | HeadlessException e) {
            //JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void actualizarDatosCorreos(int rif, String correo1, String correo2, String correo3, String correoi1, String correoi2, String correoi3) {
        if (!correo1.isEmpty()){
             if (correo1.equals(correoi1)==false){
                try { 
                    String SQL = "UPDATE correos SET correo='"+correo1+"' WHERE rifproveedor="+rif+" and correo='"+correoi1+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Correo1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
         }
        if (!correo2.isEmpty()){
            if (correo2.equals(correoi2)==false){
                try { 
                    String SQL = "UPDATE correos SET correo='"+correo2+"' WHERE rifproveedor="+rif+" and correo='"+correoi2+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Correo1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
         }
        if (!correo3.isEmpty()){
            if (correo3.equals(correoi3)==false){
                try { 
                    String SQL = "UPDATE correos SET correo='"+correo3+"' WHERE rifproveedor="+rif+" and correo='"+correoi3+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Correo1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
         }
    }

    public void actualizarDatosTelefonos(int rif, String tl1, String tl2, String tl3, String ti1, String ti2, String ti3) {
        if (!tl1.isEmpty()){
             if (tl1.equals(ti1)==false){
                try { 
                    String SQL = "UPDATE telefonos SET telefonos='"+tl1+"' WHERE rifproveedor="+rif+" and telefonos='"+ti1+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Telefono 1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
        }
        if (!tl2.isEmpty()){
            if (tl2.equals(ti2)==false){
                try { 
                    String SQL = "UPDATE telefonos SET telefonos='"+tl2+"' WHERE rifproveedor="+rif+" and telefonos='"+ti2+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Telefono 2 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
        }
        if (!tl3.isEmpty()){
            if (tl3.equals(ti3)==false){
                try { 
                    String SQL = "UPDATE telefonos SET telefonos='"+tl3+"' WHERE rifproveedor="+rif+" and telefonos='"+ti3+"'";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Telefono 3 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
             }
        }
    }

    public void actualizarDatosLineas(int rif, String linea1, String linea2, String linea3, String li1,String li2, String li3) {
        if (!"Seleccione una opcion".equals(linea1)){
             if (linea1.equals(li1)==false){
                try {
                    String SQL = "update suministran set codlineas=(select codlineas from lineas where descripcionl='"+linea1+"') where rifproveedor="+rif+" and codlineas in (select s.codlineas from lineas l, suministran s where l.descripcionl='"+li1+"' and rifproveedor="+rif+")";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Linea de suministro 1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
            }
       }
       if (!"Seleccione una opcion".equals(linea2)){
             if (linea2.equals(li2)==false){
                try {
                    String SQL = "update suministran set codlineas=(select codlineas from lineas where descripcionl='"+linea2+"') where rifproveedor="+rif+" and codlineas in (select s.codlineas from lineas l, suministran s where l.descripcionl='"+li2+"' and rifproveedor="+rif+")";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Linea de suministro 1 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
            }
       }
       if (!"Seleccione una opcion".equals(linea3)){
             if (linea3.equals(li3)==false){
                try {
                    String SQL = "update suministran set codlineas=(select codlineas from lineas where descripcionl='"+linea3+"') where rifproveedor="+rif+" and codlineas in (select s.codlineas from lineas l, suministran s where l.descripcionl='"+li3+"' and rifproveedor="+rif+")";
                    PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL); 
                    consulta.execute();
                    JOptionPane.showMessageDialog(null, "Linea de suministro 3 actualizado exitosamente", "Accion realizada", JOptionPane.INFORMATION_MESSAGE);
                } catch (SQLException | HeadlessException e) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
                }
            }
       } 
    }
        
        
     public void eliminarDatosProveedores(int rif){ 
        try{
            String SQL = "UPDATE proveedores SET statusp = 'S' WHERE rif=?"; 
            PreparedStatement consulta = TipoUsuario.conexion.prepareStatement(SQL);
            consulta.setInt(1, rif);
            consulta.executeUpdate();
            JOptionPane.showMessageDialog(null, "Proveedor Eliminado exitosamente ","Accion realizada",JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar datos: " + e.getMessage(), "Accion no realizada", JOptionPane.ERROR_MESSAGE);
        }
        
    }       
    // ELIMINAR ---- OJO 
     
     
         public boolean ingresarProveedores(int rif) {
        boolean inProveedor = false;
        try {
            String SQL = "SELECT * FROM proveedores WHERE rif=" + rif + " ";
            Statement consulta = TipoUsuario.conexion.createStatement();
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
