package patronCommand;

public class ApagarProyectorCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Proyector apagado");
    }
}
