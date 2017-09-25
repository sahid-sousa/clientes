/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bairro.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author SHD
 */
public class CadastrarBairroWebTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void formCadastrarUmBairroTest() {

        driver.navigate().to("http://localhost:8084/clientes/bairro/cadastro.xhtml");

        WebElement titulo = driver.findElement(By.name("formCadastroBairro:district"));
        WebElement button = driver.findElement(By.name("formCadastroBairro:enviar"));
        titulo.sendKeys("Terra Firme");
        button.click();

        boolean existeMensagem = driver.getPageSource().contains("Erro de validação");

        Assert.assertTrue(!existeMensagem);

    }

//    public static void main(String[] args) {
//        CadastrarBairroWebTest.formCadastrarUmBairroTest();
//    }
}
