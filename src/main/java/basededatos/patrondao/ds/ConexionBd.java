package basededatos.patrondao.ds;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBd {

    private static ConexionBd instancia;

    private final String url = "jdbc:postgresql://localhost:5432/";;
    private final int port = 5432;
    private final String db = "edd";
    private final String user = "postgres";
    private final String password = "aaaaaa";

    private Connection conexion;

    public static ConexionBd getOrCreate() throws SQLException {
        if (instancia == null) {
            instancia = new ConexionBd();
        }
        return instancia;
    }

    private ConexionBd() throws SQLException {
        conexion = DriverManager.getConnection(url + db, user, password);
        System.out.println("Database connected!");
    }

    public void desconectar() throws SQLException {
        conexion.close();
        System.out.println("Database disconnected!");
    }

    public Connection getConexion() {
        return conexion;
    }
}
