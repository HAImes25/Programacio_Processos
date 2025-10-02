public class HiloInPar extends Thread{
    // El constructor pide el nombre
    public HiloInPar(String name) {
        super(name);
    }

    @Override
    public void run() {
        // mostrar los numeros pares del 1 al 20
        for (int i = 1; i < 20; i +=2) {
            System.out.println(getName() + i);
            i++;
            //System.out.println(Thread.currentThread().getName() + "Soy el proceso " + (i+1));
        }

    }
}
