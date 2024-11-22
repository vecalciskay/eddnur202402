package arbolaritmetico.objetos;

public class TestExpresionAritmetica {
    public static void main(String[] args) {
        // ((5*2) + ((6 /4)-  (8 - 2) ) )
        String expresion = "((5*2) + ((6 /4)-  (8 - 2) ) )";

        try {
            ArbolAritmetico arbol = new ArbolAritmetico(expresion);
            System.out.println(arbol);
        } catch(AritmeticaException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
