// Server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started...");
        Socket socket = server.accept();
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        output.println("Welcome to the server!");

        String msg;
        while ((msg = input.readLine()) != null) {
            System.out.println("Client: " + msg);
            output.println("Echo: " + msg);
        }
        socket.close();
        server.close();
    }
}
// Client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Server says: " + input.readLine());

        String msg;
        while ((msg = console.readLine()) != null) {
            output.println(msg);
            System.out.println("Server: " + input.readLine());
        }
        socket.close();
    }
}
