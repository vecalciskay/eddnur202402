package multiprocesos;

public class ThreadsSimple {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo 1: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo 2: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("Iniciando hilos");
        t1.start();
        t2.start();
        System.out.println("Hilos terminados");

        carrera();
    }

    public static void carrera() {
        Thread t1 = new Thread(new Corredor("hugo"));
        Thread t2 = new Thread(new Corredor("paco"));
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Luis : " + i);
                    double d = Math.sqrt(30458.7) * Math.log(100);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        System.out.println("Chau");
    }
}
