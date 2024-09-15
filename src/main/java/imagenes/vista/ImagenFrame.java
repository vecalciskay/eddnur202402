package imagenes.vista;

import imagenes.modelo.Imagen;
import imagenes.modelo.operaciones.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ImagenFrame extends JFrame {
    private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager.getRootLogger();

    private transient Imagen modelo;
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
        item.addActionListener(e -> mnuArchivoItemCargarImagen());
        mnu.add(item);

        mnu.addSeparator();

        item = new JMenuItem("Salir");
        item.addActionListener(e -> mnuArchivoItemSalir());
        mnu.add(item);
        
        bar.add(mnu);

        // Menu Vista
        mnu = new JMenu("Vista");

        item = new JMenuItem("Ajustar");
        item.addActionListener(e -> mnuVistaItemAjustar());
        mnu.add(item);

        bar.add(mnu);

        // Menu Imagen
        mnu = new JMenu("Imagen");

        item = new JMenuItem("Aclarar");
        item.addActionListener(e -> mnuImagenItemAclarar());
        mnu.add(item);

        item = new JMenuItem("Achicar x 2");
        item.addActionListener(e -> mnuImagenItemAchicarX2());
        mnu.add(item);

        item = new JMenuItem("Grises");
        item.addActionListener(e -> mnuImagenItemGrises());
        mnu.add(item);

        item = new JMenuItem("Paso Bajo");
        item.addActionListener(e -> mnuImagenItemPasoBajo());
        mnu.add(item);

        item = new JMenuItem("Bordes Sobel");
        item.addActionListener(e -> mnuImagenItemBordesSobel());
        mnu.add(item);

        bar.add(mnu);

        // Menu Herramientas
        mnu = new JMenu("Herramientas");

        item = new JMenuItem("Icono / Emoji");
        item.addActionListener(e -> mnuImagenItemIconoEmoji());
        mnu.add(item);

        bar.add(mnu);

        this.setJMenuBar(bar);
    }

    private void mnuImagenItemPasoBajo() { modelo.operacion(new FiltroPasoBajo()); }

    private void mnuImagenItemBordesSobel() { modelo.operacion(new BordesSobel()); }

    private void mnuImagenItemGrises() { modelo.operacion(new ConvertirAGris());}

    private void mnuImagenItemIconoEmoji() {
        logger.info("Icono / Emoji");
        panel.herramientaSeleccionada();
    }

    private void mnuArchivoItemSalir() {
        logger.info("Saliendo de la aplicación");
        System.exit(0);
    }

    private void mnuVistaItemAjustar() {
        this.pack();
    }

    private void mnuImagenItemAclarar() {
        modelo.operacion(new Aclarar());
    }
    private void mnuImagenItemAchicarX2() {
        modelo.operacion(new AchicarX2());
    }

    private void mnuArchivoItemCargarImagen() {
        JFileChooser fileChooser = new JFileChooser();
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
