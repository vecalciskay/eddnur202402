package observer.models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class CuadradoSimple {
    private static final Logger logger = LogManager.getRootLogger();
    private static final String OBSERVER_COLOR = "COLOR";
    private static final String OBSERVER_POSICION = "POSICION";
    private int tamano;
    private Color color;
    private int x;
    private int y;
    private PropertyChangeSupport supportObserver;
    private static final String OBSERVER_TAMANO = "TAMANO";

    public CuadradoSimple() {
        this(50,Color.black, 100, 100);
    }
    public CuadradoSimple(int tamano, Color color, int x, int y) {
        supportObserver = new PropertyChangeSupport(this);
        this.tamano = tamano;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void agrandar(int n) {
        int oldTamano = tamano;
        tamano += n;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, oldTamano, tamano);
    }
    public void achicar(int n) {
        int oldTamano = tamano;
        tamano -= n;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, oldTamano, tamano);
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        int oldTamano = this.tamano;
        this.tamano = tamano;
        supportObserver.firePropertyChange(
                OBSERVER_TAMANO, oldTamano, tamano);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        Color oldColor = this.color;
        this.color = color;
        supportObserver.firePropertyChange(
                OBSERVER_COLOR,oldColor, color);
    }

    public void setPosicion(int x, int y) {
        Point oldPoint = new Point(this.x, this.y);
        this.x = x;
        this.y = y;
        Point newPoint = new Point(this.x, this.y);
        supportObserver.firePropertyChange(
                OBSERVER_POSICION, oldPoint, newPoint);
        logger.debug("Cuadrado, cambio de posicion de:" + oldPoint +
                " a: " + newPoint);
    }

    public void addObserver(PropertyChangeListener observer) {
        supportObserver.addPropertyChangeListener(observer);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Cuadrado -> tamano: " + tamano + ", (x,y): " + x + "," + y +
                " color:" + color.toString();
    }
}
