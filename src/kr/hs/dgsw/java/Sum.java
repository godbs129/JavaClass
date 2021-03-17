package kr.hs.dgsw.java;

public class Sum {

//	public static int addTwoNumbers(int n, int m) {
//		return n+m;
//
//	}

    public static void main(String[] args) {
        int sum = 0;

        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            int value = Integer.parseInt(args[i]);
            sum += value;
        }
        System.out.println("Total : " + sum);
    }
}
