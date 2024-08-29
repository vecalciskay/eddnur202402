package recursividad.hanoi.vista;

import recursividad.hanoi.modelo.HanoiModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HanoiPanel extends JPanel implements PropertyChangeListener {
    private HanoiModel modelo;
    public HanoiPanel(HanoiModel modelo) {
        this.modelo = modelo;
        modelo.addObserver(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,400);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        IDibujable vista = new HanoiVista(modelo);
        vista.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}
