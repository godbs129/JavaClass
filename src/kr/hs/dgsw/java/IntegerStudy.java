package kr.hs.dgsw.java;

public class IntegerStudy {
    public static void main(String[] args) {
        int intValue;
        short shortValue;
        long longValue;
        byte byteValue;
        char charValue;

        System.out.println("Byte: " + Byte.BYTES);
        System.out.println("Short: "+ Short.BYTES);

        System.out.println("Byte Range: " +
                Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);
        System.out.println("Byte Range: " +
                Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
    }
}
