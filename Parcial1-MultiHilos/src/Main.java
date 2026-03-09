public class Main {
    public static void main(String[] args) {
        Impresora impresora = new Impresora();


        Thread t1 = new Thread(new Empleado("Ruben", impresora));
        Thread t2 = new Thread(new Empleado("Jose", impresora));
        Thread t3 = new Thread(new Empleado("Maria", impresora));
        Thread t4 = new Thread(new Empleado("Pedro", impresora));
        Thread t5 = new Thread(new Empleado("Pol", impresora));


        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();



    }


}
class Impresora{
    boolean ocupada = false;
    public Impresora() {
        this.ocupada = false;
    }



    synchronized void imprimir(String nombreEmpleado){
        //Esperar a que la impresora no este ocupada y hacer
        System.out.println(nombreEmpleado + " QUIERE IMPRIMIR");
        while (ocupada) {
            System.out.println("Impresora ocupada. " + nombreEmpleado + " espera...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ocupada = true;
        System.out.println(nombreEmpleado + " empieza a imprimir");
        System.out.println(nombreEmpleado + " termina de imprimir");
        System.out.println("Impresora libre, avisando a los empleados");
        System.out.println("");
        ocupada = false;
        notifyAll();
    }

}
class Empleado extends Thread{
    private String nombre;
    private Impresora impresora;

    public Empleado(String nombre, Impresora impresora) {
        this.nombre = nombre;
        this.impresora = impresora;
    }
    @Override
    public void run() {
        impresora.imprimir(nombre);
    }

}


