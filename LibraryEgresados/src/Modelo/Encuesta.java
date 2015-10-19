/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;



/**
 *
 * @author YURY
 */
public class Encuesta {
    private long idEncuesta;
    private String nombre;
    private String descripcion;
    private boolean estado;
    private int orden;
    private boolean graduando;
    private boolean egresado;
    private Date fechaRegistro;

    public Encuesta() {
    }
        
    public Encuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    

    public boolean isGraduando() {
        return graduando;
    }

    public void setGraduando(boolean graduando) {
        this.graduando = graduando;
    }

    public boolean isEgresado() {
        return egresado;
    }

    public void setEgresado(boolean egresado) {
        this.egresado = egresado;
    }

    
    /**
     * @return the idEncuesta
     */
    public long getIdEncuesta() {
        return idEncuesta;
    }

    /**
     * @param idEncuesta the idEncuesta to set
     */
    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
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
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return (estado ? "Activo" : "Inactivo");
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the orden
     */
    public int getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(int orden) {
        this.orden = orden;
    }
}
