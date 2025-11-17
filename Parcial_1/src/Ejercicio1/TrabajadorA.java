package Ejercicio1;

public class TrabajadorA extends Thread{
    @Override
    public void run() {
        try {
            for (int i = 1; i < 4; i++) {
                System.out.println(getName() + " Paso " + i);
                sleep(150);
            }
        } catch (InterruptedException e) {
            System.err.println("El hilo a fue interumpido");
        }
    }
}
