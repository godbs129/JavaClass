package kr.hs.dgsw.java2.chat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;

    public static final int PORT = 1200;

    public List<String> list = new ArrayList<>();

    public void startServer() {
        try {

            while (true) {
                serverSocket = new ServerSocket(PORT);
                System.out.println("Server start");
                while (true) {
                    Socket socket = serverSocket.accept();

                    Agent agent = new Agent(socket);
                    new Thread(agent).start();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Agent implements Runnable {

        private Socket socket;

        public Agent(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                SocketWorker socketWorker = new ServerWorker();
                socketWorker.setSocket(socket);
                socketWorker.prepareTalking();
                socketWorker.startTalking();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
