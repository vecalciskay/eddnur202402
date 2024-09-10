package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.excepciones.ImagenException;

public class Aclarar implements IOperacionImagen {

    @Override
    public void hacer(Imagen img) throws ImagenException {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int[] pixelrgb = img.getRgb(i,j);
                for (int k = 0; k < 3; k++) {
                    pixelrgb[k]+= 10;
                    if (pixelrgb[k] > 255)
                        pixelrgb[k] = 255;
                }

                img.setRgb(i, j, pixelrgb[0], pixelrgb[1], pixelrgb[2]);
            }
        }
    }
}
