package comparadores;

public class Materia {
    private String nombre;
    private String codigo;
    private int creditos;

    public Materia(String nom, String cod, int cred) {
        nombre = nom;
        codigo = cod;
        creditos = cred;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
}
