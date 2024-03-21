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
        // String nombre;
        boolean acceso = true;

        // String rut;
        int opcion = 9, monto;
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        // instanciar
        AlfiWallet saldo = new AlfiWallet();
        AlfiWallet deposito = new AlfiWallet();
        AlfiWallet retiro = new AlfiWallet();
        System.out.println("********************");
        System.out.println("Billetera Virtual");
        System.out.println("Ingrese nombre: ");
        String nombre = leer.nextLine();
        // leer.nextLine();
        Usuario usuario1 = new Usuario(1, nombre, deposito);
        usuarios.add(usuario1);
        usuario1.getWallet().obtenerSaldo();
        // System.out.println("Ingrese rut: ");
        // rut = leer.nextLine();
        // menu
        while (acceso) {
            try {
                System.out.println("Ingrese una opcion");
                System.out.println(" 0: para salir");
                System.out.println(" 1: para consultar saldo");
                System.out.println(" 2: para depositar");
                System.out.println(" 3: para retirar");
                System.out.println(" 4: para convertir moneda (EUR/USD)");
                System.out.println(" 5: para obtener transacciones");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 0:
                        System.out.println("Cerrando Menu");
                        acceso = false;
                        break;
                    case 1:
                        System.out.println(usuario1.getNombre() + ". Su saldo es: $" + usuario1.getWallet().obtenerSaldo());
                        break;
                    case 2:
                        System.out.println("Ingrese el monto a depositar");
                        monto = leer.nextInt(); // 5000
                        System.out.println("Monto depositado: $ " + monto + " en la cuenta de: " + usuario1.getNombre());
                        usuario1.getWallet().depositar(monto);
                        break;
                    case 3:
                        System.out.println("Ingrese el monto a retirar");
                        monto = leer.nextInt();
                        System.out.println("Monto retirado es : " + usuario1.getWallet().retirar(monto));
                        break;
                    case 4:
                        System.out.println("Ingrese opcion para convertir moneda ");
                        System.out.println("1: USD/EUR ; 2: EUR/USD");
                        int moneda = leer.nextInt();
                        if (moneda == 1) {
                            System.out.println("ingrese dolares");
                        } else if (moneda == 2) {
                            System.out.println("ingrese euros");
                        } else System.out.println("opcion no valida");
                        break;
                    case 5:
                        System.out.println("Imprimir cartola");
                        // monto = leer.nextInt(); // 5000
                        // if (deposito.depositar((monto))) {
                        // System.out.println("Monto depositado: " + monto);
                        // usuario1.getWallet().depositar(monto);
                        // }
                        break;
                    default:
                        System.out.println("Opcion no existe");
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println(" ingrese solo numero de opcion");
            }

            leer.nextLine();
            System.out.println("Si desa volver al Menu ingrese S, sino Enter");
            String respuesta = leer.nextLine();
            if (respuesta.equals("s") || respuesta.equals("S")) {
                acceso = true;
            } else {
                System.out.println("Muchas gracias");
                acceso = false;
            }

        }
        leer.close();
    }
}
