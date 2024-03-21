/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.billeteravirtual;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Vera
 */
public class AlfiWallet implements Wallet {

    // variables
    private double saldo;
    private List<String> transacciones = new ArrayList<>();
    double euroDolars = 1.0869; // dolares en un EUR (20 de marzo 2024)
    double dolarEurs = 0.920961; // euros en un DOLAR (20 de marzo 2024)

    @Override
    public double obtenerSaldo() {
        return saldo;
    }

    @Override
    public void depositar(double cantidad) {
        
        if (cantidad > 0) {
            saldo += cantidad;
            transacciones.add("\nDeposito: +$" + cantidad);
            System.out.println("Monto depositado: $ " + cantidad);

        } else {
            System.out.println("El deposito debe ser mayor a 0");
        }
    }

    @Override
    public boolean retirar(double cantidad) {
        if (cantidad > 0) { // && saldo >= cantidad
            saldo -= cantidad;
            if (saldo < 0) {
                System.out.println("No puede retirar esa cantidad...");
                saldo += cantidad;
                return false;

            } else {
                transacciones.add("\nRetiro: -$" + cantidad);
                System.out.println("restando......$" + cantidad);
                System.out.println("Nuevo Saldo...$" + obtenerSaldo());
                return true;
            }

        } else {
            System.out.println("Ingrese un número mayor a 0 y menor o igual al saldo actual de: $" + saldo);
            return false;
        }
    }

    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda) {
        if (desdeMoneda == "USD") {
            double euros = cantidad * dolarEurs;
            System.out.println(cantidad + " Dolares, equivalen a: "
            + euros + " Euros");
        } else if (desdeMoneda == "EUR") {
            double dolares = cantidad * euroDolars;
            System.out.println(cantidad + " Euros, equivalen a: "
                    + dolares + " Dolares");
        }
        return true;
    }

    public List<String> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<String> transacciones) {
        this.transacciones = transacciones;
    }
}
