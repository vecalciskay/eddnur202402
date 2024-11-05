package arboles.gui;

import arboles.Arbol;
import arboles.NumeroIdentificable;

import javax.swing.*;
import java.awt.*;

public class ArbolFrame extends JFrame {
    public ArbolFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        Arbol<NumeroIdentificable> arbol = construirArbol();
        ArbolPanel panel = new ArbolPanel(arbol);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ArbolFrame();
    }

    private Arbol<NumeroIdentificable> construirArbol() {
        Arbol<NumeroIdentificable> arbol = new Arbol<>();
        arbol.insertar(new NumeroIdentificable(3));
        arbol.insertar(new NumeroIdentificable(4), "3");
        arbol.insertar(new NumeroIdentificable(5), "3");
        arbol.insertar(new NumeroIdentificable(8), "3");

        arbol.insertar(new NumeroIdentificable(2), "4");
        arbol.insertar(new NumeroIdentificable(7), "4");
        arbol.insertar(new NumeroIdentificable(6), "4");
        arbol.insertar(new NumeroIdentificable(10), "4");

        arbol.insertar(new NumeroIdentificable(9), "5");

        arbol.insertar(new NumeroIdentificable(1), "8");
        arbol.insertar(new NumeroIdentificable(12), "8");

        return arbol;
    }
}
