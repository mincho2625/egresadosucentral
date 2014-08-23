/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Persistencia.AreaEmpresa;
import Persistencia.CargoEquivalente;
import Persistencia.ExperienciaLaboral;
import Persistencia.Mes;
import Persistencia.NivelCargo;
import Persistencia.RangoSalarial;
import Persistencia.Subsector;
import Persistencia.TipoContrato;
import java.util.ArrayList;

/**
 *
 * @author JERONIMO
 */
public class ExperienciaLaboralAction extends CrudAction<ExperienciaLaboral> {
    // Aquí van las listas que van a sr los combos del formulario, ejemplo: ciudades
    // Debes crear el objeto TipoContrato en el modelo, los atributos del modelo deben llamarse igual que el Persistencia, porque 
    // yo hice unos métodos genéricos que pasan los datos rápidamente, pero es importante el nombre
        private ArrayList<TipoContrato> listaTipoContacto;
        private ArrayList<Subsector> listasubSector;
        private ArrayList<NivelCargo> listaNivelCargo;
        private ArrayList<AreaEmpresa> listaAreaEmpresa;
        private ArrayList<RangoSalarial> listaRangoSalarial;
        private ArrayList<CargoEquivalente> listaCargoEquivalente;
        private ArrayList<Mes> listaMesIngreso;
        private ArrayList<Mes> listaMesTerminacion;



    public ArrayList<NivelCargo> getListaNivelCargo() {
        return listaNivelCargo;
    }

    public void setListaNivelCargo(ArrayList<NivelCargo> listaNivelCargo) {
        this.listaNivelCargo = listaNivelCargo;
    }

    public ArrayList<Subsector> getListasubSector() {
        return listasubSector;
    }

    public void setListasubSector(ArrayList<Subsector> listasubSector) {
        this.listasubSector = listasubSector;
    }
        private ArrayList<ExperienciaLaboral> listaEsperienciaLaboral;
    

    public ExperienciaLaboralAction() {
        super("Modelo.ExperienciaLaboral");
        
    }

    /**
     * @return the listaRedesSociales
     */
    public ArrayList<ExperienciaLaboral> getlistaEsperienciaLaboral() {
        return listaEsperienciaLaboral;
    }

    /**
     * @param ExperienciaLaboralAction the listaRedesSociales to set
     */
    public void setlistaEsperienciaLaboral(ArrayList<ExperienciaLaboral> listaEsperienciaLaboral) {
        this.listaEsperienciaLaboral = listaEsperienciaLaboral;
    }

    public ArrayList<TipoContrato> getListaTipoContacto() {
        return listaTipoContacto;
    }

    public void setListaTipoContacto(ArrayList<TipoContrato> listaTipoContacto) {
        this.listaTipoContacto = listaTipoContacto;
    }
    
    
    @Override
    public String desplegar() {
        this.obtenerLista();
//        this.setListaTipoContacto(controladorListas.consultarTipoContrato());
//        this.setListasubSector(controladorListas.consultarSubsector());
//        this.setListaNivelCargo(controladorListas.consultarNivelCargo());
//        this.setListaAreaEmpresa(controladorListas.consultarAreaEmpresa());
//        this.setListaRangoSalarial(controladorListas.consultarRangoSalarial());
//        this.setListaCargoEquivalente(controladorListas.consultarCargoEquivalente());
//        this.setListaMesIngreso(controladorListas.consultarMeseIngreso());
//        this.setListaMesTerminacion(controladorListas.consultarMeseIngreso());
        
        this.editar = true;
        return SUCCESS;
    }

    public ArrayList<ExperienciaLaboral> getListaEsperienciaLaboral() {
        return listaEsperienciaLaboral;
    }

    public void setListaEsperienciaLaboral(ArrayList<ExperienciaLaboral> listaEsperienciaLaboral) {
        this.listaEsperienciaLaboral = listaEsperienciaLaboral;
    }

    public ArrayList<AreaEmpresa> getListaAreaEmpresa() {
        return listaAreaEmpresa;
    }

    public void setListaAreaEmpresa(ArrayList<AreaEmpresa> listaAreaEmpresa) {
        this.listaAreaEmpresa = listaAreaEmpresa;
    }

    public ArrayList<RangoSalarial> getListaRangoSalarial() {
        return listaRangoSalarial;
    }

    public void setListaRangoSalarial(ArrayList<RangoSalarial> listaRangoSalarial) {
        this.listaRangoSalarial = listaRangoSalarial;
    }

    public ArrayList<CargoEquivalente> getListaCargoEquivalente() {
        return listaCargoEquivalente;
    }

    public void setListaCargoEquivalente(ArrayList<CargoEquivalente> listaCargoEquivalente) {
        this.listaCargoEquivalente = listaCargoEquivalente;
    }

    public ArrayList<Mes> getListaMesIngreso() {
        return listaMesIngreso;
    }

    public void setListaMesIngreso(ArrayList<Mes> listaMesIngreso) {
        this.listaMesIngreso = listaMesIngreso;
    }

    public ArrayList<Mes> getListaMesTerminacion() {
        return listaMesTerminacion;
    }

    public void setListaMesTerminacion(ArrayList<Mes> listaMesTerminacion) {
        this.listaMesTerminacion = listaMesTerminacion;
    }

    @Override
    public void insertarTipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultarTipos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarValoresDefecto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
