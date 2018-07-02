
package clases;

public class Unidad {
    
    private String idUnidad;
    private String nombre;
    private int numeroUnidad;
    private String descripcion;
    private String idAsignatura;
    private String nombrePdf;

    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }
    private byte [] pdfUnidad;

    public byte[] getPdfUnidad() {
        return pdfUnidad;
    }

    public void setPdfUnidad(byte[] pdfUnidad) {
        this.pdfUnidad = pdfUnidad;
    }

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(int numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }
    

    
    
    
}
