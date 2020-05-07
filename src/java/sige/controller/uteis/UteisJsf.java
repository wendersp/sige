/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sige.controller.uteis;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author wender
 */
public class UteisJsf {
    
    public static void addMensagemErro(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, sumario , mensagem ));
    }
    
    public static void addMensagemInfo(String sumario, String mensagem) {
        FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_INFO, sumario , mensagem ));
    }
    
}
