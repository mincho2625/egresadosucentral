package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class TipoDocumento {

    private long idTipoDocumento;
    private String nombre;
    private boolean estado;

    public TipoDocumento() {}
    
    public TipoDocumento(long idTipoDocumento)
    {
        this.idTipoDocumento = idTipoDocumento;
    }
    
    /**
     * @return the idTipoDocumento
     */
    public long getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     * @param idTipoDocumento the idTipoDocumento to set
     */
    public void setIdTipoDocumento(long idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
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
