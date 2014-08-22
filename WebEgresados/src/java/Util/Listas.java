/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Controlador.ControladorListas;
import Modelo.Ciudad;
import Modelo.ClaseReconocimiento;
import Modelo.Departamento;
import Modelo.EstadoCivil;
import Modelo.Genero;
import Modelo.GrupoSanguineo;
import Modelo.Pais;
import Modelo.TipoContacto;
import Modelo.TipoDocumento;
import Modelo.TipoReconocimiento;
import java.util.Map;

/**
 *
 * @author YURY
 */
public final class Listas {
    private Map<Long, Ciudad> listaCiudades;
    private Map<Long, TipoReconocimiento> listaTiposReconocimiento;
    private Map<Long, ClaseReconocimiento> listaClasesReconocimiento;

    private Listas()
    {
        ControladorListas cl = new ControladorListas();
        this.listaCiudades = cl.consultarCiudades();
        this.listaClasesReconocimiento = cl.consultarClasesReconocimiento();
        this.listaTiposReconocimiento = cl.consultarTiposReconocimiento();
    }
    
    private static Listas listas;
    
    public static Listas obtenerListas()
    {
        if (listas == null)
            listas = new Listas();
        
        return listas;
    }

    /**
     * @return the listaCiudades
     */
    public Map<Long, Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    /**
     * @param listaCiudades the listaCiudades to set
     */
    public void setListaCiudades(Map<Long, Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    /**
     * @return the listaTiposReconocimiento
     */
    public Map<Long, TipoReconocimiento> getListaTiposReconocimiento() {
        return listaTiposReconocimiento;
    }

    /**
     * @param listaTiposReconocimiento the listaTiposReconocimiento to set
     */
    public void setListaTiposReconocimiento(Map<Long, TipoReconocimiento> listaTiposReconocimiento) {
        this.listaTiposReconocimiento = listaTiposReconocimiento;
    }

    /**
     * @return the listaClasesReconocimiento
     */
    public Map<Long, ClaseReconocimiento> getListaClasesReconocimiento() {
        return listaClasesReconocimiento;
    }

    /**
     * @param listaClasesReconocimiento the listaClasesReconocimiento to set
     */
    public void setListaClasesReconocimiento(Map<Long, ClaseReconocimiento> listaClasesReconocimiento) {
        this.listaClasesReconocimiento = listaClasesReconocimiento;
    }
}