package arbolaritmetico.objetos;

public class Numero implements IObjetoAlgebraico {
    private double valor;
    public Numero(double d) {
        valor = d;
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }

    @Override
    public double getValor() throws AritmeticaException {
        return valor;
    }

    @Override
    public double getValor(double op1, double op2) throws AritmeticaException {
        throw new AritmeticaException("Este es un numero, no necesita parametros");
    }
}
