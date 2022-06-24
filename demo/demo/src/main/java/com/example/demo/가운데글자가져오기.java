package com.example.demo;

public class 가운데글자가져오기 {


    /*
    단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

    재한사항
    s는 길이가 1 이상, 100이하인 스트링입니다.
    입출력 예
    s	return
    "abcde"	"c"
    "qwer"	"we"
     */

    public String solution(String s) {
        String answer = "";
        if(s.length() % 2 != 0){ //문자열의 길이를 2로 나눴는데 나머지가 0이 아니면 홀수개 하나만 리턴
            answer = s.substring(s.length() / 2,s.length() / 2 + 1);
        } else {
            //두개인경우
            answer = s.substring(s.length() / 2 -1 , s.length()/ 2 + 1);
        }

        return answer;
    }


}
