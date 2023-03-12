package http;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerInitial {
    private final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        SimpleWebServerInitial server = new SimpleWebServerInitial();
        int port = 9000;
        server.start(port);
    }

    private void start(int port) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            while(true) {
                Socket socket = server.accept();
                InputStream request = new BufferedInputStream(socket.getInputStream());
                byte[] receivedBytes = new byte[BUFFER_SIZE];
                request.read(receivedBytes);
                String requestData = new String(receivedBytes).trim();

                System.out.println("Request Data=\n"+requestData);
                System.out.println("===========");

                PrintStream response = new PrintStream(socket.getOutputStream());
                response.println("HTTP/1.1 200 OK");
                response.println("Content-type: text/html");
                response.println();
                response.println("It is working");
                response.flush();
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(server != null) {
                try {
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }



}
