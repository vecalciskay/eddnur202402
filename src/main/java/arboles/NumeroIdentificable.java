package arboles;

public class NumeroIdentificable implements Identificable {
    private Integer id;
    public NumeroIdentificable(int id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id.toString();
    }

    @Override
    public String toString() {
        return id.toString();
    }
}
