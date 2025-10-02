public class Main {
    public static void main(String[] args) throws InterruptedException {

// Ejercicio 1
        // Creo los dos hilos
        /*
        Hilo h1 = new Hilo("H1");
        Hilo h2 = new Hilo("H2");

        // Inicio desde start los dos hilos
        h1.start();
        h2.start();
        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "Soy el proceso " + (i + 1));
                       try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

         */


        HiloPar h1 = new HiloPar("PAR ");
        HiloInPar h2 = new HiloInPar("INPAR ");

        System.out.println("h1 vivo antes de start? " + h1.isAlive()); 
        System.out.println("h2 vivo antes de start? " + h2.isAlive()); 

        h1.start();
        h2.start();

        System.out.println("h1 vivo despues de start? " + h1.isAlive()); 
        System.out.println("h2 vivo despues de start? " + h2.isAlive()); 
        



    }
}