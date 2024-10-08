package cadena.models;

import java.util.Iterator;

public class IteradorLista<E> implements Iterator<E> {
    private Nodo<E> actual;
    public IteradorLista(Lista<E> lista) {
        actual = lista.getRaiz();
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
