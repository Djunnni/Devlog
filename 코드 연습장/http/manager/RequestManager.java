package http.manager;

import http.dto.RequestDto;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class RequestManager {
    private final int BUFFER_SIZE = 1024;
    Socket socket;

    public RequestManager(Socket socket) {
        this.socket = socket;
    }
    public RequestDto readRequest() throws Exception {
        RequestDto dto = new RequestDto();

        InputStream request = new BufferedInputStream(socket.getInputStream());
        byte[] receivedBytes = new byte[BUFFER_SIZE];
        request.read(receivedBytes);

        StringTokenizer st = new StringTokenizer(new String(receivedBytes).trim(), "\n");
        String requestInfo = st.nextToken(); // => GET / HTTP/1.1

        String[] parseData = requestInfo.split(" ");
        dto.setRequestMethod(parseData[0]);
        dto.setUri(parseData[1]);
        dto.setHttpVersion(parseData[2]);

        return dto;
    }
}
