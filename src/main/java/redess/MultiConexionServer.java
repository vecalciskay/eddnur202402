package redess;

import arbolaritmetico.objetos.AritmeticaException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que representa un servidor que puede recibir múltiples conexiones
 * y que respeta un protocolo de comunicación.
 * El protocolo es el siguiente:
 * USR -> SRV: Registrar, tomar en cuenta, una expresion aritmetica\nEXPR 4+5
 * SRV -> USR: OK
 * USR -> SRV: Preguntar cual es la expresion actual\n EXPR
 * SRV -> USR: OK 4+5
 * USR -> SRV: Evaluar la expresion que tiene registrada\n EVAL
 * SRV -> USR: OK 9
 * USR -> SRV: Preguntar cantidad de nodos que se necesitaron\n NODES
 * SRV -> USR: OK 3
 * USR -> SRV: Terminar la conexión\n FIN
 */
public class MultiConexionServer {
    private int port;
    private boolean prendido;
    public MultiConexionServer(int port) {
        this.port = port;
        this.prendido = true;
    }

    public void apagar() {
        System.out.println("Apagando servidor, en la proxima conexion se apaga automatico");
        this.prendido = false;
    }

    public void start() throws IOException {
        ServerSocket srv = new ServerSocket(port);

        Socket clt;
        int respuesta = 1;
        while(prendido) {
            clt = srv.accept();
            InputStreamReader isr = new InputStreamReader(clt.getInputStream());
            BufferedReader entrada = new BufferedReader(isr);
            PrintWriter salida = new PrintWriter(clt.getOutputStream(), true);

            ServicioAritmetica servicio = new ServicioAritmetica(this, entrada, salida);
            Thread hilo = new Thread(servicio);
            hilo.start();
        }
    }
}
