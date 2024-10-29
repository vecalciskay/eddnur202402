package arboles;

import java.util.HashMap;

public class Arbol<E extends Identificable> {
    private NodoArbol<E> raiz;
    private HashMap<String, NodoArbol<E>> nodos;

    public Arbol() {
        raiz = null;
    }

    public void insertar(E valor) {
        insertar(valor, null);
    }

    public void insertar(E valor, String idPadre) {
        NodoArbol<E> nuevo = new NodoArbol<>(valor);
        if (idPadre == null) {
            raiz = nuevo;
            nodos.put(valor.getId(), nuevo);
            return;
        }
        NodoArbol<E> padre = buscar(idPadre);
        if (padre == null) {
            throw new IllegalArgumentException("No se encontró el padre con id " + idPadre);
        }
        padre.getHijos().insertar(nuevo);
        nodos.put(valor.getId(), nuevo);
    }

    private NodoArbol<E> buscar(String idPadre) {
        NodoArbol<E> nodo = nodos.get(idPadre);
        return nodo;
    }

    public String recorrerInOrden() {
        return recorrerInOrden(raiz);
    }

    private String recorrerInOrden(NodoArbol<E> nodo) {
        if (nodo == null) {
            return "[NODO NULO]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nodo.getValor().getId());
        sb.append(" (");
        for(NodoArbol<E> hijo : nodo.getHijos()) {
            sb.append(hijo).append(",");
        }
        sb.append(")");
        return sb.toString();
    }

}
