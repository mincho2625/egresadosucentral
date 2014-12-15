package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:57:25 a.m.
 */
public class Pais {

    private long idPais;
    private String nombre;
    private boolean estado;
    
    public Pais() {}
    
    public Pais(long idPais)
    {
        this.idPais = idPais;
    }
    
    /**
     * @return the idPais
     */
    public long getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(long idPais) {
        this.idPais = idPais;
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
}
