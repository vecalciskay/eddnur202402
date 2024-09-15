package imagenes.modelo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class Histograma {
    private static final Logger logger = LogManager.getRootLogger();
    private int[] red;
    private int[] green;
    private int[] blue;
    private int maximo;

    public static final int ALTURA_TOTAL = 400;
    public static final int ANCHO_TOTAL = 552;
    public static final int SEPARACION_EJES = 20;

    public Histograma() {
        red = new int[256];
        green = new int[256];
        blue = new int[256];
        maximo = 100;
    }

    public void calcular(Imagen img) {
        int ancho = img.getWidth();
        int alto = img.getHeight();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int[] color = img.getRgb(i, j);
                red[color[0]]++;
                green[color[1]]++;
                blue[color[2]]++;
            }
        }

        for (int i = 0; i < 256; i++) {
            if (red[i] > maximo) maximo = red[i];
            if (green[i] > maximo) maximo = green[i];
            if (blue[i] > maximo) maximo = blue[i];
        }
        String msg = String.format("Histograma calculado para imagen %dx%d",ancho, alto);
        logger.info(msg);
    }

    /**
     * Dibua el histograma de una imagen en sus 3 canales.
     * Los ejes x y y los dibuja en color gris oscuro y el
     * histograma de cada color en el color correspondiente (rojo, verde, azul)
     * @param g
     */
    public void dibujar(Graphics g) {
        // dibuja los ejes primero
        g.setColor(Color.black);
        g.drawLine(SEPARACION_EJES, ALTURA_TOTAL - SEPARACION_EJES,
                SEPARACION_EJES, SEPARACION_EJES);
        g.drawLine(SEPARACION_EJES, ALTURA_TOTAL - SEPARACION_EJES,
                ANCHO_TOTAL - SEPARACION_EJES,ALTURA_TOTAL - SEPARACION_EJES );

        dibujaHistograma(g, red, Color.red, maximo,
                SEPARACION_EJES, ALTURA_TOTAL - SEPARACION_EJES);
        dibujaHistograma(g, green, Color.green, maximo,
                SEPARACION_EJES, ALTURA_TOTAL - SEPARACION_EJES);
        dibujaHistograma(g, blue, Color.blue, maximo,
                SEPARACION_EJES, ALTURA_TOTAL - SEPARACION_EJES);
    }

    private void dibujaHistograma(Graphics g, int[] histo, Color c, int max, int x0, int y0) {
        int lastx = x0;
        int lasty = y0;
        int x1;
        int y1;
        g.setColor(c);
        int alturaEje = ALTURA_TOTAL - 2 * SEPARACION_EJES;
        for (int i = 0; i < histo.length; i++) {
            x1 = x0 + 2 * i;
            y1 = y0 - (int)(histo[i] * alturaEje / (double)max);
            g.drawLine(lastx, lasty, x1, y1);

            lastx = x1;
            lasty = y1;
        }
    }
}
