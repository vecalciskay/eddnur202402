package cadena.models;

import java.beans.PropertyChangeSupport;
import java.util.Iterator;

public class ListaDoble<E> implements Iterable<E> {

    protected Nodo<E> raiz;
    protected Nodo<E> cola;
    protected int tam = 0;
    private PropertyChangeSupport supportObserver;
    private static final String OBSERVER_TAMANO = "TAMANO";
    public ListaDoble() {
        raiz = null;
        cola = null;
        supportObserver = new PropertyChangeSupport(this);
    }

    public int getTam() {
        return tam;
    }

    public void insertar(E valor) {
        Nodo<E> nuevo = new Nodo<>(valor);
        nuevo.setSiguiente(raiz);
        if (raiz != null) {
            raiz.setAnterior(nuevo);
            raiz = nuevo;
        } else {
            raiz = nuevo;
            cola = nuevo;
        }

        tam++;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam, tam + 1);
    }

    public void adicionar(E valor) {
        Nodo<E> nuevo = new Nodo<>(valor);
        nuevo.setAnterior(cola);
        if (cola != null) {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        } else {
            raiz = nuevo;
            cola = nuevo;
        }

        tam++;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam, tam + 1);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterador<E>(raiz);
    }

    public E obtener(int posicion) {
        if (posicion < 0 || posicion >= tam) {
            throw new IndexOutOfBoundsException(
                    "La posición " + posicion + " está fuera del tamaño de la lista (" + tam + ")"
            );
        }

        Nodo<E> actual = null;
        if (posicion < (tam / 2)) {
            int count = 0;
            actual = raiz;
            while (actual.getSiguiente() != null && count != posicion) {
                count++;
                actual = actual.getSiguiente();
            }
        } else {
            int count = tam - 1;
            actual = cola;
            while (actual.getAnterior() != null && count != posicion) {
                count--;
                actual = actual.getAnterior();
            }
        }

        return actual.getValor();
    }

    public void eliminar(int posicion) {
        if (posicion < 0 || posicion >= tam) {
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
        if (posicion == (tam - 1)) {
            cola = cola.getAnterior();
            tam--;
            supportObserver.firePropertyChange(
                    OBSERVER_TAMANO, tam + 1, tam);
            return;
        }

        Nodo<E> actual = null;
        Nodo<E> anterior = null;
        Nodo<E> siguiente = null;
        if (posicion < (tam / 2)) {
            int count = 0;
            actual = raiz;
            anterior = null;
            siguiente = raiz.getSiguiente();
            while (actual.getSiguiente() != null && count != posicion) {
                count++;
                anterior = actual;
                actual = actual.getSiguiente();
                siguiente = actual.getSiguiente();
            }
        } else {
            int count = tam - 1;
            actual = cola;
            anterior = cola.getAnterior();
            siguiente = null;
            while (actual.getAnterior() != null && count != posicion) {
                count--;
                siguiente = actual;
                actual = actual.getAnterior();
                anterior = actual.getAnterior();
            }
        }

        // Borramos el elemento
        anterior.setSiguiente(siguiente);
        siguiente.setAnterior(anterior);

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

    /**
     * En realidad se llama ListaDoble.Nodo
     * @param <E>
     */
    class Nodo<E> {
        private E valor;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E v) {
            valor = v;
            siguiente = null;
            anterior = null;
        }

        public E getValor() {
            return valor;
        }

        public void setValor(E valor) {
            this.valor = valor;
        }

        public Nodo<E> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }

        public Nodo<E> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<E> anterior) {
            this.anterior = anterior;
        }

        @Override
        public String toString() {
            return valor + " <-> ";
        }
    }

    class Iterador<E> implements Iterator<E> {
        private Nodo<E> actual;

        public Iterador(Nodo<E> raiz) {
            actual = raiz;
        }
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public E next() {
            E valor = actual.getValor();
            actual = actual.getSiguiente();
            return valor;
        }
    }
}
