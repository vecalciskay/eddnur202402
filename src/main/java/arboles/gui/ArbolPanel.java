package arboles.gui;

import arboles.Arbol;
import arboles.NodoArbol;
import arboles.NumeroIdentificable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ArbolPanel extends JPanel implements MouseListener {

    private Arbol<NumeroIdentificable> modelo;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,500);
    }

    public ArbolPanel(Arbol<NumeroIdentificable> m) {
        addMouseListener(this);
        this.modelo = m;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (modelo != null) {
            DibujoArbol dibujo = new DibujoArbol(modelo);
            dibujo.dibujar(g, 0, 0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        NodoArbol<NumeroIdentificable> nodo = null;

        int x = e.getX();
        int y = e.getY();
        nodo = modelo.puntoDentroDeNodo(x, y);

        if (nodo == null) {
            return;
        }

        String msg = "Informacion nodo: " + nodo.getValor().toString();
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
