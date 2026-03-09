public class Visitante extends Thread {

    private final String nombre;
    private final Acceso acceso;

    public Visitante(String nombre, Acceso acceso) {
        this.nombre = nombre;
        this.acceso  = acceso;
        // Si se apaga el main el visitante se apaga
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                acceso.entrar(nombre);
                long estancia = 1000 + (long)(Math.random() * 2000);
                Thread.sleep(estancia);

                acceso.salir(nombre);

                Thread.sleep(500 + (long)(Math.random() * 1000));

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}