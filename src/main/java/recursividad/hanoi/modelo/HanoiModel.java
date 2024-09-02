package recursividad.hanoi.modelo;

import recursividad.hanoi.exceptions.HanoiException;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * Modelo de la torre de Hanoi.
 * Los valores de de, a y pp son los números de las torres de origen, auxiliar y destino respectivamente.
 * Estos valores pueden ser 0, 1 y 2.
 * La velocidad es el tiempo en ms que esperar el algoritmo para mover un anillo.
 */
public class HanoiModel {
    private int n;
    private int de;
    private int a;
    private int pp;
    private int velocidad;
    private Torre[] torres;
    private PropertyChangeSupport observado;

    public HanoiModel(int n, int de, int a, int pp, int velocidad) throws HanoiException {
        if (n <= 0) {
            throw new HanoiException(HanoiException.ARG_ANILLOS_POSITIVO_MESSAGE);
        }

        this.n = n;
        this.de = de;
        this.a = a;
        this.pp = pp;
        this.velocidad = velocidad;
        observado = new PropertyChangeSupport(this);

        torres = new Torre[3];
        for (int i = 0; i < 3; i++) {
            torres[i] = new Torre();
        }
        for (int i = n; i > 0; i--) {
            torres[de].agregarAnillo(new Anillo(i));
        }
    }

    public void addObserver(PropertyChangeListener observador) {
        observado.addPropertyChangeListener(observador);
    }

    public void hanoi() {
        hanoi(de, a, pp, n);
    }

    private void hanoi(int de, int a, int pp, int n) {
        if (n == 1) {
            torres[a].agregarAnillo(torres[de].quitarAnillo());
            observado.firePropertyChange("HANOI", true, false);
            try {
                if (velocidad > 0)
                    Thread.sleep(velocidad);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else {
            hanoi(de, pp, a, n - 1);
            hanoi(de, a, pp, 1);
            hanoi(pp, a, de, n - 1);
        }
    }

    public Torre[] getTorres() {
        return torres;
    }

    public void resolver() {
        hanoi(de, a, pp, n);
    }
}
