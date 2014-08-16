package Controlador;

import Modelo.AreaEstudios;
import Modelo.Ciudad;
import Modelo.Departamento;
import Modelo.EstadoCivil;
import Modelo.EstadoEducacion;
import Modelo.Estrato;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Institucion;
import Modelo.Jornada;
import Modelo.Mes;
import Modelo.Modalidad;
import Modelo.NivelEstudios;
import Modelo.Pais;
import Modelo.PreguntaSeguridad;
import Modelo.Programa;
import Modelo.RedSocial;
import Modelo.TipoContacto;
import Modelo.TipoDocumento;
import Modelo.TipoTenenciaVivienda;
import Modelo.TipoVivienda;
import Persistencia.AreaEmpresa;
import Persistencia.CargoEquivalente;
import Persistencia.NivelCargo;
import Persistencia.RangoSalarial;
import Persistencia.Subsector;
import Persistencia.TipoContrato;
import Util.ConvertidorObjetos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jun-2014 06:36:19 a.m.
 */
public class ControladorListas {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("WebEgresadosPU");
    private final ConvertidorObjetos convertidorObjetos = new ConvertidorObjetos();

    public ArrayList<Ciudad> obtenerCiudades() {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Ciudad.findAll");
        List<Persistencia.Ciudad> lista = query.getResultList();
        for (Persistencia.Ciudad c : lista) {
            listaCiudades.add(convertidorObjetos.convertirCiudad(c));
        }

        return listaCiudades;
    }

    /**
     *
     * @param idDepartamento
     * @return
     */
    public ArrayList<Ciudad> obtenerCiudadesPorDepartamento(int idDepartamento) {
        ArrayList<Ciudad> listaCiudades = new ArrayList<>();

        EntityManager em = emf.createEntityManager();

        Query query = em.createNamedQuery("Ciudad.findByIdDepartamento");
        query.setParameter("idDepartamento", em.getReference(Persistencia.Departamento.class, idDepartamento));
        List<Persistencia.Ciudad> lista = query.getResultList();
        for (Persistencia.Ciudad c : lista) {
            listaCiudades.add(convertidorObjetos.convertirCiudad(c));
        }

        return listaCiudades;
    }

    /**
     *
     * @param idPais
     * @return
     */
    public ArrayList<Departamento> obtenerDepartamentosPorPais(int idPais) {
        ArrayList<Departamento> listaDepartamentos = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Departamento.findByIdPais");
        query.setParameter("idPais", em.getReference(Persistencia.Pais.class, idPais));
        List<Persistencia.Departamento> lista = query.getResultList();
        for (Persistencia.Departamento d : lista) {
            listaDepartamentos.add(convertidorObjetos.convertirDepartamento(d));
        }

        return listaDepartamentos;
    }

    public ArrayList<EstadoCivil> obtenerEstadosCiviles() {
        ArrayList<EstadoCivil> listaEstadosCiviles = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EstadoCivil.findAll");

        List<Persistencia.EstadoCivil> lista = query.getResultList();
        for (Persistencia.EstadoCivil e : lista) {
            listaEstadosCiviles.add(convertidorObjetos.convertirEstadoCivil(e));
        }

        return listaEstadosCiviles;
    }

    public ArrayList<Genero> obtenerGeneros() {
        ArrayList<Genero> listaGeneros = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Genero.findAll");

        List<Persistencia.Genero> lista = query.getResultList();
        for (Persistencia.Genero g : lista) {
            listaGeneros.add(convertidorObjetos.convertirGenero(g));
        }

        return listaGeneros;
    }

    public ArrayList<GrupoSanguineo> obtenerGruposSanguineos() {
        ArrayList<GrupoSanguineo> listaGruposSanguineos = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("GrupoSanguineo.findAll");

        List<Persistencia.GrupoSanguineo> lista = query.getResultList();
        for (Persistencia.GrupoSanguineo g : lista) {
            listaGruposSanguineos.add(convertidorObjetos.convertirGrupoSanguineo(g));
        }

        return listaGruposSanguineos;
    }

