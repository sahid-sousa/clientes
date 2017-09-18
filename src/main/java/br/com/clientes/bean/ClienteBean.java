/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.bean;

import br.com.clientes.entidades.Bairro;
import br.com.clientes.entidades.Cliente;
import br.com.clientes.rn.ClienteRN;
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
public class ClienteBean {

    //ENTIDADES
    Cliente cliente = new Cliente();
    Bairro bairro = new Bairro();

    //RN
    private final ClienteRN CLIENTE_RN = new ClienteRN();

    public ClienteBean() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    public List<Cliente> getClientes(){
        return CLIENTE_RN.obterTodos();
    }

    public String salvar() {
        if (CLIENTE_RN.salvar(cliente)) {
            UtilBean.criarMensagemDeAviso("Sucesso", "Cliente Salvo");
            return "listar.xhtml?faces-redirect=true";
        } else {
            UtilBean.criarMensagemDeErro("Erro", "Cliente não foi Salvo");
            return null;
        }
    }

    public void excluir() {
        if (CLIENTE_RN.excluir(cliente)) {
            UtilBean.criarMensagemDeAviso("Sucesso", "Cliente removido");
        } else {
            UtilBean.criarMensagemDeErro("Erro", "Cliente não foi removido");
        }
    }

}
