/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.entidades.Bairro;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author SHD
 */
public class BairroRNTest {

    //RN
    private final BairroRN BAIRRO_RN = new BairroRN();

    public BairroRNTest() {

    }

    @Test
    public void deveCadastrarUmBairro() {
        Bairro bairro = new Bairro(null, "Cremação");
        Assert.assertEquals(true, BAIRRO_RN.salvar(bairro));
    }
}
