/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "estado_proceso")
@XmlRootElement
public class EstadoProceso implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_PROCESO")
    private Long idEstadoProceso;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    /**
     * @return the idEstadoProceso
     */
    public Long getIdEstadoProceso() {
        return idEstadoProceso;
    }

    /**
     * @param idEstadoProceso the idEstadoProceso to set
     */
    public void setIdEstadoProceso(Long idEstadoProceso) {
        this.idEstadoProceso = idEstadoProceso;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProceso != null ? idEstadoProceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProceso)) {
            return false;
        }
        EstadoProceso other = (EstadoProceso) object;
        return !((this.idEstadoProceso == null && other.idEstadoProceso != null) || (this.idEstadoProceso != null && !this.idEstadoProceso.equals(other.idEstadoProceso)));
    }

    @Override
    public String toString() {
        return "Persistencia.EstadoProceso[ idTipoDocumento=" + idEstadoProceso + " ]";
    }
}