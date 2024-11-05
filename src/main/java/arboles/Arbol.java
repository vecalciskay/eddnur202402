package arboles;

import java.util.HashMap;

public class Arbol<E extends Identificable> {
    private NodoArbol<E> raiz;
    private HashMap<String, NodoArbol<E>> nodos = new HashMap<>();

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
        padre.agregarHijo(nuevo);
        nodos.put(valor.getId(), nuevo);
    }

    private NodoArbol<E> buscar(String idPadre) {
        NodoArbol<E> nodo = nodos.get(idPadre);
        return nodo;
    }

    public String recorrerPostOrden() {
        return recorrerPostOrden(raiz);
    }

    private String recorrerPostOrden(NodoArbol<E> nodo) {
        if (nodo == null) {
            return "[NODO NULO]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nodo.getValor().getId());
        if (nodo.getHijos().getTam() > 0) {
            sb.append(" (");
            String separador = "";
            for (NodoArbol<E> hijo : nodo.getHijos()) {
                sb.append(separador).append(recorrerPostOrden(hijo));
                separador = ",";
            }
            sb.append(")");
        }
        return sb.toString();
    }

    public NodoArbol<E> getRaiz() {
        return raiz;
    }

    public NodoArbol<E> puntoDentroDeNodo(int x, int y) {
        NodoArbol<E> nodo = raiz;

        NodoArbol<E> encontrado = puntoDentroDeNodoRecursivo(nodo, x, y);

        return encontrado;
    }

    private NodoArbol<E> puntoDentroDeNodoRecursivo(NodoArbol<E> nodo, int x, int y) {
        int r2 = nodo.getTamano() * nodo.getTamano();
        int posX_circulo = (int)Math.pow(x - nodo.getX(), 2);
        int posY_circulo = (int)Math.pow(y - nodo.getY(), 2);
        /*if (x > (nodo.getX() - nodo.getTamano()) &&
                x < (nodo.getX() + nodo.getTamano()) &&
                y > (nodo.getY() - nodo.getTamano()) &&
                y < (nodo.getY() + nodo.getTamano())) {*/
        if ((posX_circulo + posY_circulo) < r2)
            return nodo;

        if (nodo.getHijos().getTam() == 0) {
            return null;
        }
        NodoArbol<E> encontrado = null;
        for (NodoArbol<E> hijo: nodo.getHijos()) {
            encontrado = puntoDentroDeNodoRecursivo(hijo, x, y);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
}
