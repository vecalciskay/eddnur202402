package cadena.vista;

import cadena.models.Lista;
import observer.models.CuadradoSimple;
import observer.vista.SimpleJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaJFrame extends JFrame {
    private Lista<Integer> modelo;

    public ListaJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        this.getContentPane().setLayout(new BorderLayout());
        modelo = new Lista();
        ListaJPanel panel = new ListaJPanel(modelo);
        this.getContentPane().add(panel, BorderLayout.CENTER);
        JButton btnAgregar = new JButton("Agregar elemento");
        this.getContentPane().add(btnAgregar, BorderLayout.SOUTH);
        btnAgregar.addActionListener(e -> {
            int random = (int) (Math.random() * 100);
            modelo.insertar(random);
        });
    }
}
