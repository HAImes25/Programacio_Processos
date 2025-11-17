package Ejercicio1;

public class TrabajadorB implements Runnable{


    @Override
    public void run() {
        try {
            for (int i = 1; i < 4; i++) {
                System.out.println(Thread.currentThread().getName() + " Paso " + i);
                Thread.sleep(200);


            }
        } catch (InterruptedException e) {
            System.err.println("El hilo a fue interumpido");
        }
    }
}
