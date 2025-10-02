public class Hilo extends Thread{

    // El constructor pide el nombre
    public Hilo(String name) {
        super(name);
    }

    @Override
    public void run() {
        // hacer que el hilo arranque y mostrar un mensaje 5 veces con unn sleep
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "Soy el proceso " + (i+1));
        }

    }
}
