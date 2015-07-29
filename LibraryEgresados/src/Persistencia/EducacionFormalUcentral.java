/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
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
@Table(name = "educacion_formal_ucentral")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducacionFormalUcentral.findAll", query = "SELECT e FROM EducacionFormalUcentral e"),
    @NamedQuery(name = "EducacionFormalUcentral.findByIdEducacion", 
            query = "SELECT e FROM EducacionFormalUcentral e inner join Educacion ed on ed = e.educacion WHERE ed.idEducacion = :idEducacion"),
    @NamedQuery(name = "EducacionFormalUcentral.findByIdEgresado", 
            query = "SELECT e FROM EducacionFormalUcentral e "
                    + "inner join Educacion ed on ed = e.educacion "
                    + "inner join Egresado eg on eg = ed.idEgresado "
                    + "inner join Usuario u on u = eg.usuario "
                    + "WHERE u.idUsuario = :idEgresado and ed.estado = :estado")})
public class EducacionFormalUcentral implements Serializable {
    private static final long serialVersionUID = 1L;
    @JoinColumn(name = "ID_PROGRAMA", referencedColumnName = "ID_PROGRAMA")
    @ManyToOne(optional = false)
    private Programa idPrograma;
    @JoinColumn(name = "ID_JORNADA", referencedColumnName = "ID_JORNADA")
    @ManyToOne(optional = false)
    private Jornada idJornada;
    @Id
    @JoinColumn(name = "ID_EDUCACION", referencedColumnName = "ID_EDUCACION")
    @OneToOne(optional = false)
    private Educacion educacion;

    public EducacionFormalUcentral() {
    }

    public Programa getIdPrograma() {
        return idPrograma;
    }

    public void setIdPrograma(Programa idPrograma) {
        this.idPrograma = idPrograma;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Educacion getEducacion() {
        return educacion;
    }

    public void setEducacion(Educacion educacion) {
        this.educacion = educacion;
    }
    
    public boolean getEstado()
    {
        return educacion.getEstado();
    }
}