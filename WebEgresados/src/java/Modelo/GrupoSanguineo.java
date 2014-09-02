package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:26 a.m.
 */
public class GrupoSanguineo {

    private long idGrupoSanguineo;
    private String grupoSanguineo;
    private boolean estado;

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
     * @return the grupoSanguineo
     */
    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    /**
     * @param grupoSanguineo the grupoSanguineo to set
     */
    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
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
