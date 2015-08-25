/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Persistencia.Aficiones;
import Persistencia.Ciudad;
import Persistencia.Contacto;
import Persistencia.EdFormalOtrasInstituciones;
import Persistencia.Educacion;
import Persistencia.EducacionFormalUcentral;
import Persistencia.EgresadoRespuesta;
import Persistencia.EstadoCivil;
import Persistencia.EstadoEducacion;
import Persistencia.Estrato;
import Persistencia.Genero;
import Persistencia.Institucion;
import Persistencia.Mes;
import Persistencia.PreguntaEncuesta;
import Persistencia.Programa;
import Persistencia.Residencia;
import Persistencia.RespuestaEncuesta;
import Persistencia.TipoActividad;
import Persistencia.TipoContacto;
import Persistencia.TipoTenenciaVivienda;
import Persistencia.TipoVivienda;
import Persistencia.Usuario;
import Util.Constantes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author YURY
 */
public class CargueEgresado {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EgresadosPU");
    private final EntityManager em;
    private final String[] informacion;
    private Persistencia.Egresado egresado;
    private String error;

    public CargueEgresado(String[] informacion) {
        this.informacion = informacion;
        em = emf.createEntityManager();
    }

    /**
     * @return the error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(String error) {
        this.error = error;
    }

    public void iniciarTransaccion() {
        em.getTransaction().begin();
        egresado = new Persistencia.Egresado();
    }

    public void terminarTransaccion(boolean ok) {
        try {
            if (ok) {
                if (!em.getTransaction().getRollbackOnly()) {
                    em.getTransaction().commit();
                    System.out.println("Commit " + informacion[0]);
                } else {
                    em.getTransaction().rollback();
                    System.out.println("Rollback 1 " + informacion[0]);
                }
            } else {
                em.getTransaction().rollback();
                System.out.println("Rollback 2 " + informacion[0]);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorCargueMasivo.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.getMessage();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    public String validarDocumento() {
        if (asignarNumeroDocumento(informacion[0])) {
            return informacion[0];
        }
        return null;
    }

    public String validarCorreo() {
        return informacion[10];
    }

    public boolean crearEgresado() {
        try {
            if (!asignarNumeroDocumento(informacion[0])) {
                return false;
            }
            if (!asignarEstadoCivil(informacion[26])) {
                return false;
            }
            if (!asignarGenero(informacion[3])) {
                return false;
            }
            if (!asignarNombres(informacion[4])) {
                return false;
            }
            if (!asignarUsuario(informacion[10])) {
                return false;
            }

            egresado.setAceptaCondiciones(true);
            egresado.setInformacionCompleta(false);

            if (!asignarEducacionFormalUCentral()) {
                return false;
            }

            asignarInformacionContacto(informacion[11], Constantes.TIPO_CONTACTO_CORREO_PERSONAL);
            asignarInformacionContacto(informacion[12], Constantes.TIPO_CONTACTO_CORREO_PERSONAL);
            asignarInformacionContacto(informacion[17], Constantes.TIPO_CONTACTO_MOVIL);
            asignarInformacionContacto(informacion[18], Constantes.TIPO_CONTACTO_MOVIL);
            asignarInformacionContacto(informacion[19], Constantes.TIPO_CONTACTO_MOVIL);
            asignarInformacionContacto(informacion[15], Constantes.TIPO_CONTACTO_TELEFONO_RESIDENCIA);
            asignarInformacionContacto(informacion[16], Constantes.TIPO_CONTACTO_TELEFONO_RESIDENCIA);
            asignarInformacionContacto(informacion[20], Constantes.TIPO_CONTACTO_DIRECCION_EMPRESA);

            if (!asignarInformacionResidencia()) {
                return false;
            }
            asignarInformacionEducacionFormalOtrasInst(informacion[20], informacion[21]);
            asignarInformacionEducacionFormalOtrasInst(informacion[22], informacion[23]);
            System.out.println("Deportes y Aficiones");
            asignarDeportesAficiones(informacion[50]);
            asignarDeportesAficiones(informacion[51]);
            asignarEncuesta();
            asignarFechaUltimaActualizacion(informacion[25]);

            System.out.println("Persist egresado" + egresado.getNumeroDocumento());
            em.persist(egresado);

            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControladorCargueMasivo.class.getName()).log(Level.SEVERE, null, ex);
            error = ex.getMessage();
            return false;
        }
    }

    private boolean asignarNumeroDocumento(String numeroDocumento) {
        if (numeroDocumento != null && !numeroDocumento.isEmpty()) {
            egresado.setNumeroDocumento(numeroDocumento);
            return true;
        }
        setError("El número de documento no es válido");
        return false;
    }

    private boolean asignarEstadoCivil(String nombre) {
        System.out.println("Estado civil: " + nombre);
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("estadoCivil", nombre);

        Object estadoCivil = consultar("EstadoCivil.findByEstadoCivil", parametros);
        if (estadoCivil == null) {
            setError(String.format("El estado civil %s no existe", nombre));
            return false;
        } else {
            egresado.setIdEstadoCivil((EstadoCivil) estadoCivil);
            return true;
        }
    }

    private boolean asignarGenero(String nombre) {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        Object genero = consultar("Genero.findByNombre", parametros);
        if (genero == null) {
            setError(String.format("El género %s no existe", nombre));
            return false;
        } else {
            egresado.setIdGenero((Genero) genero);
            return true;
        }
    }

    private boolean asignarNombres(String nombres) {
        String[] n = nombres.split(" ");
        if (n.length == 2) {
            egresado.setNombres(n[0]);
            egresado.setPrimerApellido(n[1]);
            return true;
        }
        if (n.length == 3) {
            egresado.setNombres(n[0]);
            egresado.setPrimerApellido(n[1]);
            egresado.setSegundoApellido(n[2]);
            return true;
        }
        if (n.length == 4) {
            egresado.setNombres(String.format("%s %s", n[0], n[1]));
            egresado.setPrimerApellido(n[2]);
            egresado.setSegundoApellido(n[3]);
            return true;
        }
        if (n.length > 4) {
            egresado.setNombres(String.format("%s %s", n[0], n[1]));
            egresado.setPrimerApellido(n[2]);

            for (int i = 3; i < n.length; i++) {
                egresado.setSegundoApellido(egresado.getSegundoApellido() + " " + n[i]);
            }
            return true;
        }

        setError(String.format("El nombre %s no es válido", nombres));
        return false;
    }

    private void asignarFechaUltimaActualizacion(String fecha) {
        if (fecha != null && !fecha.isEmpty()) {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            try {
                egresado.setFechaUltimaAct(formato.parse(fecha));
            } catch (ParseException ex) {
                egresado.setFechaUltimaAct(Calendar.getInstance().getTime());
            }
        } else {
            egresado.setFechaUltimaAct(Calendar.getInstance().getTime());
        }
    }

    private boolean asignarUsuario(String correoInstitucional) {
        if (correoInstitucional != null && !correoInstitucional.isEmpty()) {
            String[] split = correoInstitucional.split("@");
            if (split.length == 2) {
                Usuario usuario = new Usuario();
                usuario.setContrasenia(egresado.getNumeroDocumento());
                usuario.setCorreoInstitucional(correoInstitucional);
                usuario.setEstado(true);
                usuario.setFechaRegistro(Calendar.getInstance().getTime());
                usuario.setNombre(split[0]);
                egresado.setUsuario(usuario);
                System.out.println("persist usuario");
                em.persist(usuario);
                return true;
            }
        }

        setError(String.format("El correo institucional %s no es válido", correoInstitucional));
        return false;
    }

    private boolean asignarEducacionFormalUCentral() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", informacion[2]);
        Object programa = consultar("Programa.findByNombre", parametros);
        if (programa == null) {
            setError(String.format("El programa %s no existe", informacion[2]));
            return false;
        } else {
            EducacionFormalUcentral educacionFormalUcentral = new EducacionFormalUcentral();
            Educacion educacion = new Educacion();
            educacionFormalUcentral.setIdPrograma((Programa) programa);
            educacion.setIdEgresado(egresado);
            educacion.setFechaRegistro(Calendar.getInstance().getTime());
            educacion.setFechaActEstado(Calendar.getInstance().getTime());
            educacion.setIdCiudad(em.getReference(Ciudad.class, Constantes.CIUDAD_BOGOTA));
            educacion.setIdEstadoEducacion(em.getReference(EstadoEducacion.class, Constantes.ESTADO_EDUCACION_TERMINADO));
            educacion.setIdInstitucion(em.getReference(Institucion.class, Constantes.INSTITUCION_UCENTRAL));
            educacion.setEstado(true);

            try {
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaGrado = formato.parse(informacion[5]);
                educacion.setAnioFinalizacion(fechaGrado.getYear());
                educacion.setIdMesFinalizacion(em.getReference(Mes.class, (long) fechaGrado.getMonth()));
            } catch (ParseException ex) {
                setError(String.format("El formato de fecha de Grado %s no es válido", informacion[5]));
                return false;
            }

            educacionFormalUcentral.setEducacion(educacion);
            System.out.println("Persist educacionFormalUcentral");
            //egresado.getEducacionCollection().add(educacion);
            em.persist(educacion);
            em.persist(educacionFormalUcentral);
            return true;
        }
    }

    private void asignarInformacionContacto(String descripcion, long idTipoContacto) {
        if (descripcion != null && !descripcion.isEmpty()) {
            Contacto contacto = new Contacto();
            contacto.setDescripcion(descripcion);
            contacto.setEstado(true);
            contacto.setFechaRegistro(Calendar.getInstance().getTime());
            contacto.setIdEgresado(egresado);
            contacto.setIdTipoContacto(em.getReference(TipoContacto.class, idTipoContacto));
            System.out.println("Persist contacto");
            //egresado.getContactoCollection().add(contacto);
            em.persist(contacto);
        }
    }

    private boolean asignarInformacionResidencia() {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", informacion[14]);
        Object objeto = consultar("Ciudad.findByNombre", parametros);
        if (objeto != null) {
            if (informacion[13] != null && !informacion[13].isEmpty() && objeto != null) {
                Residencia residencia = new Residencia();
                residencia.setDireccion(informacion[13]);
                residencia.setIdCiudad((Ciudad) objeto);

                parametros.clear();
                parametros.put("nombre", informacion[47]);
                objeto = consultar("TipoVivienda.findByNombre", parametros);
                if (objeto != null) {
                    residencia.setIdTipoVivienda((TipoVivienda) objeto);
                }else {
                    setError(String.format("Tipo de vivienda %s no validao", informacion[47]));
                    return false;
                }
                
                parametros.clear();
                parametros.put("nombre", informacion[48]);
                objeto = consultar("TipoTenenciaVivienda.findByNombre", parametros);
                if (objeto != null) {
                    residencia.setIdTipoTenenciaVivienda((TipoTenenciaVivienda) objeto);
                }else {
                    setError(String.format("Tipo tenencia de vivienda %s no validao", informacion[48]));
                    return false;
                }
                
                parametros.clear();
                parametros.put("nombre", informacion[49]);
                objeto = consultar("Estrato.findByNombre", parametros);
                if (objeto != null) {
                    residencia.setIdEstrato((Estrato) objeto);
                } else {
                    setError(String.format("Estrato %s no validao", informacion[49]));
                    return false;
                }
                residencia.setComputador(convertirBooleano(informacion[52]));
                residencia.setConexionInternet(convertirBooleano(informacion[53]));
                residencia.setEstado(true);
                residencia.setFechaRegistro(Calendar.getInstance().getTime());
                residencia.setIdEgresado(egresado);
                System.out.println("Persist residencia");
                //egresado.getResidenciaCollection().add(residencia);
                em.persist(residencia);
            } else {
                setError(String.format("La dirección de residencia %s no es valida", informacion[13]));
                return false;
            }
        } else {
            setError(String.format("Cuidad %s no valida", informacion[14]));
            return false;
        }
        return true;
    }

    private void asignarInformacionExperienciaLaboral() {

    }

    private void asignarInformacionEducacionFormalOtrasInst(String titulo, String institucion) {
        if (titulo != null && !titulo.isEmpty() && institucion != null && !institucion.isEmpty()) {
            EdFormalOtrasInstituciones edFormalOtrasInstituciones = new EdFormalOtrasInstituciones();
            edFormalOtrasInstituciones.setTitulo(titulo);
            Educacion educacion = new Educacion();
            educacion.setEstado(true);
            educacion.setFechaActEstado(Calendar.getInstance().getTime());
            educacion.setIdEgresado(egresado);

            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nombre", institucion);
            Object inst = consultar("Institucion.findByNombre", parametros);
            if (inst != null) {
                educacion.setIdInstitucion((Institucion) inst);
            } else {
                educacion.setOtraInstitucion(institucion);
            }

            edFormalOtrasInstituciones.setEducacion(educacion);
            System.out.println("Persist edFormalOtrasInstituciones");
            //egresado.getEducacionCollection().add(educacion);
            em.persist(edFormalOtrasInstituciones);
        }
    }

    private void asignarLenguaExtranjera() {

    }

    private void asignarDeportesAficiones(String actividad) {
        if (actividad != null && !actividad.isEmpty()) {
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("nombre", actividad);
            Object tipoActividad = consultar("TipoActividad.findByNombre", parametros);
            if (tipoActividad == null) {
                tipoActividad = em.getReference(TipoActividad.class, Constantes.TIPO_ACTIVIDAD_OTRA);
            }
            Aficiones aficiones = new Aficiones();
            aficiones.setEstado(true);
            aficiones.setFechaRegistro(Calendar.getInstance().getTime());
            aficiones.setIdEgresado(egresado);
            aficiones.setIdTipoActividad((TipoActividad) tipoActividad);
            aficiones.setListaActividades(actividad);
            System.out.println("Persist aficiones");
            //egresado.getAficionesCollection().add(aficiones);
            em.persist(aficiones);
        }
    }

    private void asignarEncuesta() {
        EntityManager em1 = emf.createEntityManager();
        Query query = em1.createNamedQuery("PreguntaEncuesta.findByPosicionFormato");
        List<PreguntaEncuesta> listaPreguntas = query.getResultList();
        for (PreguntaEncuesta preguntaEncuesta : listaPreguntas) {
            if (informacion[preguntaEncuesta.getPosicionFormato()] != null
                    && !informacion[preguntaEncuesta.getPosicionFormato()].isEmpty()) {
                EgresadoRespuesta egresadoRespuesta = new EgresadoRespuesta();
                egresadoRespuesta.setEstado(true);
                egresadoRespuesta.setFechaRegistro(Calendar.getInstance().getTime());
                egresadoRespuesta.setIdEgresado(egresado);
                egresadoRespuesta.setIdPreguntaEncuesta(preguntaEncuesta);

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("respuesta", informacion[preguntaEncuesta.getPosicionFormato()]);
                parametros.put("idPreguntaEncuesta", preguntaEncuesta);
                Object respuestaEncuesta = consultar("RespuestaEncuesta.findByRespuesta", parametros);

                if (respuestaEncuesta != null) {
                    egresadoRespuesta.setIdRespuestaEncuesta((RespuestaEncuesta) respuestaEncuesta);
                } else {
                    egresadoRespuesta.setOtra(informacion[preguntaEncuesta.getPosicionFormato()]);
                }

                System.out.println("Persist egresadoRespuesta");
                //egresado.getEgresadoRespuestaCollection().add(egresadoRespuesta);
                em.persist(egresadoRespuesta);
            }
        }
    }

    private Object consultar(String consulta, Map<String, Object> parametros) {
        try {
            EntityManager em1 = emf.createEntityManager();
            System.out.println("consulta "+consulta);
            Query query = em1.createNamedQuery(consulta);
            query.setParameter("estado", true);
            if (parametros != null) {
                for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
                }
            }
            return query.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    private boolean convertirBooleano(String valor) {
        if (valor != null && !valor.isEmpty()) {
            return valor.toUpperCase().equals("SI");
        }

        return false;
    }
}
