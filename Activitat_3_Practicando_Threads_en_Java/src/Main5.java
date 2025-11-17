class Contador {
    private int valor = 0;

    public void incrementar() {
        valor++; 
    }

    public int getValor() {
        return valor;
    }
}

class HiloContador extends Thread {
    private Contador contador;

    public HiloContador(Contador c) {
        this.contador = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.incrementar();
        }
    }
}

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        Contador c = new Contador();

        HiloContador h1 = new HiloContador(c);
        HiloContador h2 = new HiloContador(c);

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Valor final (esperado 2000): " + c.getValor());
    }
}
