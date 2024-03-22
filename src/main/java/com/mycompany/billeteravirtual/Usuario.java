/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.billeteravirtual;

/**
 *
 * @author Mauricio Vera
 */
public class Usuario {

    //atributos
    private int id;
    private String nombre;
    private AlfiWallet wallet;

    //constructor vacio
    public Usuario() {
    }

    /**
     * constructor por parametros
     * @param id numero entero para identificar al usuario
     * @param nombre string para el nombre del usuario
     * @param wallet  para instanciar la clase AlfiWallet
     */
    public Usuario(int id, String nombre, AlfiWallet wallet) {
        this.id = id;
        this.nombre = nombre;
        this.wallet = new AlfiWallet(); // instancia
    }

    // getter y setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public AlfiWallet getWallet() {
        return wallet;
    }
    public void setWallet(AlfiWallet wallet) {
        this.wallet = wallet;
    }
}
