package cadena.vista;

import cadena.models.Lista;
import cadena.models.ListaDoble;
import cadena.models.ListaOrdenada;
import observer.models.CuadradoSimple;
import observer.vista.SimpleJPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ListaJFrame extends JFrame {
    private ListaOrdenada<String> modelo;

    public ListaJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        this.getContentPane().setLayout(new BorderLayout());
        modelo = new ListaOrdenada();
        setSize(1200, 720);
        ListaJPanel panel = new ListaJPanel(modelo);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btnAgregar = new JButton("Agregar elemento");

        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new BorderLayout());

        pnlSouth.add(btnAgregar, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JTextField txtSearchField = new JTextField();
        txtSearchField.setSize(200, 30);
        JButton btnSearch = new JButton("Buscar elemento");
        bottomPanel.add(txtSearchField, BorderLayout.CENTER);
        bottomPanel.add(btnSearch, BorderLayout.EAST);

        pnlSouth.add(bottomPanel, BorderLayout.SOUTH);

        this.getContentPane().add(pnlSouth, BorderLayout.SOUTH);
        insertarElementosAlAzar();
        btnAgregar.addActionListener(e -> {
//            int random = (int) (Math.random() * 100);
//            modelo.insertar(random);
            String az = "abcdefghijklmnopqrstuvwxyz";
            String random = "";
            int lengthRandom = (int) (Math.random() * 5);
            for (int i = 0; i < lengthRandom; i++) {
                int indexRandom = (int) (az.length() * Math.random());
                random += az.charAt(indexRandom);
            }
            modelo.insertar(random);
        });
        btnSearch.addActionListener(e -> {
//            int valor = Integer.parseInt(txtSearchField.getText());
            String valor = txtSearchField.getText();
            panel.iniciarBusqueda(valor);
        });
        setVisible(true);

    }

    private void insertarElementosAlAzar() {
//        Integer[] listaEnteros = new Integer[10];
        String[] ordenados = {"hugo", "paco", "luis", "juan", "mario",
                "ana", "olga", "anastasia", "elsa", "rapunzel"};
        for (String palabra :
                ordenados) {
            modelo.insertar(palabra);
        }
//        for (int i = 0; i < 10; i++) {
//            int random = (int) (Math.random() * 100);
//            modelo.insertar(random);
//        }
//        Arrays.sort(listaEnteros, Collections.reverseOrder());
//        for (int i = 0; i < listaEnteros.length; i++) {
//            modelo.insertar(listaEnteros[i]);
//        }
    }

    public static void main(String[] args) {
        new ListaJFrame();
    }
}
