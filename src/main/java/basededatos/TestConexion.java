package basededatos;

import java.sql.*;

/**
 * Clase de prueba para la conexión a la base de datos MySql.
 * En la base de datos edd tenemos una tabla llamada "personas" con los campos:
 * id, nombre, edad, email.
 * Con el metodo hacerSelect() se hace una consulta a la base de datos y se
 * obtienen los datos de la tabla "personas" y se muestran en la consola.
 */
public class TestConexion {
    public static Connection connection;
    public static void main(String[] args) throws SQLException {
        conectar();
        hacerSelect();
        desconectar();
        //
        // PersonaDao dao = new PersonaDao();
        // Lista<Persona> lista = dao.selectTodo();
    }

    private static void desconectar() throws SQLException {
        connection.close();
        System.out.println("Database disconnected!");
    }

    private static void hacerSelect() {
        String sql = "SELECT * FROM personas";
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                System.out.println("id: " + result.getInt("id"));
                System.out.println("nombre: " + result.getString("nombre"));
                System.out.println("edad: " + result.getInt("edad"));
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void conectar() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/edd";
        String username = "postgres";
        String password = "aaaaaa";

        System.out.println("Connecting database ...");

        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Database connected!");
    }
}
