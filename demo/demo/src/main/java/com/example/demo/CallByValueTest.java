package com.example.demo;

public class CallByValueTest {

    public static void main(String[] args) {
        CallByValueTest test = new CallByValueTest();
        test.method1();

    /*
    String s = "12345";
    String 형을 바로 int에 바로 변수값으로 넣을 때 사용합니다.
    int num = s.charAt(1) - '0';
        System.out.println(num);
        */
    }

    public void method1() {
        int a = 10;
        int b = 20;
        System.out.println("method2 호출전 a값 :" + a + ", b의 값 :" + b);
        method2(a, b);
        System.out.println("method2 호출gn a값 :" + a + ", b의 값 :" + b);
    }

    ;

    public void method2(int a, int b) {
        a = 20;
        b = 10;
        System.out.println("method2의 a,b값 :" + a + "," + b);
    }

    //Java는 기본적으로 Call By Value를 사용한다.
    //참조 타입 에서는 (String) 결과가 어떻게 나올까

    public void method_1() {
        String a = "EMMA";
        String b = "DOKE";
        System.out.println("method_2 호출 전 값 a, b 값 : " + a + ", " + b);
        method_2(a,b);
        System.out.println("method_2 호출 전 값 a, b 값 : " + a + ", " + b);

    };

    public void method_2(String a, String b){
        a = "chagename";
        b = "ANFD";
    };
}
