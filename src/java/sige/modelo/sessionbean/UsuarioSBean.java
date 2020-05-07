/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sige.modelo.sessionbean;

import sige.modelo.entidade.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author wender
 */
@Stateless
public class UsuarioSBean {

    @PersistenceContext(unitName = "sigePU")
    EntityManager em;

    public void salvar(Usuario usuario) throws Exception {
        try {
            validarDados(usuario);
            em.merge(usuario);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    private void validarDados(Usuario usuario) throws Exception {
        // validarUsuarioUnico(usuario.getUserName());
        if (usuario.getSenha().length() < 8) {
            throw new Exception("Senha não poder ser menor do que 8 caracteres.");
        }
    }

    private void validarUsuarioUnico(String userName) throws Exception {
        Query consulta = em.createNamedQuery("Usuario.findByUserName");
        consulta.setParameter("userName", userName);
        Usuario usuario = (Usuario) consulta.getSingleResult();
        if (usuario != null || usuario.getId() > 0) {
            throw new Exception("Usuario já existe.");
        }
    }

    public void excluir(Usuario usuario) {
        em.remove(em.find(Usuario.class, usuario.getId()));
    }

    public Usuario pesquisar(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> pesquisar(String nome) {
        List<Usuario> listaUsuarios;
        Query consulta = em.createNamedQuery("Usuario.findByNome");
        consulta.setParameter("nome", nome.toUpperCase() + "%");
        listaUsuarios = consulta.getResultList();
        return listaUsuarios;
    }
}
