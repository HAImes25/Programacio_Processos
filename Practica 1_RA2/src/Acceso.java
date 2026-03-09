public class Acceso {

    private boolean puertaAbierta = false;
    private boolean controlActivo = false;
    private int dentro = 0;

    public synchronized void entrar(String nombre) throws InterruptedException {
        System.out.println("Entrando a entrar() [" + nombre + "]");

        while (!puertaAbierta || controlActivo) {
            System.out.println(nombre + " espera…");
            wait();
        }

        dentro++;
        System.out.println(nombre + " entra  (dentro=" + dentro + ")");
        System.out.println(" ----- Saliendo de entrar() [" + nombre + "]");
    }


    public synchronized void salir(String nombre) {
        System.out.println(" ----- Entrando a salir() [" + nombre + "]");

        if (dentro > 0) dentro--;
        System.out.println(nombre + " sale   (dentro=" + dentro + ")");

        System.out.println(" ----- Saliendo de salir() [" + nombre + "]");
    }



    public synchronized void abrirPuerta() {
        System.out.println(" ----- Entrando a abrirPuerta()");

        puertaAbierta = true;
        System.out.println("  *** Puerta abierta ***");
        notifyAll();

        System.out.println(" ----- Saliendo de abrirPuerta()");
    }



    public synchronized void cerrarPuerta() {
        System.out.println(" ----- Entrando a cerrarPuerta()");

        puertaAbierta = false;
        System.out.println("  *** Puerta cerrada ***");

        System.out.println(" ----- Saliendo de cerrarPuerta()");
    }



    public synchronized void activarControl() {
        System.out.println(" ----- Entrando a activarControl()");

        controlActivo = true;
        System.out.println("  *** Control activado ***");

        System.out.println(" ----- Saliendo de activarControl()");
    }


    public synchronized void desactivarControl() {
        System.out.println(" ----- Entrando a desactivarControl()");

        controlActivo = false;
        System.out.println("  *** Control desactivado ***");
        notifyAll();

        System.out.println(" ----- Saliendo de desactivarControl()");
    }


    public synchronized int getDentro() {
        return dentro;
    }
}