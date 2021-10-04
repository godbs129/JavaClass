package kr.hs.dgsw.java2.chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServerWorker implements SocketWorker {
    protected Socket socket;

    protected InputStream is;
    protected OutputStream os;

    protected Thread listenerThread;

    private static List<Socket> sockets = new ArrayList<>();

    private static UserList list = new UserList();

    String name;

    @Override
    public void setSocket(Socket socket) {
        this.socket = socket;
        System.out.println(socket.getInetAddress().toString() + " 연결");
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
    public void startTalking() throws IOException {

        sockets.add(this.socket);
    }

    public void listen(String head, String payload) throws IOException {

        switch (head) {
            case "ID":
                ID(payload);
                break;
            case "GM":
                GM(payload);
                break;
            case "SM":
                SM(payload);
                break;
            case "DC":
                DC();
            case "WD":
                WD(payload);
            default:
                break;
        }
    }

    public void DC() throws IOException {
        for (Socket idx : sockets) {
            OutputStream os = idx.getOutputStream();
            String id = name.substring(0, 4);
            os.write(("DC" + String.format("%04d", id.getBytes().length) + id).getBytes());
        }
        List<String> users = list.getUserList();

        int idx = forr(users, name.substring(0, 4));
        users.remove(idx);
    }

    public void WD(String payload) throws IOException {
        List<String> users = list.getUserList();
        if (users.get(0).equals(name)) {
            int idx = forr(users, payload);

            Socket kickUser = sockets.get(idx);
            OutputStream kickOS = kickUser.getOutputStream();

            kickOS.write(("WR" + "0000").getBytes());

            users.remove(idx);

            WA(payload);
        }

    }

    public void WA(String payload) throws IOException {
        for (Socket socket : sockets) {
            OutputStream os = socket.getOutputStream();
            os.write(("WA" + String.format("%04d", payload.getBytes().length) + payload).getBytes());
        }
    }

    public void ID(String payload) throws IOException {
        List<String> users = list.getUserList();
        for (String idx : users) {
            if (idx.equals(payload)) {
                OutputStream os = socket.getOutputStream();
                String message = "DR" + "0000";
                os.write(message.getBytes());
                return;
            }
        }
        list.setUserList(payload);
        System.out.println(list.getUserList());
        UR();
        name = payload;
        JR(payload);
    }

    public void UR() throws IOException {
        List<String> users = list.getUserList();
        String user = "";
        int size = users.size();

        int i = 0;
        while (i < size) {
            user += users.get(i) + ",";

            if (i + 1 == size) {
                user = user.substring(0, user.length() - 1);
                String message = "UR" + String.format("%04d", user.getBytes().length) + user;
                os.write(message.getBytes());
            }
            i++;
        }
        System.out.println("1" + user);
    }

    public void JR(String name) throws IOException {
        for (Socket so : sockets) {
            OutputStream os = so.getOutputStream();
            String message = "JR" + String.format("%04d", name.getBytes().length) + name;
            os.write(message.getBytes());
        }
    }

    public void GR(String payload) throws IOException {
        for (Socket so : sockets) {
            OutputStream os = so.getOutputStream();
            if (so != socket) {
                String msg = name.split(" ")[0] + payload;
                os.write(("GR" + String.format("%04d", msg.getBytes().length) + msg).getBytes());
            }
        }
    }

    public void GM(String payload) throws IOException {
        System.out.println(name + ": " + payload);
        GR(payload);
    }

    public void SM(String payload) throws IOException {
        OutputStream os = socket.getOutputStream();
        List<String> users = list.getUserList();
        String to = payload.substring(0, 4);
        String msg = payload.substring(4, payload.length());
        String from = name.substring(0,4) + msg;

        int idx = forr(users, to);
        if (idx == -1) {
            os.write(("존재하지 않는 유저입니다").getBytes());
        }

        Socket toUser = sockets.get(idx);
        OutputStream out = toUser.getOutputStream();
        String message = "SR" + String.format("%04d", from.getBytes().length) + from;
        out.write(message.getBytes());
    }

    public int forr(List<String> users, String to) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).split(" ")[0].equals(to)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void disconnect() throws IOException {

        if (is != null) is.close();
        if (os != null) os.close();
        if (socket != null) {
            socket.close();
            sockets.remove(socket);
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
                    String payloadLength = message.substring(2, 6);
                    String payload = message.substring(6);
                    listen(head, payload);
                }
            } catch (SocketException e) {
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
