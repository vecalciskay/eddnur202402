package arbolaritmetico.objetos;

public class SimboloOperacionDivision extends SimboloOperacion {

    public SimboloOperacionDivision() {
        simbolo = "/";
    }
    @Override
    public double getValor(double op1, double op2) throws AritmeticaException {
        if (op2 == 0.0)
            throw new AritmeticaException("No se puede dividir entre 0");
        return op1 / op2;
    }
}
