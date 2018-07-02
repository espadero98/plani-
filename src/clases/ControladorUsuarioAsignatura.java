/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kike
 */
public class ControladorUsuarioAsignatura {
    
    static Conexion cn;
    static ResultSet rs;

   
   
   
    public static void Agregar(UsuarioAsignatura meto) throws ErrorPlanificacion{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO usuarioasignatura(idUsuario,idAsignatura) VALUES('"+meto.getIdUsuario()+"','"+meto.getIdAsignatura()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUsuarioAsignatura/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(UsuarioAsignatura asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE usuarioasignatura SET idUsuario='"+asig.getIdUsuario()+"',idAsignatura='"+asig.getIdAsignatura()+"' WHERE idUsuario='"+asig.getIdUsuario()+"' AND idAsignatura='"+asig.getIdAsignatura()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUsuarioAsignatura/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(UsuarioAsignatura pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM usuarioasignatura WHERE idUsuario='"+pr.getIdUsuario()+"' AND idAsignatura='"+pr.getIdAsignatura()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorUsuarioAsignatura/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<UsuarioAsignatura> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> metodologia = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
//            rs=cn.st.executeQuery("SELECT DISTINCT idMetodologia, idAsignatura FROM metodologiaasignatura");
            rs=cn.st.executeQuery("SELECT DISTINCT asignatura.asignatura, usuario.usuario FROM usuarioasignatura INNER JOIN asignatura ON usuarioasignatura.idAsignatura=asignatura.idAsignatura INNER JOIN usuario ON usuarioasignatura.idUsuario=usuario.idUsuario");
            
                while (rs.next()) {
                    metodologia.add(rs.getString(1));
                    metodologia.add(rs.getString(2));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUsuarioAsignatura/Buscar",e.getMessage());
        }
        
        ArrayList<UsuarioAsignatura> metodologias=(ArrayList) metodologia;
        
        return metodologias;
    }
    
}

