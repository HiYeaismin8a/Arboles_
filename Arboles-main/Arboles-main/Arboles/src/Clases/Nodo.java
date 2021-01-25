/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Arbol_Binario;

/**
 *
 * @author HiYeaismin 8a
 */
public class Nodo {

    // <editor-fold defaultstate="collapsed" desc="VARIABLES"> 
    Nodo punteroIzquierdo,
            punteroDerecho, padre;
    char valor;
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="CONSTRUCTORES"> 
    public Nodo(char elValor) {
        valor = elValor;
        padre = punteroIzquierdo = punteroDerecho = null;
    }

    Nodo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GETTERS AND SETTERS">
    public void setValor(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return valor;
    }
     // </editor-fold>
   
}

    
