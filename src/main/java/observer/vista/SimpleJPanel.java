package observer.vista;

import observer.models.CuadradoSimple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleJPanel extends JPanel
        implements PropertyChangeListener, MouseListener {
    private static final Logger logger = LogManager.getRootLogger();
    private final CuadradoSimple modelo;

    public SimpleJPanel(CuadradoSimple obj) {
        this.modelo = obj;
        this.modelo.addObserver(this);

        this.addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,400);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        VistaCuadradoSimple dibujador = new VistaCuadradoSimple(modelo);
        dibujador.dibujar(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.debug("Despierta el panel, hubo cambios en el cuadrado");
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.modelo.setPosicion(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
