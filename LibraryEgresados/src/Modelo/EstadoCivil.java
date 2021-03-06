package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class EstadoCivil {

    private long idEstadoCivil;
    private String estadoCivil;
    private boolean estado;

    public EstadoCivil() {}
    
    public EstadoCivil(long idEstadoCivil)
    {
        this.idEstadoCivil = idEstadoCivil;
    }
    
    /**
     * @return the idEstadoCivil
     */
    public long getIdEstadoCivil() {
        return idEstadoCivil;
    }

    /**
     * @param idEstadoCivil the idEstadoCivil to set
     */
    public void setIdEstadoCivil(long idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    /**
     * @return the estadoCivil
     */
    public String getEstadoCivil() {
        return estadoCivil;
    }

    /**
     * @param estadoCivil the estadoCivil to set
     */
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
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
