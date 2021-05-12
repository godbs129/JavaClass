package kr.hs.dgsw.java.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileReader {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/haeyoon/Desktop/DGSW/test.txt");
            InputStream is = new FileInputStream(file);

            while(is.available() > 0) {
                int value = is.read();
                char ch = (char)value;
                System.out.println(value + " " + ch);
            }
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
