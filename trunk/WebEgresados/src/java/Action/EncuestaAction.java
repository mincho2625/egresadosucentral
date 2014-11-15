/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Controlador.ControlardorEncuesta;
import Modelo.EgresadoRespuesta;
import Modelo.Encuesta;
import Modelo.PreguntaEncuesta;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author YURY
 */
public class EncuestaAction extends ActionSupport {
    private Map<Long, PreguntaEncuesta> listaPreguntasEncuesta;
    private ControlardorEncuesta controlardorEncuesta;
    private long idEncuesta;
    private long anterior;
    private long siguiente;
    private ArrayList<EgresadoRespuesta> listaRespuestas;
    private Map<String, String[]> parameterMap;
    private HttpServletRequest request;
    
    public EncuestaAction()
    {
        Map session = ActionContext.getContext().getSession();
        String usuario = (String) session.get("usuario");
        controlardorEncuesta = new ControlardorEncuesta(usuario);
        
        request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        this.parameterMap = request.getParameterMap();
    }
    
    /**
     * @return the listaPreguntasEncuesta
     */
    public Collection<PreguntaEncuesta> getListaPreguntasEncuesta() {
        return listaPreguntasEncuesta.values();
    }

    /**
     * @param listaPreguntasEncuesta the listaPreguntasEncuesta to set
     */
    public void setListaPreguntasEncuesta(Map<Long, PreguntaEncuesta> listaPreguntasEncuesta) {
        this.listaPreguntasEncuesta = listaPreguntasEncuesta;
    }
    
    /**
     * @return the idEncuesta
     */
    public long getIdEncuesta() {
        return idEncuesta;
    }

    /**
     * @param idEncuesta the idEncuesta to set
     */
    public void setIdEncuesta(long idEncuesta) {
        this.idEncuesta = idEncuesta;
    }
    
    /**
     * @return the anterior
     */
    public long getAnterior() {
        return anterior;
    }

    /**
     * @param anterior the anterior to set
     */
    public void setAnterior(long anterior) {
        this.anterior = anterior;
    }

    /**
     * @return the siguiente
     */
    public long getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(long siguiente) {
        this.siguiente = siguiente;
    }
    
    public String editar()
    {
        if (request.getParameter("idEncuesta") == null)
        {
            this.anterior = 0;
            ArrayList<Encuesta> listaEncuestas = controlardorEncuesta.consultarEncuestas();
            
            if (listaEncuestas.size() > 0) {
                this.idEncuesta = listaEncuestas.get(0).getIdEncuesta();
            }
            if (listaEncuestas.size() > 1) {
                this.siguiente = listaEncuestas.get(1).getIdEncuesta();
            }
        }
        else {
            this.idEncuesta = Long.parseLong( request.getParameter("idEncuesta"));
            this.setAnterior(request.getParameter("anterior") == null ? 0 : Long.parseLong(request.getParameter("anterior")));
            this.setSiguiente(request.getParameter("siguiente") == null ? 0 : Long.parseLong(request.getParameter("siguiente")));
            this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasEncuesta(this.idEncuesta));
        }
        return SUCCESS;
    }
    
    public String guardar()
    {
        this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasEncuesta(this.idEncuesta));
        this.obtenerRespuestas();
        this.controlardorEncuesta.guardar(listaRespuestas);
        this.setAnterior(idEncuesta);
        this.idEncuesta = getSiguiente();
        controlardorEncuesta.refrescar();
        this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasEncuesta(this.idEncuesta));
        return SUCCESS;
    }
    
    private void obtenerRespuestas()
    {
        long idPreguntaEncuesta, idEgresadoRespuesta = 0;
        listaRespuestas = new ArrayList<>();
        
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            if (entry.getValue().length > 0)
                System.out.println("Value: " + entry.getValue()[0]);
            
            if (!entry.getKey().contains("otro") && !entry.getKey().equals("idEncuesta")
                    && !entry.getKey().equals("anterior") && !entry.getKey().equals("siguiente")) {
                for (String valor : entry.getValue()) {
                    try {

                        String[] ids = entry.getKey().split("-");
                        idPreguntaEncuesta = Long.parseLong(ids[0]);
                        if (ids.length > 1)
                            idEgresadoRespuesta = Long.parseLong(ids[1]);

                        EgresadoRespuesta egresadoRespuesta = new EgresadoRespuesta();
                        egresadoRespuesta.setEstado(true);
                        egresadoRespuesta.setFechaRegistro(java.sql.Date.valueOf(LocalDate.now()));
                        egresadoRespuesta.setIdPreguntaEncuesta(listaPreguntasEncuesta.get(idPreguntaEncuesta));
                        egresadoRespuesta.setIdEgresadoRespuesta(idEgresadoRespuesta);

                        switch((int)egresadoRespuesta.getIdPreguntaEncuesta().getIdTipoRespuesta().getIdTipoRespuesta())
                        {
                            case 1:
                            case 4:
                                egresadoRespuesta.setOtra(valor);
                                break;
                            case 2:
                            case 5:
                                egresadoRespuesta.setIdRespuestaEncuesta(egresadoRespuesta.getIdPreguntaEncuesta().getRespuestaEncuesta(Long.parseLong(valor)));
                                break;
                            case 3:
                                System.out.println("otro: " + parameterMap.get("__checkbox_otroPregunta"+entry.getKey())[0]);
                                if (Boolean.parseBoolean(parameterMap.get("__checkbox_otroPregunta"+entry.getKey())[0])) {
                                    egresadoRespuesta.setOtra(valor);
                                }
                                else {
                                    egresadoRespuesta.setIdRespuestaEncuesta(egresadoRespuesta.getIdPreguntaEncuesta().getRespuestaEncuesta(Long.parseLong(valor)));
                                }
                                break;
                        }
                        listaRespuestas.add(egresadoRespuesta);
                        
                    }catch(Exception ex)
                    {
                        Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}