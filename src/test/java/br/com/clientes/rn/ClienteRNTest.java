/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.entidades.Bairro;
import br.com.clientes.entidades.Cliente;
import javax.persistence.EntityManager;

/**
 *
 * @author SHD
 */
public class ClienteRNTest {

    //ENTIDADES    
    private Bairro bairro;
    private Cliente cliente;
    //RN
    private final ClienteRN CLIENTE_RN = new ClienteRN();
    private final BairroRN BAIRRO_RN = new BairroRN();

    private static EntityManager em;

    public ClienteRNTest() {
    }

    
}
