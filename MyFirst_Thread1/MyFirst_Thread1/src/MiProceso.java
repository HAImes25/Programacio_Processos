public class MiProceso extends Thread  {

    // ver docs, oracle.
    //Tiene varios constructores, pero tiene un metodo muy importante, que es le metodo run, cuando nosotros creemos un
    //proceso, se llama automaticamente a este metodo, el metodo run.

    // boton derecho, Generate...etc
    @Override
    public void run() {
        super.run();
        System.out.println(Thread.currentThread().getName()+"Soy el proceso");
    }

    //Constructor para darle nombre a mi proceso para identificarlo donde esta.
    public MiProceso(String name) {
        super(name);
    }
    //Ahora vamos a crear un proceso en la clase padre

    //Cada vez que ejecitemos, puede salir en una posición diferente, segun como este cargada la CPU
    //Complejo ver la trazabilidad de un progrma de procesos, ni cuanto tiempo dura...

}
