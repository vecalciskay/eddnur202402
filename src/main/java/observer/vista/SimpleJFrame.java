package observer.vista;

import observer.models.CuadradoSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleJFrame extends JFrame implements PropertyChangeListener {
    private CuadradoSimple modelo;
    private JLabel mensaje;

    public SimpleJFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();

        this.pack();
        this.setVisible(true);
    }

    public void init() {
        // layout
        this.getContentPane().setLayout(new BorderLayout());

        // Panel edntro de contentPane
        modelo = new CuadradoSimple();
        SimpleJPanel panel = new SimpleJPanel(modelo);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        // Mensajes abajo
        modelo.addObserver(this);
        mensaje = new JLabel(modelo.toString());
        mensaje.setFont(new Font("Serif", Font.PLAIN, 18));
        this.getContentPane().add(mensaje, BorderLayout.SOUTH);

        // menu color
        JMenuBar bar =  new JMenuBar();

        JMenu menu = new JMenu("Color");

        JMenuItem item = new JMenuItem("Verde");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuColor_verde();
            }
        });
        menu.add(item);

        bar.add(menu);

        this.setJMenuBar(bar);
    }

    public void menuColor_verde() {
        modelo.setColor(Color.green);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mensaje.setText(modelo.toString());
    }
}
