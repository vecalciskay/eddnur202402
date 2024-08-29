package recursividad.hanoi.modelo;

public class Anillo {
    private int tamano;

    public Anillo(int tamano) {
        this.tamano = tamano;
    }

    public int getTamano() {
        return tamano;
    }

    @Override
    public String toString() {
        return String.valueOf(tamano);
    }
}
