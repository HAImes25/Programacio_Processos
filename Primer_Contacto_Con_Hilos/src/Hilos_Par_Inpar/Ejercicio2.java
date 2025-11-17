package Hilos_Par_Inpar;
public class Ejercicio2 {
    public static void main(String[] args) throws InterruptedException {



        HiloPar h1 = new HiloPar("PAR ");
        HiloInPar h2 = new HiloInPar("INPAR ");

        System.out.println("h2 vivo antes de start? " + h2.isAlive()); 

        h1.start();
        h2.start();

        
        

    }    
}