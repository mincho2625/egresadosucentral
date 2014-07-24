package Modelo;

import java.util.ArrayList;

/**
 * @author YURY
 * @version 1.0
 * @created 12-jul-2014 06:57:25 a.m.
 */
public class Pais {

    private int idPais;
    private String nombre;
    private ArrayList<Departamento> listaDepartamentos;
    
    public Pais()
    {
        listaDepartamentos = new ArrayList<>();
    }
    
    /**
     * @return the idPais
     */
    public int getIdPais() {
        return idPais;
    }

    /**
     * @param idPais the idPais to set
     */
    public void setIdPais(int idPais) {
        this.idPais = idPais;
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
     * @return the listaDepartamentos
     */
    public ArrayList<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public void agregarDepartamento(int idDepartamento, String nombre)
    {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(idDepartamento);
        departamento.setNombre(nombre);
        listaDepartamentos.add(departamento);
    }
}
