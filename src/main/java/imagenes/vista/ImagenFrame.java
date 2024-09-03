package imagenes.vista;

import imagenes.modelo.Imagen;

import javax.swing.*;
import java.awt.*;

public class ImagenFrame extends JFrame {
    private Imagen modelo;
    private ImagenPanel panel;
    public ImagenFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        modelo = new Imagen(600,400);
        modelo.imagenBandasColores();

        panel = new ImagenPanel(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }
}
