package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
@Equivalencia(nombre = "getIdCiudad")
public class Ciudad {
    
    public Ciudad() { }
    
    public Ciudad(long idCiudad)
    {
        this.idCiudad = idCiudad;
    }

    private long idCiudad;
    private String nombre;
    private boolean estado;
    private Departamento idDepartamento;
    private boolean soloLectura;

    /**
     * @return the idCiudad
     */
    public long getIdCiudad() {
        return idCiudad;
    }

    /**
     * @param idCiudad the idCiudad to set
     */
    public void setIdCiudad(long idCiudad) {
        this.idCiudad = idCiudad;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the idDepartamento
     */
    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    /**
     * @param idDepartamento the idDepartamento to set
     */
    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    /**
     * @return the soloLectura
     */
    public boolean isSoloLectura() {
        return soloLectura;
    }

    /**
     * @param soloLectura the soloLectura to set
     */
    public void setSoloLectura(boolean soloLectura) {
        this.soloLectura = soloLectura;
    }
}