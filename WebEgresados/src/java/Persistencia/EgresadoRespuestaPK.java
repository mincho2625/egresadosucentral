/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author YURY
 */
@Embeddable
public class EgresadoRespuestaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_EGRESADO")
    private int idEgresado;
    @Basic(optional = false)
    @Column(name = "ID_RESPUESTA")
    private int idRespuesta;

    public EgresadoRespuestaPK() {
    }

    public EgresadoRespuestaPK(int idEgresado, int idRespuesta) {
        this.idEgresado = idEgresado;
        this.idRespuesta = idRespuesta;
    }

    public int getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(int idEgresado) {
        this.idEgresado = idEgresado;
    }

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEgresado;
        hash += (int) idRespuesta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresadoRespuestaPK)) {
            return false;
        }
        EgresadoRespuestaPK other = (EgresadoRespuestaPK) object;
        if (this.idEgresado != other.idEgresado) {
            return false;
        }
        if (this.idRespuesta != other.idRespuesta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EgresadoRespuestaPK[ idEgresado=" + idEgresado + ", idRespuesta=" + idRespuesta + " ]";
    }
    
}
