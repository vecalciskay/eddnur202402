package redess;

import arbolaritmetico.objetos.ArbolAritmetico;
import arbolaritmetico.objetos.AritmeticaException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Esta clase implementa la funcionalidad de un servidor que recibe conexiones
 * de clientes y realiza operaciones aritméticas.
 */
public class ServicioAritmetica implements Runnable {
    private final MultiConexionServer srv;
    private final BufferedReader entrada;
    private final PrintWriter salida;
    private Socket clt;
    private ArbolAritmetico arbol;

    public ServicioAritmetica(MultiConexionServer srv,
                              BufferedReader entrada,
                              PrintWriter salida) {
        this.srv = srv;
        this.entrada = entrada;
        this.salida = salida;
        this.arbol = null;
    }

    public void brindarServicio() throws IOException, AritmeticaException {
        System.out.println("Cliente conectado....");
        String lecturaSocket = entrada.readLine();
        System.out.println("<<< " + lecturaSocket);

        String lecturaLimpia = lecturaSocket.trim();

        if (lecturaLimpia.equals("FIN")) {
            salida.println("OK");
            srv.apagar();
        }

        if(lecturaSocket.matches("EXPR\s(.+)")) {
            String expresion = lecturaLimpia.substring(5);
            arbol = new ArbolAritmetico(expresion);
            salida.println("OK");
            salida.flush();

            lecturaSocket = entrada.readLine();
            if(lecturaSocket.trim().equals("EXPR")) {
                salida.println("OK " + arbol.toString());
                salida.flush();
            } else if(lecturaSocket.trim().equals("EVAL")) {
                salida.println("OK " + arbol.evaluar());
                salida.flush();
            } else if(lecturaSocket.trim().equals("NODES")) {
                salida.println("OK " + arbol.contarNodos());
                salida.flush();
            } else {
                System.out.println("<<< ERR Comando no conocido " + lecturaLimpia);
            }
        } else {
            System.out.println("<<< ERR Comando no conocido " + lecturaLimpia);
        }

        entrada.close();
        salida.close();
        System.out.println("Termina conexion de un servicio y cierra todo");
    }

    @Override
    public void run() {
        try {
            brindarServicio();
        } catch (IOException | AritmeticaException e) {
            e.printStackTrace();
        }
    }
}
