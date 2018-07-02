
package clases;

public class Asignatura {
    
    private String idAsignatura;
    private String asignatura;
    private int horasTeoricas;
    private int horasPracticas;
    private int numeroUnidades;
    private String nombrePdf;
    private byte[] descripcionPdf;
    
    public String getNombrePdf() {
        return nombrePdf;
    }

    public void setNombrePdf(String nombrePdf) {
        this.nombrePdf = nombrePdf;
    }
   

    public byte[] getDescripcionPdf() {
        return descripcionPdf;
    }

    public void setDescripcionPdf(byte[] descripcionPdf) {
        this.descripcionPdf = descripcionPdf;
    }

    public String getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(String idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getHorasTeoricas() {
        return horasTeoricas;
    }

    public void setHorasTeoricas(int horasTeoricas) {
        this.horasTeoricas = horasTeoricas;
    }

    public int getHorasPracticas() {
        return horasPracticas;
    }

    public void setHorasPracticas(int horasPracticas) {
        this.horasPracticas = horasPracticas;
    }

    public int getNumeroUnidades() {
        return numeroUnidades;
    }

    public void setNumeroUnidades(int numeroUnidades) {
        this.numeroUnidades = numeroUnidades;
    }
    
    

}
