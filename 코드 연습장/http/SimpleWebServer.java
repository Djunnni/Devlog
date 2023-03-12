package http;

import http.hanlder.RequestHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServer {
    public static void main(String[] args) {
        SimpleWebServer server = new SimpleWebServer();
        int port = 9000;
        server.run(port);
    }
    private void run(int port) {
        try(ServerSocket server = new ServerSocket(port)) {
            while(true) {
                Socket client = server.accept();
                RequestHandler handler = new RequestHandler(client);
                handler.run();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
