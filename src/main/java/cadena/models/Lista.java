package cadena.models;

import cadena.vista.ListaJPanel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Lista<E> {
    private Nodo<E> raiz;
    private int tam = 0;
    private PropertyChangeSupport supportObserver;
    private static final String OBSERVER_TAMANO = "TAMANO";

    public Lista() {
        supportObserver = new PropertyChangeSupport(this);
    }

    public void insertar(E valor) {
        if (raiz == null) {
            raiz = new Nodo<>(valor);
            tam++;
            supportObserver.firePropertyChange(
                    OBSERVER_TAMANO, tam, tam + 1);
            return;
        }
        Nodo<E> actual = raiz;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        Nodo<E> nuevo = new Nodo<>(valor);
        actual.setSiguiente(nuevo);
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam, tam + 1);
        tam++;
    }

    public Nodo<E> getNodo(int posicion) {
        if (posicion >= tam) {
            throw new IndexOutOfBoundsException(
                    "La posición " + posicion + " está fuera del tamaño de la lista (" + tam + ")"
            );
        }
        int count = 0;
        Nodo<E> actual = raiz;
        while (actual.getSiguiente() != null && count != posicion) {
            count++;
            actual = actual.getSiguiente();
        }
        return actual;
    }

    public E obtener(int posicion) {
        return getNodo(posicion).getValor();
    }

    public void eliminar(int posicion) {
        if (posicion >= tam) {
            throw new IndexOutOfBoundsException(
                    "La posición " + posicion + " está fuera del tamaño de la lista (" + tam + ")"
            );
        }
        if (posicion == 0) {
            raiz = raiz.getSiguiente();
            tam--;
            supportObserver.firePropertyChange(
                    OBSERVER_TAMANO, tam + 1, tam);
            return;
        }
        int count = 0;
        Nodo<E> actual = raiz;
        Nodo<E> anterior = null;
        Nodo<E> siguiente = raiz.getSiguiente();
        while (actual.getSiguiente() != null && count != posicion) {
            count++;
            anterior = actual;
            actual = actual.getSiguiente();
            siguiente = actual.getSiguiente();
        }
        anterior.setSiguiente(siguiente);
        tam--;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam + 1, tam);
    }

    @Override
    public String toString() {
        Nodo<E> actual = raiz;
        if (actual == null) {
            return "Null";
        }
        StringBuilder builder = new StringBuilder();
        while (actual.getSiguiente() != null) {
            builder.append(actual);
            actual = actual.getSiguiente();
        }
        builder.append(actual);

        return builder.toString();
    }

    public Nodo<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<E> raiz) {
        this.raiz = raiz;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public static void main(String[] args) {
        Lista<Integer> listaPrueba = new Lista<>();
        listaPrueba.insertar(5);
        listaPrueba.insertar(10);
        listaPrueba.insertar(8);
        listaPrueba.insertar(1);
        System.out.println(listaPrueba);
        int elementoPos2 = listaPrueba.obtener(2);
        System.out.println(elementoPos2);
        System.out.println(listaPrueba.obtener(3));
//        System.out.println(listaPrueba.obtener(5));
//        listaPrueba.eliminar(2);
        listaPrueba.eliminar(0);
        System.out.println(listaPrueba);
        listaPrueba.eliminar(1);
        System.out.println(listaPrueba);
        listaPrueba.eliminar(1);
        System.out.println(listaPrueba);
        listaPrueba.eliminar(0);
        System.out.println(listaPrueba);
        listaPrueba.eliminar(4);
        System.out.println(listaPrueba);


//        Lista<String> listaStrings = new Lista<>();
//        listaStrings.insertar("Hola");
//        listaStrings.insertar("mundo");
//        listaStrings.insertar("chau");
//        System.out.println(listaStrings);

    }

    public void addObserver(PropertyChangeListener observer) {
        supportObserver.addPropertyChangeListener(observer);
    }
}
