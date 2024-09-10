package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.excepciones.ImagenException;

public class AchicarX2 implements IOperacionImagen {
    @Override
    public void hacer(Imagen img) throws ImagenException {
        int ancho = (int)Math.ceil((double)img.getWidth() / 2.0);
        int alto = (int)Math.ceil((double)img.getHeight() / 2.0);
        int[][] pixeles = new int[ancho][alto];

        for (int i = 0; i < ancho-1; i++) {
            for (int j = 0; j < alto-1; j++) {
                pixeles[i][j] = img.get(i*2, j*2);
            }
        }
        img.setPixeles(pixeles);
    }
}
