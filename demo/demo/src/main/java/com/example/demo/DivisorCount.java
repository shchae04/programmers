package com.example.demo;

public class DivisorCount {

    /*
    약수의 개수와 덧셈

    두 정수 left와 right가 매개변수로 주어집니다. left부터 right까지의 모든 수들 중에서,
    약수의 개수가 짝수인 수는 더하고, 약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.

    1 ≤ left ≤ right ≤ 1,000
    */

    //짝수 + 홀수 - 해서 리턴해라. left -> right까지.
    public int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++) {
            int cnt = 0;
            for(int j=1; j<= i; j++) {
                if(i % j == 0) cnt++;
            }
            if(cnt % 2 == 0) answer += i;
            else answer -= i;
        }


        return answer;
    }


    /*
    public int solution(int left, int right) {
        int answer = 0;

        for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }

        return answer;
    }
    제곱수로 간단하게 풀 수 있다.
    refrain form hands
     */
}
