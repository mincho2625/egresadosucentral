/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.PreguntaEncuesta;


/**
 *
 * @author pc
 */
public class PreguntasEncuestasAction extends CrudAction<PreguntaEncuesta> {
   private String activo="Activo";
   private String inactivo="Inactivo";
   private String si="Si";
   private String no="No";
   

    public PreguntasEncuestasAction() {
        
        super(PreguntaEncuesta.class.getName());
        this.getIdObjeto = "getIdEncuesta";
        this.nombreIdObjeto = "idPreguntaEncuesta";
        this.entidadEn = PreguntaEncuesta.class.getSimpleName();
        this.getIdObjetoEn = "getIdPreguntaEncuesta";
        this.consultaTodosEn = "PreguntaEncuesta.findByIdEncuesta";
        this.consultaTodosPregunta = "PreguntaEncuesta.findAll";
        this.consultaIdObjetoEn = "PreguntaEncuesta.findByIdPreguntaEncuesta";
        this.consultar=true;
    }

    @Override
    public void desplegar() {

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
