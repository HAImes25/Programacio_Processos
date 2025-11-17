class Numeros extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Número: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Main3 {
    public static void main(String[] args) {
        Numeros n = new Numeros();
        n.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("Mensaje desde main: " + i);
        }
    }
}
