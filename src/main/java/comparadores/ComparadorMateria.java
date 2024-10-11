package comparadores;

import java.util.Comparator;

public class ComparadorMateria implements Comparator<Materia> {
    @Override
    public int compare(Materia o1, Materia o2) {
        if (o1.getNombre().equals(o2.getNombre()))
            return 0;
        return o1.getNombre().compareTo(o2.getNombre());
    }
}
