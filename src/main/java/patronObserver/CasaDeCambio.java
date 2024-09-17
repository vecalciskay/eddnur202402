package patronObserver;

public class CasaDeCambio implements IObserver{
    String nombre;
    String direccion;
    @Override
    public void doAction(double valor) {
        System.out.println(this.nombre + " ahora vende a " + (valor *1.05));
    }

    public CasaDeCambio(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
}

