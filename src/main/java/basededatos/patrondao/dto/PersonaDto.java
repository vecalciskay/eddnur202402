package basededatos.patrondao.dto;

public class PersonaDto {
    private int id;
    private String nombre;
    private int edad;

    public PersonaDto(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + nombre + ", " + edad + ")";
    }
}
