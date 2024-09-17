package patronObserver;

public class Cambista implements IObserver{
    String nombre;
    String direccion;
    @Override
    public void doAction(double valor) {
        System.out.println(this.nombre + " ahora vende a " + valor);
    }

    public Cambista(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
