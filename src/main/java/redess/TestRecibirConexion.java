package redess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestRecibirConexion {
    public static void main(String[] args) throws IOException {
        ServerSocket srv = new ServerSocket(5864);
        System.out.println("Comienza a escuchar en el puerto 5864");
        Socket clt = srv.accept();
        System.out.println("Cliente conectado....");

        InputStreamReader isr = new InputStreamReader(clt.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String lecturaSocket = br.readLine();
        System.out.println("<<< " + lecturaSocket);
        while(!lecturaSocket.equals("FIN")) {
            lecturaSocket = br.readLine();
            System.out.println("<<< " + lecturaSocket);
        }

        System.out.println("Termina conexion y cierra todo");
        br.close();
        isr.close();
        clt.close();
        srv.close();
    }
}
