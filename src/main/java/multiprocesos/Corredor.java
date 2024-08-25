package multiprocesos;

public class Corredor implements Runnable {
    private String nombre;
    public Corredor(String n) {
        this.nombre = n;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(nombre + ": " + i);
            double d = Math.sqrt(30458.7) * Math.log(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
