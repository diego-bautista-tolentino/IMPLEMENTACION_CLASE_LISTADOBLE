/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructura.de.datos.practicas;

/**
 *
 * @author Diego
 */
public class main {
    public static void main(String[] args) {
        listaDoble lista = new listaDoble();

        //1 - Casos limite con lista vacia
        System.out.println("=== 1. Pruebas con lista vacia ===");
        System.out.println("Esta vacia? " + lista.estaVacia());
        System.out.println("Eliminar ultimo: " + lista.eliminarUltimo());
        System.out.println("Eliminar por valor (10): " + lista.eliminarPorValor(10));
        System.out.println("Eliminar en posicion (0): " + lista.eliminarEnPosicion(0));
        lista.insertarEnPosicion(2, 99);

        //2 - Insercion ordenada (inicio, medio, final, duplicados)
        System.out.println("\n=== 2. Insercion ordenada ===");
        int[] datos = {30, 10, 50, 20, 40, 20, 5, 60};
        for (int d : datos) {
            lista.insertarOrdenado(d);
            System.out.println("Insertado " + d + " -> " + lista);
        }
        System.out.println("Tamanio actual: " + lista.getTamanio());
        System.out.println("Recorrido inverso (cola a cabeza): " + lista.toStringReversa());

        //3 - Insercion por posicion
        System.out.println("\n=== 3. Insercion en posicion ===");
        lista.insertarEnPosicion(0, 1);
        System.out.println("Insertar 1 en pos 0: " + lista);
        lista.insertarEnPosicion(lista.getTamanio(), 99);
        System.out.println("Insertar 99 al final: " + lista);
        lista.insertarEnPosicion(4, 25);
        System.out.println("Insertar 25 en pos 4: " + lista);
        lista.insertarEnPosicion(-1, 500);
        lista.insertarEnPosicion(50, 500);

        //4 - Eliminacion por posicion
        System.out.println("\n=== 4. Eliminacion en posicion ===");
        System.out.println("Eliminado en pos 0: " + lista.eliminarEnPosicion(0));
        System.out.println("Lista: " + lista);
        System.out.println("Eliminado en pos final: " + lista.eliminarEnPosicion(lista.getTamanio() - 1));
        System.out.println("Lista: " + lista);
        System.out.println("Eliminado en pos 3: " + lista.eliminarEnPosicion(3));
        System.out.println("Lista: " + lista);
        lista.eliminarEnPosicion(100);

        //5 -Eliminacion por valor
        System.out.println("\n=== 5. Eliminacion por valor ===");
        System.out.println("Eliminar 5 (cabeza): " + lista.eliminarPorValor(5));
        System.out.println("Lista: " + lista);
        System.out.println("Eliminar 60 (cola): " + lista.eliminarPorValor(60));
        System.out.println("Lista: " + lista);
        System.out.println("Eliminar 30 (medio): " + lista.eliminarPorValor(30));
        System.out.println("Lista: " + lista);
        System.out.println("Eliminar 999 (no existe): " + lista.eliminarPorValor(999));

        //6 - Eliminacion del ultimo y vaciado completo
        System.out.println("\n=== 6. Eliminar ultimo hasta vaciar ===");
        while (!lista.estaVacia()) {
            lista.eliminarUltimo();
            System.out.println("Eliminar ultimo -> " + lista + " | Tamanio: " + lista.getTamanio());
        }
        System.out.println("Recorrido inverso final: " + lista.toStringReversa());
    }
}
