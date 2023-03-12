package http.hanlder;

import http.dto.RequestDto;
import http.manager.RequestManager;
import http.manager.ResponseManager;

import java.net.Socket;

public class RequestHandler extends Thread {
    Socket socket;
    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            RequestManager manager = new RequestManager(socket);
            RequestDto request = manager.readRequest();

            ResponseManager responseManager = new ResponseManager(socket, request);
            responseManager.writeResponse();

        } catch(Exception e) {
            System.out.println("사용자 요청에서 예외가 발생했습니다.");
            e.printStackTrace();
        }

    }
}
