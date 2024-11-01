package arboles.gui;

import arboles.Arbol;
import arboles.NodoArbol;
import arboles.NumeroIdentificable;

import java.awt.*;

public class DibujoArbol {
    private Arbol<NumeroIdentificable> modelo;
    private Graphics grafico;
    private static final int ESPACIO_VERTICAL = 60;
    private static final int ESPACIO_HORIZONTAL = 15;
    private static final int TAMANO_NODO = 30;

    public DibujoArbol(Arbol<NumeroIdentificable> modelo) {
        this.modelo = modelo;
    }

    public void dibujar(Graphics g, int x, int y) {
        NodoArbol<NumeroIdentificable> raiz = modelo.getRaiz();

        grafico = g;
        dibujarRecursivo(raiz, x, y);
    }

    private void dibujarRecursivo(NodoArbol<NumeroIdentificable> nodo, int x, int y) {
        int ancho = getAncho(nodo);
        dibujarNodo(nodo, x + ancho / 2, y);

        int yHijo = y + ESPACIO_VERTICAL;
        int xHijo = x;
        int separador = 0;
        for (NodoArbol<NumeroIdentificable> hijo: nodo.getHijos() ){
            int anchoHijo = getAncho(hijo);
            dibujarRecursivo(hijo, xHijo, yHijo);
            xHijo += (separador + anchoHijo);
            separador = ESPACIO_HORIZONTAL;
        }
    }

    private int getAncho(NodoArbol<NumeroIdentificable> nodo) {
        if (nodo.getHijos().getTam() == 0) {
            return TAMANO_NODO;
        }

        int anchoTotal = 0;
        int separador = 0;
        for (NodoArbol<NumeroIdentificable> hijo: nodo.getHijos()) {
            int anchoHijo = getAncho(hijo);
            anchoTotal += (separador + anchoHijo);
            separador = ESPACIO_HORIZONTAL;
        }

        return anchoTotal;
    }

    private void dibujarNodo(NodoArbol<NumeroIdentificable> nodo, int x, int y) {
        grafico.drawArc(x, y, TAMANO_NODO, TAMANO_NODO, 0, 360);
        grafico.setFont(new Font("Arial", Font.PLAIN, 18));
        grafico.drawString(nodo.getValor().toString(), x + 7, y + 20);
    }
}
