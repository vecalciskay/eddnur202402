package patronCommand;

public class ControlRemotoInvoker {
    private ICommand comando;

    public void setCommand(ICommand comando){
        this.comando = comando;
    }

    public void presionarBoton(){
        this.comando.execute();
    }
}
