package basededatos.patrondao.dao;

import basededatos.patrondao.ds.ConexionBd;
import basededatos.patrondao.dto.PersonaDto;
import cadena.models.ListaDoble;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonaDao {

    public PersonaDto getRegistroConId(int id) {
        return null;
    }

    public ListaDoble<PersonaDto> getRegistros() {
        ListaDoble<PersonaDto> lista = new ListaDoble<>();
        String sql = "SELECT * FROM personas";
        try {
            ConexionBd conexion = ConexionBd.getOrCreate();
            Statement statement = conexion.getConexion().createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                int edad = result.getInt("edad");

                lista.insertar(new PersonaDto(id, nombre, edad));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public void update(PersonaDto obj) {

    }

    public int insert(PersonaDto obj) {
        return 0;
    }

    public void delete(int id) {

    }
}
