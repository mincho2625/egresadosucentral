/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorEgresado;
import Controlador.ControladorEncuesta;
import Controlador.ControladorCrud;
import Modelo.Egresado;
import Modelo.EgresadoRespuesta;
import Modelo.PreguntaEncuesta;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author YURY
 */
public class EncuestaAction extends ActionSupport implements ModelDriven<Egresado>, ServletRequestAware  {
    private Map<Long, PreguntaEncuesta> listaPreguntasEncuesta;
    private final ControladorEncuesta controlardorEncuesta;
    private final ControladorEgresado controladorEgresado;
    private final ControladorCrud controladorCrud;
    private long orden;
    private int ultima;
    private ArrayList<EgresadoRespuesta> listaRespuestas;
    private HttpServletRequest request;
    private Egresado egresado;
    private String usuario;
    
    public Egresado getEgresado() {
        return egresado;
    }

    public void setEgresado(Egresado egresado) {
        this.egresado = egresado;
    }
        
    public EncuestaAction()
    {
       Map session = ActionContext.getContext().getSession();
        long idEgresado = (long) session.get("idEgresado");
        usuario = (String) session.get("usuario");
        System.out.println("usuario "+idEgresado);
        controlardorEncuesta = new ControladorEncuesta(usuario);
        controladorEgresado = new ControladorEgresado();
        controladorCrud = new ControladorCrud();
        this.egresado = (Egresado) controladorCrud.consultar("Egresado.findByIdEgresado", 
                Modelo.Egresado.class.getName(), "idEgresado", idEgresado, Modelo.Usuario.class.getName());
        System.out.println("aaaaaaaaa");
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
    
    /**
     * @return the ultima
     */
    public int getUltima() {
        return ultima;
    }

    /**
     * @param ultima the ultima to set
     */
    public void setUltima(int ultima) {
        this.ultima = ultima;
    }
    
    @Override
    public void setServletRequest(HttpServletRequest hsr) {
        this.request = hsr;
    }
    
    public String editar()
    {
        if (request.getParameter("orden") != null)
        {
            this.orden = Long.parseLong(request.getParameter("orden"));
            this.desplegar(0);
            this.ultima = controlardorEncuesta.consultarUltimaEncuesta();
        }
        return SUCCESS;
    }
    
    public String anterior()
    {
        guardar();
        desplegar(-1);
        return SUCCESS;
    }
    
    public String siguiente()
    {
        guardar();
        desplegar(1);
        return SUCCESS;
    }
    
    public String guardar()
    {
        this.setListaPreguntasEncuesta(controlardorEncuesta.consultarPreguntasEncuesta(this.orden));
        this.obtenerRespuestas();
        this.controlardorEncuesta.guardar(listaRespuestas);     
        
        if (orden == ultima)
        {
            try {
                System.out.println("jojojojojojo1");
                controladorEgresado.completarInformacion(usuario);
                java.util.Date fecha = null;
                SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
                String fecha1 = formatoDeFecha.format(Date.valueOf(LocalDate.now()));
                fecha = formatoDeFecha.parse(fecha1);
                this.egresado.setFechaUltimaAct(fecha);
                this.egresado.setInformacionCompleta(true);
                controladorCrud.actualizar(egresado, Egresado.class.getSimpleName(), "getIdUsuario");            
                System.out.println("jojojojojojo2");
            } catch (ParseException ex) {
                
            }
        }
        return SUCCESS;
    }
    
    private void desplegar(int incremento)
    {
        this.orden+=incremento;
        controlardorEncuesta.refrescar();
        this.setListaPreguntasEncuesta(controlardorEncuesta.consultarPreguntasEncuesta(this.orden));
    }
    
    private void obtenerRespuestas()
    {
        Map<String, String[]> parameterMap = request.getParameterMap();
        long idPreguntaEncuesta, idEgresadoRespuesta = 0;
        listaRespuestas = new ArrayList<>();
        
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            if (entry.getValue().length > 0)
            
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
                        Logger.getLogger(EncuestaAction.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @Override
    public Egresado getModel() {
        return getEgresado();
    }
}