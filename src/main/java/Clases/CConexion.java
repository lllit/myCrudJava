
package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author litio
 */
public class CConexion {
  
    Connection conectar = null;
    
    String usuario="root";
    String contraseña="contraseña";
    String bd="bdusuarios";
    String ip="localhost";
    String puerto="3306";
    
    String cadena="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConexion (){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contraseña);
            
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente a la BD");
            
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "No se conecto correctamente a la BD");
        }
        
        return conectar;
        
    }
    
    public void cerrarConexion () {
    
        try {
            if (conectar != null && !conectar.isClosed()) {
                
                conectar.close();
                //JOptionPane.showMessageDialog(null, "Conexión Cerrada");
                
            }
        } catch (Exception e) {
            
            //JOptionPane.showMessageDialog(null, "No se pudo cerrar la conexión");
        }
    }
    
}
