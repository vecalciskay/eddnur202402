package arbolaritmetico.objetos;

public class SimboloOperacionAdicion extends SimboloOperacion {

    public SimboloOperacionAdicion() {
        simbolo = "+";
    }
    @Override
    public double getValor(double op1, double op2) throws AritmeticaException {
        return op1 + op2;
    }
}
