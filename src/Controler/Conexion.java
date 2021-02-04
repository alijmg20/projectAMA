
package Controler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private  Connection con = null;
    //private final String jdbc = "jdbc:postgresql://localhost:5432/";
    private final  String jdbc = "jdbc:postgresql://bavixwxvz0mgrsrunvxw-postgresql.services.clever-cloud.com:5432/";
    public Connection conectar()
    {
        try{
            Class.forName("org.postgresql.Driver");
            //con = DriverManager.getConnection(jdbc+"universidad","postgres","password");
            con = DriverManager.getConnection(jdbc+"bavixwxvz0mgrsrunvxw","umackhx3srhd5tg1gjtq","lssfLzq8Z6Ff9fDaLnTM");
            
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage());
        }
        return con;
    }
    
}
