/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import br.com.sige.entidade.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author wender
 */
@Named(value = "usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    private  Usuario usuario;
    private List<Usuario> listaUsuario;
    
    public UsuarioMBean() {
        
    }
    
    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.listaUsuario = new ArrayList<>();
    }
    
    public String novo() {
        this.usuario = new Usuario();
        return "cadUsuario?faces-redirect=true";
    }
    
    public String salvar() {
        listaUsuario.add(usuario);                
        usuario = new Usuario();
        return "consUsuario?faces-redirect=true";
    }
        
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }   
    
}
