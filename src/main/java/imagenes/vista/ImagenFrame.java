package imagenes.vista;

import imagenes.modelo.Imagen;
import imagenes.modelo.operaciones.AchicarX2;
import imagenes.modelo.operaciones.Aclarar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ImagenFrame extends JFrame {
    private Imagen modelo;
    private ImagenPanel panel;
    public ImagenFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();
    }

    private void init() {
        modelo = new Imagen(600,400);
        modelo.imagenBandasColores();

        panel = new ImagenPanel(modelo);

        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);

        crearMenu();

        this.pack();
        this.setVisible(true);
    }

    private void crearMenu() {
        JMenuBar bar = new JMenuBar();

        // Menu Archivo
        JMenu mnu = new JMenu("Archivo");
        
        JMenuItem item = new JMenuItem("Cargar imagen");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuArchivo_cargarImagen();
            }
        });
        mnu.add(item);
        
        bar.add(mnu);

        // Menu Imagen
        mnu = new JMenu("Imagen");

        item = new JMenuItem("Aclarar");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuImagen_Aclarar();
            }
        });
        mnu.add(item);

        item = new JMenuItem("Achicar x 2");
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mnuImagen_AchicarX2();
            }
        });
        mnu.add(item);

        bar.add(mnu);

        this.setJMenuBar(bar);
    }

    private void mnuImagen_Aclarar() {
        modelo.operacion(new Aclarar());
    }
    private void mnuImagen_AchicarX2() {
        modelo.operacion(new AchicarX2());
    }

    private void mnuArchivo_cargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        //fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            // user selects a file
            File selectedFile = fileChooser.getSelectedFile();
            nuevoModelo(selectedFile);
        }
    }

    private void nuevoModelo(File selectedFile) {
        modelo = new Imagen(selectedFile);
        panel.setModelo(modelo);

        this.pack();
    }
}
