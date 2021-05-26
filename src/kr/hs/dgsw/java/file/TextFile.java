package kr.hs.dgsw.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class TextFile {
    public String read(String filePath)
        throws Exception{
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);

        BufferedReader reader = new BufferedReader(fileReader);

        String result = "";
        while(true) {
            String line = reader.readLine();
            if(line == null) {
                break;
            }
            result += line + "\n";
        }

        reader.readLine();

        reader.close();

        return result;
    }

    public void write(String filePath, String content)
            throws Exception {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        writer.write(content);

        writer.close();
    }

    public static void main(String[] args) {
        try {
            TextFile textFile = new TextFile();
            String contents = textFile.read("/Users/haeyoon/Desktop/DGSW/zzz.txt");
            System.out.println(contents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
