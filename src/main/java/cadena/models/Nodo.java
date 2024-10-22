package cadena.models;

import java.awt.*;

public class Nodo<E> {
    private E valor;
    private Nodo<E> siguiente;

    public Nodo(E valor) {
        this.valor = valor;
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

    @Override
    public String toString() {
        return valor + " -> ";
    }

    public void dibujar(Graphics g, int posX, int posY) {
        g.drawRect(posX, posY, 100, 50);
        g.setFont(new Font("Serif", Font.PLAIN, 18));
        g.drawString(valor.toString(), posX + 40, posY + 30);
    }
}
