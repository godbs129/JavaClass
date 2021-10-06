package kr.hs.dgsw.java2.chat;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client extends SocketWorkerAdapter {

    String name;

    public void connect(String address, int port) throws IOException {
        this.socket = new Socket(address, port);
    }

    @Override
    public void startTalking() throws IOException {
        Scanner sc = new Scanner(System.in);

        getUserList();
        System.out.print("ID와 이름을 입력하세요: ");
        while (true) {
            if (socket.isConnected()) {

                String line = sc.nextLine();

                if (!isFirst && !line.matches("^[a-zA-Z0-9ㄱ-ㅏ-가-힣]+.*$")) {
                    System.out.println("이름에 특수문자 사용이 불가능합니다");
                    continue;
                }

                if (!isFirst) {
                    this.os.write(("ID" + String.format("%04d", line.getBytes().length) + line).getBytes());
                    isFirst = true;
                    name = line;
                } else {
                    if ("/quit".equals(line)) {
                        this.os.write(("DC" + name.substring(0, 4).getBytes().length + name).getBytes());
                        socket.close();
                        break;
                    } else if ("/w".equals(line)) {
                        System.out.print("귓속말할 상대를 입력하세요: ");
                        String to = sc.nextLine();
                        System.out.print("메시지를 입력하세요: ");
                        String msg = sc.nextLine();

                        String message = to + msg;
                        this.os.write(("SM" + String.format("%04d", message.getBytes().length) + message).getBytes());
                    } else if ("/k".equals(line)) {
                        System.out.print("추방할 사람의 아이디를 입력하세요: ");
                        String id = sc.nextLine();

                        this.os.write(("WD" + String.format("%04d", id.getBytes().length) + id).getBytes());
                    } else {
                        this.os.write(("GM" + String.format("%04d", line.getBytes().length) + line).getBytes(StandardCharsets.UTF_8));
                    }
                }

            } else {
                socket.close();
            }
        }

        os.close();
        sc.close();
        disconnect();
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.connect("127.0.0.1", 1200);
            client.prepareTalking();
            client.startTalking();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
