package arboles;

public class TestArbol {
    public static void main(String[] args) {
        Arbol<NumeroIdentificable> arbol = new Arbol<>();
        arbol.insertar(new NumeroIdentificable(3));
        arbol.insertar(new NumeroIdentificable(4), "3");
        arbol.insertar(new NumeroIdentificable(5), "3");
        arbol.insertar(new NumeroIdentificable(8), "3");

        arbol.insertar(new NumeroIdentificable(2), "4");
        arbol.insertar(new NumeroIdentificable(7), "4");

        arbol.insertar(new NumeroIdentificable(9), "5");

        arbol.insertar(new NumeroIdentificable(1), "8");
        arbol.insertar(new NumeroIdentificable(12), "8");
        System.out.println("Recorrido post-orden");
        System.out.println(arbol.recorrerPostOrden());
    }
}
