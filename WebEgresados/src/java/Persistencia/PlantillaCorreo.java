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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "plantilla_correo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PlantillaCorreo.findAll", query = "SELECT p FROM PlantillaCorreo p"),
    @NamedQuery(name = "PlantillaCorreo.findByIdPlantillaCorreo", query = "SELECT p FROM PlantillaCorreo p WHERE p.idPlantillaCorreo = :idPlantillaCorreo"),
    @NamedQuery(name = "PlantillaCorreo.findByNombre", query = "SELECT p FROM PlantillaCorreo p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "PlantillaCorreo.findByTexto", query = "SELECT p FROM PlantillaCorreo p WHERE p.texto = :texto"),
    @NamedQuery(name = "PlantillaCorreo.findByEstado", query = "SELECT p FROM PlantillaCorreo p WHERE p.estado = :estado")})
public class PlantillaCorreo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PLANTILLA_CORREO")
    private Long idPlantillaCorreo;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "TEXTO")
    private String texto;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private boolean estado;

    public PlantillaCorreo() {
    }

    public PlantillaCorreo(Long idPlantillaCorreo) {
        this.idPlantillaCorreo = idPlantillaCorreo;
    }

    public PlantillaCorreo(Long idPlantillaCorreo, String nombre, String texto, boolean estado) {
        this.idPlantillaCorreo = idPlantillaCorreo;
        this.nombre = nombre;
        this.texto = texto;
        this.estado = estado;
    }

    public Long getIdPlantillaCorreo() {
        return idPlantillaCorreo;
    }

    public void setIdPlantillaCorreo(Long idPlantillaCorreo) {
        this.idPlantillaCorreo = idPlantillaCorreo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlantillaCorreo != null ? idPlantillaCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlantillaCorreo)) {
            return false;
        }
        PlantillaCorreo other = (PlantillaCorreo) object;
        if ((this.idPlantillaCorreo == null && other.idPlantillaCorreo != null) || (this.idPlantillaCorreo != null && !this.idPlantillaCorreo.equals(other.idPlantillaCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persistencia.PlantillaCorreo[ idPlantillaCorreo=" + idPlantillaCorreo + " ]";
    }
    
}
