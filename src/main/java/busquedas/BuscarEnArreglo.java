package busquedas;

import cadena.models.ListaDoble;

import java.util.Arrays;

public class BuscarEnArreglo {
    public static void main(String[] args) {
        String[] nombres = { "hugo", "paco", "luis", "juan", "mario",
                "ana", "olga", "anastasia", "elsa", "rapunzel"};

        ListaDoble<String> lista = new ListaDoble<>();
        for (String s: nombres) {
            lista.insertar(s);
        }

        String n1 = buscar("olga", lista);

        String[] ordenados = { "hugo", "paco", "luis", "juan", "mario",
                "ana", "olga", "anastasia", "elsa", "rapunzel"};
        Arrays.sort(ordenados);
        ListaDoble<String> listaOrdenada = new ListaDoble<>();
        for (String s: ordenados) {
            listaOrdenada.adicionar(s);
        }
        System.out.println(listaOrdenada);

        String n2 = buscarEnOrdenada("rapunzel", listaOrdenada);
    }

    private static String buscarEnOrdenada(String o, ListaDoble<String> listaOrdenada) {
        return busqeudaDicotomica(o, listaOrdenada,
                0, listaOrdenada.getTam()-1 );
    }

    /**
     * Complejidad de algoritmo es O(n) = log_2(n)
     * @param o
     * @param lista
     * @param pos0
     * @param posF
     * @return
     */
    public static String busqeudaDicotomica(String o,
                                            ListaDoble<String> lista,
                                            int pos0, int posF) {
        boolean encontre = false;
        String encontrado = null;

        int mitad = pos0 + (posF - pos0) / 2;
        // Solo quedan 2 elementos
        if (mitad == pos0) {
            String elemento0 = lista.obtener(pos0);
            if (elemento0.equals(o)) {
                encontrado = elemento0;
                return encontrado;
            }
            String elementoF = lista.obtener(posF);
            if (elementoF.equals(o)) {
                encontrado = elementoF;
                return encontrado;
            }
        }
        String elementoMitad = lista.obtener(mitad);
        if (elementoMitad.compareTo(o) == 0) {
            encontre = true;
            encontrado = elementoMitad;
            return encontrado;
        }
        if (elementoMitad.compareTo(o) < 0) {
            encontrado = busqeudaDicotomica(o, lista, mitad, posF);
            return encontrado;
        }
        encontrado = busqeudaDicotomica(o, lista, pos0, mitad);
        return encontrado;
    }

    /**
     * La compleidad de este algoritmo de busqueda es O(n)=n
     * @param o
     * @param lista
     * @return
     */
    private static String buscar(String o, ListaDoble<String> lista) {
        boolean encontre = false;
        String encontrado = null;
        for (String s:lista) {
            if (s.equals(o)) {
                encontre = true;
                encontrado = s;
                break;
            }
        }

        return encontrado;
    }
}
