public class Guardia extends Thread {

    private final Acceso acceso;
    private static final long CICLO = 5000;

    public Guardia(Acceso acceso) {
        this.acceso = acceso;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                acceso.activarControl();
                Thread.sleep(CICLO);

                acceso.desactivarControl();
                Thread.sleep(CICLO);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}