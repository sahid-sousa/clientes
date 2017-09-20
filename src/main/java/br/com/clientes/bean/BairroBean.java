/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.bean;

import br.com.clientes.entidades.Bairro;
import br.com.clientes.rn.BairroRN;
import br.com.clientes.util.UtilBean;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author SHD
 */
@ManagedBean
@RequestScoped
public class BairroBean {

    //ENTIDADES
    Bairro bairro = new Bairro();

    //RN
    private final BairroRN BAIRRO_RN = new BairroRN();

    public BairroBean() {
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<Bairro> getBairros() {
        return BAIRRO_RN.obterTodos();
    }

    public String salvar() {
        if (BAIRRO_RN.salvar(bairro)) {
            UtilBean.criarMensagemDeAviso("Sucesso", "Bairro Salvo");
            return "listar.xhtml?faces-redirect=true";
        } else {
            UtilBean.criarMensagemDeErro("Erro", "Bairro não foi Salvo");
            return null;
        }
    }

    public void excluir() {
        if (BAIRRO_RN.excluir(bairro)) {
            UtilBean.criarMensagemDeAviso("Sucesso", "Bairro removido");
        } else {
            UtilBean.criarMensagemDeErro("Erro", "Bairro não foi removido");
        }
    }
}
