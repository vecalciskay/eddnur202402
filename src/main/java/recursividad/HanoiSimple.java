package recursividad;

public class HanoiSimple {
    public static void main(String[] args) {
        hanoi(1, 3, 2, 3);
    }

    /**
     * Resuelve el problema de las torres de Hanoi.
     * @param de El numero de torre de inicio, puede tener valor 1, 2 o 3.
     * @param a El numero de torre de destino, puede tener valor 1, 2 o 3.
     * @param pp El numero de torre de paso, puede tener valor 1, 2 o 3.
     * @param n El numero de discos.
     */
    private static void hanoi(int de, int a, int pp, int n) {
        if (n == 1) {
            System.out.println("Mover disco de " + de + " a " + a);
        } else {
            hanoi(de, pp, a, n - 1);
            hanoi(de, a, pp, 1);
            hanoi(pp, a, de, n - 1);
        }
    }
}
