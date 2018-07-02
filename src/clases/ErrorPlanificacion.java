
package clases;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ErrorPlanificacion extends Exception {
    

    public ErrorPlanificacion(String ClaseMetodo,String mensajeError){
        super(ClaseMetodo+mensajeError);
        JOptionPane.showMessageDialog(null, ClaseMetodo+"{------}"+mensajeError);
    }
    

    
}
