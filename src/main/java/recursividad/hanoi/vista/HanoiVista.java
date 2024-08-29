package recursividad.hanoi.vista;

import recursividad.hanoi.modelo.HanoiModel;
import recursividad.hanoi.modelo.Torre;

import java.awt.*;

public class HanoiVista implements IDibujable {
    private HanoiModel modelo;
    public HanoiVista(HanoiModel modelo) {
        this.modelo = modelo;
    }
    @Override
    public void dibujar(Graphics g) {
        // base
        g.fillRect(0, 350, 600, 20);

        // torres
        g.fillRect(150, 50, 5, 300);
        g.fillRect(300, 50, 5, 300);
        g.fillRect(450, 50, 5, 300);

        // anillos
        for (int i = 0; i < modelo.getTorres().length; i++) {
            Torre torre = modelo.getTorres()[i];
            for (int j = 0; j < torre.getAnillos().size(); j++) {
                int ancho = modelo.getTorres()[i].getAnillos().get(j).getTamano() * 20;
                int x = 150 + 150 * i - ancho / 2;
                int y = 350 - 30 * (j + 1);
                g.fillRect(x, y, ancho, 20);
            }
        }
    }
}
