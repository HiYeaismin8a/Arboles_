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
public class Arbol_Binario {
//https://www.youtube.com/watch?v=2J6ku6tFXG0&list=PLKGunf51mjlKbhwVHCvyHNvniDNHPoO8Q&index=45
    Nodo raiz;
    char valorDelNodoRaiz;

    public Arbol_Binario() {
        raiz = null;
    }

    public boolean existe(char valor) {

        return preOrden().contains("" + valor);
    }

    // <editor-fold defaultstate="collapsed" desc="MÉTODOS"> 
    public boolean insertar(char valor) {
        if (existe(valor)) {
            return false;
        }
        Nodo temp = new Nodo(valor);
        if (temp == null) {
            return false;
        }

        if (raiz == null) {
            raiz = temp;
            return true;
        }
        /*si es menor el valor del "nuevo" nodo a introducir comparado con el 
              otro Nodo Anterior (el que ya habíamos puesto)
               -> Evaluar si el valor es mayo o menor.*/
        if (temp.valor < raiz.valor) {
            if (raiz.punteroIzquierdo == null) {
                raiz.punteroIzquierdo = temp;
                return true;
            } else {
                return enlazar(raiz.punteroIzquierdo, temp);
            }
        } else {
            // Sí es mayor a la raíz que busque posición a la derecha.
            if (raiz.punteroDerecho == null) {
                raiz.punteroDerecho = temp;
                return true;
            }
            return enlazar(raiz.punteroDerecho, temp);
        }
    }

    public boolean enlazar(Nodo otroNodo, Nodo temp) {
        //RAIZ-Padre, hijo
        //Si un hijo está desocupado, se vuelve padre.

        /*si es menor el valor del "nuevo" nodo a introducir comparado con el 
              otro Nodo Anterior (el que ya habíamos puesto)
               -> Evaluar si el valor es mayo o menor.*/
        if (temp.valor < otroNodo.valor) {
            if (otroNodo.punteroIzquierdo == null) {
                otroNodo.punteroIzquierdo = temp;
                return true;
            }
            return enlazar(otroNodo.punteroIzquierdo, temp);
        } else { //mayores que padre= otroNodo;
            if (otroNodo.punteroDerecho == null) {
                otroNodo.punteroDerecho = temp;
                return true;
            }
            // Sí es mayor a la raíz que busque posición a la derecha.
            return enlazar(otroNodo.punteroDerecho, temp);
        }
    }

    public String postorden() {
        String recorrido = postorden(raiz).trim();
        do {
            recorrido = recorrido.replaceAll("  ", " ");
        } while (recorrido.contains("  "));
        recorrido = recorrido.replace(" ", ",");
        return recorrido;
    }

    private String postorden(Nodo padre) {
        if (padre == null) {
            return "";
        }
        //izquierdo, derecho, raíz
        return postorden(padre.punteroIzquierdo)  + " " + postorden(padre.punteroDerecho) + " "
                + padre.valor + " ";
    }

    public String inOrden() {
        String recorrido = inOrden(raiz).trim();
        do {
            recorrido = recorrido.replaceAll("  ", " ");
        } while (recorrido.contains("  "));
        recorrido = recorrido.replace(" ", ",");
        return recorrido;
    }

    private String inOrden(Nodo padre) {
        if (padre == null) {
            return "";
        }
        // izquierdo, raíz/padre, derecho.
        return inOrden(padre.punteroIzquierdo)  + " " + padre.valor + " "
                + inOrden(padre.punteroDerecho) + " ";
    }

    public String preOrden() {
        String recorrido = preOrden(raiz).trim();
        do {
            recorrido = recorrido.replaceAll("  ", " ");
        } while (recorrido.contains("  "));
        recorrido = recorrido.replace(" ", ",");
        return recorrido;
    }

    private String preOrden(Nodo padre) {
        if (padre == null) {
            return "";
        }
        // raíz, izquierdo, derecho.
        return padre.valor + " " + preOrden(padre.punteroIzquierdo) + " "
                + preOrden(padre.punteroDerecho) + " ";
    }

    private boolean soloEliminarNodoHojas(char valorsito) {
        Nodo papa = new Nodo();

        // 1. Si arbol está vacío, return false;
        if (raiz == null) {
            return false;
        }

        // 2. Revisar si no existe -> return false
        if (raiz.valor == valorsito) {
            //si valor está en raiz -> si raiz es hoja  11:27

            //si es hoja
            if (papa.punteroIzquierdo.punteroIzquierdo == null
                    && papa.punteroIzquierdo.punteroDerecho == null) {
                raiz.punteroIzquierdo = null;
                return true;
            }
            return false;
        }
        //3. Si no existe.
        if (!existe(raiz.valor)) {
            return false;
        }

        //4. si existe el valor
            if (valorsito < papa.valor) {
                //Verificar que exista si es Hoja.
                if (valorsito == papa.punteroIzquierdo.valor) {
                    //si es hoja
                    if (papa.punteroIzquierdo.punteroIzquierdo == null
                            && papa.punteroIzquierdo.punteroDerecho == null) {
                        
                        papa.punteroIzquierdo = null;
                        return true;
                    }
                    return false;
                }
                return eliminar(raiz.punteroIzquierdo, valorsito);

            } else {
                if (valorsito == papa.punteroDerecho.valor) {
                    //si es hoja
                    if (papa.punteroIzquierdo.punteroIzquierdo == null
                            && papa.punteroIzquierdo.punteroDerecho == null) {
                        
                        papa.punteroDerecho = null;
                        return true;
                    }
                    return false;
                }

                return eliminar(raiz.punteroDerecho, valorsito);
            }
        }
        
        
    

    private boolean eliminar(Nodo papa, char valorsito) {

        if (valorsito < papa.valor) {
            if (valorsito == papa.punteroIzquierdo.valor) {
                //si es hoja
                if (papa.punteroIzquierdo.punteroIzquierdo == null
                        && papa.punteroDerecho.punteroIzquierdo == null) {
                    
                    papa.punteroIzquierdo = null;
                    return true;
                }
                return false;
            }
            return eliminar(raiz.punteroIzquierdo, valorsito);

        } else {
            if (valorsito == papa.punteroDerecho.valor) {
                //si es hoja
                if (papa.punteroDerecho.punteroIzquierdo == null
                        && papa.punteroDerecho.punteroDerecho == null) {
                    papa.punteroDerecho = null;
                    return true;
                }
                return false;
            }

            return eliminar(raiz.punteroDerecho, valorsito);
        }
    }

    // </editor-fold> 
}
