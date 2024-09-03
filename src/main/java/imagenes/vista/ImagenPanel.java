package imagenes.vista;

import imagenes.modelo.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenPanel extends JPanel {
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
}
