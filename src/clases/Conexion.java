
package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class Conexion {
     public Connection conexion;
     public  Statement st;
    
        
            
   
    public  Conexion() throws ErrorPlanificacion{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/planificacion", "root", "");  
            st = conexion.createStatement();
            
        } catch (Exception e) {
            throw new ErrorPlanificacion("Conexion.conexion()",e.getMessage());

        }
    }
    
    public Connection conectarBase() throws ErrorPlanificacion {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/planificacion", "root", "");
         } catch (Exception ex) {
            
         }
      }
      return conexion;
   }
    
}
