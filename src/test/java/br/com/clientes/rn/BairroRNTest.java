/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.rn;

import br.com.clientes.dao.FabricaEntityManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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

    //RN
    private final BairroRN BAIRRO_RN = new BairroRN();
    private static EntityManager em;

    public BairroRNTest() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @BeforeClass
    public static void setUpClass() {
        EntityManagerFactory fabrica = FabricaEntityManager.obterFabrica();
        em = fabrica.createEntityManager();
    }

    @Before
    public void setUp() {
        EntityTransaction transaction = em.getTransaction();
        String sql = "INSERT INTO bairro VALUES (null, 'Panorama')";
        try {
            transaction.begin();
            Query q = em.createNativeQuery(sql);
            q.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            transaction.rollback();
        }
    }

    @After
    public void tearDown() {
        EntityTransaction transaction = em.getTransaction();
        String sql = "SELECT id FROM bairro WHERE nome = 'Jurunas'";

        try {
            transaction.begin();
            Query q = em.createNativeQuery(sql);
            List resultado = q.getResultList();
            if (resultado != null && !resultado.isEmpty()) {
                int id = (Integer) resultado.get(0);
                q = em.createNativeQuery("DELETE FROM bairro WHERE id=" + id);
                q.executeUpdate();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.err);
            transaction.rollback();
        }
    }

    @Test
    public void conexaoTest() {
        assertNotNull(em);
    }
    
    
}
