/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEncuesta;
import Modelo.Encuesta;
import Modelo.PreguntaEncuesta;
import Modelo.TipoRespuesta;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author pc
 */
public class PreguntasEncuestasAction extends CrudEncuestaAction<PreguntaEncuesta> {

    private String activo = "Activo";
    private String inactivo = "Inactivo";
    private String si = "Si";
    private String no = "No";
    private String respuesta;
    private String encuesta;
    private long tipoRespuesta;
    private long encuest;

    public PreguntasEncuestasAction() {
        super(PreguntaEncuesta.class.getName());
        this.getIdObjeto = "getIdEncuesta";
        this.nombreIdObjeto = "idPreguntaEncuesta";
        this.entidadEn = PreguntaEncuesta.class.getSimpleName();
        this.getIdObjetoEn = "getIdPreguntaEncuesta";
        this.consultaTodosEn = "PreguntaEncuesta.findByIdEncuesta";
        this.consultaTodosRe = "RespuestaEncuesta.findByIdPreguntaEncuesta";
        this.consultaTodosPregunta = "PreguntaEncuesta.findAll";
        this.consultaIdObjetoEn = "PreguntaEncuesta.findByIdPreguntaEncuesta";
        this.consultar = true;
        System.out.println("ni modos");
    }

    @Override
    public void desplegar() {
        this.setListaTipoPregunta(listas.consultarTipoRespuesta());
        this.setListaIdEncuesta(listas.consultarIdEncuesta());
    }

    @Override
    public void insertarTipos() {

    }

    @Override
    public void consultarTipos() {

    }

    @Override
    public void insertarValoresDefecto() {

    }

    @Override
    public void validar() {
        System.out.println("jajajaa1");
        if (objeto.getOrden() <= 0) {
            System.out.println("Digite el orden de la pregunta.");
            addActionError("Digite un numero positivo o mayor a 0 en el campo orden");
        }
        System.out.println("jajajaa2");
    }

    @Override
    public void validarLista() {

    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getInactivo() {
        return inactivo;
    }

    public void setInactivo(String inactivo) {
        this.inactivo = inactivo;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String llenar() {
        System.out.println("llenar " + respuesta);
        validarIngreso();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.objeto.setPregunta(request.getParameter("pregunta"));
        this.objeto.setEstado(true);
        this.objeto.setObligatoria(true);
        this.objeto.setOrden(Integer.parseInt(request.getParameter("orden")));
        this.objeto.setPosicionFormato(0);
        insertarTipos();
        validar();
        tipoRespuesta = controladorCrud.consultarPregunta(respuesta);
        this.objeto.setIdTipoRespuesta(new TipoRespuesta(tipoRespuesta));
        encuest = controladorCrud.consultarIdEncuesta(encuesta);
        this.objeto.setIdEncuesta(new Encuesta(encuest));
        if (!hasErrors()) {
            insertarValoresDefecto();
            controladorCrud.actualizar(getObjeto(), entidadEn, getIdObjetoEn);
            obtenerListaPreguntaEncuesta();
            this.setEditar(false);
            return SUCCESS;
        } else {
            System.out.println("entro aqui");
            this.crear();
            return ERROR;
        }
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(String encuesta) {
        this.encuesta = encuesta;
    }

    public String cambiarEstado() {
        ControladorEncuesta controladorEncuesta = new ControladorEncuesta();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.println("jojojojo " + request.getParameter("idObjeto1"));
        if (!hasErrors()) {
            if (request.getParameter("idObjeto1").equals("Activo")) {
                controladorEncuesta.activarPregunta(Long.parseLong(request.getParameter("idObjeto")), false);
            }
            if (request.getParameter("idObjeto1").equals("Inactivo")) {
                controladorEncuesta.activarPregunta(Long.parseLong(request.getParameter("idObjeto")), true);
            }
            obtenerListaPreguntaEncuesta();
            return SUCCESS;
        }
        addActionError("No se pudo cambiar el estado");
        return ERROR;
    }

    public void validarIngreso() {
        if (encuest < 0) {
            addFieldError("Preguntas Encuesta", "Seleccione la encuesta perteneciente la pregunta.");
        }
        if (tipoRespuesta < 0) {
            addFieldError("Preguntas Encuesta", "Seleccione una tipo de respuesta.");
        }
        if (objeto.getPregunta().isEmpty()) {
            System.out.println("Digite el campo pregunta.");
            addFieldError("Preguntas Encuesta", "Digite el campo pregunta.");
        }
    }
}
