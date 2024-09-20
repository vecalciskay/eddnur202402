package cadena;

import java.util.ArrayList;
import java.util.List;

public class Cadena<T> implements IIterable<T> {
    private List<T> coleccion;

    @Override
    public IIterator getIterator() {
        return new CadenaIterator(this);
    }

    public Cadena() {
        this.coleccion = new ArrayList<>();
    }

    public void agregarNodo(T elemento) {
        this.coleccion.add(elemento);
    }

    public void eliminarNodo(T elemento) {
        this.coleccion.remove(elemento);
    }

    public int length() {
        return this.coleccion.size();
    }

    public T getElementAt(int posicion) {
        return this.coleccion.get(posicion);
    }
}
