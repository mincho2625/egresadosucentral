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
    @Column(name = "ID_RESPUESTA")
    private long idRespuesta;
    @Basic(optional = false)
    @Column(name = "ID_EGRESADO")
    private long idEgresado;

    public EgresadoRespuestaPK() {
    }

    public EgresadoRespuestaPK(long idRespuesta, long idEgresado) {
        this.idRespuesta = idRespuesta;
        this.idEgresado = idEgresado;
    }

    public long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public long getIdEgresado() {
        return idEgresado;
    }

    public void setIdEgresado(long idEgresado) {
        this.idEgresado = idEgresado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idRespuesta;
        hash += (int) idEgresado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EgresadoRespuestaPK)) {
            return false;
        }
        EgresadoRespuestaPK other = (EgresadoRespuestaPK) object;
        if (this.idRespuesta != other.idRespuesta) {
            return false;
        }
        if (this.idEgresado != other.idEgresado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.EgresadoRespuestaPK[ idRespuesta=" + idRespuesta + ", idEgresado=" + idEgresado + " ]";
    }
    
}
