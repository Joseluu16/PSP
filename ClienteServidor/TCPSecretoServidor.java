
package ClienteServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPSecretoServidor {
     public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2000);
            System.out.println("Servidor esperando conexiones en el puerto 2000...");

            // Generar un número secreto aleatorio entre 0 y 100
            Random random = new Random();
            int numeroSecreto = random.nextInt(101);

            // Aceptar la conexión del cliente
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            // Flujo de entrada y salida para comunicarse con el cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            int intentos = 0;
            boolean adivinado = false;

            while (!adivinado) {
                // Leer el número enviado por el cliente
                int numeroCliente = Integer.parseInt(in.readLine());

                // Incrementar el contador de intentos
                intentos++;

                // Comparar el número del cliente con el número secreto
                if (numeroCliente < numeroSecreto) {
                    out.println("Menor");
                } else if (numeroCliente > numeroSecreto) {
                    out.println("Mayor");
                } else {
                    out.println("Adivinaste");
                    adivinado = true;
                }
            }

            System.out.println("Número secreto adivinado en " + intentos + " intentos");

            // Cerrar conexiones
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
