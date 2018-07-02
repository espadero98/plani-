/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kike
 */
public class ControladorAsignatura {
    
    static Conexion cn;
    static ResultSet rs;
    static PreparedStatement ps = null;

   
   
   
    public static void Agregar(Asignatura asig) throws ErrorPlanificacion{
        
        try {
            String sql = "INSERT INTO asignatura(idAsignatura,asignatura,horasTeoricas,horasPracticas,numeroUnidades,nombrePdf,descripcionPdf) VALUES('"+asig.getIdAsignatura()+"','"+asig.getAsignatura()+"','"+asig.getHorasTeoricas()+"','"+asig.getHorasPracticas()+"','"+asig.getNumeroUnidades()+"','"+asig.getNombrePdf()+"',?)";

            cn=new Conexion();
            ps=cn.conexion.prepareStatement(sql);
            ps.setBytes(1, asig.getDescripcionPdf());
            ps.executeUpdate();
            
//            cn.st.executeUpdate("INSERT INTO asignatura(idAsignatura,asignatura,horasTeoricas,horasPracticas,numeroUnidades,nombrePdf,descripcionPdf) VALUES('"+asig.getIdAsignatura()+"','"+asig.getAsignatura()+"','"+asig.getHorasTeoricas()+"','"+asig.getHorasPracticas()+"','"+asig.getNumeroUnidades()+"','"+asig.getNombrePdf()+"','"+asig.getDescripcionPdf()+"');");
            //cn.st.executeUpdate("INSERT INTO inventario(IdSucursal,CodBarra,Cantidad) VALUES('"+pr.getIdSucursal()+"','"+pr.getCodBarra()+"','"+pr.getInventario()+"')");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorAsignatura/Agregar",e.getMessage());
        }
           
    }
    
    public static void Modificar(Asignatura asig) throws ErrorPlanificacion{
        try {
            cn=new Conexion();
            cn.st.execute("UPDATE asignatura SET idAsignatura='"+asig.getIdAsignatura()+"',asignatura='"+asig.getAsignatura()+"',horasTeoricas='"+asig.getHorasTeoricas()+"',horasPracticas='"+asig.getHorasPracticas()+"',numeroUnidades='"+asig.getNumeroUnidades()+"', nombrePdf='"+asig.getNombrePdf()+"',descripcionPdf='"+asig.getDescripcionPdf()+"' WHERE idAsignatura='"+asig.getIdAsignatura()+"'");
            //cn.st.execute("UPDATE inventario SET IdSucursal='"+pr.getIdSucursal()+"',CodBarra='"+pr.getCodBarra()+"',Cantidad='"+pr.getInventario()+"' WHERE CodBarra='"+pr.getCodBarra()+"'");
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorAsignatura/Modificar",e.getMessage());
        }
    }
    
    public static void Eliminar(Asignatura pr) throws ErrorPlanificacion{
        
            
            
        try {
            cn.st.executeUpdate("DELETE FROM asignatura WHERE idAsignatura='"+pr.getIdAsignatura()+"'");
        } catch (SQLException ex) {
            throw new ErrorPlanificacion("Class ControladorAsignatura/Modificar",ex.getMessage());
        }
                
                
            
        
    }
    
    
    public static ArrayList<Asignatura> Buscar() throws ErrorPlanificacion{
        ArrayList<Object> asignatura = new ArrayList<Object>();
        
        cn=new Conexion();
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT asignatura.idAsignatura,asignatura.asignatura,asignatura.horasTeoricas,asignatura.horasPracticas, asignatura.numeroUnidades,asignatura.nombrePdf,asignatura.descripcionPdf FROM asignatura ");
            
                while (rs.next()) {
                    asignatura.add(rs.getString(1));
                    asignatura.add(rs.getString(2));
                    asignatura.add(rs.getString(3));
                    asignatura.add(rs.getString(4));
                    asignatura.add(rs.getString(5));
                    asignatura.add(rs.getString(6));
                    asignatura.add(rs.getBytes(7));
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorAsignatura/Buscar",e.getMessage());
        }
        
        ArrayList<Asignatura> asignaturas=(ArrayList) asignatura;
        
        return asignaturas;
    }
    
    public static byte[] obtenerPdf(String idAsignatura)throws ErrorPlanificacion{
        byte[] pdf=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT asignatura.descripcionPdf FROM asignatura WHERE descripcionPdf='"+idAsignatura+"'");
            
                while (rs.next()) {
                    
                    pdf=rs.getBytes(7);
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorAsignatura/Buscar",e.getMessage());
        }
        return pdf;
    }
    
     public void ejecutar_archivoPDF(String id) {

        
        
        byte[] b = null;

        try {
            rs = cn.st.executeQuery("SELECT descripcionPdf FROM asignatura WHERE idAsignatura ='"+id+"'");
            
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
     
     public static String obtenerCodigo(String asig)throws ErrorPlanificacion{
        String codigo=null;
        try {
            rs=cn.st.executeQuery("SELECT DISTINCT asignatura.idAsignatura FROM asignatura WHERE asignatura='"+asig+"'");
            
                while (rs.next()) {
                    
                    codigo=rs.getString(1);
                }
            
            
        } catch (SQLException e) {
            throw new ErrorPlanificacion("Class ControladorMetodologiaAsignatura/Buscar",e.getMessage());
        }
        return codigo;
    }
    
    
     
}

