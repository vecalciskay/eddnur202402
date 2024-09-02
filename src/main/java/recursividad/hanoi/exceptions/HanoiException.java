package recursividad.hanoi.exceptions;

public class HanoiException extends Exception {
    public static final String ARG_ANILLOS_POSITIVO_MESSAGE = "El número de anillos debe ser mayor a 0";
    public HanoiException(String message) {
        super(message);
    }
}
