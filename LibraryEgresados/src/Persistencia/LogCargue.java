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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "log_cargue")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logcargue.findAll", query = "SELECT m FROM LogCargue m WHERE m.idProcesoCargue = :idProcesoCargue")})
public class LogCargue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LOG_CARGUE")
    private Long idLogCargue;
    @Basic(optional = true)
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;
    @Basic(optional = false)
    @Column(name = "LINEA")
    private int linea;
    @JoinColumn(name = "ID_EGRESADO", referencedColumnName = "ID_EGRESADO")
    @ManyToOne(optional = true)
    private Egresado idEgresado;
    @JoinColumn(name = "ID_PROCESO_CARGUE", referencedColumnName = "ID_PROCESO_CARGUE")
    @ManyToOne(optional = false)
    private ProcesoCargue idProcesoCargue;
    @JoinColumn(name = "ID_ESTADO_LOG", referencedColumnName = "ID_ESTADO_LOG")
    @ManyToOne(optional = false)
    private EstadoLog idEstadoLog;
    @Basic(optional = true)
    @Column(name = "ERROR")
    private String error;

    /**
     * @return the idLogCargue
     */
    public Long getIdLogCargue() {
        return idLogCargue;
    }

    /**
     * @param idLogCargue the idLogCargue to set
     */
    public void setIdLogCargue(Long idLogCargue) {
        this.idLogCargue = idLogCargue;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the linea
     */
    public int getLinea() {
        return linea;
    }

    /**
     * @param linea the linea to set
     */
    public void setLinea(int linea) {
        this.linea = linea;
    }

    /**
     * @return the idEgresado
     */
    public Egresado getIdEgresado() {
        return idEgresado;
    }

    /**
     * @param idEgresado the idEgresado to set
     */
    public void setIdEgresado(Egresado idEgresado) {
        this.idEgresado = idEgresado;
    }

    /**
     * @return the idProcesoCargue
     */
    public ProcesoCargue getIdProcesoCargue() {
        return idProcesoCargue;
    }

    /**
     * @param idProcesoCargue the idProcesoCargue to set
     */
    public void setIdProcesoCargue(ProcesoCargue idProcesoCargue) {
        this.idProcesoCargue = idProcesoCargue;
    }
    
    /**
     * @return the idEstadoLog
     */
    public EstadoLog getIdEstadoLog() {
        return idEstadoLog;
    }

    /**
     * @param idEstadoLog the idEstadoLog to set
     */
    public void setIdEstadoLog(EstadoLog idEstadoLog) {
        this.idEstadoLog = idEstadoLog;
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
        hash += (idLogCargue != null ? idLogCargue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogCargue)) {
            return false;
        }
        LogCargue other = (LogCargue) object;
        return !((this.idLogCargue == null && other.idLogCargue != null) || (this.idLogCargue != null && !this.idLogCargue.equals(other.idLogCargue)));
    }

    @Override
    public String toString() {
        return "Persistencia.LogCargue[ idLogCargue=" + idLogCargue + " ]";
    }
}