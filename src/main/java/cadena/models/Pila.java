package cadena.models;

public class Pila<E> extends Lista<E> {

    public Pila() {
        super();
    }

    public void push(E valor) {
        insertar(valor);
    }

    public E pop () {
        E valor = obtener(0);
        eliminar(0);
        return valor;
    }
}
