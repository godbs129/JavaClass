package kr.hs.dgsw.java.tryCatch;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryStudy {
    public static int divide() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("두 정수를 입력하세요");
            int value1 = sc.nextInt();
            int value2 = sc.nextInt();

            System.out.println(String.format("%d / %d = %d", value1, value2, (value1 / value2)));


            return value1 / value2;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("정수 입력 하셈");
        } catch (Exception e) {
            System.out.println("잘못된 입력");
        } finally {
           sc.close();
        }

        throw new RuntimeException();
    }

    public static void readFile1() {
        try {
            File file = new File("/Users/haeyoon/Desktop/text.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String firstLine = reader.readLine();
            System.out.println(firstLine);

            reader.close();
        } catch(FileNotFoundException e)  {

        } catch (IOException e) {

        }
    }
    public static void readFile2() throws FileNotFoundException, IOException{


        File file = new File("/Users/haeyoon/Desktop/text.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        String firstLine = reader.readLine();
        System.out.println(firstLine);

        reader.close();
    }

    public static void method1() throws Exception{
        Exception e = new Exception("샘플 예외");
        throw e;
    }
    public static void method2() throws RuntimeException{
        RuntimeException e = new RuntimeException();
        throw e;
    }

    public static void main(String[] args) {
        divide();

        try {
            method1();
            method2();
        } catch (Exception e) {

        }

    }
}
