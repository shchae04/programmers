package com.example.demo;



/*
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

ex 5라고 하면 1,2,3,4,5 인데 이중에서 소수는 3 , 5 즉 return 2;

그럼 2부터 n까지
 */


public class 소수찾기 {

    public int solution(int n) {
        int answer = 0;
        boolean[] prime = new boolean [n+1];
        for(int i=2; i<=n ; i++)
            prime[i]=true; //2~n번째수를 true로 초기화

        //제곱근 구하기
        int root=(int)Math.sqrt(n);
        for(int i=2; i<=root; i++){ //2~루트n까지 검사
            if(prime[i]==true){ //i번째의 수가 소수일 때
                for(int j=i; i*j<=n; j++) //그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문)
                    prime[i*j]=false;
            }
        }

        for(int i =2; i<=n; i++) {
            if(prime[i]==true)
                answer++;
        }
        return answer;
    }
}

