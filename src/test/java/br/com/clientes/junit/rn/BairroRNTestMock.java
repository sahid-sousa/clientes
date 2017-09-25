/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clientes.junit.rn;

import br.com.clientes.dao.GenericDAO;
import br.com.clientes.entidades.Bairro;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author BPMLAB-04
 */
public class BairroRNTestMock {
    Bairro bairro;
    GenericDAO<Bairro> genericDAOFalso = mock(GenericDAO.class) ;
    
    @Before
    public void setUp(){
        this.bairro = new Bairro();
        this.bairro.setNome("Cremação");
    }
    
    @After
    public void tearDown(){
        this.bairro = null;
        this.genericDAOFalso.limparCache();
    }
    
    @Test
    public void salvarBairroMockTest(){
        when(genericDAOFalso.criar(bairro)).thenReturn(true);
    }
}
