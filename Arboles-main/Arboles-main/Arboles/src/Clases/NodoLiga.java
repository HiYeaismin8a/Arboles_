/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author HiYeaismin 8a
 */
public class NodoLiga {
    public Nodo_General direccion;
    public NodoLiga ant, sig;
    
    public NodoLiga(Nodo_General direccion){
        this.direccion= direccion;
        ant = sig=null;
    }
}
