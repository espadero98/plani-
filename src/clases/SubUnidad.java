
package clases;

public class SubUnidad {
    
    private String idSubUnidad;
    private String nombre;
    private String idUnidad;
    private String nombrePdf;

    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }
    private byte[] pdf;

    public byte[] getPdf() {
        return pdf;
    }

    public void setPdf(byte[] pdf) {
        this.pdf = pdf;
    }

    public String getIdSubUnidad() {
        return idSubUnidad;
    }

    public void setIdSubUnidad(String idSubUnidad) {
        this.idSubUnidad = idSubUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(String idUnidad) {
        this.idUnidad = idUnidad;
    }
    
    
    
}
