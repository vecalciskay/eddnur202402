package imagenes.vista;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.operaciones.IconoEmoji;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ImagenPanel extends JPanel implements PropertyChangeListener, MouseListener {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();
    private transient Imagen modelo;

    public ImagenPanel(Imagen img) {
        setModelo(img);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getWidth(), modelo.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo == null) {
            return;
        }

        BufferedImage rsm = new BufferedImage(
                modelo.getWidth(), modelo.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        modelo.dibujar(g2d);
        g.drawImage(rsm, 0, 0, this);
    }

    public void setModelo(Imagen modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        logger.debug("Panel will be repainted now");
        this.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ParametrosOperacion parametros = new ParametrosOperacion();
        parametros.setX0(e.getX());
        parametros.setY0(e.getY());
        modelo.operacion(new IconoEmoji(), parametros);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        logger.debug("mousePressed no implementado");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        logger.debug("mouseReleased no implementado");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        logger.debug("mouseEntered no implementado");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        logger.debug("MouseExited no implementado");
    }

    public void herramientaSeleccionada() {
        this.addMouseListener(this);
    }
}