    public ArrayList<Pais> obtenerPaises() {
        ArrayList<Pais> listaPaises = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Pais.findAll");

        List<Persistencia.Pais> lista = query.getResultList();
        for (Persistencia.Pais p : lista) {
            listaPaises.add(convertidorObjetos.convertirPais(p));
        }

        return listaPaises;
    }

    public ArrayList<TipoDocumento> obtenerTiposDocumento() {
        ArrayList<TipoDocumento> listaTiposDocumento = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoDocumento.findAll");

        List<Persistencia.TipoDocumento> lista = query.getResultList();
        for (Persistencia.TipoDocumento td : lista) {
            listaTiposDocumento.add(convertidorObjetos.convertirTipoDocumento(td));
        }

        return listaTiposDocumento;
    }

    public ArrayList<PreguntaSeguridad> obtenerPreguntasSeguridad() {
        ArrayList<PreguntaSeguridad> listaPreguntasSeguridad = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("PreguntaSeguridad.findAll");

        List<Persistencia.PreguntaSeguridad> lista = query.getResultList();
        for (Persistencia.PreguntaSeguridad ps : lista) {
            listaPreguntasSeguridad.add(convertidorObjetos.convertirPreguntaSeguridad(ps));
        }

        return listaPreguntasSeguridad;
    }

    public ArrayList<TipoContacto> obtenerTiposContacto() {
        ArrayList<TipoContacto> listaTiposContacto = new ArrayList<>();

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoContacto.findAll");

        List<Persistencia.TipoContacto> lista = query.getResultList();
        for (Persistencia.TipoContacto tc : lista) {
            listaTiposContacto.add(convertidorObjetos.convertirTipoContacto(tc));
        }

        return listaTiposContacto;
    }

