package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.excepciones.ImagenException;

/**
 * Toda operacion sobre la imagen debe implementar esta clase.
 */
public interface IOperacionImagen {
    public void hacer(Imagen img, ParametrosOperacion parametros) throws ImagenException;
}
