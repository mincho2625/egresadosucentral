/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEncuesta;
import Modelo.PreguntaEncuesta;
import Modelo.RespuestaEncuesta;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author pc
 */
public class RespuestasEncuAction extends CrudEncuestaAction<RespuestaEncuesta>{

    private String activo = "Activo";
    private String inactivo = "Inactivo";
    private String si = "Si";
    private String no = "No";
    private String pregunta;
    
    
    public RespuestasEncuAction() {
        super(RespuestaEncuesta.class.getName());
        System.out.println("aqui!!");
        this.getIdObjeto = "idPreguntaEncuesta";
        this.nombreIdObjeto = "idRespuestaEncuesta";
        this.entidadEn = RespuestaEncuesta.class.getSimpleName();
        this.getIdObjetoEn = "getIdRespuestaEncuesta";
        this.consultaTodosEn = "RespuestaEncuesta.findByIdPreguntaEncuesta";
        this.consultaTodosPregunta = "RespuestaEncuesta.findAll";
        this.consultaIdObjetoEn = "RespuestaEncuesta.findByIdRespuestaEncuesta";
        this.consultar1 = true;
        System.out.println("jojoojo");
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
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
    
    
    
    @Override
    public void desplegar() {
        this.setListaPreguntas(listas.consultarIdPregunta());    
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
        
    }

    @Override
    public void validarLista() {
       
    }
    
    public String cambiarEstado() {
        ControladorEncuesta controladorEncuesta = new ControladorEncuesta();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.println("jojojojo " + request.getParameter("idObjeto1"));
        if (!hasErrors()) {
            if (request.getParameter("idObjeto1").equals("Activo")) {
                controladorEncuesta.activarRespuesta(Long.parseLong(request.getParameter("idObjeto")), false);
            }
            if (request.getParameter("idObjeto1").equals("Inactivo")) {
                controladorEncuesta.activarRespuesta(Long.parseLong(request.getParameter("idObjeto")), true);
            }
            obtenerListaPreguntaEncuesta();
            return SUCCESS;
        }
        addActionError("No se pudo cambiar el estado");
        return ERROR;
    }
    public String llenar() {
        System.out.println("llenar "+pregunta);
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.objeto.setRespuesta(request.getParameter("respuesta"));
        this.objeto.setIdPreguntaEncuesta(new PreguntaEncuesta(Long.parseLong(pregunta)));
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
        this.objeto.setOrden(Integer.parseInt(request.getParameter("orden")));
        insertarTipos();
        validar();
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
}
