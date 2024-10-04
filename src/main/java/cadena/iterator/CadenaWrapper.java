package cadena.iterator;

import java.util.ArrayList;
import java.util.List;

public class CadenaWrapper<T> implements IIterable<T> {
    private List<T> coleccion;

    @Override
    public IIterator getIterator() {
        return new CadenaIterator(this);
    }

    public CadenaWrapper() {
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
