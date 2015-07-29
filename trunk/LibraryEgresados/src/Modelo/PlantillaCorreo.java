/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author YURY
 */
public class PlantillaCorreo {
    private long idPlantillaCorreo;
    private String nombre;
    private String asunto;
    private String contenido;
    private boolean estado;
    private boolean soloLectura;

    /**
     * @return the idPlantillaCorreo
     */
    public long getIdPlantillaCorreo() {
        return idPlantillaCorreo;
    }

    /**
     * @param idPlantillaCorreo the idPlantillaCorreo to set
     */
    public void setIdPlantillaCorreo(long idPlantillaCorreo) {
        this.idPlantillaCorreo = idPlantillaCorreo;
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
     * @return the asunto
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
    /**
     * @return the texto
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * @param contenido
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
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