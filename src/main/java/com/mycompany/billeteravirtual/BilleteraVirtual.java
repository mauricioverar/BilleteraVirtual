/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.billeteravirtual;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mauricio Vera
 */
public class BilleteraVirtual {

    public static void main(String[] args) {

        // variables
        // instanciando a Scanner
        Scanner leer = new Scanner(System.in);
        boolean acceso = true;
        int opcion = 9, monto;

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        // instancia de AlfiWallet
        AlfiWallet wallet = new AlfiWallet();

        System.out.println(" ");
        System.out.println("*********************");
        System.out.println("*********************");
        System.out.println("* Billetera Virtual *");
        System.out.println("*********************");
        System.out.println(" ");

        System.out.println("Ingrese su nombre para iniciar: ");
        System.out.println(" ");

        String nombre = leer.nextLine();
        // leer.nextLine();
        Usuario usuario1 = new Usuario(1, nombre, wallet);
        usuarios.add(usuario1);
        usuario1.getWallet().obtenerSaldo();

        // menu
        while (acceso) {
            try {
                System.out.println(" ");
                System.out.println("******************");
                System.out.println("Ingrese una opcion");
                System.out.println(" 0:  Salir");
                System.out.println(" 1:  Consultar saldo");
                System.out.println(" 2:  Depositar");
                System.out.println(" 3:  Retirar");
                System.out.println(" 4:  Convertir moneda (EUR/USD)");
                System.out.println(" 5:  Obtener transacciones");
                System.out.println("**************************");
                System.out.println(" ");

                opcion = leer.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("...Cerrando Menu");
                        acceso = false;
                        break;
                    case 1:
                        System.out.println(usuario1.getNombre() + ". Su saldo es: $" + usuario1.getWallet().obtenerSaldo());
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a depositar");
                        monto = leer.nextInt();
                        usuario1.getWallet().depositar(monto);
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a retirar");
                        monto = leer.nextInt();
                        usuario1.getWallet().retirar(monto);
                        break;
                    case 4:
                        System.out.println("Ingrese opcion para convertir moneda ");
                        System.out.println("1: USD/EUR ; 2: EUR/USD");
                        int moneda = leer.nextInt();
                        if (moneda == 1) {
                            System.out.println("ingrese dolares");
                            int dolars = leer.nextInt();
                            usuario1.getWallet().convertirMoneda(dolars, "USD", "EUR");
                        } else if (moneda == 2) {
                            System.out.println("ingrese euros");
                            int euros = leer.nextInt();
                            usuario1.getWallet().convertirMoneda(euros, "EUR", "USD");
                        } else System.out.println("opcion no valida");
                        break;
                    case 5:
                        System.out.println("Imprimiendo el historial de su cuenta...");
                        if (usuario1.getWallet().getTransacciones().size() > 0) {
                            System.out.println(usuario1.getWallet().getTransacciones());
                        } else System.out.println("Sin movimientos en su cuenta");

                        break;
                    default:
                        System.out.println("Opcion no existe");
                }
            } catch (Exception e) {
                System.out.println(" Error:_Ingrese solo numero de opcion");
            }

            leer.nextLine();
            System.out.println("........Si desea volver al Menu ingrese S, sino Enter para finalizar sesion");
            System.out.println("........Sino Enter para finalizar sesion");
            String respuesta = leer.nextLine();
            if (respuesta.equals("s") || respuesta.equals("S")) {
                acceso = true;
            } else {
                System.out.println("___ Muchas gracias por utilizar la BilleteraVirtual ... vuelva pronto ___");
                acceso = false;
            }

        }
        leer.close();
    }
}
