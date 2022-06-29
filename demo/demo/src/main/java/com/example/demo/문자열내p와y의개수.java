package com.example.demo;

public class 문자열내p와y의개수 {
    /*
    대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
    다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

    예를 들어 s가 "pPoooyY"면 true를 return하고 "Pyy"라면 false를 return합니다.

    제한사항
    문자열 s의 길이 : 50 이하의 자연수
    문자열 s는 알파벳으로만 이루어져 있습니다.
    입출력 예
    s	answer
    "pPoooyY"	true
    "Pyy"	false

    문자열을 쭉 검사하면서 p의 개수, y의 개수를 센다.
     */
    boolean solution(String s) {
        //위치!
        int countP = 0;
        int countY = 0;

        boolean answer = true;
        //모두 소문자로 변환시키고 char 배열로 전환.
        char[] ch = s.toLowerCase().toCharArray();

        for (int i=0; i<ch.length; i++) {
            if(ch[i] == 'p') countP++;
            if(ch[i] == 'y') countY++;
        }


        return countP == countY ? true : false;
    }
}
