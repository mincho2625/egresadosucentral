/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Modelo.Ciudad;
import Modelo.Contacto;
import Modelo.Departamento;
import Modelo.EgresadoRedSocial;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.RedSocial;
import Modelo.TipoContacto;
import Modelo.TipoDocumento;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YURY
 * @param <O>
 * @param <D>
 */
public class ConvertidorObjetos<O, D> {

    private String claseDestino;

    public ConvertidorObjetos() {
    }

    public ConvertidorObjetos(String claseDestino) {
        this.claseDestino = claseDestino;
    }

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

    public PreguntaSeguridad convertirPreguntaSeguridad(Persistencia.PreguntaSeguridad ps) {
        PreguntaSeguridad preguntaSeguridad = new PreguntaSeguridad();
        preguntaSeguridad.setIdPreguntaSeguridad(ps.getIdPreguntaSeguridad());
        preguntaSeguridad.setPreguntaSeguridad(ps.getPregunta());
        return preguntaSeguridad;
    }

    public Contacto convertirContacto(Persistencia.Contacto c) {
        Contacto contacto = new Contacto();
        contacto.setDescripcion(c.getDescripcion());
        contacto.setFechaRegistro(c.getFechaRegistro());
        contacto.setIdContacto(c.getIdContacto());
        contacto.setIdEgresado(c.getIdEgresado().getIdEgresado());
        contacto.setIdTipoContacto(c.getIdTipoContacto().getIdTipoContacto());

        return contacto;
    }

    public TipoContacto convertirTipoContacto(Persistencia.TipoContacto tc) {
        TipoContacto tipoContacto = new TipoContacto();
        tipoContacto.setIdTipoContacto(tc.getIdTipoContacto());
        tipoContacto.setNombre(tc.getNombre());

        return tipoContacto;
    }

    public EgresadoRedSocial convertirEgresadoRedSocial(Persistencia.EgresadoRedSocial ers) {
        EgresadoRedSocial egresadoRedSocial = new EgresadoRedSocial();
        egresadoRedSocial.setIdEgresado(ers.getIdEgresado().getIdEgresado());
        egresadoRedSocial.setIdEgresadoRedSocial(ers.getIdEgresadoRedSocial());
        egresadoRedSocial.setIdRedSocial(ers.getIdRedSocial().getIdRedSocial());
        egresadoRedSocial.setUrl(ers.getUrl());

        return egresadoRedSocial;
    }

    public RedSocial convertirRedSocial(Persistencia.RedSocial rs) {
        RedSocial redSocial = new RedSocial();
        redSocial.setIdRedSocial(rs.getIdRedSocial());
        redSocial.setNombre(rs.getNombre());

        return redSocial;
    }

    private Object instanciar() {
        try {
            Class<?> clase = Class.forName(claseDestino);
            if (clase == null) {
                return null;
            }
            return clase.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(ConvertidorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Object invokeGet(Object clase, String metodo) {
        try {
            Method get = clase.getClass().getDeclaredMethod(metodo);
            if (get != null) {
                Class<?> tipo = get.getReturnType();
                if (tipo.getPackage().getName().equals("Persistencia")) {
                    return invokeGet(get.invoke(clase), metodo);
                }

                return get.invoke(clase);
            }
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(ConvertidorObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    private boolean isSetter(String metodo) {
        return metodo.startsWith("set");
    }

    public D convertir(O origen) {
        D destino = (D) instanciar();

        for (Method set : destino.getClass().getDeclaredMethods()) {
            try {
                if (isSetter(set.getName())) {
                    Object valor = invokeGet(origen, set.getName().replaceFirst("set", "get"));
                    if (valor != null) set.invoke(destino, valor);
                }
            } catch (SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ConvertidorObjetos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return destino;
    }
}