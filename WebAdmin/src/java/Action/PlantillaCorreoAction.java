/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Modelo.PlantillaCorreo;

/**
 *
 * @author YURY
 */
public class PlantillaCorreoAction extends CrudAction<PlantillaCorreo> {    
    public PlantillaCorreoAction() {
        super(PlantillaCorreo.class.getName());
        this.getIdObjeto = "getIdPlantillaCorreo";
        this.nombreIdObjeto = "idPlantillaCorreo";
        this.entidad = PlantillaCorreo.class.getSimpleName();
        this.consultaTodos = "PlantillaCorreo.findByEstado";
        this.consultaIdObjeto = "PlantillaCorreo.findByIdPlantillaCorreo";
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
        this.objeto.setEstado(true);
    }

    @Override
    public void validar() {
        if (objeto.getNombre().isEmpty()){
            addFieldError("nombre", "El nombre es requerido");
        }else{
            
        }
        if (objeto.getAsunto().isEmpty())
            addFieldError("asunto", "El asunto es requerido");
        if (objeto.getContenido().isEmpty())
            addFieldError("contenido", "El contenido es requerido");
    }

    @Override
    public void validarLista() {
        if (cantidadObjetos == 0)
            addActionError("Ingrese al menos una plantilla.");
    }
}