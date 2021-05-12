package kr.hs.dgsw.java.file;

import java.io.File;
import java.util.Date;

public class FileStudy {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/haeyoon/Desktop/DGSW/test.txt");
            boolean exist = file.exists();

            System.out.println(exist);

            file = new File("/Users/haeyoon/Desktop/DGSW/abc.txt");
            boolean result = file.createNewFile();
            System.out.println(result);

            file = new File("/Users/haeyoon/Desktop/DGSW/abc.txt");
            boolean res = file.createNewFile();
            System.out.println(res);
            file.delete();

            File dir = new File("/Users/haeyoon/Desktop/DGSW/sub");
            result = dir.mkdir();
            System.out.println(result);

            dir.delete();

            System.out.println(dir.isFile());
            System.out.println(dir.isDirectory());

            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length());
            System.out.println(file.lastModified());
            long lastModified = file.lastModified();
            Date date = new Date(lastModified);
            System.out.println(date);

            String parent = file.getParent();
            System.out.println(parent);

            System.out.println("----list----");
            dir = new File("Users/haeyoon/Desktop/DGSW");
            File[] list = dir.listFiles();
            for(File file1 : list) {
                System.out.println(file1.getName());
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
