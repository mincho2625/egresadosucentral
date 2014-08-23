/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EgresadoRedSocial;
import Modelo.RedSocial;
import java.util.ArrayList;

/**
 *
 * @author YURY
 */
public class EgresadoRedSocialAction extends CrudAction<EgresadoRedSocial>{
    //Esta lista es de tipos de redes sociales: facebook, twiter, etc.
    private ArrayList<RedSocial> listaRedesSociales;

    public EgresadoRedSocialAction() {
        super(EgresadoRedSocial.class.getName());
        this.idObjeto = "getIdEgresadoRedSocial";
        this.coleccion = "getEgresadoRedSocialCollection";
        this.clasePersistencia = Persistencia.Reconocimiento.class.getName();
    }

    /**
     * @return the listaRedesSociales
     */
    public ArrayList<RedSocial> getListaRedesSociales() {
        return listaRedesSociales;
    }

    /**
     * @param listaRedesSociales the listaRedesSociales to set
     */
    public void setListaRedesSociales(ArrayList<RedSocial> listaRedesSociales) {
        this.listaRedesSociales = listaRedesSociales;
    }
    
    @Override
    public String desplegar() {
        this.obtenerLista();
        //this.setListaRedesSociales(controladorListas.consultarRedesSociales());
        this.editar = true;
        return SUCCESS;
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
