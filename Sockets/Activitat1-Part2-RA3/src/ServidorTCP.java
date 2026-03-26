import java.io.*;
import java.net.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServidorTCP {

    public static void main(String[] args) throws IOException {
        int puerto = 5000;
        ServerSocket server = new ServerSocket(puerto);
        System.out.println("Servidor escuchando en puerto " + puerto);

        // Bucle infinito
        while (true) {
            // Esperar al siguiente cliente
            Socket cliente = server.accept();
            // Cada cliente tiene su propio hilo
            Thread hilo = new Thread(new ManejadorCliente(cliente));
            hilo.start();
        }
        //server.close() lo quito para que no se apague el servidor
    }
}

// ManejadorCLiente se crea una instancia por cliente
class ManejadorCliente implements Runnable {

    private Socket socket;
    private String ip;

    public ManejadorCliente(Socket socket) {
        this.socket = socket;
        this.ip = socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
        System.out.println(" --- CONECTADO     " + ip);

        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String msg;
            while ((msg = in.readLine()) != null) {
                System.out.println(" --- MSG " + ip + " -> " + msg);
                if (msg.equalsIgnoreCase("bye")) {
                    out.println("bye");
                    break;
                } else if (msg.equalsIgnoreCase("time")) {
                    String hora = LocalTime.now()
                            .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                    out.println("Hora servidor: " + hora);
                } else {
                    out.println("Eco: " + msg);
                }
            }

        } catch (IOException e) {
            //si el cliente se cierra sin decir bye se ejecuta
            System.out.println(" --- ERROR " + ip + " -> " + e.getMessage());
        } finally {
            // si o si se ejecuta esto
            System.out.println(" --- DESCONECTADO  " + ip);
            try { socket.close(); } catch (IOException ignored) {}
        }
    }
}