package basededatos.patrondao;

import basededatos.patrondao.dao.PersonaDao;
import basededatos.patrondao.dto.PersonaDto;
import cadena.models.ListaDoble;

public class TestDao {
    public static void main(String[] args) {
        PersonaDao dao = new PersonaDao();
        ListaDoble<PersonaDto> lista = dao.getRegistros();

        System.out.println(lista);
    }
}
