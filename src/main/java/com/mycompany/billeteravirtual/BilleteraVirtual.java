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

        try (
                // variables
                // instanciando a Scanner
                Scanner leer = new Scanner(System.in)) {
            String password, patron_password = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[^A-Za-z0-9]).{8,}$";
            String nombre, patron_nombre = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ]+$";
            boolean acceso = true;
            int monto, intentos = 4;

            ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

            // instancia de AlfiWallet
            AlfiWallet wallet = new AlfiWallet();

            System.out.println(" ");
            System.out.println("*********************");
            System.out.println("*********************");
            System.out.println("* Billetera Virtual *");
            System.out.println("*********************");
            System.out.println(" ");

            // validar nombre del usuario para ingresar solo letras
            do {
                System.out.println(
                        "Ingrese su nombre:");
                nombre = leer.nextLine();

                if (!nombre.matches(patron_nombre)) {
                    System.out.println("Ingrese solo letras");
                    System.out.println("-------------------");
                }

            } while (!nombre.matches(patron_nombre));
            System.out.println(" ");

            // validar clave del usuario (por seguridad)
            do {
                System.out.println(
                        "Ingrese la clave de su cuenta, para iniciar sesion \n(almenos una minuscula y una mayuscula y un digito y caracter especial, largo minimo de 8 caracteres) ");
                password = leer.nextLine();

                if (!password.matches(patron_password)) {
                    System.out.println("Error:_Clave_No valida");
                    intentos--;
                    if (intentos > 1) {
                        System.out.println("*** Le quedan " + intentos + " intentos ***");
                    } else if (intentos == 1) {
                        System.out.println("*************************************************");
                        System.out.println("***** ¡ATENCION! Le queda el ultimo intento *****");
                        System.out.println("*************************************************");
                    } else {
                        System.out.println("Acceso bloqueado....");
                        acceso = false;
                        break;
                    }
                }
            } while (!password.matches(patron_password));
            System.out.println(" ");

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

                    int opcion = leer.nextInt();
                    System.out.println(" ");

                    switch (opcion) {
                        case 0 -> {
                            System.out.println("...Cerrando Menu");
                            acceso = false;
                        }
                        case 1 -> System.out.println(
                                usuario1.getNombre() + ". Su saldo es: $" + usuario1.getWallet().obtenerSaldo());
                        case 2 -> {
                            System.out.println("Ingrese el monto a depositar");
                            monto = leer.nextInt();
                            usuario1.getWallet().depositar(monto);
                        }
                        case 3 -> {
                            System.out.println("Ingrese el monto a retirar");
                            monto = leer.nextInt();
                            usuario1.getWallet().retirar(monto);
                        }
                        case 4 -> {
                            System.out.println("Ingrese opcion para convertir moneda ");
                            System.out.println("1: USD/EUR ; 2: EUR/USD");
                            int moneda = leer.nextInt();
                            switch (moneda) {
                                case 1 -> {
                                    System.out.println("ingrese dolares");
                                    int dolars = leer.nextInt();
                                    usuario1.getWallet().convertirMoneda(dolars, "USD", "EUR");
                                }
                                case 2 -> {
                                    System.out.println("ingrese euros");
                                    int euros = leer.nextInt();
                                    usuario1.getWallet().convertirMoneda(euros, "EUR", "USD");
                                }
                                default -> System.out.println("opcion no valida");
                            }
                        }

                        case 5 -> {
                            System.out.println("Imprimiendo el historial de su cuenta...");
                            if (usuario1.getWallet().getTransacciones().isEmpty()) {
                                System.out.println("...Sin movimientos en su cuenta");
                            } else
                                System.out.println(usuario1.getWallet().getTransacciones());
                        }
                        default -> System.out.println("Opcion no existe");
                    }
                } catch (Exception e) {
                    System.out.println("_____________________________");
                    System.out.println(" ");
                    System.out.println(" Error:_Ingrese solo numeros");
                    System.out.println("_____________________________");
                }

                leer.nextLine();
                System.out.println(" ");
                System.out.println("********************************************");
                System.out.println("* Si desea volver al Menu ingrese S        *");
                System.out.println("* ........Sino Enter para finalizar sesion *");
                System.out.println("********************************************");
                System.out.println(" ");

                String respuesta = leer.nextLine();
                if (respuesta.equals("s") || respuesta.equals("S")) {
                    acceso = true;
                } else {
                    System.out.println(" ¿ Está seguro que desea salir ?, entonces ingrese S. Sino Enter para volver  ");
                    System.out.println(" ---------------------------------------------------------------------------  ");
                    String exit = leer.nextLine();

                    if (exit.equals("s") || exit.equals("S")) {
                        System.out.println("___ Muchas gracias por utilizar la BilleteraVirtual ... vuelva pronto ___");
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("-------------------------------------------------------------------------");
                        acceso = false;
                    } else {
                        acceso = true;
                    }
                }

            }
        }
    }
}
