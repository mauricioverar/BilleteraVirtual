/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.billeteravirtual;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mao
 */
public class AlfiWallet implements Wallet {

    private double saldo;
    private List<String> transacciones = new ArrayList<>();
    
    @Override
    public double obtenerSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double cantidad) {
        saldo += cantidad; // 5000
        transacciones.add("Deposito: +" + saldo);
        if (cantidad > 0) {
        }
    }

    @Override
    public boolean retirar(double cantidad) {
        System.out.println("cantidad en AlfiWallet " + cantidad);
        if (cantidad > 0) { //&& saldo >= cantidad
            saldo -= cantidad;
            System.out.println("Saldo..." + obtenerSaldo());
            System.out.println("restando......" + saldo);
            return true;
        } else {
            System.out.println("Ingrese un número mayor a 0 y menor o igual al saldo actual" + saldo);
            return false;
        }
    }

    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda) {
        return false;
    }
    
}
