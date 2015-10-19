/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Persistencia.Usuario;
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
 * @author pc
 */
@Entity
@Table(name = "usuario_columna")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioColumna.findAll", query = "SELECT u FROM UsuarioColumna u"),
    @NamedQuery(name = "UsuarioColumna.findByIdUsuarioColumna", query = "SELECT u FROM UsuarioColumna u WHERE u.idUsuarioColumna = :idUsuarioColumna"),
    @NamedQuery(name = "UsuarioColumna.findByIdUsuario", query = ""
            + "SELECT uc FROM UsuarioColumna uc "
            + "inner join Usuario u on u = uc.idUsuario "
            + "inner join Columna c on c = uc.idColumna "
            + "WHERE u.idUsuario = :idUsuario and c.estado = :estado")})
public class UsuarioColumna implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_USUARIO_COLUMNA")
    private Long idUsuarioColumna;
    @JoinColumn(name = "ID_COLUMNA", referencedColumnName = "ID_COLUMNA")
    @ManyToOne(optional = false)
    private Columna idColumna;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public UsuarioColumna() {
    }

    public UsuarioColumna(Long idUsuarioColumna) {
        this.idUsuarioColumna = idUsuarioColumna;
    }

    public Long getIdUsuarioColumna() {
        return idUsuarioColumna;
    }

    public void setIdUsuarioColumna(Long idUsuarioColumna) {
        this.idUsuarioColumna = idUsuarioColumna;
    }

    public Columna getIdColumna() {
        return idColumna;
    }

    public void setIdColumna(Columna idColumna) {
        this.idColumna = idColumna;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuarioColumna != null ? idUsuarioColumna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioColumna)) {
            return false;
        }
        UsuarioColumna other = (UsuarioColumna) object;
        if ((this.idUsuarioColumna == null && other.idUsuarioColumna != null) || (this.idUsuarioColumna != null && !this.idUsuarioColumna.equals(other.idUsuarioColumna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Controlador.UsuarioColumna[ idUsuarioColumna=" + idUsuarioColumna + " ]";
    }
    
}
