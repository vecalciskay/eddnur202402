package arboles.arbol2;

import cadena.models.Lista;

public class Arbol2<E> {
    private NodoArbol2<E> raiz;

    public NodoArbol2<E> getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol2<E> raiz) {
        this.raiz = raiz;
    }

    public String preOrden(NodoArbol2<E> actual) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(actual.getContenido())
                .append(" ");
        if (actual.getHijos().getTam() > 0) {
            builder.append("[");

            for (int i = 0; i < actual.getHijos().getTam(); i++) {
                NodoArbol2<E> hijo = actual.getHijos().getNodo(i).getValor();
                builder.append(preOrden(hijo));
            }
            builder.append("]");
        }
        return builder.toString();
    }

    public String postOrden(NodoArbol2<E> actual) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(actual.getContenido())
                .append(" ");
        if (actual.getHijos().getTam() > 0) {
            builder.append("[");
            Lista<NodoArbol2<E>> hijos = actual.getHijos();
            for (int i = hijos.getTam() - 1; i >= 0; i--) {
                NodoArbol2<E> hijo = actual.getHijos().getNodo(i).getValor();
                builder.append(postOrden(hijo));
            }

            builder.append("]");
        }
        return builder.toString();
    }
}
