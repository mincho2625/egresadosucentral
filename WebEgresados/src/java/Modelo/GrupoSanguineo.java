package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class GrupoSanguineo {

    private long idGrupoSanguineo;
    private String nombre;

    /**
     * @return the idGrupoSanguineo
     */
    public long getIdGrupoSanguineo() {
        return idGrupoSanguineo;
    }

    /**
     * @param idGrupoSanguineo the idGrupoSanguineo to set
     */
    public void setIdGrupoSanguineo(long idGrupoSanguineo) {
        this.idGrupoSanguineo = idGrupoSanguineo;
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
