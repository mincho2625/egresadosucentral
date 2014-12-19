/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Controlador.ControlardorEncuesta;
import Modelo.EgresadoRespuesta;
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
    private final ControlardorEncuesta controlardorEncuesta;
    private long orden;
    private ArrayList<EgresadoRespuesta> listaRespuestas;
    private final Map<String, String[]> parameterMap;
    private final HttpServletRequest request;
    
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
     * @return the orden
     */
    public long getOrden() {
        return orden;
    }

    /**
     * @param orden the orden to set
     */
    public void setOrden(long orden) {
        this.orden = orden;
    }
    
    public String editar()
    {
        if (request.getParameter("orden") != null)
        {
            this.orden = Long.parseLong(request.getParameter("orden"));
            this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasSeccionEncuesta(orden, 1));
            System.out.println("Preguntas: " + listaPreguntasEncuesta.size());
        }
        return SUCCESS;
    }
    
    public void guardar(int incremento)
    {
        this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasSeccionEncuesta(this.orden, 1));
        this.obtenerRespuestas();
        this.controlardorEncuesta.guardar(listaRespuestas);
        this.orden+=incremento;
        controlardorEncuesta.refrescar();
        this.setListaPreguntasEncuesta(controlardorEncuesta.consularPreguntasSeccionEncuesta(this.orden, 1));
    }
    
    public String anterior()
    {
        System.out.println("Anterior antes, orden:" + orden);
        guardar(-1);
        System.out.println("Anterior despues, orden:" + orden);
        return SUCCESS;
    }
    
    public String siguiente()
    {
        System.out.println("Siguiente antes, orden:" + orden);
        guardar(1);
        System.out.println("Siguiente despues, orden:" + orden);
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
                        
                    }catch(NumberFormatException ex)
                    {
                        Logger.getLogger(ControladorEgresado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}