public class HiloInPar extends Thread{
    // El constructor pide el nombre
    public HiloInPar(String name) {
        super(name);
    }

    @Override
    public void run() {
        // mostrar los numeros impares del 1 al 19
        for (int i = 1; i <= 19; i += 2) {
            //System.out.println(getName() + i);
            //System.out.println(Thread.currentThread().getName() + "Soy el proceso " + (i));
        }

    }
}
