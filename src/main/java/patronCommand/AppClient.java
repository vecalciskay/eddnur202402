package patronCommand;

public class AppClient {
    public static void main(String[] args) {
        // Instancio mi Receiver
        ProyectorReceiver proyector = new ProyectorReceiver("Aula 305");
        // Instanciar mis comandos
        EncenderProjectorCommand comandoEncender = new EncenderProjectorCommand(proyector);
        ApagarProyectorCommand comadoApagar = new ApagarProyectorCommand(proyector);
        // Instancio mi Invoker
        ControlRemotoInvoker controlRemoto = new ControlRemotoInvoker();
        // Procedemos a setear el comando de encender y ejecutamos la acción
        controlRemoto.setCommand(comandoEncender);
        controlRemoto.presionarBoton();
        // Procedemos a setear el comando de apagar y ejecutamos la acción
        controlRemoto.setCommand(comadoApagar);
        controlRemoto.presionarBoton();
    }
}
