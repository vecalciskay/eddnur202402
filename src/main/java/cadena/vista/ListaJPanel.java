package cadena.vista;

import cadena.models.ListaDoble;
import cadena.models.ListaOrdenada;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ListaJPanel extends JPanel implements PropertyChangeListener {
    private final ListaOrdenada<String> modelo;
    private int posInicial = -1;
    private int posFinal = -1;
    private int posEncontrado = -1;

    public ListaJPanel(ListaOrdenada<String> modelo) {
        this.modelo = modelo;
        this.modelo.addObserver(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int posX = 0;
        int posY = 0;
        for (int i = 0; i < this.modelo.getTam(); i++) {
            String valor = this.modelo.obtener(i);
            g.setColor(Color.BLACK);
            g.drawRect(posX, posY, 100, 50);

            if (i >= posInicial && i <= posFinal) {
                g.setColor(Color.BLUE);
                g.fillRect(posX, posY, 100, 50);
                g.setColor(Color.WHITE);
            } else if (i == posEncontrado) {
                g.setColor(Color.RED);
                g.fillRect(posX, posY, 100, 50);
                g.setColor(Color.WHITE);
            } else {
                g.setColor(Color.BLACK);
            }

            g.setFont(new Font("Serif", Font.PLAIN, 18));
            g.drawString(valor.toString(), posX + 40, posY + 30);
            posX += 105;
            if (posX > getWidth()) {
                posX = 0;
                posY += 55;
            }
        }

    }


    /**
     * Complejidad de algoritmo es O(n) = log_2(n)
     *
     * @param o
     * @param lista
     * @param pos0
     * @param posF
     * @return
     */
    public Integer busquedaDicotomica(String o,
                                      ListaDoble<String> lista,
                                      int pos0, int posF) {
        this.posInicial = pos0;
        this.posFinal = posF;
        this.repaint();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean encontre = false;
        Integer encontrado;


        int mitad = pos0 + (posF - pos0) / 2;
        // Solo quedan 2 elementos
        if (mitad == pos0) {
            String elemento0 = lista.obtener(pos0);
            if (elemento0.equals(o)) {
                encontrado = pos0;
                return pos0;
            }
            if (posF >= lista.getTam()) {
                return -1;
            }
            String elementoF = lista.obtener(posF);
            if (elementoF.equals(o)) {
                encontrado = posF;
                return posF;
            }
        }
        String elementoMitad = lista.obtener(mitad);
        if (elementoMitad.compareTo(o) == 0) {
            encontre = true;
            encontrado = mitad;
            return mitad;
        }
        if (elementoMitad.compareTo(o) < 0) {
            encontrado = busquedaDicotomica(o, lista, mitad, posF);
            return encontrado;
        }
        encontrado = busquedaDicotomica(o, lista, pos0, mitad);
        return encontrado;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.repaint();
    }

    public void iniciarBusqueda(String valor) {
        Thread t = new Thread(() -> {
            posEncontrado = -1;
            posEncontrado = busquedaDicotomica(valor, modelo, 0, modelo.getTam());
            System.out.println("PosEncontrado: " + posEncontrado);
            posInicial = -1;
            posFinal = -1;
            this.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
    }
}
