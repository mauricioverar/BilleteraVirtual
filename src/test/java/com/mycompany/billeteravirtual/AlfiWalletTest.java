/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.billeteravirtual;

// import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mao
 */
public class AlfiWalletTest {

    // instancias
    AlfiWallet wallet = new AlfiWallet();
    Usuario usuario = new Usuario(1, "Pedro", wallet);
  
    public AlfiWalletTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of obtenerSaldo method, of class AlfiWallet.
     */
    /* @Test
    public void testObtenerSaldo() {
        System.out.println("obtenerSaldo");
        AlfiWallet instance = new AlfiWallet();
        double expResult = 0.0;
        double result = instance.obtenerSaldo();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of depositar method, of class AlfiWallet.
     */
    @Test // OK ***
    public void testDepositar() {
        System.out.println("depositar");
        double cantidad = 10.0;
        // AlfiWallet instance = new AlfiWallet();
        // instance.depositar(cantidad);

        // realizar deposito
        usuario.getWallet().depositar(cantidad); // instanciado al inicio

        // comparar valores
        assertEquals(cantidad, usuario.getWallet().obtenerSaldo(), 0); // Monto depositado: $ 10.0  
        // intentar realizar deposito con cantidad negativa
        usuario.getWallet().depositar(-cantidad); // instanciado al inicio 
        // comparar valores
        assertEquals(cantidad, usuario.getWallet().obtenerSaldo(), 0); // El deposito debe ser mayor a 0
    }

    /**
     * Test of retirar method, of class AlfiWallet.
     */
    @Test // OK ***
    public void testRetirar() {
        usuario.getWallet().depositar(200);
        System.out.println("retirar");
        double cantidad = 100.0;
        // retirar
        usuario.getWallet().retirar(cantidad); // instanciado al inicio 
        // comparar valores
        assertEquals(cantidad, usuario.getWallet().obtenerSaldo(), 0); // Nuevo Saldo...$100.0
    }

    /**
     * Test of convertirMoneda method, of class AlfiWallet.
     */
    /* @Test
    public void testConvertirMoneda() {
        System.out.println("convertirMoneda");
        double cantidad = 0.0;
        String desdeMoneda = "";
        String aMoneda = "";
        AlfiWallet instance = new AlfiWallet();
        boolean expResult = false;
        boolean result = instance.convertirMoneda(cantidad, desdeMoneda, aMoneda);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */

    /**
     * Test of getTransacciones method, of class AlfiWallet.
     */
    /* @Test
    public void testGetTransacciones() {
        System.out.println("getTransacciones");
        AlfiWallet instance = new AlfiWallet();
        List<String> expResult = null;
        List<String> result = instance.getTransacciones();
        assertEquals(expResult, result);
    } */

    /**
     * Test of setTransacciones method, of class AlfiWallet.
     */
    /* @Test
    public void testSetTransacciones() {
        System.out.println("setTransacciones");
        List<String> transacciones = null;
        AlfiWallet instance = new AlfiWallet();
        instance.setTransacciones(transacciones);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
}
