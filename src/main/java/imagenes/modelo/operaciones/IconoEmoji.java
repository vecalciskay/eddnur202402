package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.excepciones.ImagenException;

/**
 * Esta operacion dibuja un emoji de 9x9 en el punto del parametro
 * BBBWWWBBB
 * BWWBBBWWB
 * BWBBBBBWB
 * BWBWBWBWB
 * BWBBBBBWB
 * BWWBBBWWB
 * BWBWWWBWB
 * BWWBBBWWB
 * BBBWWWBBB
 */
public class IconoEmoji implements IOperacionImagen {
private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();
    @Override
    public void hacer(Imagen img, ParametrosOperacion parametros) throws ImagenException {
        int black = 0;
        int white = 0xFFFFFF;
        int x = parametros.getX0();
        int y = parametros.getY0();
        String msg = String.format("Dibuja emoji en x: %d y: %d",x , y);
        logger.info(msg);
        int[][] emoji = {
                {black, black, black, white, white, white, black, black, black},
                {black, white, white, black, black, black, white, white, black},
                {black, white, black, black, black, black, black, white, black},
                {black, white, black, white, black, white, black, white, black},
                {black, white, black, black, black, black, black, white, black},
                {black, white, white, black, black, black, white, white, black},
                {black, white, black, white, white, white, black, white, black},
                {black, white, white, black, black, black, white, white, black},
                {black, black, black, white, white, white, black, black, black}
        };

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                img.setRgb(x + i, y + j, emoji[j][i]);
            }
        }
    }
}
