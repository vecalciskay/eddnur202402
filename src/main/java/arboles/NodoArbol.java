package arboles;

import cadena.models.Lista;

public class NodoArbol<E extends Identificable> {
    private E valor;
    private Lista<NodoArbol<E>> hijos;

    public NodoArbol(E valor) {
        this.valor = valor;
        hijos = new Lista<>();
    }

    public E getValor() {
        return valor;
    }

    public Lista<NodoArbol<E>> getHijos() {
        return hijos;
    }
    public void agregarHijo(NodoArbol<E> hijo){
        this.hijos.insertar(hijo);
    }

    @Override
    public String toString() {
        return this.getValor().toString();
    }
}