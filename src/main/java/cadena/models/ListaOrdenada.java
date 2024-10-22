package cadena.models;

/**
 * Esta es una lista que acepta que los elementos sean Comparables.
 * Cuando los elementos son comparables entonces la lista automáticamente,
 * cuando se inserta o adiciona un nuevo elemento,
 * hace las operaciones para que se pueda encontrar el lugar correcto y
 * poder insertarlo de manera que la lista se mantenga ordenada.
 * @param <E>
 */
public class ListaOrdenada<E> extends ListaDoble<E> {
    public ListaOrdenada() {
        super();
    }

    @Override
    public void insertar(E valor) {
        if (raiz == null) {
            super.insertar(valor);
            return;
        }
        if (!(valor instanceof Comparable<?>)) {
            super.insertar(valor);
            return;
        }
        // Si va antes de la raiz
        Comparable<E> valorComparable = (Comparable<E>) valor;
        Nodo<E> actual = raiz;
        Nodo<E> nuevo = new Nodo(valor);
        if (valorComparable.compareTo(actual.getValor()) <= 0) {
            super.insertar(valor);
            return;
        }

        // Si no buscamos el lugar correcto o llegamos al final
        while(actual.getSiguiente() != null &&
                valorComparable.compareTo(actual.getSiguiente().getValor()) > 0) {
            actual = actual.getSiguiente();
        }

        // Esto si va justo despues de actual
        Nodo<E> despuesDeActual = actual.getSiguiente();
        // insertamos
        actual.setSiguiente(nuevo);
        nuevo.setAnterior(actual);
        // actualizamos los enlaces de y hacia nuevo
        nuevo.setSiguiente(despuesDeActual);
        if (despuesDeActual != null)
            despuesDeActual.setAnterior(nuevo);
        else
            cola = nuevo;

        // Actualizamos el tam como en la clase superior
        tam++;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, tam, tam + 1);
    }
}
