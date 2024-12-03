package arbolaritmetico.objetos;

public class ArbolAritmetico {
    private NodoAritmetico raiz;

    public ArbolAritmetico() {
        raiz = null;
    }

    /**
     * Hay que encontrar la operacion principal. Veamos algunos ejemplos:
     * 45
     * 4 + 3
     * (4+3)
     * ((4+3))
     * 3 + (3 * 8)
     * (5 / 2) + 3
     * (7 + 3) / (5 * 2)
     * @param expresion
     */
    public ArbolAritmetico(String expresion) throws AritmeticaException {
        raiz = leerExpresion(expresion);
    }

    private NodoAritmetico leerExpresion(String expresionSucia) throws AritmeticaException {
        String expresion = expresionSucia.trim();

        double numeroDecimal = 0.0;
        try {
            numeroDecimal = Double.parseDouble(expresion);
            Numero numero = new Numero(numeroDecimal);
            NodoAritmetico nodoNumero = new NodoAritmetico(numero);
            return nodoNumero;
        } catch(NumberFormatException e) {
            ;
        }

        NodoAritmetico resultado;
        int parentesis = 0;
        int pos = 0;
        while(pos < expresion.length()) {
            char c = expresion.charAt(pos);

            if (c == '(') {
                parentesis++;
                pos++;
                continue;
            }

            if (c == ')') {
                parentesis--;
                pos++;
                continue;
            }

            if (esEspacioEnBlanco(c)) {
                pos++;
                continue;
            }

            if (parentesis == 0 && esOperacion(c)) {
                SimboloOperacion simbolo =
                        SimboloOperacion.leerSimbolo(String.valueOf(c));
                resultado = new NodoAritmetico(simbolo);

                String expresionIzquierda = expresion.substring(0, pos);
                NodoAritmetico izquierda = leerExpresion(expresionIzquierda);
                resultado.setIzquierda(izquierda);

                String expresionDerecha = expresion.substring(pos + 1);
                NodoAritmetico derecha = leerExpresion(expresionDerecha);
                resultado.setDerecha(derecha);

                return resultado;
            }

            pos++;
        }

        if (parentesis != 0) {
            String msg = "El termino " + expresion + " en la expresion no es aritmeticamente correcto";
            throw new AritmeticaException(msg);
        }

        if (!expresion.startsWith("(")) {
            String msg = "El termino " + expresion + " tiene caracteres no aceptados";
            throw new AritmeticaException(msg);
        }

        String expresionSinParentesis =
                expresion.substring(1, expresion.length() - 1);
        return leerExpresion(expresionSinParentesis);
    }

    private boolean esNumero(char c) {
        String n = String.valueOf(c);
        return n.matches("([0-9]|\\.)");
    }

    private boolean esEspacioEnBlanco(char c) {
        return c == ' ' || c == '\t';
    }

    private boolean esOperacion(char c) {
        return c == '+' ||
                c == '-' ||
                c == '*' ||
                c == '/';
    }

    @Override
    public String toString() {
        if (raiz == null)
            return "[VACIO]";
        double resultado = 0;
        try {
            resultado = evaluar();
        } catch(Exception e) {
            return "[ERROR EXPRESION: " + raiz.toString() + "]";
        }
        return raiz.toString() + " = " + String.valueOf(resultado);
    }

    public NodoAritmetico getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoAritmetico raiz) {
        this.raiz = raiz;
    }

    public double evaluar() throws AritmeticaException{
        return raiz.evaluar();
    }

    public int contarNodos() {
        return raiz.contarNodos();
    }
}
