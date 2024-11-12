package arbolaritmetico.objetos;

public abstract class SimboloOperacion implements IObjetoAlgebraico {
    protected String simbolo;
    @Override
    public double getValor() throws AritmeticaException {
        throw new AritmeticaException("Esta es una operacion, necesita parametros");
    }

    @Override
    public String toString() {
        return simbolo;
    }
}
