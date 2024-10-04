package cadena.vista;

import cadena.models.Lista;
import cadena.models.Nodo;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ListaJPanel extends JPanel implements PropertyChangeListener {
    private final Lista modelo;

    public ListaJPanel(Lista modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Nodo<Integer> actual = this.modelo.getNodo(0);
        //TODO: Dibujar lista.
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }

}
