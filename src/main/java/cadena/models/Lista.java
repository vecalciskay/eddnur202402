package cadena.models;

import cadena.vista.ListaJPanel;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class Lista<E> implements Iterable<E>{
    protected Nodo<E> raiz;
    protected int tam = 0;
    private PropertyChangeSupport supportObserver;
    private static final String OBSERVER_TAMANO = "TAMANO";


    public Lista() {
        supportObserver = new PropertyChangeSupport(this);
    }

    public void insertar(E valor) {
        Nodo<E> nuevo = new Nodo<>(valor);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        tam++;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam, tam + 1);
    }

    public void adicionar(E valor) {
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

        System.out.println("FOR");
        for (int i = 0; i < listaPrueba.getTam(); i++) {
            System.out.println(listaPrueba.obtener(i));
        }

        System.out.println("WHILE");
        Iterator<Integer> iter = listaPrueba.iterator();
        while(iter.hasNext()) {
            Integer valInt = iter.next();
            System.out.println(valInt);
        }

        System.out.println("FOREACH");
        for (Integer valInt: listaPrueba) {
            System.out.println(valInt);
        }

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
        //listaPrueba.eliminar(4);
        //System.out.println(listaPrueba);



    }

    public void addObserver(PropertyChangeListener observer) {
        supportObserver.addPropertyChangeListener(observer);
    }

    @Override
    public Iterator<E> iterator() {
        return new IteradorLista<>(this);
    }
}
