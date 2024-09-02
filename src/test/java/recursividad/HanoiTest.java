package recursividad;

import org.junit.Test;
import recursividad.hanoi.exceptions.HanoiException;
import recursividad.hanoi.modelo.HanoiModel;

import static org.junit.Assert.assertEquals;

public class HanoiTest {
    @Test
    public void testFuncionamientoNormal3Anillos() {
        HanoiModel hanoi = null;
        try {
            hanoi = new HanoiModel(3, 0, 2, 1, 0);
        } catch (HanoiException e) {
            throw new RuntimeException(e);
        }
        hanoi.resolver();

        // Verificar que la torre 3 tenga los 3 anillos
        assertEquals(3, hanoi.getTorres()[2].getAnillos().size());
    }

    @Test
    public void testParametrosNegativos() {
        try {
            HanoiModel hanoi = new HanoiModel(0, 0, 2, 1, 0);
        } catch(HanoiException e) {
            assertEquals("El número de anillos debe ser mayor a 0", e.getMessage());
        }
    }
}
