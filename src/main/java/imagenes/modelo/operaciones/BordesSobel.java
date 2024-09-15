package imagenes.modelo.operaciones;

import imagenes.modelo.ParametrosOperacion;

public class BordesSobel extends Convolucion {
    public BordesSobel() {

        int[][] kernel = {
                {-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}
        };
        int divisor = 1;

        this.parametrosKernel = new ParametrosOperacion();
        this.parametrosKernel.setKernel(kernel);
        this.parametrosKernel.setKernelDivisor(divisor);
    }
}
