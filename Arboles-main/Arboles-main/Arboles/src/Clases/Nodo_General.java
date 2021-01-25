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
public class Nodo_General {

    public char valor;
    public NodoLiga ini, fin;

    public Nodo_General(char v) {
        valor = v;
        ini = fin = null;
    }

    public Nodo_General() {
    }
    

    //Contruir las ligas con los noditos:
    //La direccion de tipo NODO_GENERAL se obtiene a traves del path
    public boolean insertarLiga(Nodo_General direccion) {
        //se insera hasta el final
        NodoLiga temp = new NodoLiga(direccion);

        if (temp == null) {
            return false;
        }
        if (ini == null && fin == null) {
            ini = fin = temp;
            return true;
        }
        fin.sig = temp;
        temp.ant = fin;
        fin = temp;
        return true;
    }

    //Eliminar la liga = desenlazar.
    //El árbol Elimina los nodos pero
    //El nodo elimina la liga.
    //--Eliminar tipico de una lista.
    //--vacio, no exista,(Los 4casos).
    public boolean eliminarLiga(Nodo_General direccion) {
        if (ini == null && fin == null) {
            return false;
        }
        //único nodo.
        if (ini == fin && ini.direccion == direccion) {
            fin = ini = null;
            return true;
        }

        if (ini.direccion == direccion) {
            NodoLiga temp = ini.sig;
            ini.sig = null;
            temp.ant = null;
            ini = temp;
            return true;
        }

        if (fin.direccion == direccion) {
            NodoLiga temp = fin.ant;
            temp.sig = null;
            fin.ant = null;
            fin = temp;
            return true;
        }
        //encontrar la ubicación donde se encuentra el nodo 
        //que voy a borrar.
        NodoLiga temp = ini.sig;
        do {
            if (temp.direccion == direccion) {
                temp.ant.sig = temp.sig;
                temp.sig.ant = temp.ant;
                temp.sig = temp.ant = null;

                return true;
            }
        } while (temp != fin);
        return false;
    }

    public boolean esHoja() {
        //si la lista está vacía de dicho nod general sig. que no tiene hijos.
        return ini == null && fin == null;
    }
    
    
    
        public String mostrar(NodoLiga temp) {
        if (temp == null) {
            return "";
        }
        return temp.direccion.valor + "\n" + mostrar(temp.sig);
    }

    public String mostrar() {
        if (ini == null && fin == null) {
            return "La lista está vacía";
        }
        return mostrar(ini);
    }
}
