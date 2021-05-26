package kr.hs.dgsw.java.file;

import java.io.File;
import java.util.Scanner;

public class Console {
    private String dirpath = "/Users/haeyoon";

    public void nowDir() throws Exception {
        System.out.print(this.dirpath + " >  ");
    }

    public void ls() throws Exception {
        File dir = new File(this.dirpath);
        File[] files = dir.listFiles();

        for (File file : files) {
            System.out.println(file);
        }
    }

    public void cd(String path) throws Exception {
        if (path.equals("..")) {
            this.dirpath = this.dirpath.substring(0, this.dirpath.lastIndexOf("/"));
            return;
        }

        String newPath = this.dirpath + "/" + path;
        File dir = new File(newPath);

        if (dir.isDirectory()) {

            this.dirpath = newPath;
        } else {

            System.out.println("없는 경로입니다");
        }
    }

    public void touch(String name) throws Exception {
        File file = new File(this.dirpath + "/" + name);

        if (file.exists()) {
            System.out.println("이미 존재하는 파일");
        } else {
            file.createNewFile();
        }
    }

    public void rm(String name) throws Exception {
        File file = new File(this.dirpath + "/" + name);

        if (file.exists()) {
            file.delete();
        } else {
            System.out.println("파일이 존재하지 않습니다");
        }
    }

    public void mkdir(String name) throws Exception {
        File dir = new File(this.dirpath + "/" + name);

        if(dir.exists()) {
            System.out.println("이미 존재하는 디렉토리");
        } else {
            dir.mkdir();
        }
    }

    public void rmdir(String name) throws Exception {
        File dir = new File(this.dirpath + "/" + name);

        if(dir.exists()) {
            dir.delete();
        } else {
            System.out.println("존재하지 않는 디렉토리");
        }
    }

    public static void main(String[] args) {
        Console con = new Console();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {
                con.nowDir();
                String command = sc.nextLine();
                String[] commandSplit = command.split(" ");

                switch (commandSplit[0]) {
                    case "ls":
                        con.ls();
                        break;
                    case "cd":
                        con.cd(commandSplit[1]);
                        break;
                    case "touch":
                        con.touch(commandSplit[1]);
                        break;
                    case "rm":
                        con.rm(commandSplit[1]);
                        break;
                    case "mkdir":
                        con.mkdir(commandSplit[1]);
                        break;
                    case "rmdir":
                        con.rmdir(commandSplit[1]);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
