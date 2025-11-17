package ejercicio1;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        
        HiloExtendido hiloExtendido = new HiloExtendido();
        hiloExtendido.setName("Worker-1");
        Thread thread = new Thread(new HiloRunnable(), "Worker-2");

        System.out.println(Thread.currentThread().getName() + " Inicio");
        hiloExtendido.start();
        thread.start();

        hiloExtendido.join();
        thread.join();

        System.out.println(Thread.currentThread().getName() + " Final");


    }
}
