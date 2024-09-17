package patronObserver;

import java.util.*;

public class MonedaExtranjera implements IObservable {
    List<IObserver> observadores;
    String nombre;
    String simbolo;
    double valor;

    public MonedaExtranjera(String nombre, String simbolo, double valor) {
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.valor = valor;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void notifyObservers() {
        for (IObserver observador : observadores) {
            observador.doAction(this.valor);
        }
    }
    public void cambiarValor(double nuevoValor){
        this.valor = nuevoValor;
        notifyObservers();
    }
    public void addObservador(IObserver observador){
        this.observadores.add(observador);
    }
    public void removeObservador(IObserver observador){
        this.observadores.remove(observador);
    }
}
