package com.example.demo;

public class 자연수뒤집어배열로만들기 {

    /*
    자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.

    제한 조건
    n은 10,000,000,000이하인 자연수입니다.
    입출력 예
    n	return
    12345	[5,4,3,2,1]
     */

    public int[] solution(long n) {
        int[] answer = {};
        int count = 0;
        long num = n;

        while (n>0) {
            count++;
            n = n/10;
        }

        answer = new int[count];

        for (int i=0; i<count; i++) {
            answer[i] = (int)(num%10);
            num = num /10;
        }
        return answer;
    }
}
