package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.excepciones.ImagenException;

public class ConvertirAGris implements IOperacionImagen {
    @Override
    public void hacer(Imagen img, ParametrosOperacion parametros) throws ImagenException {
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                int[] pixel = img.getRgb(i,j);
                int promedio = (int)((pixel[0] + pixel[1] + pixel[2]) / 3.0);
                img.setRgb(i, j, promedio, promedio, promedio);
            }
        }
    }
}
