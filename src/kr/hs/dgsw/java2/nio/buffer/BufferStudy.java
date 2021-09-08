package kr.hs.dgsw.java2.nio.buffer;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class BufferStudy {

    public static void studyBuffer() throws Exception {
        ByteBuffer buffer1 = ByteBuffer.allocate(10);

        byte[] bytes = new byte[]{1, 2, 3, 4, 5};
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);

        printStatus(buffer1, "buffer1");
        printStatus(buffer2, "buffer2");

        // buffer1에 추가한다
        buffer1.put((byte) 55);
        buffer1.put((byte) -12);
        printStatus(buffer1, "buffer1 +2byte");

        buffer1.put(new byte[]{15, 16, 17, 18});
        printStatus(buffer1, "buffer1 +4byte");

        byte value = buffer2.get();
        System.out.println("result : " + value);
        printStatus(buffer2, "buffer2 read 1byte");

        byte[] bytes1 = new byte[3];
        buffer2.get(bytes1);
        printStatus(buffer2, "buffer2 read 3byte");

        printStatus(buffer1, "before flip");
        buffer1.flip();
        printStatus(buffer1, "after flip");
        value = buffer1.get();
        System.out.println("value : " + value);
        printStatus(buffer1, "buffer1 read 1byte");

        printStatus(buffer1, "before rewind buffer1");
        buffer1.rewind();
        printStatus(buffer1, "after rewind buffer1");

//        printStatus(buffer1, "before clear");
//        buffer1.clear();
//        printStatus(buffer1, "after clear");

        buffer1.get(bytes1);
        printStatus(buffer1, "state buffer1");
        buffer1.mark();

        buffer1.get();
        printStatus(buffer1, "before reset buffer1");
        buffer1.reset();
        printStatus(buffer1, "after reset buffer1");

        printStatus(buffer1, "before compact");
        buffer1.compact();
        printStatus(buffer1, "after compact");
        buffer1.rewind();
        printStatus(buffer1, "after rewind");
        value = buffer1.get();
        System.out.println("value : " + value);
    }

    public static void printStatus(Buffer buffer, String note) {
        System.out.println(String.format("%s %d %d %d", note, buffer.position(), buffer.limit(), buffer.capacity()));
    }

    public static void main(String[] args) {
        try {
            studyBuffer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
