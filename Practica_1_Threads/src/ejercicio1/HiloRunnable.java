package ejercicio1;

public class HiloRunnable implements Runnable{
    @Override
    public void run() {
        try{
            System.out.println(Thread.currentThread().getName() + " preparando...");
            Thread.sleep(150);
            System.out.println(Thread.currentThread().getName() + "preparando...");
            Thread.sleep(150);
            System.out.println(Thread.currentThread().getName() + "preparando...");
        }catch (InterruptedException e){
            System.err.println("El hilo fue interumpido");
        }
    }
}
