package arbolaritmetico.objetos;

public class SimboloOperacionSustraccion extends SimboloOperacion {

    public SimboloOperacionSustraccion() {
        simbolo = "-";
    }
    @Override
    public double getValor(double op1, double op2) throws AritmeticaException {
        return op1 - op2;
    }
}
