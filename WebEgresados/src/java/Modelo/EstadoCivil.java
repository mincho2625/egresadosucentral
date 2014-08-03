package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class EstadoCivil {

    private long idEstadoCivil;
    private String nombre;

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
}
