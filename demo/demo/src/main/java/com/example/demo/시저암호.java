package com.example.demo;

public class 시저암호 {

    /*
    어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
    예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
    문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
        아스키코드 활용.
    제한 조건
    공백은 아무리 밀어도 공백입니다.
    s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
    s의 길이는 8000이하입니다.
    n은 1 이상, 25이하인 자연수입니다.
    입출력 예
    s	    n	result
    "AB"	1	"BC"
    "z"	    1	"a"
    "a B z"	4	"e F d"
     */

    public static void main(String[] args) {
        시저암호 s = new 시저암호();
        s.solution("ab",1);
    }

    public String solution(String s, int n) {
        String answer = "";

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            System.out.println("for문 안 ch 값 :" + ch);

            if (Character.isLowerCase(ch)) {  //
                ch = (char) ((ch - 'a' + n) % 26 + 'a'); // 소문자
                System.out.println(((ch - 'a' + n) % 26 + 'a'));
                System.out.println("대문자 ch 값 :" + ch);
            } else if (Character.isUpperCase(ch)) {
                ch = (char) ((ch - 'A' + n) % 26 + 'A'); // 대문자
                System.out.println("소문자 ch 값 :" + ch);
            }
            // 
            answer += ch;
        }

        return answer;

    }

    /*
   아스키코드에 대한 완벽한 이핵 필요합니당. Character.toCharArray()

     */
}
