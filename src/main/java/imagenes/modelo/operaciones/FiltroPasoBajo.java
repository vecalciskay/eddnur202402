package imagenes.modelo.operaciones;

import imagenes.modelo.ParametrosOperacion;

public class FiltroPasoBajo extends Convolucion {
    public FiltroPasoBajo() {

        int[][] kernel = {
            {1, 2, 1},
            {2, 4, 2},
            {1, 2, 1}
        };
        int divisor = 16;

        this.parametrosKernel = new ParametrosOperacion();
        this.parametrosKernel.setKernel(kernel);
        this.parametrosKernel.setKernelDivisor(divisor);
    }
}
