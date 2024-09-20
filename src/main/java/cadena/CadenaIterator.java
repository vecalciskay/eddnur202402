package cadena;

public class CadenaIterator<T> implements IIterator<T> {
    private Cadena<T> cadena;
    private int posicionActual;

    public CadenaIterator(Cadena<T> cadena) {
        this.cadena = cadena;
        this.posicionActual = 0;
    }

    @Override
    public boolean hasNext() {
        return this.posicionActual < cadena.length();
    }

    @Override
    public T next() {
        if (this.hasNext()) {
            T elemento = cadena.getElementAt(this.posicionActual);
            this.posicionActual = this.posicionActual + 1;
            return elemento;
        }
        return null;
    }
}
