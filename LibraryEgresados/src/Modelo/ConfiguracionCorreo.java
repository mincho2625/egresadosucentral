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
public class ConfiguracionCorreo {
    private long idConfiguracionCorreo;
    private String servidor;
    private String puerto;
    private String usuario;
    private String contrasenia;
    
    /**
     * @return the idConfiguracionCorreo
     */
    public long getIdConfiguracionCorreo() {
        return idConfiguracionCorreo;
    }

    /**
     * @param idConfiguracionCorreo the idConfiguracionCorreo to set
     */
    public void setIdConfiguracionCorreo(long idConfiguracionCorreo) {
        this.idConfiguracionCorreo = idConfiguracionCorreo;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}