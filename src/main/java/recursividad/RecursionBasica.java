package recursividad;

public class RecursionBasica {
    public static void main(String[] args) {
        ejecutar(10);

        int suma = sumar(-1);
        System.out.println("Suma: " + suma);
    }

    public static int sumar(int n) {
        if (n == 0)
            return 0;
        return n + sumar(n - 1);
    }

    public static void ejecutar(int n) {
        if (n == 0)
            return;
        System.out.println("Hola");
        ejecutar(n - 1);
    }
}
