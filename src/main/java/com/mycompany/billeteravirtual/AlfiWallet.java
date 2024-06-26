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

    /**
     * metodo para obtener el saldo
     * 
     * @return el valor del saldo de la cuenta del usuario
     */
    @Override
    public double obtenerSaldo() {
        return saldo;
    }

    /**
     * metodo para depositar en la cuenta del usuario
     * 
     * @param cantidad valor double con la cantidad a depositar
     */
    @Override
    public void depositar(double cantidad) {

        if (cantidad > 0) {

            if (cantidad <= 99999) {
                saldo += cantidad;
                transacciones.add("\nDeposito: +$" + cantidad);
                System.out.println("Monto depositado: $ " + cantidad);
            } else {
                System.out.println("La cantidad a depositar, no debe superar los 5 digitos ");
            }

        } else {
            System.out.println("El deposito debe ser mayor a 0");
        }
    }

    /**
     * metodo para retirar dinero
     * 
     * @param cantidad valor double con la cantidad a retirar
     */
    @Override
    public void retirar(double cantidad) {
        if (cantidad > 0) {
            saldo -= cantidad;
            if (saldo < 0) {
                saldo += cantidad;
                System.out.println("No puede retirar esa cantidad...");
            } else {
                transacciones.add("\nRetiro: -$" + cantidad);
                System.out.println("restando......$" + cantidad);
                System.out.println("Nuevo Saldo...$" + obtenerSaldo());
            }

        } else {
            System.out.println("Ingrese un número mayor a 0 y menor o igual al saldo actual de: $" + saldo);
        }
    }

    /**
     * metodo para convertir de dolar a euro y viceversa
     * 
     * @param cantidad    valor double con la cantidad a convertir
     * @param desdeMoneda string que indica desde que tipo de moneda convertir
     * @param aMoneda     string que indica a cual tipo de moneda convertir
     * @return true indicando que el valor fue convertido
     */
    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda) {
        if (desdeMoneda.equals("USD")) {
            double euros = cantidad * dolarEurs;
            System.out.println(cantidad + " Dolares, equivalen a: "
                    + euros + " Euros");
        } else if (desdeMoneda.equals("EUR")) {
            double dolares = cantidad * euroDolars;
            System.out.println(cantidad + " Euros, equivalen a: "
                    + dolares + " Dolares");
        }
        return true;
    }

    /**
     * metodo para obtener el historial
     * 
     * @return el listado de las transacciones
     */
    public List<String> getTransacciones() {
        return transacciones;
    }

    /**
     * metodo para almacenar las transacciones
     * 
     * @param transacciones listado de las transacciones realizadas por usuario
     */
    public void setTransacciones(List<String> transacciones) {
        this.transacciones = transacciones;
    }
}
