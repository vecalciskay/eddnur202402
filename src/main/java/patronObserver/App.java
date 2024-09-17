package patronObserver;

public class App {
    public static void main(String[] args) {
        MonedaExtranjera dolar = new MonedaExtranjera("Dólar", "USD", 6.96);
        Cambista cambista1 = new Cambista("Juan", "Los Pozoz");
        Cambista cambista2 = new Cambista("Pepe", "La Mutualista");
        CasaDeCambio casa1 = new CasaDeCambio("Trebol", "Shopping Bolívar");
        dolar.addObservador(cambista1);
        dolar.addObservador(cambista2);
        dolar.addObservador(casa1);
        /////////////////////////
        dolar.cambiarValor(8.5);
        ////////////////////////
        dolar.cambiarValor(10.50);
    }
}
