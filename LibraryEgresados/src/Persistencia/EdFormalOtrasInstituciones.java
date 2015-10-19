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
@Table(name = "ed_formal_otras_instituciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EdFormalOtrasInstituciones.findAll", query = "SELECT e FROM EdFormalOtrasInstituciones e"),
    @NamedQuery(name = "EdFormalOtrasInstituciones.findByIdEducacion", 
            query = "SELECT e FROM EdFormalOtrasInstituciones e inner join Educacion ed on ed = e.educacion WHERE ed.idEducacion = :idEducacion"),
    @NamedQuery(name = "EdFormalOtrasInstituciones.findByTitulo", query = "SELECT e FROM EdFormalOtrasInstituciones e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "EdFormalOtrasInstituciones.findByConsulta", 
            query = "SELECT e FROM EdFormalOtrasInstituciones e "
                    + "inner join Educacion ed on ed = e.educacion "
                    + "inner join Egresado eg on eg = ed.idEgresado "
                    + "inner join Usuario u on u = eg.usuario "
                    + "WHERE ed.estado = :estado"),
    @NamedQuery(name = "EdFormalOtrasInstituciones.findByIdEgresado", 
            query = "SELECT e FROM EdFormalOtrasInstituciones e "
                    + "inner join Educacion ed on ed = e.educacion "
                    + "inner join Egresado eg on eg = ed.idEgresado "
                    + "inner join Usuario u on u = eg.usuario "
                    + "WHERE u.idUsuario = :idEgresado and ed.estado = :estado")})
public class EdFormalOtrasInstituciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TITULO")
    private String titulo;
    @JoinColumn(name = "ID_MODALIDAD", referencedColumnName = "ID_MODALIDAD")
    @ManyToOne(optional = false)
    private Modalidad idModalidad;
    @Id
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION")
    @OneToOne(optional = false)
    private Educacion educacion;
    @JoinColumn(name = "ID_AREA_ESTUDIOS", referencedColumnName = "ID_AREA_ESTUDIOS")
    @ManyToOne(optional = false)
    private AreaEstudios idAreaEstudios;
    @JoinColumn(name = "ID_NIVEL_ESTUDIOS", referencedColumnName = "ID_NIVEL_ESTUDIOS")
    @ManyToOne(optional = false)
    private NivelEstudios idNivelEstudios;

    public EdFormalOtrasInstituciones() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
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
