package com.example.demo;

public class NewIdRecommend {

    public String solution(String new_id) {

        /*
         - 정규표현식 문법
         ^ : 문자열의 시작
         $ : 문자열의 끝
         . : 임의의 한 문자
         * : 문자가 0번 이상 발생
         + : 문자가 1번 이상 발생
         ? : 문자가 0번 혹은 1번 발생
         [] : 문자의 집합 범위를 나타냄 <앞에 ^가 나타나면 not을 의미>
         {} : 횟수 또는 범위를 의미
         () : 소괄호 안의 문자를 하나의 문자로 인식
         | : or 조건
         \ : 확장 문자의 시작
         \b : 단어의 경계
         \B : 단어가 아닌 것의 경계
         \A : 입력의 시작부분
         \G : 이전 매치의 끝
         \Z : 입력의 끝이지만 종결자가 있는 경우
         \z : 입력의 끝
         \s : 공백문자
         \S : 공백문자가 아닌 나머지 문자
         \w : 알파벳이나 숫자
         \W : 알파벳이나 숫자를 제외한 문자
         \d : [0-9] 와 동일
         \D : 숫자를 제외한 모든 문자.

         -정규표현식을 이용하면 1~7단계를 간결하게 표현할 수 있다.
        */

        //1단계
        String answer = new_id.toLowerCase();

        //2단계
        answer = answer.replaceAll("[^-_.a-z0-9]","");
        //3단계
        answer = answer.replaceAll("[.]{2,}",".");
        //4단계
        answer = answer.replaceAll("^[.]|[.]$","");

        //5단계
        if (answer.equals("")) {
            answer += "a";
        }

        //6단계
        if(answer.length() >= 16) {
            answer = answer.substring(0,15);
            answer = answer.replaceAll("[.]$","");
        }

        //7단계
        if (answer.length() <= 2){
            while (answer.length() < 3){
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }

}
