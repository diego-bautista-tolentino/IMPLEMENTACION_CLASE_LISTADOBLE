/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructura.de.datos.practicas;

/**
 *
 * @author Diego
 */
public class nodoD {
    private int dato;
    private nodoD siguiente;
    private nodoD anterior;
    
    public nodoD(int x) {
        dato = x;
        siguiente = null;
        anterior = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public nodoD getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(nodoD siguiente) {
        this.siguiente = siguiente;
    }

    public nodoD getAnterior() {
        return anterior;
    }

    public void setAnterior(nodoD anterior) {
        this.anterior = anterior;
    }
}
