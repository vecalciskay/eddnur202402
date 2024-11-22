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

    public static SimboloOperacion leerSimbolo(String operacion) throws AritmeticaException {
        switch(operacion) {
            case "+":
                return new SimboloOperacionAdicion();
            case "-":
                return new SimboloOperacionSustraccion();
            case "*":
                return new SimboloOperacionMultiplicacion();
            case "/":
                return new SimboloOperacionDivision();
            default:
                String msg = "El simbolo " + operacion + " no se reconoce";
                throw new AritmeticaException(msg);
        }
    }
}
