package arboles.gui;

import arboles.Arbol;
import arboles.NumeroIdentificable;

import javax.swing.*;
import java.awt.*;

public class ArbolPanel extends JPanel {

    private Arbol<NumeroIdentificable> modelo;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,500);
    }

    public ArbolPanel(Arbol<NumeroIdentificable> m) {
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
}
