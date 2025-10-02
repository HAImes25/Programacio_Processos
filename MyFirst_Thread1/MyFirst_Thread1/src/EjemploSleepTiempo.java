import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EjemploSleepTiempo {
    public static void main(String[] args) {
        // Formato de hora con segundos
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        for (int i = 1; i <= 50; i++) {
            // Obtenemos la hora actual
            String hora = LocalTime.now().format(formato);

            System.out.println("Número: " + i + " (Hora: " + hora + ")");

            try {
                // Dormimos 1 segundo (1000 ms)
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("¡Fin del programa!");
    }
}


