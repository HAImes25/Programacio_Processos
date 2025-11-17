class ContadorSeguro {
    private int valor = 0;

    public synchronized void incrementar() {
        valor++; 
    }

    public int getValor() {
        return valor;
    }
}

class HiloContadorSeguro extends Thread {
    private ContadorSeguro contador;

    public HiloContadorSeguro(ContadorSeguro c) {
        this.contador = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            contador.incrementar();
        }
    }
}

public class Main6 {
    public static void main(String[] args) throws InterruptedException {
        ContadorSeguro c = new ContadorSeguro();

        HiloContadorSeguro h1 = new HiloContadorSeguro(c);
        HiloContadorSeguro h2 = new HiloContadorSeguro(c);

        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("Valor final (esperado 2000): " + c.getValor());
    }
}
