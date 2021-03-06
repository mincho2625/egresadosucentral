/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persistencia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YURY
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findByPrimerApellido", query = "SELECT f FROM Funcionario f WHERE f.primerApellido = :primerApellido"),
    @NamedQuery(name = "Funcionario.findBySegundoApellido", query = "SELECT f FROM Funcionario f WHERE f.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "Funcionario.findByNombres", query = "SELECT f FROM Funcionario f WHERE f.nombres = :nombres")})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Basic(optional = false)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Basic(optional = false)
    @Column(name = "NOMBRES")
    private String nombres;
    @Id
    @JoinColumn(name = "ID_FUNCIONARIO", referencedColumnName = "ID_USUARIO")
    @OneToOne(optional = false)
    private Usuario usuario;

    public Funcionario() {
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean getEstado()
    {
        return usuario.getEstado();
    }
}