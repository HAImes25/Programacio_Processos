package Ejercicio2;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Cremos hilos y contador
        Contador contadorComprartido = new Contador();
        HiloContador hiloContador1 = new HiloContador(contadorComprartido);
        HiloContador hiloContador2 = new HiloContador(contadorComprartido);
        HiloContador hiloContador3 = new HiloContador(contadorComprartido);
        HiloContador hiloContador4 = new HiloContador(contadorComprartido);

        //Empezamos hilos
        hiloContador1.start();
        hiloContador2.start();
        hiloContador3.start();
        hiloContador4.start();

        //Haemos joins para que se espere antes de enseñar el valor de contador
        hiloContador1.join();
        hiloContador2.join();
        hiloContador3.join();
        hiloContador4.join();

        System.out.println(contadorComprartido.getValor());


    }
}
