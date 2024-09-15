package imagenes.modelo.operaciones;

import imagenes.modelo.Imagen;
import imagenes.modelo.ParametrosOperacion;
import imagenes.modelo.excepciones.ImagenException;

public class Convolucion implements IOperacionImagen {
    protected ParametrosOperacion parametrosKernel;

    @Override
    public void hacer(Imagen img, ParametrosOperacion parametrosInline) throws ImagenException {
        ParametrosOperacion parametros = parametrosInline;
        if (parametrosInline == null || parametrosInline.getKernel() == null) {
            parametros = this.parametrosKernel;
        }
        int[][] kernel = parametros.getKernel();
        int divisor = parametros.getKernelDivisor();

        int ancho = img.getWidth();
        int alto = img.getHeight();
        int[][] pixeles = new int[ancho][alto];

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                int[] suma = new int[3]; // r,g,b
                for (int l = 0; l < kernel.length; l++) {
                    for (int m = 0; m < kernel[l].length; m++) {
                        int x = i + l - kernel.length / 2;
                        int y = j + m - kernel[l].length / 2;
                        if (x >= 0 && x < ancho && y >= 0 && y < alto) {
                            int[] pixelrgb = img.getRgb(x, y);
                            suma[0] += pixelrgb[0] * kernel[l][m];
                            suma[1] += pixelrgb[1] * kernel[l][m];
                            suma[2] += pixelrgb[2] * kernel[l][m];
                        }
                    }
                }
                for (int k = 0; k < 3; k++) {
                    suma[k] = (int)(suma[k] / (double)divisor);
                    if (suma[k] < 0) {
                        suma[k] = 0;
                    }
                    if (suma[k] > 255) {
                        suma[k] = 255;
                    }
                }

                pixeles[i][j] = suma[0] << 16 | suma[1] << 8 | suma[2];
            }
        }

        img.setPixeles(ancho, alto, pixeles);
    }
}
