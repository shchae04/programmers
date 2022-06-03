package com.example.demo;

public class StringNum {
    //숫자 문자열과 영단어

    /*
    1478 --> one4seveneight
    234567 --> 23foursix
    -로 변경해주면 됩니다.
    */

   public int solution(String s){

       String[] num = {"zero","one","two","three","four","five","six","seven","eight","nine"};

       //숫자가 0-9까지 10개
       //반복문 돌려서 num 값이랑 일치하면 int로 바꾸어 주면 된다.

       for(int i=0; i<10; i++){
            s = s.replace(num[i],Integer.toString(i));
            //num[i] 를 i로 !
       }

       //s는 String이기 때문에 parseInt 해주어야 함.
       return Integer.parseInt(s);
   }
}
