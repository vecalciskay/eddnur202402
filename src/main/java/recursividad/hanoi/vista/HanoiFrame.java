package recursividad.hanoi.vista;

import recursividad.hanoi.exceptions.HanoiException;
import recursividad.hanoi.modelo.HanoiModel;

import javax.swing.*;
import java.awt.*;

public class HanoiFrame extends JFrame {
    private HanoiModel modelo;
    public HanoiFrame() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            init();
        } catch (HanoiException e) {
            e.printStackTrace();
            System.exit(0);
        }

        this.pack();
        this.setVisible(true);
    }

    private void init() throws HanoiException {
        // layout
        this.getContentPane().setLayout(new BorderLayout());

        // Panel edntro de contentPane
        modelo = new HanoiModel(3, 0, 2, 1, 1000);
        HanoiPanel panel = new HanoiPanel(modelo);
        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btn = new JButton("Resolver");
        btn.addActionListener(e -> {
            btn_clicked();
        });
        this.getContentPane().add(btn, BorderLayout.SOUTH);
    }

    private void btn_clicked() {
        Thread t = new Thread(() -> {
            modelo.resolver();
        });
        t.start();
    }
}
