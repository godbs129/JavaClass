package kr.hs.dgsw.java;

public class VariableStudy {

    int instanceVar;
    static String name;
    public void method1(String param) {
        int local = 3;

        if(3 == local) {
            int a=1;
        } else {
            int a=2;
        }
    }
    public void method2(String param) {
        int local;
    }

    public static void main(String[] args) {
        VariableStudy study = new VariableStudy();
        VariableStudy study2 = new VariableStudy();

        VariableStudy.name = "홍길동";
        VariableStudy.name = "이순신";

        System.out.println(study.name);
    }
}
