package kr.hs.dgsw.java.array;

public class Stack {
    private String[] array = new String[5];

    private int num = 0;

    public void push(String str) {
        array[num] = str;
        num++;
    }

    public String pop() {
        num--;
        return array[num];
    }

    public void print() {
        for(int i = 0;i<array.length;i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("hi");
        stack.push("hihi");

        System.out.println(stack.pop());

    }
}
