package com.example.demo;

public class MlnPlusAdd {

    /*
    음양 더하기
    정수배열 하나씩 받아서 그게 false인지 true인지 구분한다음에 더해주면될듯!
    */

    public int solution(int[] absolutes,boolean[] signs){

        int answer = 0;

        for(int i=0; i<absolutes.length; i++){
            if(signs[i]){
                answer = answer + absolutes[i];
            } else {
                answer = answer - absolutes[i];
            }
        }

        return answer;
    }
}
