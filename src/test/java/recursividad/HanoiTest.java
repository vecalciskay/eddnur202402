package recursividad;

import org.junit.Test;
import recursividad.hanoi.modelo.HanoiModel;

import static org.junit.Assert.assertEquals;

public class HanoiTest {
    @Test
    public void testFuncionamientoNormal3Anillos() {
        HanoiModel hanoi = new HanoiModel(3, 0, 2, 1, 0);
        hanoi.resolver();

        // Verificar que la torre 3 tenga los 3 anillos
        assertEquals(3, hanoi.getTorres()[2].getAnillos().size());
    }
}
