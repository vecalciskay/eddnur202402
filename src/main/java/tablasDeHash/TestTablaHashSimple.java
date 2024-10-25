package tablasDeHash;

public class TestTablaHashSimple {
    public static void main(String[] args) {
        TablaHashString tablaHash = new TablaHashString();

        Estudiante e1 = new Estudiante("josegonz", "Jose Gonzales");
        Estudiante e2 = new Estudiante("hugorami", "Hugo Ramirez");
        Estudiante e3 = new Estudiante("alejmora", "Alejandro Morales");
        Estudiante e4 = new Estudiante("luisbuen", "Luisa Bueno");

        Persona p1 = new Persona("Juan", 25);
        Persona p2 = new Persona("Maria",18);

        tablaHash.insertar(e1);
        tablaHash.insertar(e2);
        tablaHash.insertar(e3);
        tablaHash.insertar(e4);

        tablaHash.insertar(p1);
        tablaHash.insertar(p2);

        System.out.println(tablaHash);

        System.out.println("Encontrar a alejmora:");

        String id = "alejmora";
        Estudiante e = (Estudiante) (tablaHash.encontrar(id));
        System.out.println(e);

        System.out.println("Encontrar a Juan:");
        Persona objJuan = (Persona) tablaHash.encontrar("Juan");
        System.out.println(objJuan);

        System.out.println("Encontrar a Maria:");
        Persona objMaria = (Persona)tablaHash.encontrar("Maria");
        System.out.println(objMaria);
    }
}
