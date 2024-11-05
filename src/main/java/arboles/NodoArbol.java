package arboles;

import cadena.models.Lista;

public class NodoArbol<E extends Identificable> {
    private E valor;
    private Lista<NodoArbol<E>> hijos;
    private NodoArbol<E> padre;
    private int x;
    private int y;
    private int tamano;
    public NodoArbol(E valor) {
        this.valor = valor;
        hijos = new Lista<>();
        x = 0;
        y = 0;
    }

    public E getValor() {
        return valor;
    }

    public Lista<NodoArbol<E>> getHijos() {
        return hijos;
    }
    public void agregarHijo(NodoArbol<E> hijo){
        this.hijos.insertar(hijo);
        hijo.setPadre(this);
    }

    @Override
    public String toString() {
        return this.getValor().toString();
    }

    public NodoArbol<E> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol<E> padre) {
        this.padre = padre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }
}