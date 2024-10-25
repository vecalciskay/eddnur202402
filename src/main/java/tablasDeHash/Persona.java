package tablasDeHash;

public class Persona implements Identificable {
    private String nombre;
    private int edad;

    @Override
    public String getId() {
        return nombre;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Clase persona: Nombre: " + nombre + " Edad: " + edad;
    }
}
