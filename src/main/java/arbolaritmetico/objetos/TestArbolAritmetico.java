package arbolaritmetico.objetos;

public class TestArbolAritmetico {
    public static void main(String[] args) {
        // 6 / 4
        Numero a = new Numero(6);
        Numero b = new Numero(4);
        SimboloOperacion o1 = new SimboloOperacionDivision();

        NodoAritmetico n1 = new NodoAritmetico(o1);
        n1.setIzquierda(new NodoAritmetico(a));
        n1.setDerecha(new NodoAritmetico(b));

        // 8 - 2
        a = new Numero(8);
        b = new Numero(2);
        o1 = new SimboloOperacionSustraccion();

        NodoAritmetico n2 = new NodoAritmetico(o1);
        n2.setIzquierda(new NodoAritmetico(a));
        n2.setDerecha(new NodoAritmetico(b));

        // Juntamos las ultimas dos operaciones
        NodoAritmetico n = new NodoAritmetico(new SimboloOperacionSustraccion());
        n.setIzquierda(n1);
        n.setDerecha(n2);

        // 5 * 2
        a = new Numero(5);
        b = new Numero(2);
        o1 = new SimboloOperacionMultiplicacion();

        n1 = new NodoAritmetico(o1);
        n1.setIzquierda(new NodoAritmetico(a));
        n1.setDerecha(new NodoAritmetico(b));

        // La pate de la derecha de la operacion principal
        n2 = n;

        // Juntamos las dos operaciones
        n = new NodoAritmetico(new SimboloOperacionAdicion());
        n.setIzquierda(n1);
        n.setDerecha(n2);

        ArbolAritmetico arbol = new ArbolAritmetico();
        arbol.setRaiz(n);

        System.out.println(arbol);
    }

    public static void test1() {
        Numero a = new Numero(5);
        Numero b = new Numero(3);
        SimboloOperacionAdicion o1 = new SimboloOperacionAdicion();

        NodoAritmetico n1 = new NodoAritmetico(o1);
        n1.setIzquierda(new NodoAritmetico(a));
        n1.setDerecha(new NodoAritmetico(b));

        ArbolAritmetico arbol = new ArbolAritmetico();
        arbol.setRaiz(n1);

        System.out.println(arbol);
    }
}
