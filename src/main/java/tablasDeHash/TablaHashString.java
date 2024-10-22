package tablasDeHash;

public class TablaHashString {
    private Identificable[] tabla;

    public TablaHashString() {
        tabla = new Identificable[26*(1+2+3+4+5+6+7+8+9+10)+10];
    }

    /**
     * Esta funcion devuelve un entero cuando se le da una palabra
     * El entero se calcula sumando el valor de cada una de las
     * letras multiplicada por la posicion. Se suman los valores
     * encontrados para cada una de las letras. Adicionalmente, si
     * la letra es mayuscula se aumenta 1.
     * El tamano maximo de la palabra es de 10 letras. Por ende, la
     * palabra con el valor MAS GRANDE de hash es:
     * ZZZZZZZZZZ
     *
     * Veamos como se puede calcular para algo mas normal como:
     * Mesas
     * M = 13 * 1 + 1 (Si A es 1, entonces M es 13, se multiplica por 1 porque es la primera letra. Se le suma 1 porque esta en mayuscula)
     * e =  5 * 2
     * s = 19 * 3
     * a =  1 * 4
     * s = 19 * 5
     * Hash = 14 + 10 + 57 + 4 + 95
     * Hash = 180
     * @param palabra
     * @return the hash of a word with this algorithm
     */
    public int miFuncionHash(String palabra) {
        if (palabra.length() > 10)
            return -1;
        int valorLetra = 0;
        int hash = 0;
        for(int i=0; i<palabra.length(); i++) {
            char c = palabra.toLowerCase().charAt(i);
            int intC = (int)c - (int)('a') + 1;
            valorLetra = intC * (i + 1);
            if (c != palabra.charAt(i)) {
                valorLetra++;
            }
            hash += valorLetra;
        }
        return hash;
    }

    public void insertar(Identificable o) {
        int hash = miFuncionHash(o.getId());
        if (hash < 0) {
            // error
            return;
        }

        tabla[hash] = o;
    }

    public Identificable encontrar(String id) {
        int hash = miFuncionHash(id);
        return tabla[hash];
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == null)
                continue;
            result.append("[" + i + "] ")
                    .append(tabla[i])
                    .append(" -> ");
        }
        return result.toString();
    }
}
