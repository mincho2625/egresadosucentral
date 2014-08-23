/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EgresadoRedSocial;
import Modelo.RedSocial;
import Util.Listas;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class EgresadoRedSocialAction extends CrudAction<EgresadoRedSocial>{
    //Esta lista es de tipos de redes sociales: facebook, twiter, etc.
    private Map<Long, RedSocial> listaRedesSociales;
    private long redSocial;

    public EgresadoRedSocialAction() {
        super(EgresadoRedSocial.class.getName());
        this.idObjeto = "getIdEgresadoRedSocial";
        this.coleccion = "getEgresadoRedSocialCollection";
        this.clasePersistencia = Persistencia.EgresadoRedSocial.class.getName();
    }

    /**
     * @return the listaRedesSociales
     */
    public Collection<RedSocial> getListaRedesSociales() {
        return listaRedesSociales.values();
    }

    /**
     * @param listaRedesSociales the listaRedesSociales to set
     */
    public void setListaRedesSociales(Map<Long, RedSocial> listaRedesSociales) {
        this.listaRedesSociales = listaRedesSociales;
    }
    
    /**
     * @return the redSocial
     */
    public long getRedSocial() {
        return redSocial;
    }

    /**
     * @param redSocial the redSocial to set
     */
    public void setRedSocial(long redSocial) {
        this.redSocial = redSocial;
    }
    
    @Override
    public String desplegar() {
        this.setListaRedesSociales(Listas.obtenerListas().getListaRedesSociales());
        this.obtenerLista();
        this.editar = true;
        return SUCCESS;
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdRedSocial(Listas.obtenerListas().getListaRedesSociales().get(this.redSocial));
    }

    @Override
    public void consultarTipos() {
        this.setRedSocial(objeto.getIdRedSocial().getIdRedSocial());
    }

    @Override
    public void insertarValoresDefecto() {
        this.objeto.setEstado(true);
        this.objeto.setFechaRegistro(Date.valueOf(LocalDate.now()));
    }
}
