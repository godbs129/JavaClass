package kr.hs.dgsw.java;

public class charStudy {
    public static void main(String[] args) {
        char a = 65;
        char b = 'a';
        int c= b + 0;
        char d = '가';

        System.out.println(a);
        System.out.println(b + " " + c);
        System.out.println(d + " " + ((int)d));

//        for(char i = '가'; i < '나'; i++) {
//            System.out.println(i + " " + (int)i);
//        }

        System.out.println("지원되는 한그르이 개수 : " + ('힣' - '가' + 1));
    }
}
