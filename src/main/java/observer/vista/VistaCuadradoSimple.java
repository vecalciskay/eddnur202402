package observer.vista;

import observer.models.CuadradoSimple;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class VistaCuadradoSimple {
    private static Logger logger = LogManager.getRootLogger();
    private CuadradoSimple modelo;
    public VistaCuadradoSimple(CuadradoSimple m) {
        modelo = m;
    }
    public void dibujar(Graphics g) {
        g.setColor(modelo.getColor());
        g.fillRect(modelo.getX(), modelo.getY(),
                modelo.getTamano(), modelo.getTamano());
        logger.info("Dibujo figura en " + modelo.getX() +
                "," + modelo.getY() +
                " con tamano " +  modelo.getTamano());
    }
}
