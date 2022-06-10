package com.example.demo;
import java.util.*;


// k번째 수 구하기
class KNumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++){
            //commands 배열에 값 3개가 들어오는데 3개의 값 가져오기
            int start  = commands[i][0];
            int end    = commands[i][1];
            int select = commands[i][2];

            //result라는 메서드를 선언하여 배열과 값을 넘겨준다
            answer[i] = result(start, end, select, array);
        }

        return answer;
    }

    //배열과 값을 받은 후 정렬 , 잘라서 리턴해준다.
    public int result(int start, int end, int select, int[] array){
        int selectNum = 0;
        ArrayList<Integer> list = new ArrayList<>();

        for(int j = start - 1; j < end; j++){
            list.add(array[j]);
        }

        Collections.sort(list);

        return selectNum = (int) list.get(select-1);
    }
}