package recursividad.hanoi.modelo;

import java.util.Stack;

public class Torre {
    private Stack<Anillo> anillos;

    public Torre() {
        anillos = new Stack<>();
    }

    public void agregarAnillo(Anillo anillo) {
        anillos.push(anillo);
    }

    public Anillo quitarAnillo() {
        return anillos.pop();
    }

    public Stack<Anillo> getAnillos() {
        return anillos;
    }
}
