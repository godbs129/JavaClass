package kr.hs.dgsw.java2.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BroadCastServerWorker extends SocketWorkerAdapter{

    private static List<Socket> sockets = new ArrayList<>();

    @Override
    public void startTalking() throws IOException {

        sockets.add(this.socket);
    }

    @Override
    public void listen(String message) throws IOException {

        for(Socket socket: sockets) {
            OutputStream os = socket.getOutputStream();
            os.write(message.getBytes());
        }
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
}
