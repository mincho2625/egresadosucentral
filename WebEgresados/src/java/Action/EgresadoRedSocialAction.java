/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Modelo.EgresadoRedSocial;
import Modelo.ItemLista;
import Modelo.RedSocial;
import com.opensymphony.xwork2.ActionContext;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author YURY
 */
public class EgresadoRedSocialAction extends CrudAction<EgresadoRedSocial>{
    //Esta lista es de tipos de redes sociales: facebook, twiter, etc.
    private List<ItemLista> listaRedesSociales;
    private long redSocial;

    public EgresadoRedSocialAction() {
        super(EgresadoRedSocial.class.getName());
        this.getIdObjeto = "getIdEgresadoRedSocial";
        this.consultaTodos = "EgresadoRedSocial.findByIdEgresado";
        this.entidad = EgresadoRedSocial.class.getSimpleName();
        this.nombreIdObjeto = "idEgresadoRedSocial";
        this.consultaIdObjeto = "EgresadoRedSocial.findByIdEgresadoRedSocial";
        
        Map session = ActionContext.getContext().getSession();
        long id = (long) session.get("idEgresado");
        this.parametros = new HashMap<>();
        this.parametros.put("idEgresado", id);
        this.objeto.setIdEgresado(id);
    }

    /**
     * @return the listaRedesSociales
     */
    public List<ItemLista> getListaRedesSociales() {
        return listaRedesSociales;
    }

    /**
     * @param listaRedesSociales the listaRedesSociales to set
     */
    public void setListaRedesSociales(List<ItemLista> listaRedesSociales) {
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
    public void desplegar() {
        this.setListaRedesSociales(listas.consultarRedesSociales());
    }

    @Override
    public void insertarTipos() {
        this.objeto.setIdRedSocial(new RedSocial(this.redSocial));
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

    @Override
    public void validar() {
        if (objeto.getUrl().isEmpty())
            addFieldError("url", "La url es requerida");
        if (redSocial <= 0)
            addFieldError("redSocial", "La red social es requerida");
    }

    @Override
    public void validarLista() {
        
    }
}