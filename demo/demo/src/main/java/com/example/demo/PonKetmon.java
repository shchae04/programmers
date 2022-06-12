package com.example.demo;

import java.util.ArrayList;

public class PonKetmon {

    /*
     프로그래머스 폰켓몬

     N마리의 폰켓몬의 종류 번호가 들어있는 배열 nums (1 ~ 10000) 사이 정수항상 짝수

     N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법 (1 ~ 200,000) 이하의 자연수


     */

    public static int solution(int[] nums) {
        int answer = 0;

        // nums 에서 중복되지 않는 값만을 arrayList에 넣는다.
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int i = 0; i < nums.length; i++) {
            //배열에 nums[i]가 list에 존재하지 않으면  add해라
            if(!arrayList.contains(nums[i])) {
                arrayList.add(nums[i]);
                // 결과적으로 answer와 arrayList.size()의 값은 동일
                answer++;
            }
        }

        // N/2 (종류의 최댓값) 과 중복 제거된 arraylist의 길이를 비교해 더 작은 것을 return한다.
        int max_answer = nums.length / 2;
        if(max_answer < answer) {
            return max_answer;
        } else {
            return answer;
        }
    }



    /*
        public int solution(int[] nums) {

            HashSet<Integer> hs = new HashSet<>();

            for(int i =0; i<nums.length;i++) {
                hs.add(nums[i]);
            }

            if(hs.size()>nums.length/2)
                return nums.length/2;

            return hs.size();
    }
    */
    }
