/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.dao.GenericDAO;
import br.com.clientes.entidades.Cliente;
import java.util.List;

/**
 *
 * @author SHD
 */
public class ClienteRN {

    private final GenericDAO<Cliente> CLIENTE_DAO = new GenericDAO<>();

    public boolean salvar(Cliente cliente) {
        if (cliente == null) {
            return false;
        } else {
            if (cliente.getId() == null || cliente.getId() == 0) {
                return CLIENTE_DAO.criar(cliente);
            } else {
                return CLIENTE_DAO.alterar(cliente);
            }
        }
    }

    public boolean excluir(Cliente cliente) {
        if (cliente == null) {
            return false;
        } else {
            return CLIENTE_DAO.excluir(cliente);
        }
    }

    public Cliente obter(Integer id) {
        return CLIENTE_DAO.obter(Cliente.class, id);
    }

    public List<Cliente> obterTodos() {
        return CLIENTE_DAO.obterTodos(Cliente.class);
    }
}
