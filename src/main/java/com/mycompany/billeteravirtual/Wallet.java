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
    double obtenerSaldo();
    void depositar(double cantidad);
    void retirar(double cantidad); // void
    boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda);
}
