/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorEncuesta;
import Modelo.Encuesta;
import com.opensymphony.xwork2.ActionContext;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author pc
 */
public class EncuestaAction extends CrudEncuestaAction<Encuesta> {

    private String activo = "Activo";
    private String inactivo = "Inactivo";
    private String si = "Si";
    private String no = "No";

    public EncuestaAction() {
        super(Encuesta.class.getName());
        this.getIdObjeto = "getIdEncuesta";
        this.nombreIdObjeto = "idEncuesta";
        this.entidad = Encuesta.class.getSimpleName();
        this.consultaTodos = "Encuesta.findAll";
        this.consultaIdObjeto = "Encuesta.findByIdEncuesta";
    }

    @Override
    public void insertarTipos() {
    }

    @Override
    public void consultarTipos() {
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(java.sql.Date.valueOf(LocalDate.now()));
    }

    @Override
    public void validar() {
        if (objeto.getDescripcion().isEmpty()) {
            addFieldError("Encuesta", "Digite la descripción de la encuesta.");
        }

        if (objeto.getOrden() <= 0) {
            addFieldError("Encuesta", "Digiete el orden de la encuesta.");
        }
    }

    @Override
    public void validarLista() {
    }

    @Override
    public void desplegar() {

    }

    public String llenar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.objeto.setNombre(request.getParameter("nombre"));
        this.objeto.setDescripcion(request.getParameter("descripcion"));
        this.objeto.setOrden(Integer.parseInt(request.getParameter("orden")));
        insertarTipos();
        validar();
        if (objeto.getNombre().isEmpty()) {
            addFieldError("Encuesta", "Digite el Nombre de la encuesta.");
        }
        this.objeto.setGraduando(true);
        this.objeto.setEgresado(true);
        if (!hasErrors()) {
            insertarValoresDefecto();
            controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto);
            obtenerLista();
            this.setEditar(false);
            return SUCCESS;
        } else {
            System.out.println("entro aqui");
            this.crear();
            return ERROR;
        }
    }

    public String cambiarEstado() {
        ControladorEncuesta controladorEncuesta = new ControladorEncuesta();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        System.out.println("jojojojo " + request.getParameter("idObjeto1"));
        if (!hasErrors()) {
            if (request.getParameter("idObjeto1").equals("Activo")) {
                controladorEncuesta.activar(Long.parseLong(request.getParameter("idObjeto")), false);
            }
            if (request.getParameter("idObjeto1").equals("Inactivo")) {
                controladorEncuesta.activar(Long.parseLong(request.getParameter("idObjeto")), true);
            }
            obtenerLista();
            return SUCCESS;
        }
        addActionError("No se pudo cambiar el estado");
        return ERROR;

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
}
