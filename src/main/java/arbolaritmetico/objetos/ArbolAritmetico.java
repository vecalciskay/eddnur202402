package arbolaritmetico.objetos;

public class ArbolAritmetico {
    private NodoAritmetico raiz;

    public ArbolAritmetico() {
        raiz = null;
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
}
