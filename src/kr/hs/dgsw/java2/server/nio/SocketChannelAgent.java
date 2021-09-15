package kr.hs.dgsw.java2.server.nio;

import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class SocketChannelAgent {

    public SocketChannel socketChannel;

    private Thread listenerThread;

    public SocketChannelAgent(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    public void init() throws Exception {
        listenerThread = new Thread(new Listener());
        listenerThread.setDaemon(true);
        listenerThread.start();
    }

    public void send(String message) throws Exception {
        Charset charset = Charset.forName("UTF-8");
        ByteBuffer buffer = charset.encode(message);
        buffer.flip();

        socketChannel.write(buffer);
    }

    public void receive(String message) {
        try {
            send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class Listener implements Runnable {
        @Override
        public void run() {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            byte[] bytes = new byte[1024];

            int length;

            try {
                while (true) {
                    length = socketChannel.read(buffer);

                    if (length < 0) {
                        break;
                    }

                    buffer.flip();
                    Charset charset = Charset.forName("UTF-8");
                    String message = charset.decode(buffer).toString();

                }
            } catch (Exception e) {

            }
        }
    }
}
