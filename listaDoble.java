/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructura.de.datos.practicas;

/**
 *
 * @author Diego
 */
public class listaDoble {
    private int tamanio;
    private nodoD cabeza;
    private nodoD cola;
    
    public listaDoble() {
        tamanio = 0;
        cabeza = null;
        cola = null;
    }
    
    public boolean estaVacia() {
        return cabeza == null && cola == null;
    }

    public int getTamanio() {
        return tamanio;
    }
    
    // Busca un valor en la lista
    public boolean buscar(int dato) {
        nodoD aux = cabeza;
        while (aux != null) {
            if (aux.getDato() == dato) {
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    // Inserta un nodo al inicio de la lista
    public void insertarInicio(int dato) {
        nodoD nuevo = new nodoD(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            nuevo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;
        }
        tamanio++;
    }

    // Inserta un nodo al final de la lista
    public void insertarFinal(int dato) {
        nodoD nuevo = new nodoD(dato);
        if (estaVacia()) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola = nuevo;
        }
        tamanio++;
    }

    // 1. Inserta un nodo en una posicion especifica (0 a tamanio)
    public void insertarEnPosicion(int pos, int dato) {
        if (pos < 0 || pos > tamanio) {
            System.out.println("Error: Posicion " + pos + " fuera de rango.");
            return;
        }
        if (pos == 0) {
            insertarInicio(dato);
            return;
        }
        if (pos == tamanio) {
            insertarFinal(dato);
            return;
        }

        nodoD aux = cabeza;
        for (int i = 0; i < pos - 1; i++) {
            aux = aux.getSiguiente();
        }

        nodoD nuevo = new nodoD(dato);
        nodoD siguienteNodo = aux.getSiguiente();

        nuevo.setSiguiente(siguienteNodo);
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        siguienteNodo.setAnterior(nuevo);

        tamanio++;
    }

    // 2. Inserta manteniendo el orden ascendente
    public void insertarOrdenado(int dato) {
        if (estaVacia() || dato <= cabeza.getDato()) {
            insertarInicio(dato);
            return;
        }
        if (dato >= cola.getDato()) {
            insertarFinal(dato);
            return;
        }

        nodoD aux = cabeza;
        while (aux.getSiguiente() != null && aux.getSiguiente().getDato() < dato) {
            aux = aux.getSiguiente();
        }

        nodoD nuevo = new nodoD(dato);
        nodoD siguienteNodo = aux.getSiguiente();

        nuevo.setSiguiente(siguienteNodo);
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        siguienteNodo.setAnterior(nuevo);

        tamanio++;
    }

    // Elimina el primer nodo de la lista
    public boolean eliminarInicio() {
        if (estaVacia()) {
            return false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        tamanio--;
        return true;
    }

    // 3. Elimina el ultimo nodo de la lista
    public boolean eliminarUltimo() {
        if (estaVacia()) {
            return false;
        }
        if (cabeza == cola) {
            cabeza = null;
            cola = null;
        } else {
            cola = cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return true;
    }

    // 4. Elimina la primera ocurrencia del valor x
    public boolean eliminarPorValor(int x) {
        if (estaVacia()) {
            return false;
        }
        if (cabeza.getDato() == x) {
            return eliminarInicio();
        }
        if (cola.getDato() == x) {
            return eliminarUltimo();
        }

        nodoD aux = cabeza.getSiguiente();
        while (aux != null && aux != cola) {
            if (aux.getDato() == x) {
                nodoD previo = aux.getAnterior();
                nodoD siguienteNodo = aux.getSiguiente();

                previo.setSiguiente(siguienteNodo);
                siguienteNodo.setAnterior(previo);
                tamanio--;
                return true;
            }
            aux = aux.getSiguiente();
        }
        return false;
    }

    // 5. Elimina el nodo en la posicion indicada y devuelve su dato (-1 si falla)
    public int eliminarEnPosicion(int pos) {
        if (estaVacia() || pos < 0 || pos >= tamanio) {
            System.out.println("Error: Posicion " + pos + " invalida o lista vacia.");
            return -1;
        }
        if (pos == 0) {
            int datoEliminado = cabeza.getDato();
            eliminarInicio();
            return datoEliminado;
        }
        if (pos == tamanio - 1) {
            int datoEliminado = cola.getDato();
            eliminarUltimo();
            return datoEliminado;
        }

        nodoD aux = cabeza;
        for (int i = 0; i < pos; i++) {
            aux = aux.getSiguiente();
        }

        int datoEliminado = aux.getDato();
        nodoD previo = aux.getAnterior();
        nodoD siguienteNodo = aux.getSiguiente();

        previo.setSiguiente(siguienteNodo);
        siguienteNodo.setAnterior(previo);
        tamanio--;

        return datoEliminado;
    }

    // Imprime la lista de cabeza a cola
    @Override
    public String toString() {
        String res = "null <- ";
        nodoD aux = cabeza;
        while (aux != null) {
            res += "[" + aux.getDato() + "]";
            if (aux.getSiguiente() != null) {
                res += " <-> ";
            }
            aux = aux.getSiguiente();
        }
        res += " -> null";
        return res;
    }

    // Imprime la lista de cola a cabeza para verificar enlaces anteriores
    public String toStringReversa() {
        String res = "null <- ";
        nodoD aux = cola;
        while (aux != null) {
            res += "[" + aux.getDato() + "]";
            if (aux.getAnterior() != null) {
                res += " <-> ";
            }
            aux = aux.getAnterior();
        }
        res += " -> null";
        return res;
    }
}