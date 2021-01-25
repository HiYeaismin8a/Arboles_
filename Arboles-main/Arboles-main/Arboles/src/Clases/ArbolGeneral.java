/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author HiYeaismin 8a
 */
public class ArbolGeneral {

    public Nodo_General raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public String insertarNodoGeneral(String path, char valor) {
        String[] vectorParche = path.split("/");
        if (vectorParche.length==2) {
            if (raiz == null) {
                raiz = new Nodo_General(valor);
                return "Nodo raíz: "+ valor;
                //return true;
            }
        }  //punteroPadre
        
        Nodo_General padre = bucarNodo(path);
        if (padre == null) {
            return "El nodo al que le quieres insertar hijos no fue encontrado";
        }
      
        Nodo_General buscarhijo = bucarNodo(path + "/" + valor);
        
        //Si la busqueda me regresa un NULL significa "NO EXISTE" por tanto se crea
        //Si la busqueda me regresa un !=NULL significa "HIJO YA EXISTE"
        if (buscarhijo != null) {
            return "El nodo " + valor + "ya existe como hijo del nodo " + padre.valor;
        }// buscarhijo = null;
       
        Nodo_General hijo = new Nodo_General(valor);
        
        if(padre.insertarLiga(hijo))
           return "Nodos hijos del Nodo " + padre.valor+":"+"\n"+ padre.mostrar();
        else 
            return "algo salió mal, preguntale a jazmín por favor";
    }
 
    public String consultarNodoGeneral(String path) {
        
        Nodo_General padre = bucarNodo(path);
        if (padre == null) {
            return "El nodo al que le quieres insertar hijos no fue encontrado";
        }     

        return "Nodos hijos del Nodo " + padre.valor+":"+"\n"+ padre.mostrar();
        
    }
 

    //primera forma
    private Nodo_General bucarNodo(String path) {
         
        // consiferar que sea un path encillo /m ó /m/w -> sig. que el padre es RAÍZ
        if (path.isEmpty()) {
            return null;
        }
        path = path.substring(1); // no quiero la primera diagonal[posición 0]. Así que tomamos de la [Posición 1]
        String[] vector = path.split("/"); //   /m/w/a/t
        
        /*if( raiz.ini == null){
            return null;
        }*/
        
        /*Encontrar la raiz*/
        if (raiz.valor == vector[0].charAt(0)) {
            
            if (vector.length == 1) { //
                System.out.println("2");
                return raiz;            //
            } 
            
            for (NodoLiga temp = raiz.ini; temp != null; temp = temp.sig) {
                //La ubicación es la dirección.
                if (temp.direccion.valor == vector[1].charAt(0)) {
                    if (vector.length == 2) {
                        
                        //JOptionPane.showMessageDialog(null,"MENSAJE");
                        return temp.direccion;
                    }
                    return buscarNodo(temp.direccion, path.substring(3));
                }
            }
        }
        return null;
    }

    //2da forma
    private Nodo_General buscarNodo(Nodo_General nodoEncontrado, String path) {
        if (path.isEmpty()) {
            return nodoEncontrado;
        }
        if(raiz==null){
            return null;
        }
        path = path.substring(1);
        String vector[];
        if (path.length() == 1) {
            vector = new String[1];
            vector[0] = path;
            
        } else {
            vector = path.split("/");
        }
        for (NodoLiga temp = nodoEncontrado.ini; temp != null; temp = temp.sig) {
            if (temp.direccion.valor == vector[0].charAt(0)) {
                buscarNodo(temp.direccion, path.substring(1));
            }
        }
        return null;
    }

    public boolean eliminadNodoGeneral(String path) {
        
        Nodo_General hijo = bucarNodo(path);
        //No se ingrsó ningún path a buscar para eliminar
        if (hijo == null) {
            return false;
        }
        //El hijo deja de existir y se lo lleva el reciclador de memoria.
        if (hijo == raiz) {
            if (raiz.esHoja()) {
                raiz = null;
                return true;
            }
            return false;
        } 
        /*La última letra es la que se va a analizar. Así que se toma en cuenta
        si el padre tiene ese hijo*/
        String pathPadre = obtenerPathPadre(path);
        Nodo_General padre = bucarNodo(pathPadre);
        //SI no existe ese padre entonces no puede existir dicho hijo a buscar para eliminar.
        if(padre == null){
            return false;
        }
        /*
        Si el hijo o letra o nodo general que se quiere eliminar ya no tiene más hijos.
        Entonces sí se puede eliminar. Empezando desaciendo la liga (cordón umbilical)
        que el hijo/nodo que queremos eliminar*/
        if(hijo.esHoja()){
            return padre.eliminarLiga(hijo);
        
        } 
        //No es una raiz pero tampoco es una rama por lo tanto no se puede eliminar.
        return false;
    }
    
    
    private String obtenerPathPadre(String pathHijo){
        int pasicionUltimaDiagonal= pathHijo.lastIndexOf("/")-1;
        return pathHijo.substring(0, pasicionUltimaDiagonal);
    }
    
    
   
    
}
