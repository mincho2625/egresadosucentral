/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "columna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Columna.findAll", query = "SELECT c FROM Columna c"),
    @NamedQuery(name = "Columna.findByIdColumna", query = "SELECT c FROM Columna c WHERE c.idColumna = :idColumna"),
    @NamedQuery(name = "Columna.findByIdColumnas", query = "SELECT c FROM Columna c WHERE c.idColumna in :idColumna"),
    @NamedQuery(name = "Columna.findByNombre", query = "SELECT c FROM Columna c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Columna.findByValor", query = "SELECT c FROM Columna c WHERE c.valor = :valor"),
    @NamedQuery(name = "Columna.findByEstado", query = "SELECT c FROM Columna c WHERE c.estado = :estado"),
    @NamedQuery(name = "Columna.findByDisponible", query =
            "SELECT c FROM Columna c " +
            "left join UsuarioColumna uc on uc.idColumna = c " +
            "where uc.idUsuarioColumna is null and c.estado = :estado")})
public class Columna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_COLUMNA")
    private Long idColumna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VALOR")
    private String valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ESTADO")
    private boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idColumna")
    private Collection<UsuarioColumna> usuarioColumnaCollection;

    public Columna() {
    }

    public Columna(Long idColumna) {
        this.idColumna = idColumna;
    }

    public Columna(Long idColumna, String nombre, String valor, boolean estado) {
        this.idColumna = idColumna;
        this.nombre = nombre;
        this.valor = valor;
        this.estado = estado;
    }

    public Long getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(Long idColumna) {
        this.idColumna = idColumna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<UsuarioColumna> getUsuarioColumnaCollection() {
        return usuarioColumnaCollection;
    }

    public void setUsuarioColumnaCollection(Collection<UsuarioColumna> usuarioColumnaCollection) {
        this.usuarioColumnaCollection = usuarioColumnaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColumna != null ? idColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Columna)) {
            return false;
        }
        Columna other = (Columna) object;
        if ((this.idColumna == null && other.idColumna != null) || (this.idColumna != null && !this.idColumna.equals(other.idColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlador.Columna[ idColumna=" + idColumna + " ]";
    }
    
}
