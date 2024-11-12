package arbolaritmetico.objetos;

public class NodoAritmetico {
    private IObjetoAlgebraico contenido;
    private NodoAritmetico izquierda;
    private NodoAritmetico derecha;

    public NodoAritmetico(IObjetoAlgebraico o) {
        contenido = o;
        izquierda = null;
        derecha = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // if (contenido instanceof Numero)
        if (izquierda == null && derecha == null) {
            sb.append(contenido.toString());
            return sb.toString();
        }
        sb.append("(");
        sb.append(izquierda.toString()).
                append(contenido.toString()).
                append(derecha.toString());
        sb.append(")");

        return sb.toString();
    }

    public IObjetoAlgebraico getContenido() {
        return contenido;
    }

    public void setContenido(IObjetoAlgebraico contenido) {
        this.contenido = contenido;
    }

    public NodoAritmetico getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoAritmetico izquierda) {
        this.izquierda = izquierda;
    }

    public NodoAritmetico getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoAritmetico derecha) {
        this.derecha = derecha;
    }

    public double evaluar() throws AritmeticaException {
        if (izquierda == null && derecha == null) {
            return contenido.getValor();
        }

        double arg1 = izquierda.evaluar();
        double arg2 = derecha.evaluar();

        return contenido.getValor(arg1, arg2);
    }
}
