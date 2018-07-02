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
public class ControladorMetodologia {
    
    static Conexion cn;
    static ResultSet rs;

   
   
   
    public static void Agregar(Metodologia meto) throws ErrorPlanificacion{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO metodologia(idMetodologia,metodologia,descripcion) VALUES('"+meto.getIdMetodologia()+"','"+meto.getMetodologia()+"','"+meto.getDescripcion()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologia/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Metodologia asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE metodologia SET idMetodologia='"+asig.getIdMetodologia()+"',metodologia='"+asig.getMetodologia()+"',descripcion='"+asig.getDescripcion()+"' WHERE idMetodologia='"+asig.getIdMetodologia()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologia/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Metodologia pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM metodologia WHERE idMetodologia='"+pr.getIdMetodologia()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorMetodologia/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<Metodologia> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> metodologia = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT metodologia.idMetodologia, metodologia.metodologia,metodologia.descripcion FROM metodologia");
            
                while (rs.next()) {
                    metodologia.add(rs.getString(1));
                    metodologia.add(rs.getString(2));
                    metodologia.add(rs.getString(3));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorGrupo/Buscar",e.getMessage());
        }
        
        ArrayList<Metodologia> metodologias=(ArrayList) metodologia;
        
        return metodologias;
    }
    
    
   public static String obtenerCodigo(String asig)throws ErrorPlanificacion{
        String codigo=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT metodologia.idMetodologia FROM metodologia WHERE metodologia='"+asig+"'");
            
                while (rs.next()) {
                    
                    codigo=rs.getString(1);
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologia/Buscar",e.getMessage());
        }
        return codigo;
    }
}

