package arboles.arbol2;

import cadena.models.Lista;

public class NodoArbol2<E> {
    private E contenido;
    private Lista<NodoArbol2<E>> hijos = new Lista<>();

    public E getContenido() {
        return contenido;
    }

    public void setContenido(E contenido) {
        this.contenido = contenido;
    }

    public Lista<NodoArbol2<E>> getHijos() {
        return hijos;
    }

    public void agregarHijo(NodoArbol2<E> hijo){
        hijos.adicionar(hijo);
    }
    public NodoArbol2(E contenido){
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return contenido.toString();
    }
}
