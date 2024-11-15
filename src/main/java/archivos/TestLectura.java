package archivos;

import cadena.models.Lista;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TestLectura {
    public static void main(String[] args) throws IOException {
        Path ruta = Paths.get("E:/ProgramacionIII/practicos/tp6/palabras.txt");
        List<String> contenido = Files.readAllLines(ruta);

        for (String palabra: contenido) {
            System.out.println(palabra);
        }

        // para el practico desordenar la lista

        // Cargar la lista en el arbol
    }

    public static void formaAntiguaDeLeer() throws IOException {
        String ruta = "E:/ProgramacionIII/practicos/tp6/palabras.txt";
        FileReader fr =  new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);

        Lista<String> lista = new Lista<>();
        while(br.ready()) {
            String palabra = br.readLine();
            lista.insertar(palabra);
        }
        br.close();
        fr.close();
    }
}
