package Modelo;

public class TipoContacto {

    private long idTipoContacto;
    private String nombre;
    private boolean estado;
    private boolean obligatorio;
    private TipoCampo idTipoCampo;
    private int longitud;
    private boolean soloLectura;
    
    public TipoContacto() {}
    
    public TipoContacto(long idTipoContacto) {
        this.idTipoContacto = idTipoContacto;
    }

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

    /**
     * @return the obligatorio
     */
    public boolean isObligatorio() {
        return obligatorio;
    }

    /**
     * @param obligatorio the obligatorio to set
     */
    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }

    /**
     * @return the idTipoCampo
     */
    public TipoCampo getIdTipoCampo() {
        return idTipoCampo;
    }

    /**
     * @param idTipoCampo the idTipoCampo to set
     */
    public void setIdTipoCampo(TipoCampo idTipoCampo) {
        this.idTipoCampo = idTipoCampo;
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
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