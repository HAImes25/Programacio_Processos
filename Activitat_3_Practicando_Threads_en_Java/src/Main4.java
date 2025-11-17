class Letras extends Thread {
    @Override
    public void run() {
        for (char c = 'A'; c <= 'E'; c++) {
            System.out.println("Letra: " + c);
        }
    }
}

class Simbolos extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("* " + i);
        }
    }
}


class NumerosJoin extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número: " + i);
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        Letras l = new Letras();
        NumerosJoin n = new NumerosJoin();
        Simbolos s = new Simbolos();

        l.start();
        n.start();
        s.start();

        try {
            l.join();
            n.join();
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Todos los hilos han terminado.");
    }
}
