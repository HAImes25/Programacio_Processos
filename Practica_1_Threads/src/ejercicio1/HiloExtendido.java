package ejercicio1;

public class HiloExtendido extends Thread{
    @Override
    public void run() {
        try{
            System.out.println(getName() + " preparando...");
            sleep(150);
            System.out.println(getName() + " preparando...");
            sleep(150);
            System.out.println(getName() + " preparando...");
        }catch (InterruptedException e){
            System.err.println("El hilo fue interumpido");
        }

    }
}
