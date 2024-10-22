package tablasDeHash;

public class Estudiante implements Identificable {
    private String id;

    public String getId() {
        return id;
    }

    private String nombre;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + nombre;
    }
}
