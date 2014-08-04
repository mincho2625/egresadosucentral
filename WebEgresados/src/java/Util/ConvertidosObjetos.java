/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Modelo.Ciudad;
import Modelo.Contacto;
import Modelo.Departamento;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.TipoDocumento;

/**
 *
 * @author YURY
 */
public class ConvertidosObjetos {

    public Ciudad convertirCiudad(Persistencia.Ciudad c) {
        Ciudad ciudad = new Ciudad();
        ciudad.setIdCiudad(c.getIdCiudad());
        ciudad.setNombre(c.getNombre());
        return ciudad;
    }

    public Departamento convertirDepartamento(Persistencia.Departamento d) {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(d.getIdDepartamento());
        departamento.setNombre(d.getNombre());
        return departamento;
    }

    public EstadoCivil convertirEstadoCivil(Persistencia.EstadoCivil e) {
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setIdEstadoCivil(e.getIdEstadoCivil());
        estadoCivil.setNombre(e.getEstadoCivil());
        return estadoCivil;
    }

    public Genero convertirGenero(Persistencia.Genero g) {
        Genero genero = new Genero();
        genero.setIdGenero(g.getIdGenero());
        genero.setNombre(g.getNombre());
        return genero;
    }

    public GrupoSanguineo convertirGrupoSanguineo(Persistencia.GrupoSanguineo g) {
        GrupoSanguineo grupoSanguineo = new GrupoSanguineo();
        grupoSanguineo.setIdGrupoSanguineo(g.getIdGrupoSanguineo());
        grupoSanguineo.setNombre(g.getGrupoSanguineo());
        return grupoSanguineo;
    }

    public Pais convertirPais(Persistencia.Pais p) {
        Pais pais = new Pais();
        pais.setIdPais(p.getIdPais());
        pais.setNombre(p.getNombre());
        
        for (Persistencia.Departamento d : p.getDepartamentoCollection()) {
            pais.agregarDepartamento(d.getIdDepartamento(), d.getNombre());
        }
        
        return pais;
    }

    public TipoDocumento convertirTipoDocumento(Persistencia.TipoDocumento td) {
        TipoDocumento tipoDocumento = new TipoDocumento();
        tipoDocumento.setIdTipoDocumento(td.getIdTipoDocumento());
        tipoDocumento.setNombre(td.getNombre());
        return tipoDocumento;
    }
    
    public PreguntaSeguridad convertirPreguntaSeguridad(Persistencia.PreguntaSeguridad ps)
    {
        PreguntaSeguridad preguntaSeguridad = new PreguntaSeguridad();
        preguntaSeguridad.setIdPreguntaSeguridad(ps.getIdPreguntaSeguridad());
        preguntaSeguridad.setPreguntaSeguridad(ps.getPregunta());
        return preguntaSeguridad;
    }
    
    public Contacto convertirContacto(Persistencia.Contacto c)
    {
        Contacto contacto = new Contacto();
        contacto.setDescripcion(c.getDescripción());
        contacto.setEstado(c.getEstado());
        contacto.setFechaRegistro(c.getFechaRegistro());
        contacto.setIdContacto(c.getIdContacto());
        contacto.setIdEgresado(c.getIdEgresado().getIdEgresado());
        contacto.setIdTipoContacto(c.getIdTipoContacto().getIdTipoContacto());
        
        return contacto;
    }
}
