package com.example.demo;

public class 부족한금액계산 {

    public long solution(int price, long money, int count) {
        long answer = -1;
        long pay = 0;
        for(int i=1; i<=count; i++){
            pay += price*i;
        }
        answer = (pay-money>0)?pay-money:0;
        return answer;
    }
}
