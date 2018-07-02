/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorAsignatura.rs;
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
public class ControladorUsuario {
    
    static Conexion cn;
    static ResultSet rs;

   
   
   
    public static void Agregar(Usuario meto) throws ErrorPlanificacion{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO usuario(idUsuario,usuario,password,nombre,apellido,edad) VALUES('"+meto.getIdUsuario()+"','"+meto.getUsuario()+"','"+meto.getPassword()+"','"+meto.getNombre()+"','"+meto.getApellido()+"','"+meto.getEdad()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUsuario/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Usuario asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE usuario SET idUsuario='"+asig.getIdUsuario()+"',usuario='"+asig.getUsuario()+"',password='"+asig.getPassword()+"',nombre='"+asig.getNombre()+"',apellido='"+asig.getApellido()+"',edad='"+asig.getEdad()+"' WHERE idUsuario='"+asig.getIdUsuario()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUsuario/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Usuario pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM usuario WHERE idUsuario='"+pr.getIdUsuario()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorUsuario/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<Usuario> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> usuario = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT usuario.idUsuario, usuario.usuario,usuario.password,usuario.nombre,usuario.apellido,usuario.edad FROM usuario");
            
                while (rs.next()) {
                    usuario.add(rs.getString(1));
                    usuario.add(rs.getString(2));
                    usuario.add(rs.getString(3));
                    usuario.add(rs.getString(4));
                    usuario.add(rs.getString(5));
                    usuario.add(rs.getString(6));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorGrupo/Buscar",e.getMessage());
        }
        
        ArrayList<Usuario> usuarios=(ArrayList) usuario;
        
        return usuarios;
    }
    
    public static String obtenerPass(String usuario) throws ErrorPlanificacion{
        String password="";
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT usuario.password FROM usuario WHERE usuario.usuario='"+usuario+"'");
            
                while (rs.next()) {
                    password=rs.getString(1);
                }
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorGrupo/BuscarPass",e.getMessage());
        }
        
       return password;
    }
    
    
   public static String obtenerCodigo(String asig)throws ErrorPlanificacion{
        String codigo=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT usuario.idUsuario FROM usuario WHERE usuario='"+asig+"'");
            
                while (rs.next()) {
                    
                    codigo=rs.getString(1);
                }
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologiaAsignatura/Buscar",e.getMessage());
        }
        return codigo;
    }
}

