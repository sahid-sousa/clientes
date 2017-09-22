/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.dao.FabricaEntityManager;
import br.com.clientes.entidades.Bairro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author SHD
 */
public class BairroRNTest {

//Entidades
    private Bairro bairro;  
//RN
    private final BairroRN BAIRRO_RN = new BairroRN();
    private static EntityManager em;

    public BairroRNTest() {

    }

    @AfterClass
    public static void tearDownClass() {
       em.close();
    }

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory fabrica = FabricaEntityManager.obterFabrica();
        em = fabrica.createEntityManager();
    }

    @Before
    public void setUp() {
        this.bairro = new Bairro(null,"Chicória");
        assertTrue(BAIRRO_RN.salvar(this.bairro));
    }

    @After
    public void tearDown() {
         assertTrue(BAIRRO_RN.excluir(this.bairro));
    }

    @Test
    public void conexaoTest() {
        assertNotNull(em);
    }
    
    @Test
    public void obterTest(){
        Bairro bairro = null;
        bairro = BAIRRO_RN.obter(this.bairro.getId());
        assertNotNull(bairro);
    }
    
    @Test
    public void obterTodosTest(){
        List<Bairro> bairros;
        bairros = BAIRRO_RN.obterTodos();
        assertNotNull(bairros);
    }
    
}
