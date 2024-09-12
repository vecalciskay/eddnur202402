package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.excepciones.ImagenException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AchicarX2 implements IOperacionImagen {
    private static final Logger logger= LogManager.getRootLogger();
    @Override
    public void hacer(Imagen img, ParametrosOperacion parametros) throws ImagenException {
        String mensaje = String.format("AchicarX2. Img original de tamaño: %dx%d ",img.getWidth(), img.getHeight());
        logger.info(mensaje);
        int ancho = (int)Math.ceil(img.getWidth() / 2.0);
        int alto = (int)Math.ceil(img.getHeight() / 2.0);
        int[][] pixeles = new int[ancho][alto];

        mensaje = String.format("AchicarX2. Img achicada de tamaño: %dx%d ",ancho, alto);
        logger.info(mensaje);

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                pixeles[i][j] = img.get(i*2, j*2);
            }
        }
        img.setPixeles(ancho, alto, pixeles);
    }
}
