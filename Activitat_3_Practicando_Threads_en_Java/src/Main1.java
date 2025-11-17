class MiHilo extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hilo Secundario ejecutándose: mensaje " + i);
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        MiHilo hilo = new MiHilo();
        hilo.start();
        System.out.println("Soy el hilo Main");
    }
}
