package kr.hs.dgsw.java2.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    public ServerSocket serverSocket;

    public static final String SERVER_ADDRESS = "localhost";
    public static final int PORT = 8000;

    public void startServer() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("소켓 생성");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket.getInetAddress().toString());
        }
    }

    public static void main(String[] args) {
        try {
            ServerTest server = new ServerTest();
            server.startServer();
        } catch (Exception e) {

        }
    }
}
