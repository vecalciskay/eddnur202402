package imagenes.modelo;

import java.awt.*;

/**
 * Esta clase es solamente para indicar que parametros puede tener cualquier
 * operacion sobre una imagen. Esta clase puede crecer tanto como sea necesario
 */
public class ParametrosOperacion {
    private int x0;
    private int y0;
    private int[][] kernel;
    private int kernelDivisor;
    private Color color;

    public ParametrosOperacion() {
    }
    public ParametrosOperacion(int x0, int y0, Color color) {
        this.x0 = x0;
        this.y0 = y0;
        this.color = color;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int[][] getKernel() {
        return kernel;
    }

    public void setKernel(int[][] kernel) {
        this.kernel = kernel;
    }

    public int getKernelDivisor() {
        return kernelDivisor;
    }

    public void setKernelDivisor(int kernelDivisor) {
        this.kernelDivisor = kernelDivisor;
    }
}
