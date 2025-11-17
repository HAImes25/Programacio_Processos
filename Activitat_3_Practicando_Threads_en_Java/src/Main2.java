class MiRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Ejecutando Hilo Runnable: mensaje " + i);
        }
    }
}

public class Main2 {
    public static void main(String[] args) {
        Thread t = new Thread(new MiRunnable());
        t.start();
        System.out.println("Soy el hilo del main");
    }
}
