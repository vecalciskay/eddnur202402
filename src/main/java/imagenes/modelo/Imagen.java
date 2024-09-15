package imagenes.modelo;

import imagenes.modelo.excepciones.ImagenException;
import imagenes.modelo.operaciones.IOperacionImagen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

public class Imagen implements Serializable {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();
    private int[][] pixeles;
    private int width;
    private int height;
    private PropertyChangeSupport observado;

    public Imagen(int w, int h) {
        width = w;
        height = h;
        pixeles = new int[w][h];
        observado = new PropertyChangeSupport(this);
    }

    public Imagen(File f) {
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (bi == null) return;

        width = bi.getWidth();
        height = bi.getHeight();

        pixeles = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pixeles[i][j] = bi.getRGB(i, j);
            }
        }

        observado = new PropertyChangeSupport(this);
    }

    public void dibujar(Graphics g) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                g.setColor(new Color(pixeles[i][j]));
                g.drawLine(i,j,i,j);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void imagenBandasColores() {
        int green = 255;
        int color = green << 8;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < 20; j++) {
                pixeles[i][50 + j] = color;
            }
        }

        int blue = 255;
        color = blue;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < 20; j++) {
                pixeles[i][100 + j] = color;
            }
        }

        int red = 255;
        color = red << 16;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < 20; j++) {
                pixeles[i][150 + j] = color;
            }
        }

        // En Hex: 37, b7, d2
        red = 55; green = 183; blue = 210;
        red = red << 16;
        green = green << 8;
        // En hexadecimal:  3    7    b    7     d   2
        // En binario  r: 0011 0111 0000 0000 0000 0000
        // En binario  g: 0000 0000 1011 0111 0000 0000
        // En binario  b: 0000 0000 0000 0000 1101 0010
        // En binario   : 0011 0111 1011 0111 1101 0010
        //
        color = red | green | blue;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < 20; j++) {
                pixeles[i][200 + j] = color;
            }
        }
    }

    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public int get(int i, int j) {
        return pixeles[i][j];
    }

    public int[] getRgb(int i, int j) {
        int[] result = new int[3];

        if (i < 0 || i >= width || j < 0 || j >= height) {
            return result;
        }

        result[2] = 0x000000ff & pixeles[i][j];
        result[1] = (0x0000ff00 & pixeles[i][j]) >> 8;
        result[0] = (0x00ff0000 & pixeles[i][j]) >> 16;

        return result;
    }

    public void setRgb(int x, int y, int r, int g, int b) {
        int rc = r << 16;
        int gc = g << 8;
        int bc = b;
        pixeles[x][y] = rc | gc | bc;
    }
    public void setRgb(int x, int y, int rgb) {
        pixeles[x][y] = rgb;
    }

    public void operacionCompletada() {
        logger.debug("Operacion completada, notificar observers");
        observado.firePropertyChange("OPERACION", true, false);
    }

    public void operacion(IOperacionImagen objOperacion) {
        operacion(objOperacion, null);
    }

    public void operacion(IOperacionImagen objOperacion, ParametrosOperacion parametros) {
        try {
            objOperacion.hacer(this, parametros);
        } catch (ImagenException e) {
            throw new IllegalArgumentException(e);
        }

        operacionCompletada();
    }

    public void setPixeles(int ancho, int alto, int[][] pixeles) {
        this.width = ancho;
        this.height = alto;
        this.pixeles = pixeles;
    }
}
