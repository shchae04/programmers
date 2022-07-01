package com.example.demo;

import java.util.ArrayList;

public class 약수의합 {
    /*
    정수 n을 입력받아 n의 약수를 모두 더한 값을 리턴하는 함수
     */

    public int solution(int n) {
        int count = 0;
        for (int i=1; i<=n; i++) {
            if((n % i) == 0) count += i;
        }
        return count;

    }

}
