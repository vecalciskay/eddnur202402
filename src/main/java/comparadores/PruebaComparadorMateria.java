package comparadores;

import java.util.Arrays;

public class PruebaComparadorMateria {
    public static void main(String[] args) {
        Materia m1 = new Materia("Programacion III","p3",5);
        Materia m2 = new Materia("Redes I","p3",5);
        Materia m3 = new Materia("Presentacion Oral I","p3",5);
        Materia m4 = new Materia("Bases de Datos","p3",5);

        Materia[] materias = new Materia[4];
        materias[0] = m1;
        materias[1] = m2;
        materias[2] = m3;
        materias[3] = m4;

        Arrays.sort(materias);

        for (Materia m: materias) {
            System.out.println(m);
        }
    }
}
