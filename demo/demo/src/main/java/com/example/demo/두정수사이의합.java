package com.example.demo;

public class 두정수사이의합 {
    public long solution(int a, int b) {
        long answer = 0;

        //a가 b보다 큰경우
        if(a > b) {
            // 변수값 담을 변수
            int temp = a;
            a = b;

            b = temp;

        }

        for(int i = a; i<=b; i++){
            answer += i;

        }

        return answer;
    }
}
