package patronCommand;

public class ProyectorReceiver {
    private String Aula;

    public ProyectorReceiver(String aula) {
        Aula = aula;
    }

    public void encenderProyector(){
        System.out.println("Proyector encendido");
    }

    public void apagarProyector(){
        System.out.println("Apagar proyector");
    }
}
