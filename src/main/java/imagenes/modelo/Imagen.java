package imagenes.modelo;

import java.awt.*;

public class Imagen {
    private int[][] pixeles;
    private int width;
    private int height;

    public Imagen(int w, int h) {
        width = w;
        height = h;
        pixeles = new int[w][h];
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
        color = 0;
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
}
