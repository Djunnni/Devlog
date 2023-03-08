package network;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;

public class SocketClientSample {
    public static void main(String[] args) {
        SocketClientSample sample = new SocketClientSample();
        sample.sendSocketSample();
    }

    private void sendSocketSample() {
        for(int loop = 0; loop < 3; loop++) {
            sendSocketData("i like java at " + new Date());

        }
        sendSocketData("EXIT");
    }

    private void sendSocketData(String str) {
        Socket socket = null;
        try {
            System.out.println("Client:connecting");
            socket = new Socket("127.0.0.1", 9999);
            System.out.println("Client: Connect status " + socket.isConnected());
            Thread.sleep(1000);
            OutputStream stream = socket.getOutputStream();
            BufferedOutputStream out = new BufferedOutputStream(stream);
            byte[] bytes = str.getBytes();
            out.write(bytes);

            System.out.println("Client send data");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(socket != null) {
                try
                {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
