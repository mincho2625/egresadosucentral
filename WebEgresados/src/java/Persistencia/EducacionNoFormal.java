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
    @NamedQuery(name = "EducacionNoFormal.findByOtroNivelEstudios", query = "SELECT e FROM EducacionNoFormal e WHERE e.otroNivelEstudios = :otroNivelEstudios"),
    @NamedQuery(name = "EducacionNoFormal.findByTitulo", query = "SELECT e FROM EducacionNoFormal e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "EducacionNoFormal.findByDescripcion", query = "SELECT e FROM EducacionNoFormal e WHERE e.descripcion = :descripcion")})
public class EducacionNoFormal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "OTRO_NIVEL_ESTUDIOS")
    private String otroNivelEstudios;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_INTENSIDAD_HORARIA", referencedColumnName = "ID_INTENSIDAD_HORARIA")
    @ManyToOne(optional = false)
    private IntensidadHoraria idIntensidadHoraria;
    @Id
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION")
    @OneToOne(optional = false)
    private Educacion educacion;
    @JoinColumn(name = "ID_MODALIDAD", referencedColumnName = "ID_MODALIDAD")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;
    @JoinColumn(name = "ID_AREA_ESTUDIOS", referencedColumnName = "ID_AREA_ESTUDIOS")
    @ManyToOne(optional = false)
    private AreaEstudios idAreaEstudios;
    @JoinColumn(name = "ID_NIVEL_ESTUDIOS", referencedColumnName = "ID_NIVEL_ESTUDIOS")
    @ManyToOne(optional = false)
    private NivelEstudios idNivelEstudios;

    public EducacionNoFormal() {
    }

    public String getOtroNivelEstudios() {
        return otroNivelEstudios;
    }

    public void setOtroNivelEstudios(String otroNivelEstudios) {
        this.otroNivelEstudios = otroNivelEstudios;
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

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public AreaEstudios getIdAreaEstudios() {
        return idAreaEstudios;
    }

    public void setIdAreaEstudios(AreaEstudios idAreaEstudios) {
        this.idAreaEstudios = idAreaEstudios;
    }

    public NivelEstudios getIdNivelEstudios() {
        return idNivelEstudios;
    }

    public void setIdNivelEstudios(NivelEstudios idNivelEstudios) {
        this.idNivelEstudios = idNivelEstudios;
    }
    
    public boolean getEstado()
    {
        return educacion.getEstado();
    }
}
