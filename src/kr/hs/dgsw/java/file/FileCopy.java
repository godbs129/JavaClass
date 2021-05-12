package kr.hs.dgsw.java.file;

import java.io.*;

public class FileCopy {
    public void copy(String source, String target)
        throws Exception{
        long before = System.currentTimeMillis();
        File sourceFile = new File(source);
        File targetFile = new File(target);

        InputStream is = new FileInputStream(sourceFile);
        OutputStream os = new FileOutputStream(targetFile);

        byte[] buffer = new byte[1024];

        while(is.available() > 0) {
            int value = is.read();
            os.write(buffer, 0, buffer.length);
        }
        is.close();
        os.close();

        long after = System.currentTimeMillis();
        System.out.println((after - before));
    }

    public static void main(String[] args) {
        FileCopy copy = new FileCopy();

        try {
            copy.copy("/Users/haeyoon/Desktop/DGSW/test.txt", "/Users/haeyoon/Desktop/DGSW/zzz.txt");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
