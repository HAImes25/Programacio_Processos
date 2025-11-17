package Ejercicio1;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        TrabajadorA trabajadorA = new TrabajadorA();
        Thread trabajadorB = new Thread(new TrabajadorB(),"Operador-2");
        System.out.println(Thread.currentThread().getName() + " Inicio");

        trabajadorA.setName("Operador-1");

// Emìeza

        trabajadorA.start();
        trabajadorB.start();


        trabajadorA.join();
        trabajadorB.join();

        System.out.println(Thread.currentThread().getName() + " FIN (A)");


// Fin A
// Empieza B
/*
        TrabajadorA trabajadorA2 = new TrabajadorA();
        trabajadorA2.setName("Hilo-Trabajador-3 ");
        Thread trabajadorB2 = new Thread(new TrabajadorB(),"Hilo-Trabajador-4");



        trabajadorA2.join(250);
        trabajadorB2.join(250);


        System.out.println("FIN (B)");

*/

//Fin B










    }
}
