package kr.hs.dgsw.java2.server;

import java.io.IOException;
import java.net.Socket;

public class ClientTest {

    private Socket socket;

    private static final String SERVER_ADDRESS = "localhost";
    private static final int PORT = 8000;

    public void connect() throws IOException {
        socket = new Socket(SERVER_ADDRESS, PORT);
        System.out.println(socket.isConnected());

        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ClientTest client = new ClientTest();
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}