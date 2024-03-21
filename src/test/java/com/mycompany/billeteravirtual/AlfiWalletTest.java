/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.billeteravirtual;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Mauricio Vera
 */
public class AlfiWalletTest {

    // instancias
    AlfiWallet wallet = new AlfiWallet();
    Usuario usuario = new Usuario(1, "Pedro", wallet);
  
    public AlfiWalletTest() {
    }

    /**
     * Test of depositar method, of class AlfiWallet.
     */
    @Test // OK ***
    public void testDepositar() {
        System.out.println("depositar");
        double cantidad = 10.0;

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
}
