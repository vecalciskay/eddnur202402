package recursividad.hanoi.exceptions;

public class HanoiException extends Exception {
    public static final String ARG_ANILLOS_POSITIVO_MESSAGE = "El número de anillos debe ser mayor a 0";
    public static final String ARG_TORRE_POSITIVO_MESSAGE = "El número de torre debe ser positivo";
    public static final String ARG_PARAMETRO_TORRE_MESSAGE = "Los parametros de torre deben ser diferentes y entre 0 y 2";
    public static final String ARG_TORRE_RANGO_MESSAGE = "Numero de torre fuera de rango, max 2";
    public HanoiException(String message) {
        super(message);
    }
}
