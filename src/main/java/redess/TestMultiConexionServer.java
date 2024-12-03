package redess;

import java.io.IOException;

public class TestMultiConexionServer {
    public static void main(String[] args) throws IOException {
        MultiConexionServer srv = new MultiConexionServer(6865);
        srv.start();
    }
}
