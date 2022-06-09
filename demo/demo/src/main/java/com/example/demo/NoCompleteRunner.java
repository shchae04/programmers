package com.example.demo;

import java.util.HashMap;

public class NoCompleteRunner {
    /*
     - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
    completion의 길이는 participant의 길이보다 1 작습니다.
    참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
    참가자 중에는 동명이인이 있을 수 있습니다.

    HashSet은 적절치 못하다. 동명이인이 존재하기 때문에;
     */

    public String solution(String[] participant, String[] completion) {
        //완주하지 못한 사람은 리턴해라 완주못한사람을 담을 값 answer;
        String answer = "";

        HashMap<String,Integer> map = new HashMap<>();

        for(String name : participant) {

            map.put(name,map.getOrDefault(name, 0) + 1);
        }

        for(String name : completion) {

            map.put(name,map.getOrDefault(name,0) - 1);
        }

        for(String key : map.keySet()){
            //값 1+ 경우
            if(map.get(key) > 0){
                answer = key;
                break;
            }
        }
        return answer;
    }
}
