package Modelo;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:37:27 a.m.
 */
public class Usuario {

	private String correoInstitucional;
	private String nombre;
	private String password;

    /**
     * @return the correoInstitucional
     */
    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    /**
     * @param correoInstitucional the correoInstitucional to set
     */
    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}