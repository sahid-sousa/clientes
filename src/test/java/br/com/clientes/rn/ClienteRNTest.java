/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.entidades.Bairro;
import br.com.clientes.entidades.Cliente;
import static java.util.Collections.list;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author SHD
 */
public class ClienteRNTest {

    //ENTIDADES
    Bairro bairro = new Bairro();
    //RN
    private final ClienteRN CLIENTE_RN = new ClienteRN();
    private final BairroRN BAIRRO_RN = new BairroRN();

    public ClienteRNTest() {

    }

    public Bairro retornaUmBairroAleatorio() {
        Random rand = new Random();
        int id = rand.nextInt(BAIRRO_RN.obterTodos().size());
        bairro = BAIRRO_RN.obter(id);
        return bairro;
    }

    @Test
    public void deveCadastrarUmCliente() {
        Cliente cliente = new Cliente(0, "Maria Amaral", "91985762551", "Aug. Montenegro", "Belém");
        cliente.setBairro(retornaUmBairroAleatorio());
        Assert.assertEquals(true, CLIENTE_RN.salvar(cliente));
    }

}