    public ArrayList<RedSocial> consultarRedesSociales() {
        ArrayList<RedSocial> listaRedSocial = new ArrayList<>();
        ConvertidorObjetos<Persistencia.RedSocial, Modelo.RedSocial> co = new ConvertidorObjetos<>(Modelo.RedSocial.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("RedSocial.findAll");

        List<Persistencia.RedSocial> lista = query.getResultList();
        for (Persistencia.RedSocial tc : lista) {
            listaRedSocial.add(co.convertir(tc));
        }

        return listaRedSocial;
    }

    public ArrayList<TipoVivienda> consultarTiposVivienda() {
        ArrayList<TipoVivienda> listaTipoVivienda = new ArrayList<>();
        ConvertidorObjetos<Persistencia.TipoVivienda, Modelo.TipoVivienda> co = new ConvertidorObjetos<>(Modelo.TipoVivienda.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoVivienda.findAll");

        List<Persistencia.TipoVivienda> lista = query.getResultList();
        for (Persistencia.TipoVivienda tc : lista) {
            listaTipoVivienda.add(co.convertir(tc));
        }

        return listaTipoVivienda;
    }

    public ArrayList<TipoTenenciaVivienda> consultarTiposTenenciaVivienda() {
        ArrayList<TipoTenenciaVivienda> listaTipoTenenciaVivienda = new ArrayList<>();
        ConvertidorObjetos<Persistencia.TipoTenenciaVivienda, Modelo.TipoTenenciaVivienda> co = new ConvertidorObjetos<>(Modelo.TipoTenenciaVivienda.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoTenenciaVivienda.findAll");

        List<Persistencia.TipoTenenciaVivienda> lista = query.getResultList();
        for (Persistencia.TipoTenenciaVivienda tc : lista) {
            listaTipoTenenciaVivienda.add(co.convertir(tc));
        }

        return listaTipoTenenciaVivienda;
    }

    public ArrayList<Estrato> consultarEstratos() {
        ArrayList<Estrato> listaEstratos = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Estrato, Modelo.Estrato> co = new ConvertidorObjetos<>(Modelo.Estrato.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Estrato.findAll");

        List<Persistencia.Estrato> lista = query.getResultList();
        for (Persistencia.Estrato tc : lista) {
            listaEstratos.add(co.convertir(tc));
        }

        return listaEstratos;
    }

    public ArrayList<TipoContrato> consultarTipoContrato() {
        ArrayList<TipoContrato> listaTipoContrato = new ArrayList<>();
        ConvertidorObjetos<Persistencia.TipoContrato, Modelo.TipoContrato> co = new ConvertidorObjetos<>(Modelo.TipoContrato.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("TipoContrato.findAll");

        List<Persistencia.TipoContrato> lista = query.getResultList();
        for (Persistencia.TipoContrato tc : lista) {
            listaTipoContrato.add(tc);
        }

        return listaTipoContrato;
    }

    public ArrayList<Subsector> consultarSubsector() {
        ArrayList<Subsector> listaSubsector = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Subsector, Modelo.subSector> co = new ConvertidorObjetos<>(Modelo.subSector.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Subsector.findAll");

        List<Persistencia.Subsector> lista = query.getResultList();
        for (Persistencia.Subsector tc : lista) {
            listaSubsector.add(tc);
        }

        return listaSubsector;
    }

    public ArrayList<NivelCargo> consultarNivelCargo() {
        ArrayList<NivelCargo> listaSubsector = new ArrayList<>();
        ConvertidorObjetos<Persistencia.NivelCargo, Modelo.NivelCargo> co = new ConvertidorObjetos<>(Modelo.NivelCargo.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("NivelCargo.findAll");

        List<Persistencia.NivelCargo> lista = query.getResultList();
        for (Persistencia.NivelCargo tc : lista) {
            listaSubsector.add(tc);
        }

        return listaSubsector;
    }

    public ArrayList<AreaEmpresa> consultarAreaEmpresa() {
        ArrayList<AreaEmpresa> listaSubsector = new ArrayList<>();
        ConvertidorObjetos<Persistencia.AreaEmpresa, Modelo.AreaEmpresa> co = new ConvertidorObjetos<>(Modelo.AreaEmpresa.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("AreaEmpresa.findAll");

        List<Persistencia.AreaEmpresa> lista = query.getResultList();
        for (Persistencia.AreaEmpresa tc : lista) {
            listaSubsector.add(tc);
        }

        return listaSubsector;
    }

    public ArrayList<RangoSalarial> consultarRangoSalarial() {
        ArrayList<RangoSalarial> listaRangoSalarial = new ArrayList<>();
        ConvertidorObjetos<Persistencia.RangoSalarial, Modelo.RangoSalarial> co = new ConvertidorObjetos<>(Modelo.RangoSalarial.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("RangoSalarial.findAll");

        List<Persistencia.RangoSalarial> lista = query.getResultList();
        for (Persistencia.RangoSalarial tc : lista) {
            listaRangoSalarial.add(tc);
        }

        return listaRangoSalarial;
    }

    public ArrayList<CargoEquivalente> consultarCargoEquivalente() {
        ArrayList<CargoEquivalente> listaCargoEquivalente = new ArrayList<>();
        ConvertidorObjetos<Persistencia.CargoEquivalente, Modelo.CargoEquivalente> co = new ConvertidorObjetos<>(Modelo.CargoEquivalente.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("CargoEquivalente.findAll");

        List<Persistencia.CargoEquivalente> lista = query.getResultList();
        for (Persistencia.CargoEquivalente tc : lista) {
            listaCargoEquivalente.add(tc);
        }

        return listaCargoEquivalente;
    }
       public ArrayList<Persistencia.Mes> consultarMeseIngreso() {
        ArrayList<Persistencia.Mes> listaMes = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Mes, Modelo.Mes> co = new ConvertidorObjetos<>(Modelo.Mes.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Mes.findAll");

        List<Persistencia.Mes> lista = query.getResultList();
        for (Persistencia.Mes tc : lista) {
            listaMes.add(tc);
        }

        return listaMes;
    }

    public ArrayList<Mes> consultarMeses() {
        ArrayList<Mes> listaMeses = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Mes, Modelo.Mes> co = new ConvertidorObjetos<>(Modelo.Mes.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Mes.findAll");

        List<Persistencia.Mes> lista = query.getResultList();
        for (Persistencia.Mes tc : lista) {
            listaMeses.add(co.convertir(tc));
        }

        return listaMeses;
    }

    public ArrayList<EstadoEducacion> consultarEstadosEducacion() {
        ArrayList<EstadoEducacion> listaEstadosEducacion = new ArrayList<>();
        ConvertidorObjetos<Persistencia.EstadoEducacion, Modelo.EstadoEducacion> co = new ConvertidorObjetos<>(Modelo.EstadoEducacion.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("EstadoEducacion.findAll");

        List<Persistencia.EstadoEducacion> lista = query.getResultList();
        for (Persistencia.EstadoEducacion tc : lista) {
            listaEstadosEducacion.add(co.convertir(tc));
        }

        return listaEstadosEducacion;
    }
    
    public ArrayList<AreaEstudios> consultarAreasEstudios() {
        ArrayList<AreaEstudios> listaAreasEstudios = new ArrayList<>();
        ConvertidorObjetos<Persistencia.AreaEstudios, Modelo.AreaEstudios> co = new ConvertidorObjetos<>(Modelo.AreaEstudios.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("AreaEstudios.findAll");

        List<Persistencia.AreaEstudios> lista = query.getResultList();
        for (Persistencia.AreaEstudios tc : lista) {
            listaAreasEstudios.add(co.convertir(tc));
        }

        return listaAreasEstudios;
    }

    public ArrayList<Modalidad> consultarModalidades() {
        ArrayList<Modalidad> listaModalidades = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Modalidad, Modelo.Modalidad> co = new ConvertidorObjetos<>(Modelo.Modalidad.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Modalidad.findAll");

        List<Persistencia.Modalidad> lista = query.getResultList();
        for (Persistencia.Modalidad tc : lista) {
            listaModalidades.add(co.convertir(tc));
        }

        return listaModalidades;
    }

    public ArrayList<Institucion> consultarInstituciones() {
        ArrayList<Institucion> listaInstituciones = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Institucion, Modelo.Institucion> co = new ConvertidorObjetos<>(Modelo.Institucion.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Institucion.findAll");

        List<Persistencia.Institucion> lista = query.getResultList();
        for (Persistencia.Institucion tc : lista) {
            listaInstituciones.add(co.convertir(tc));
        }

        return listaInstituciones;
    }

    public ArrayList<Programa> consultarProgramas() {
        ArrayList<Programa> listaProgramas = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Programa, Modelo.Programa> co = new ConvertidorObjetos<>(Modelo.Programa.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Programa.findAll");

        List<Persistencia.Programa> lista = query.getResultList();
        for (Persistencia.Programa tc : lista) {
            listaProgramas.add(co.convertir(tc));
        }

        return listaProgramas;
    }

    public ArrayList<Jornada> consultarJornadas() {
        ArrayList<Jornada> listaJornadas = new ArrayList<>();
        ConvertidorObjetos<Persistencia.Jornada, Modelo.Jornada> co = new ConvertidorObjetos<>(Modelo.Jornada.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("Jornada.findAll");

        List<Persistencia.Jornada> lista = query.getResultList();
        for (Persistencia.Jornada tc : lista) {
            listaJornadas.add(co.convertir(tc));
        }

        return listaJornadas;
    }

    public ArrayList<NivelEstudios> consultarNivelesEstudios() {
        ArrayList<NivelEstudios> listaNivelesEstudios = new ArrayList<>();
        ConvertidorObjetos<Persistencia.NivelEstudios, Modelo.NivelEstudios> co = new ConvertidorObjetos<>(Modelo.NivelEstudios.class.getName());

        EntityManager em = emf.createEntityManager();
        Query query = em.createNamedQuery("NivelEstudios.findAll");

        List<Persistencia.NivelEstudios> lista = query.getResultList();
        for (Persistencia.NivelEstudios tc : lista) {
            listaNivelesEstudios.add(co.convertir(tc));
        }

        return listaNivelesEstudios;
    }
    
    public ArrayList<Integer> consultarAnios()
    {
        ArrayList<Integer> listaAnios = new ArrayList<>();
        for (int i = 1990; i < LocalDate.now().getYear(); i++) {
            listaAnios.add(i);
        }
        return listaAnios;
    }
}