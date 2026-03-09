import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Acceso acceso = new Acceso();

        // Crear visitantes
        int NUM_VISITANTES = 5;
        for (int i = 1; i <= NUM_VISITANTES; i++) {
            new Visitante("Visitante-" + i, acceso).start();
        }

        // Crear guardia
        new Guardia(acceso).start();

        // Menú principal
        Scanner sc = new Scanner(System.in);
        boolean ejecutando = true;
        while (ejecutando) {

            System.out.println("------------------------------------------------------------");
            System.out.println("1. Abrir puerta");
            System.out.println("2. Cerrar puerta");
            System.out.println("3. Activar control");
            System.out.println("4. Desactivar control");
            System.out.println("5. Visitantes dentro ");
            System.out.println("6. Salir");
            System.out.println("------------------------------------------------------------");
            System.out.print("Opción: ");

            String linea = sc.nextLine().trim();

            switch (linea) {
                case "1":
                    acceso.abrirPuerta();
                    break;
                case "2":
                    acceso.cerrarPuerta();
                    break;
                case "3":
                    acceso.activarControl();
                    break;
                case "4":
                    acceso.desactivarControl();
                    break;
                case "5":
                    System.out.println("  Visitantes dentro ahora: " + acceso.getDentro());
                    break;
                case "6":
                    ejecutando = false;
                    System.out.println("  Saliendo del programa…");
                    break;
                default:
                    System.out.println("  Opción no válida. Introduce un número del 1 al 6.");
            }
        }

        sc.close();
        System.exit(0);
    }
}