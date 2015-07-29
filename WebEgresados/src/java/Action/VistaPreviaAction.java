/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Action;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

/**
 *
 * @author YURY
 */
public class VistaPreviaAction extends ActionSupport {

    private String imagen;
    
    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    @Override
    public String execute() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse(); 
        response.setContentType("image/jpg"); 
        OutputStream out = response.getOutputStream();
        File archivo = new File(this.imagen);
        out.write(FileUtils.readFileToByteArray(archivo));
        
        return SUCCESS;
    }
}