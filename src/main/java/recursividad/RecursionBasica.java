package recursividad;

public class RecursionBasica {
    public static void main(String[] args) {
//        ejecutar(10);

//        int fact = factorial(0);
//        System.out.println("Factorial: " + fact);
//        conteo(1);
//        int pot = potencia(2, 0);
//        System.out.println("Potencia: " + pot);
//        String cad = "onomatopeya";
//        System.out.println(esPalindromo(cad));
//        int[] array = new int[]{1, 2, 5, 8, 20};
//        System.out.println(sumArray(array, array.length - 1));
        System.out.println(fibo(0));
    }

    public static int fibo(int n) {
        if (n <= 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static int factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public static int sumar(int n) {
        if (n == 0)
            return 0;
        return n + sumar(n - 1);
    }

    //mostrar una cuenta atras, ej: si coloco el 5,
    // mostrar: 5, 4, 3, 2, 1, 0
    public static void conteo(int n) {
        if (n == 0) {
            System.out.println(0);
            return;
        }
        System.out.println(n);
        conteo(n - 1);
    }

    //sumatoria de un vector
    //Teniendo el array [1, 2, 5, 8, 20]
    //debería dar como resultado 36

    /**
     * [1, 2, 5, 8, 20], pos: 4
     * [1, 2, 5, 8, 20], pos: 3
     * [1, 2, 5, 8, 20], pos: 2
     * [1, 2, 5, 8, 20], pos: 1
     * [1, 2, 5, 8, 20], pos: 0
     * [1, 2, 5, 8, 20], pos: -1
     */
    public static int sumArray(int[] array, int pos) {
        if (pos < 0) {
            return 0;
        }
        int ultimoNum = array[pos];
        return ultimoNum + sumArray(array, pos - 1);
    }


    public static boolean esPalindromo(String cad) {
        if (cad.length() <= 1) {
            return true;
        }
        char ultima = cad.charAt(cad.length() - 1);
        char primera = cad.charAt(0);
        if (primera == ultima) {
            String cortada = cad.substring(1, cad.length() - 1);
            return esPalindromo(cortada);
        }
        return false;
    }

    //Invertir una cadena recursivamente
    // hola -> aloh
    public static String invertir(String cad) {
        if (cad.length() == 0) {
            return "";
        }
        char ultima = cad.charAt(cad.length() - 1);
        String todasMenosLaUltima = cad.substring(0, cad.length() - 1);
        return ultima + invertir(todasMenosLaUltima);
    }

    public static int potencia(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        return base * potencia(base, exp - 1);
    }


    public static void ejecutar(int n) {
        if (n == 0)
            return;
        System.out.println("Hola");
        ejecutar(n - 1);
    }

    /**
     * Verifica si una cadena es palíndromo
     *
     * @param s
     * @return
     */
    public static boolean checkPalindromo(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return checkPalindromo(s.substring(1, s.length() - 1));
        }
        return false;
    }
}
