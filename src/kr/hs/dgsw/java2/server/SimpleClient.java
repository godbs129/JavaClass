package kr.hs.dgsw.java2.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SimpleClient {
    private Scanner sc;

    private Socket socket;

    private InputStream is;
    private OutputStream os;

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 8000;

    public void connect() throws IOException {
        socket = new Socket(SERVER_ADDRESS, PORT);
    }

    public void disconnect() throws Exception {
        if (is != null) {
            is.close();
        }
        if (os != null) {
            os.close();
        }
        if (socket != null) {
            socket.close();
        }
    }

    public void prepareTalking() throws Exception {
        is = socket.getInputStream();
        os = socket.getOutputStream();
    }

    public void startTalking() throws Exception {
        String message = "Hello";
        byte[] bytes = message.getBytes();

        os.write(bytes);
        os.flush();
    }

    public void sendMessage(String message) throws Exception {
        byte[] bytes = message.getBytes();

        os.write(bytes);
    }

    public void sendMessage(int value1, int value2) throws Exception {
        byte[] bytes = new byte[8];
        bytes[0] = (byte)(value1 & 0x000000FF);
        bytes[1] = (byte)((value1 >> 8) & 0x000000FF);
        bytes[2] = (byte)((value1 >> 16) & 0x000000FF);
        bytes[3] = (byte)((value1 >> 24) & 0x000000FF);
        bytes[4] = (byte)(value2 & 0x000000FF);
        bytes[5] = (byte)((value2 >> 8) & 0x000000FF);
        bytes[6] = (byte)((value2 >> 16) & 0x000000FF);
        bytes[7] = (byte)((value2 >> 24) & 0x000000FF);


        os.write(bytes);
    }

    public String receiveMessage() throws Exception {
        byte[] buffer = new byte[1024];
        int length = is.read(buffer);

        return new String(buffer, 0, length);
    }

    public void processUserInput() throws Exception {
        sc = new Scanner(System.in);
        int value1;
        int value2;

        while (true) {
            value1 = sc.nextInt();
            value2 = sc.nextInt();

            if(value1 == 0 && value2 == 0) {
                break;
            }

            String message = String.format("%d, %d", value1, value2);

            sendMessage(message);

            String returnMessage = receiveMessage();
            System.out.println("받은 메시지 : " + returnMessage);
        }

        sc.close();
    }

    public static void main(String[] args) {
        try {
            SimpleClient client = new SimpleClient();
            client.connect();
            client.prepareTalking();
            client.processUserInput();
//            client.startTalking();
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
