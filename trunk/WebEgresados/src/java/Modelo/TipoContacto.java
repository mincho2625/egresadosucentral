package Modelo;

public class TipoContacto {

    private long idTipoContacto;
    private String nombre;
    private boolean estado;

    public long getIdTipoContacto() {
        return idTipoContacto;
    }

    public void setIdTipoContacto(long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

    public String getNombre() {
        return nombre;
    }

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
