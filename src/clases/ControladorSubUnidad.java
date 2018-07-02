/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorAsignatura.cn;
import static clases.ControladorAsignatura.rs;
import static clases.ControladorUnidad.cn;
import static clases.ControladorUnidad.rs;
import java.io.ByteArrayInputStream;
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
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kike
 */
public class ControladorSubUnidad {
    
    static Conexion cn;
    static ResultSet rs;
    static PreparedStatement ps = null;
   
   
   
    public static void Agregar(SubUnidad meto) throws ErrorPlanificacion{
        
        try {
            String sql="INSERT INTO subunidad(idSubUnidad,nombre,nombrePdf,pdfSubUnidad,idUnidad) VALUES('"+meto.getIdSubUnidad()+"','"+meto.getNombre()+"','"+meto.getNombrePdf()+"',?,'"+meto.getIdUnidad()+"')";
            cn=new Conexion();
            ps=cn.conexion.prepareStatement(sql);
            ps.setBytes(1, meto.getPdf());
            ps.executeUpdate();
            
//            cn.st.executeUpdate("INSERT INTO subunidad(idSubUnidad,nombre,nombrePdf,pdfSubUnidad,idUnidad) VALUES('"+meto.getIdSubUnidad()+"','"+meto.getNombre()+"','"+meto.getNombrePdf()+"','"+meto.getPdf()+"','"+meto.getIdUnidad()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorSubUnidad/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(SubUnidad asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE subunidad SET idSubUnidad='"+asig.getIdSubUnidad()+"',nombre='"+asig.getNombre()+"',nombrePdf='"+asig.getNombrePdf()+"',pdfSubUnidad='"+asig.getPdf()+"',idUnidad='"+asig.getIdUnidad()+"' WHERE idSubUnidad='"+asig.getIdSubUnidad()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorSubUnidad/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(SubUnidad pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM subunidad WHERE idSubUnidad='"+pr.getIdSubUnidad()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorSubUnidad/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<SubUnidad> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> sub = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT subunidad.idSubUnidad, subunidad.nombre,subunidad.nombrePdf,subunidad.pdfSubUnidad,subunidad.idUnidad FROM subunidad");
            
                while (rs.next()) {
                    sub.add(rs.getString(1));
                    sub.add(rs.getString(2));
                    sub.add(rs.getString(3));
                    sub.add(rs.getBytes(4));
                    sub.add(rs.getString(5));
                    
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorGrupo/Buscar",e.getMessage());
        }
        
        ArrayList<SubUnidad> subunidades=(ArrayList) sub;
        
        return subunidades;
    }
    
    
    
public static String Obtener(String unidad) throws ErrorPlanificacion{
        String idAsignatura="";
        
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT idUnidad FROM unidad  WHERE  unidad.nombre='"+unidad+"'");
            while (rs.next()) {
                idAsignatura=rs.getString(1);
                
            }
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Obtener",e.getMessage());
        }
        return idAsignatura;
    }


    public static byte[] obtenerPdf(String idUnidad)throws ErrorPlanificacion{
        byte[] pdf=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT subunidad.pdfSubUnidad FROM subunidad WHERE pdfSubUnidad='"+idUnidad+"'");
            
                while (rs.next()) {
                    
                    pdf=rs.getBytes(4);
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/BuscarPdf",e.getMessage());
        }
        return pdf;
    }
    
    
    public void ejecutar_archivoPDF(String id) {

        
        
        byte[] b = null;

        try {
            rs = cn.st.executeQuery("SELECT pdfSubUnidad FROM subunidad WHERE idSubUnidad ='"+id+"'");
            
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            rs.close();
            

        } catch (IOException | NumberFormatException | SQLException ex) {
            System.out.println("Error al abrir archivo PDF " + ex.getMessage());
        }
    }
}

