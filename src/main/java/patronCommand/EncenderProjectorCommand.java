package patronCommand;

public class EncenderProjectorCommand implements ICommand{
    private ProyectorReceiver proyector;

    public EncenderProjectorCommand(ProyectorReceiver proyector) {
        this.proyector = proyector;
    }

    @Override
    public void execute() {
        this.proyector.encenderProyector();
    }
}
