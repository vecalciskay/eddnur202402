package arbolaritmetico.objetos;

public class SimboloOperacionMultiplicacion extends SimboloOperacion {

    public SimboloOperacionMultiplicacion() {
        simbolo = "*";
    }
    @Override
    public double getValor(double op1, double op2) throws AritmeticaException {
        return op1 * op2;
    }
}
