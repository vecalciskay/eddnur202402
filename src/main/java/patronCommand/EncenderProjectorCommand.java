package patronCommand;

public class EncenderProjectorCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Proyector Encendido");
    }
}
