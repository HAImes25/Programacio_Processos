package ejercicio3;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {

        Contador contadorComprartido = new Contador();
        HiloContador hiloContador1 = new HiloContador(contadorComprartido);
        HiloContador hiloContador2 = new HiloContador(contadorComprartido);
        HiloContador hiloContador3 = new HiloContador(contadorComprartido);
        HiloContador hiloContador4 = new HiloContador(contadorComprartido);

        hiloContador1.start();
        hiloContador2.start();
        hiloContador3.start();
        hiloContador4.start();

        hiloContador1.join();
        hiloContador2.join();
        hiloContador3.join();
        hiloContador4.join();

        System.out.println(contadorComprartido.getValor());


    }



}
