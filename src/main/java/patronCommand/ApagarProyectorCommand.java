package patronCommand;

public class ApagarProyectorCommand implements ICommand{
    ProyectorReceiver proyector;

    public ApagarProyectorCommand(ProyectorReceiver proyector) {
        this.proyector = proyector;
    }

    @Override
    public void execute() {
        this.proyector.apagarProyector();
    }
}
