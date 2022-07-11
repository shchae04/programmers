package com.example.demo;

public class 정수내림차순으로배치하기 {
    /*
    함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로 정렬한 새로운 정수를 리턴해주세요.
     예를들어 n이 118372면 873211을 리턴하면 됩니다.

    제한 조건
    n은 1이상 8000000000 이하인 자연수입니다.
    입출력 예
    n	return
    118372	873211

    1점 받은 풀이. 흠흠흠
    */
    public long solution(long n) {
        char[] sort = String.valueOf(n).toCharArray();
        int tmp = 0;
        for(int i=0; i<sort.length; i++) {
            for(int j=i+1; j<sort.length; j++) {
                if(sort[i] < sort[j]) {
                    tmp = sort[i];
                    sort[i] = sort[j];
                    sort[j] = (char) tmp;
                }
            }

        }

        return Long.parseLong(String.valueOf(sort));
    }
}
