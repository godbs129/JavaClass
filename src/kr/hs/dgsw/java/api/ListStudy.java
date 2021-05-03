package kr.hs.dgsw.java.api;

import java.util.ArrayList;
import java.util.List;

public class ListStudy {
    public static void printAll(List<String> list) {

        for (int i = 0; i < list.size(); i ++) {

            System.out.println(i + " : " + list.get(i));
        }
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("ㅎㅇ");
        list.add("ㅎㅎㅇ");
        list.add("ㅎㅎㅎㅇ");

        printAll(list);

        System.out.println("-----------------------");
        list.add(2, "ㅎㅇㅎㅇ");
        list.remove(3);
        printAll(list);
    }
}
