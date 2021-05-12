package kr.hs.dgsw.java.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileWriter {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/haeyoon/Desktop/DGSW/zzz.txt");
            OutputStream os = new FileOutputStream(file);

            os.write(49);
            os.write(65);
            os.write(105);

            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
