/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sige.controller;

import sige.modelo.entidade.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import sige.controller.uteis.UteisJsf;
import sige.modelo.sessionbean.UsuarioSBean;

/**
 *
 * @author wender
 */
@Named(value = "usuarioMBean")
@SessionScoped
public class UsuarioMBean implements Serializable {

    @EJB
    private UsuarioSBean usuarioSBean;

    private Usuario usuario;

    private List<Usuario> listaUsuario;

    private String valorPesquisar;

    public UsuarioMBean() {

    }

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
        this.listaUsuario = new ArrayList<>();
    }

    public String botaoNovo() {
        this.usuario = new Usuario();
        return "cadUsuario?faces-redirect=true";
    }

    public String botaoSalvar() {
        try {
            usuarioSBean.salvar(usuario);
            UteisJsf.addMensagemInfo("Usuario Salvo com sucesso. ", "");
        } catch (Exception ex) {
            UteisJsf.addMensagemErro("Erro ao Salvar - ", ex.getMessage());
            return null;
        }
        usuario = new Usuario();
        return null;
        //return "consUsuario?faces-redirect=true";
    }

    public void botaoPesquisar() {
        listaUsuario = usuarioSBean.pesquisar(valorPesquisar);
    }

    public void botaoExcluir() {
        usuarioSBean.excluir(usuario);
    }

    public String botaoEditar() {
        return "cadUsuario?faces-redirect=true";
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

    public String getValorPesquisar() {
        return valorPesquisar;
    }

    public void setValorPesquisar(String valorPesquisar) {
        this.valorPesquisar = valorPesquisar;
    }

}
