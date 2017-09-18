/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.entidades.Bairro;
import org.junit.*;

/**
 *
 * @author SHD
 */
public class BairroRNTest {

    //ENTIDADES
    //RN
    private final BairroRN BAIRRO_RN = new BairroRN();

    public BairroRNTest() {

    }

    @Test
    public void deveCadastrarUmBairro() {
        Bairro bairro = new Bairro();
        bairro.setId(0);
        bairro.setNome("Pedreira");
        
        Assert.assertEquals(true, BAIRRO_RN.salvar(bairro));
    }
}
