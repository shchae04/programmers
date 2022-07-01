package com.example.demo;

public class 하샤드수 {

    /*
    양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다.
    예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다.
    자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.

    제한 조건
    x는 1 이상, 10000 이하인 정수입니다.
     */

    public static void main(String[] args) {
        하샤드수 h = new 하샤드수();
        h.solution(123);
        h.solution(124);
        h.solution(125);
        h.solution(1260);
    }

    public boolean solution (int x) {
        int sum = 0;
        int a = x;

        while (a >= 1) {
            sum += a % 10;
            a /= 10;
        }

        if (x % sum == 0) {
            return true;
        } else
            return false;
    }
}
