package tablasDeHash;

public class TestTablaHashGeneric {
    public static void main(String[] args) {
        TablaHash<String> tablaHash = new TablaHash();

        Estudiante2 e1 = new Estudiante2("josegonz", "Jose Gonzales");
        Estudiante2 e2 = new Estudiante2("hugorami", "Hugo Ramirez");
        Estudiante2 e3 = new Estudiante2("alejmora", "Alejandro Morales");
        Estudiante2 e4 = new Estudiante2("luisbuen", "Luisa Bueno");

        tablaHash.insertar(e1);
        tablaHash.insertar(e2);
        tablaHash.insertar(e3);
        tablaHash.insertar(e4);

        System.out.println(tablaHash);

        System.out.println("Encontrar a alejmora:");

        String id = "alejmora";
        Estudiante2 e = (Estudiante2) (tablaHash.encontrar(id));
        System.out.println(e);
    }
}
