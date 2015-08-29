/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "proceso_cargue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProcesoCargue.findAllOrderByFechaInicio", query = "SELECT p FROM ProcesoCargue p order by p.fechaInicio DESC"),
    @NamedQuery(name = "ProcesoCargue.findAll", query = "SELECT p FROM ProcesoCargue p WHERE p.idProcesoCargue = :idProcesoCargue ")})
public class ProcesoCargue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROCESO_CARGUE")
    private Long idProcesoCargue;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "FECHA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;
    @JoinColumn(name = "ID_ESTADO_PROCESO", referencedColumnName = "ID_ESTADO_PROCESO")
    @ManyToOne(optional = false)
    private EstadoProceso idEstadoProceso;
    @Basic(optional = true)
    @Column(name = "ERROR")
    private String error;

    /**
     * @return the idProcesoCargue
     */
    public Long getIdProcesoCargue() {
        return idProcesoCargue;
    }

    /**
     * @param idProcesoCargue the idProcesoCargue to set
     */
    public void setIdProcesoCargue(Long idProcesoCargue) {
        this.idProcesoCargue = idProcesoCargue;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return the fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin the fechaFin to set
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**
     * @return the idEstadoProceso
     */
    public EstadoProceso getIdEstadoProceso() {
        return idEstadoProceso;
    }

    /**
     * @param idEstadoProceso the idEstadoProceso to set
     */
    public void setIdEstadoProceso(EstadoProceso idEstadoProceso) {
        this.idEstadoProceso = idEstadoProceso;
    }
    
    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcesoCargue != null ? idProcesoCargue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcesoCargue)) {
            return false;
        }
        ProcesoCargue other = (ProcesoCargue) object;
        return !((this.idProcesoCargue == null && other.idProcesoCargue != null) || (this.idProcesoCargue != null && !this.idProcesoCargue.equals(other.idProcesoCargue)));
    }

    @Override
    public String toString() {
        return "Persistencia.ProcesoCargue[ idProcesoCargue=" + idProcesoCargue + " ]";
    }
}