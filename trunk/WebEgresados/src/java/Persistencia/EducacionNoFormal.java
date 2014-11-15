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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "educacion_no_formal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducacionNoFormal.findAll", query = "SELECT e FROM EducacionNoFormal e"),
    @NamedQuery(name = "EducacionNoFormal.findByIdEducacion", query = "SELECT e FROM EducacionNoFormal e WHERE e.educacion = :educacion"),
    @NamedQuery(name = "EducacionNoFormal.findByOtroTipoEdNoFormal", query = "SELECT e FROM EducacionNoFormal e WHERE e.otroTipoEdNoFormal = :otroTipoEdNoFormal"),
    @NamedQuery(name = "EducacionNoFormal.findByTitulo", query = "SELECT e FROM EducacionNoFormal e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "EducacionNoFormal.findByDescripcion", query = "SELECT e FROM EducacionNoFormal e WHERE e.descripcion = :descripcion")})
public class EducacionNoFormal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "OTRO_TIPO_ED_NO_FORMAL")
    private String otroTipoEdNoFormal;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_TIPO_ED_NO_FORMAL", referencedColumnName = "ID_TIPO_ED_NO_FORMAL")
    @ManyToOne(optional = false)
    private TipoEdNoFormal idTipoEdNoFormal;
    @JoinColumn(name = "ID_INTENSIDAD_HORARIA", referencedColumnName = "ID_INTENSIDAD_HORARIA")
    @ManyToOne(optional = false)
    private IntensidadHoraria idIntensidadHoraria;
    @Id
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION")
    @OneToOne(optional = false)
    private Educacion educacion;
    @JoinColumn(name = "ID_AREA_ESTUDIOS", referencedColumnName = "ID_AREA_ESTUDIOS")
    @ManyToOne(optional = false)
    private AreaEstudios idAreaEstudios;
    @JoinColumn(name = "ID_MODALIDAD", referencedColumnName = "ID_MODALIDAD")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;

    public EducacionNoFormal() {
    }

    public String getOtroTipoEdNoFormal() {
        return otroTipoEdNoFormal;
    }

    public void setOtroTipoEdNoFormal(String otroTipoEdNoFormal) {
        this.otroTipoEdNoFormal = otroTipoEdNoFormal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoEdNoFormal getIdTipoEdNoFormal() {
        return idTipoEdNoFormal;
    }

    public void setIdTipoEdNoFormal(TipoEdNoFormal idTipoEdNoFormal) {
        this.idTipoEdNoFormal = idTipoEdNoFormal;
    }

    public IntensidadHoraria getIdIntensidadHoraria() {
        return idIntensidadHoraria;
    }

    public void setIdIntensidadHoraria(IntensidadHoraria idIntensidadHoraria) {
        this.idIntensidadHoraria = idIntensidadHoraria;
    }

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }

    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public boolean getEstado()
    {
        return educacion.getEstado();
    }
}
