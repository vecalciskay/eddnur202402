package arbolaritmetico.objetos;

public interface IObjetoAlgebraico {
    public double getValor() throws AritmeticaException;
    public double getValor(double op1, double op2) throws AritmeticaException;
}
