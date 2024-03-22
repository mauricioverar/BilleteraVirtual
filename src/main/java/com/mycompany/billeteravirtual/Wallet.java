/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.billeteravirtual;

/**
 *
 * @author Mauricio Vera
 */
public interface Wallet {
    /**
     * 
     * @return saldo de la cuenta del usuario
     */
    double obtenerSaldo();
    /**
     * 
     * @param cantidad valor double del dinero a depositar
     */
    void depositar(double cantidad);
    
    /**
     * 
     * @param cantidad valor double del dinero a retirar
     */
    void retirar(double cantidad);
    
    /**
     * 
     * @param cantidad    valor double del dinero a convertir
     * @param desdeMoneda string que indica desde que tipo de moneda convertir
     * @param aMoneda     string que indica a cual tipo de moneda convertir
     * @return true indicando que el valor fue convertido
     */
    boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda);
}
