package com.example.demo;

public class CallByValueTest {

    public static void main(String[] args) {
        CallByValueTest test = new CallByValueTest();
        test.method1();
    }

    public void method1(){
      int a = 10;
      int b = 20;
        System.out.println("method2 호출전 a값 :" + a + ", b의 값 :" + b );
        method2(a,b);
        System.out.println("method2 호출gn a값 :" + a + ", b의 값 :" + b );
    };

    public void method2(int a, int b){
        a = 20;
        b = 10;
        System.out.println("method2의 a,b값 :" + a + "," + b);
    }
}
