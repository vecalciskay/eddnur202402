package arboles.arbol2;

import cadena.models.Nodo;

public class TestArbol2 {
    public static void main(String[] args) {
        Arbol2<Integer> arbol = new Arbol2();
        NodoArbol2<Integer> nodo3 = new NodoArbol2(3);

        NodoArbol2<Integer> nodo4 = new NodoArbol2<>(4);
        NodoArbol2<Integer> nodo5 = new NodoArbol2(5);
        NodoArbol2<Integer> nodo8 = new NodoArbol2(8);
        nodo3.agregarHijo(nodo4);
        nodo3.agregarHijo(nodo5);
        nodo3.agregarHijo(nodo8);

        NodoArbol2<Integer> nodo2 = new NodoArbol2<>(2);
        NodoArbol2<Integer> nodo7 = new NodoArbol2<>(7);
        nodo4.agregarHijo(nodo2);
        nodo4.agregarHijo(nodo7);

        NodoArbol2<Integer> nodo9 = new NodoArbol2<>(9);
        nodo5.agregarHijo(nodo9);

        NodoArbol2<Integer> nodo1 = new NodoArbol2<>(1);
        NodoArbol2<Integer> nodo12 = new NodoArbol2<>(12);
        nodo8.agregarHijo(nodo1);
        nodo8.agregarHijo(nodo12);

        arbol.setRaiz(nodo3);
        System.out.println("Recorrido pre-orden");
        System.out.println(arbol.preOrden(arbol.getRaiz()));
        System.out.println("Recorrido post-orden");
        System.out.println(arbol.postOrden(arbol.getRaiz()));
    }
}
