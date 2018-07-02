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
public class ControladorMetodologiaAsignatura {
    
    static Conexion cn;
    static ResultSet rs;

   
   
   
    public static void Agregar(MetodologiaAsignatura meto) throws ErrorPlanificacion{
        
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO metodologiaasignatura(idMetodologia,idAsignatura) VALUES('"+meto.getIdMetodologia()+"','"+meto.getIdAsignatura()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologiaAsignatura/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(MetodologiaAsignatura asig) throws ErrorPlanificacion{
        try {
            System.out.println(asig.getIdMetodologia()+asig.getIdAsignatura());
            cn=new Conexion();
            cn.st.execute("UPDATE metodologiaasignatura SET idMetodologia='"+asig.getIdMetodologia()+"',idAsignatura='"+asig.getIdAsignatura()+"' WHERE idMetodologia='"+asig.getIdMetodologia()+"' AND idAsignatura='"+asig.getIdAsignatura()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologia/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(MetodologiaAsignatura pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM metodologiaasignatura WHERE idMetodologia='"+pr.getIdMetodologia()+"' AND idAsignatura='"+pr.getIdAsignatura()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorMetodologiaAsignatura/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<MetodologiaAsignatura> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> metodologia = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
//            rs=cn.st.executeQuery("SELECT DISTINCT idMetodologia, idAsignatura FROM metodologiaasignatura");
            rs=cn.st.executeQuery("SELECT DISTINCT asignatura.asignatura, metodologia.metodologia FROM metodologiaasignatura INNER JOIN asignatura ON metodologiaasignatura.idAsignatura=asignatura.idAsignatura INNER JOIN metodologia ON metodologiaasignatura.idMetodologia=metodologia.idMetodologia");
            
                while (rs.next()) {
                    metodologia.add(rs.getString(1));
                    metodologia.add(rs.getString(2));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologiaAsignatura/Buscar",e.getMessage());
        }
        
        ArrayList<MetodologiaAsignatura> metodologias=(ArrayList) metodologia;
        
        return metodologias;
    }
    
}

