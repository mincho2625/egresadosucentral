/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.Encuesta;
import com.opensymphony.xwork2.ActionContext;
import java.time.LocalDate;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author pc
 */
public class EncuestaAction extends CrudAction<Encuesta> {
    
   private String activo="Activo";
   private String inactivo="Inactivo";
   private String si="Si";
   private String no="No";
   

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
        this.objeto.setGraduando(true);
        this.objeto.setEgresado(true);
        insertarTipos();
        validar();
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
        insertarTipos();
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        if (Boolean.parseBoolean(request.getParameter("idObjeto1"))) {
            this.objeto.setEstado(false);
        } 
        if (Boolean.parseBoolean(request.getParameter("idObjeto1")) == false) {
            this.objeto.setEstado(true);
        }
            
        this.objeto.setIdEncuesta(Long.parseLong(request.getParameter("idObjeto")));
        controladorCrud.actualizar(getObjeto(), entidad, getIdObjeto);
        obtenerLista();
        return SUCCESS;
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
