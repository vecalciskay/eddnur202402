package imagenes.vista;

import imagenes.modelo.Imagen;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ImagenPanel extends JPanel implements PropertyChangeListener  {
    private Imagen modelo;

    public ImagenPanel(Imagen img) {
        modelo = img;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(modelo.getWidth(), modelo.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        modelo.dibujar(g);
    }

    public void setModelo(Imagen modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
        repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }
}
