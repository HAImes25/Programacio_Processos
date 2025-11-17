package Ejercicio2;

public class HiloContador extends Thread{

    private Contador contador;

    public HiloContador(Contador contadorComprartido) {
        this.contador = contadorComprartido;

    }

    // En el for se va sumando en el contador hasta 25000
    @Override
    public void run() {
        for (int i = 0; i < 25000; i++) {
            contador.inc();
        }
    }
}
