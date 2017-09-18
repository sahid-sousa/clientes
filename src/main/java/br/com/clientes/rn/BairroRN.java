/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.dao.GenericDAO;
import br.com.clientes.entidades.Bairro;
import java.util.List;

/**
 *
 * @author SHD
 */
public class BairroRN {

    private final GenericDAO<Bairro> BAIRRO_DAO = new GenericDAO<>();

    public boolean salvar(Bairro bairro) {
        if (bairro == null) {
            return false;
        } else {
            if (bairro.getId() == null || bairro.getId() == 0) {
                return BAIRRO_DAO.criar(bairro);
            } else {
                return BAIRRO_DAO.alterar(bairro);
            }
        }
    }

    public boolean excluir(Bairro bairro) {
        if (bairro == null) {
            return false;
        } else {
            return BAIRRO_DAO.excluir(bairro);
        }
    }

    public Bairro obter(Integer id) {
        return BAIRRO_DAO.obter(Bairro.class, id);
    }

    public List<Bairro> obterTodos() {
        return BAIRRO_DAO.obterTodos(Bairro.class);
    }
}
