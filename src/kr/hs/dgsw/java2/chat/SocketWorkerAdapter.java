package kr.hs.dgsw.java2.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public abstract class SocketWorkerAdapter implements SocketWorker {

    protected Socket socket;

    protected InputStream is;
    protected OutputStream os;

    protected Thread listenerThread;

    public List<String> list = new ArrayList<>();

    public boolean isFirst = false;

    @Override
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void prepareTalking() throws IOException {
        this.is = socket.getInputStream();
        this.os = socket.getOutputStream();

        Listener listener = new Listener();
        listenerThread = new Thread(listener);
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    @Override
    public abstract void startTalking() throws IOException;

    public void listen(String head, String payload) throws IOException {

        switch (head) {
            case "UR":
                UR(payload);
                break;
            case "JR":
                JR(payload);
                break;
            case "GR":
                GR(payload);
                break;
            case "SR":
                SR(payload);
                break;
            case "DC":
                DC(payload);
                break;
            case "WA":
                WA(payload);
            default:
                break;
        }
    }

    public void listen(String head) {
        switch (head) {
            case "DR":
                DR();
            case "WR":
                WR();
            default:
                break;
        }
    }

    public void WA(String payload) {
        System.out.println(payload + "님이 추방당했습니다");
    }

    public void WR() {
        System.out.println("방장에 의해 추방당했습니다");
        System.exit(0);
    }

    public void DR() {
        System.out.println("이미 존재하는 ID입니다");
        System.exit(0);
    }

    public void DC(String payload) {
        System.out.println(payload + "님이 퇴장하였습니다");
    }

    public void SR(String payload) {
        int findUser = findUser(payload.substring(0, 4));
        System.out.println(payload.substring(0, 4));

        if (findUser == -1) {
            System.out.println("없는 유저입니다");
        }

        String user = list.get(0);
        System.out.println(user + "님의 귓속말: " + payload.split(" ")[2]);
    }

    public int findUser(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).substring(0, 4).equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public void GR(String payload) {
        System.out.println(payload);
    }

    public void JR(String payload) {
        System.out.println(payload + "님이 입장했습니다.");
        list.add(payload);
    }

    public void UR(String payload) {
        for (int i = 0; i < payload.split(",").length; i++) {
            list.add(payload.split(",")[i]);
        }

        System.out.print("현재 접속한 사람:");
        for (String idx : list) {
            System.out.print(idx + ", ");
        }
        System.out.println("\n");
    }

    public String getUserList() {
        for (String idx : list) {
            return idx;
        }
        return null;
    }

    @Override
    public void disconnect() throws IOException {
        if (is != null) {
            is.close();
        }

        if (os != null) {
            os.close();
        }
    }

    private class Listener implements Runnable {
        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int length;

            try {
                while (true) {

                    length = is.read(buffer);
                    String message = new String(buffer, 0, length);
                    String head = message.substring(0, 2);

                    if (message.length() > 6) {
                        String payload = message.substring(6);
                        listen(head, payload);
                    }
                    listen(head);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
