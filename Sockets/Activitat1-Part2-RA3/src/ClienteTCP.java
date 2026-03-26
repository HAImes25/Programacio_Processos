import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteTCP {

    public static void main(String[] args) throws IOException {
        String ip     = "127.0.0.1";
        int    puerto = 5000;

        Socket socket = new Socket(ip, puerto);
        System.out.println("Conectado al servidor " + ip + ":" + puerto);
        System.out.println("Comandos disponibles: bye | time | <cualquier texto>");

        BufferedReader in      = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter    out     = new PrintWriter(socket.getOutputStream(), true);
        Scanner        teclado = new Scanner(System.in);

        while (true) {
            System.out.print("Tú: ");
            String mensaje = teclado.nextLine();

            out.println(mensaje);

            String respuesta = in.readLine();
            System.out.println("Servidor: " + respuesta);

            if (mensaje.equalsIgnoreCase("bye")) {
                break;
            }
        }

        teclado.close();
        socket.close();
        System.out.println("Conexión cerrada.");
    }
}
