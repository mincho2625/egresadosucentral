/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import Controlador.ControladorCorreo;
import Controlador.ControladorEgresado;
import Controlador.ControladorListas;
import Controlador.ControladorUsuario;
import Modelo.Egresado;
import Modelo.ItemLista;
import Modelo.PlantillaCorreo;
import Util.Constantes;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author YURY
 */
public class RestablecerContraseniaAction extends ActionSupport {
    private List<ItemLista> listaTiposDocumento;
    private String numeroDocumento;
    private long tipoDocumento;
    private Date fechaNacimiento;
        
    /**
     * @return the listaTiposDocumento
     */
    public List<ItemLista> getListaTiposDocumento() {
        return listaTiposDocumento;
    }

    /**
     * @param listaTiposDocumento the listaTiposDocumento to set
     */
    public void setListaTiposDocumento(List<ItemLista> listaTiposDocumento) {
        this.listaTiposDocumento = listaTiposDocumento;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the tipoDocumento
     */
    public long getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String execute() throws Exception {
        validar();
        if (!hasErrors())
        {
            ControladorEgresado controladorEgresado = new ControladorEgresado();
            Egresado egresado = controladorEgresado.consultar(numeroDocumento, tipoDocumento, fechaNacimiento);
            if (egresado != null)
            {   
                ControladorUsuario controladorUsuario = new ControladorUsuario();
                String contrasenia = controladorUsuario.generarContrasenia();
                if (controladorUsuario.cambiarContrasenia(egresado.getNombre(), contrasenia)) {
                
                    ControladorCorreo controladorCorreo = new ControladorCorreo();
                    PlantillaCorreo plantillaCorreo = controladorCorreo.consultarPlantillaCorreo(Constantes.PLANTILLA_CORREO_RECUPERAR_CONTRASENIA);
                    
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    plantillaCorreo.setContenido(plantillaCorreo.getContenido().replace("<fechahora>", formato.format(Calendar.getInstance().getTime())));
                    plantillaCorreo.setContenido(plantillaCorreo.getContenido().replace("<nombre>", String.format("%s %s %s", egresado.getNombres(), egresado.getPrimerApellido(), egresado.getSegundoApellido())));
                    plantillaCorreo.setContenido(plantillaCorreo.getContenido().replace("<documento>", egresado.getNumeroDocumento()));
                    plantillaCorreo.setContenido(plantillaCorreo.getContenido().replace("<nuevaclave>", contrasenia));
                    
                    Address[] destinatarios = new InternetAddress[] {
                        new InternetAddress(egresado.getCorreoInstitucional())};
                    if (controladorCorreo.enviarCorreo(plantillaCorreo, destinatarios)) {
                        String correo = ocultarCorreo(egresado.getCorreoInstitucional());
                        addActionMessage(String.format("Se ha enviado su nueva contraseña al correo %s. Recuerde cambiarla inmediatamente.",correo));
                        return SUCCESS;
                    }
                }
                else {
                    addActionError("Hubo un error al intentar recuperar su contraseña. Por favor comuníquese con el adminisitrador del sistema.");
                    return ERROR;
                }
            }
        }
        
        desplegar();
        addActionError("La información enviada no es válida. Por favor verifique e intente nuevamente.");
        return ERROR;
    }
    
    public String desplegar()
    {
        ControladorListas listas = new ControladorListas();
        listaTiposDocumento = listas.consultarTiposDocumento();
        
        return "desplegar";
    }
    
    public void validar()
    {
        if (numeroDocumento.isEmpty())
            addFieldError("numeroDocumento", "El número de documento es requerido");
        if (tipoDocumento <= 0)
            addFieldError("tipoDocumento", "El tipo de documento es requerido");
        if (fechaNacimiento == null)
            addFieldError("fechaNacimiento", "La fecha de nacimiento es requerida");
    }
    
    private String ocultarCorreo(String correo)
    {
        if (!correo.isEmpty()) {
            String[] split = correo.split("@");
            if (split.length == 2)
                return String.format("%s*******@%s", split[0].substring(0, 2), split[1]);
        }
        
        return null;
    }
}