package com.example.demo;

public class 제일작은수제거하기 {
    /*
    정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
     단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요.
     예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

    제한 조건
    arr은 길이 1 이상인 배열입니다.
    인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
    입출력 예
    arr	        return
    [4,3,2,1]	[4,3,2]
    [10]	    [-1]
     */
    public int[] solution(int[] arr) {

        int min = arr[0]; //첫번쨰 값을 기준으로 비교하기 위해서 가져옴.

        int[] answer = new int[arr.length-1];

        if(arr.length <= 1) { // 배열의 크기가 하나일때 -1로 설정해놓은 값을 리턴한다.
            int[] returnminusone = {-1};
            return returnminusone;
        }

        //크기 값 비교
        for(int i=0; i<arr.length; i++){
            if (min > arr[i]){
                min = arr[i];
            }
        }
            int idx = 0;
        for (int j=0; j<arr.length; j++){
            if (min == arr[j]) {
                continue;
            } else {
                answer[idx++]  = arr[j];
            }
        }


        return answer;
    }
}
