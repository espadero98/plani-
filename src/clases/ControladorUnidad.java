/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import static clases.ControladorAsignatura.cn;
import static clases.ControladorAsignatura.rs;
import static clases.ControladorSubUnidad.rs;
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
public class ControladorUnidad {
    
    static Conexion cn;
    static ResultSet rs;
    static PreparedStatement ps = null;
   
   
   
    public static void Agregar(Unidad meto) throws ErrorPlanificacion{
        
        try {
            cn=new Conexion();
            String sql="INSERT INTO unidad(idUnidad,nombre,numeroUnidad,descripcion,idAsignatura,nombrePdf,pdfUnidad) VALUES('"+meto.getIdUnidad()+"','"+meto.getNombre()+"','"+meto.getNumeroUnidad()+"','"+meto.getDescripcion()+"','"+meto.getIdAsignatura()+"','"+meto.getNombrePdf()+"',?)";
            cn=new Conexion();
            ps=cn.conexion.prepareStatement(sql);
            ps.setBytes(1, meto.getPdfUnidad());
            ps.executeUpdate();
//            cn.st.executeUpdate("INSERT INTO unidad(idUnidad,nombre,numeroUnidad,descripcion,idAsignatura,nombrePdf,pdfUnidad) VALUES('"+meto.getIdUnidad()+"','"+meto.getNombre()+"','"+meto.getNumeroUnidad()+"','"+meto.getDescripcion()+"','"+meto.getIdAsignatura()+"','"+meto.getNombrePdf()+"','"+meto.getPdfUnidad()+"')");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Unidad asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE unidad SET idUnidad='"+asig.getIdUnidad()+"',nombre='"+asig.getNombre()+"',numeroUnidad='"+asig.getNumeroUnidad()+"', descripcion='"+asig.getDescripcion()+"', idAsignatura='"+asig.getIdAsignatura()+"',nombrePdf='"+asig.getNombrePdf()+"',pdfUnidad='"+asig.getPdfUnidad()+"' WHERE idUnidad='"+asig.getIdUnidad()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Unidad pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM unidad WHERE idUnidad='"+pr.getIdUnidad()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Eliminar",ex.getMessage());
        }
                
    }
    
    
    public static ArrayList<Unidad> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> unidad = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT unidad.idUnidad, unidad.nombre,unidad.numeroUnidad,unidad.descripcion,asignatura.asignatura,unidad.nombrePdf,unidad.pdfUnidad FROM unidad INNER JOIN asignatura ON asignatura.idAsignatura=unidad.idAsignatura");
            
                while (rs.next()) {
                    unidad.add(rs.getString(1));
                    unidad.add(rs.getString(2));
                    unidad.add(rs.getString(3));
                    unidad.add(rs.getString(4));
                    unidad.add(rs.getString(5));
                    unidad.add(rs.getString(6));
                    unidad.add(rs.getBytes(7));
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Buscar",e.getMessage());
        }
        
        ArrayList<Unidad> unidades=(ArrayList) unidad;
        
        return unidades;
    }
    
    
    

    

    
    public static String Obtener(String asignatura) throws ErrorPlanificacion{
        String idAsignatura="";
        
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT idAsignatura FROM asignatura  WHERE  asignatura.asignatura='"+asignatura+"'");
            while (rs.next()) {
                idAsignatura=rs.getString(1);
                System.out.println(idAsignatura+"salu");
            }
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/Obtener",e.getMessage());
        }
        return idAsignatura;
    }
    
     public static byte[] obtenerPdf(String idUnidad)throws ErrorPlanificacion{
        byte[] pdf=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT unidad.pdfUnidad FROM unidad WHERE pdfUnidad='"+idUnidad+"'");
            
                while (rs.next()) {
                    
                    pdf=rs.getBytes(7);
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorUnidad/BuscarPdf",e.getMessage());
        }
        return pdf;
    }
    
    
     public void ejecutar_archivoPDF(String id) {

        
        
        byte[] b = null;

        try {
            rs = cn.st.executeQuery("SELECT pdfUnidad FROM unidad WHERE idUnidad ='"+id+"'");
            
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

