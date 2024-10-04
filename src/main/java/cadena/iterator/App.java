package cadena.iterator;

public class App {
    public static void main(String[] args) {
        CadenaWrapper numeros = new CadenaWrapper();
        numeros.agregarNodo(1);
        numeros.agregarNodo("hola");
        numeros.agregarNodo(true);
        numeros.agregarNodo(new DummyObject());

        IIterator iterator = numeros.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
