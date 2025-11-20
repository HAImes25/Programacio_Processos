public class Saludo extends Thread{
    public Saludo() {
        saludarProfesor();
        saludarAlumno();

    }

    private boolean profesorHaSaludado = false;

    public synchronized void saludarProfesor(){
        System.out.println("Buenos días, alumnos.");
        profesorHaSaludado = true;
        notify();
    }

    public synchronized void saludarAlumno(){
        while (!profesorHaSaludado) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }

        }

        System.out.println("Buenos días, profesor.");
    }


}
