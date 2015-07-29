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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "estado_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoLog.findAll", query = "SELECT e FROM EstadoLog e"),
    @NamedQuery(name = "EstadoLog.findByIdEstadoLog", query = "SELECT e FROM EstadoLog e WHERE e.idEstadoLog = :idEstadoLog"),
    @NamedQuery(name = "EstadoLog.findByNombre", query = "SELECT e FROM EstadoLog e WHERE e.nombre = :nombre")})
public class EstadoLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_LOG")
    private Long idEstadoLog;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;

    public EstadoLog() {
    }

    public EstadoLog(Long idEstadoLog) {
        this.idEstadoLog = idEstadoLog;
    }

    public EstadoLog(Long idEstadoLog, String nombre) {
        this.idEstadoLog = idEstadoLog;
        this.nombre = nombre;
    }

    public Long getIdEstadoLog() {
        return idEstadoLog;
    }

    public void setIdEstadoLog(Long idEstadoLog) {
        this.idEstadoLog = idEstadoLog;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoLog != null ? idEstadoLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoLog)) {
            return false;
        }
        EstadoLog other = (EstadoLog) object;
        return !((this.idEstadoLog == null && other.idEstadoLog != null) || (this.idEstadoLog != null && !this.idEstadoLog.equals(other.idEstadoLog)));
    }

    @Override
    public String toString() {
        return "Persistencia.EstadoLog[ idEstadoLog=" + idEstadoLog + " ]";
    }
}