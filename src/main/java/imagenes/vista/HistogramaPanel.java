package imagenes.vista;

import imagenes.modelo.Histograma;

import javax.swing.*;
import java.awt.*;

public class HistogramaPanel extends JPanel {
    private transient Histograma modelo;

    public HistogramaPanel(Histograma histograma) {
        modelo = histograma;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Histograma.ANCHO_TOTAL, Histograma.ALTURA_TOTAL);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(g);
    }
}
