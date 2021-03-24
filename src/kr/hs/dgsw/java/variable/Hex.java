package kr.hs.dgsw.java.variable;

import java.util.Scanner;

public class Hex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int intValue = sc.nextInt();

        String hex = convertToHexString(intValue);
        System.out.println(intValue + "->" + hex);

        sc.close();
    }

    private static String convertToHexString(int value) {
        String result = "";

        while(value > 0) {
            int reminder = value % 16;
            String char1 = convertToHexChar(reminder);
            result = char1 + result;

            value /= 16;
        }
        return result;
    }
    private static String convertToHexChar(int value) {
        switch (value) {
            case 11: {
                return "A";
            }
            case 12: {
                return "B";
            }
            case 13: {
                return "C";
            }
            case 14: {
                return "D";
            }
            case 15: {
                return "E";
            }
            case 16: {
                return "F";
            }
            default: {
                return value + "";
            }
        }
    }
}

