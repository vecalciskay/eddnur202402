package ordenamiento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Random;
import java.util.stream.IntStream;

public class AlgoritmosSimples {
    private static Logger logger = LogManager.getRootLogger();
    public static void main(String[] args) {
        AlgoritmosSimples obj = new AlgoritmosSimples();
        int[] arreglo = obj.generarArreglo(1000,1,100);

        int mayor = obj.mayor(arreglo);
        logger.info("El mayor es: " + mayor);

        int[] ordenado = obj.ordenarSimple(arreglo);
    }

    private int[] ordenarSimple(int[] arreglo) {
        int[] result = new int[arreglo.length];
        boolean[] leido = new boolean[arreglo.length];

        for (int x = 0; x < arreglo.length; x++) {
            int index_min = Integer.MAX_VALUE;
            int i = 0;

            for(int a : arreglo) {
                if(!leido[i] && (
                        index_min == Integer.MAX_VALUE ||
                        a < arreglo[index_min])) {
                    index_min = i;
                }
                i++;
            }
            // arreglo(index_min) es el numero menor, entonces
            // leido(index_min) debe ser verdadero ahora
            leido[index_min] = true;

            result[x] = arreglo[index_min];
        }

        return result;
    }

    private int mayor(int[] arreglo) {
        int max = Integer.MIN_VALUE;
        for(int a : arreglo) {
            if(a > max) {
                max = a;
            }
        }
        return max;
    }

    private int[] generarArreglo(int n, int imin, int imax) {
        int[] result = new int[n];
        Random rnd = new Random();
        IntStream stream = rnd.ints(n,imin, imax);
        Iterator iter = stream.iterator();
        int i = 0;
        while(iter.hasNext()) {
            result[i] = (Integer)iter.next();
            i++;
        }
        return result;
    }
}
