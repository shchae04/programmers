package com.example.demo;

import java.util.Arrays;

public class 나누어떨어지는숫자배열 {

    /*
    array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
    divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

    제한사항
    arr은 자연수를 담은 배열입니다.
    정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
    divisor는 자연수입니다.
    array는 길이 1 이상인 배열입니다.
    입출력 예
    arr	divisor	return
    [5, 9, 7, 10]	5	[5, 10]
    [2, 36, 1, 3]	1	[1, 2, 3, 36]
    [3,2,6]	        10	[-1]

     */
    public int[] solution(int[] arr, int divisor) {
        //배열을 정렬합니다.
        Arrays.sort(arr);

        int arraySize = 0;
        //정렬된 배열을 divisor에 나눠가면서 나머지가 0인것을 배열에 담습니다. count해서 개수만큼 배열의 크기 생성.
        for(int i : arr) {
            if(i % divisor == 0) {
                arraySize++;
            }

        }
        // 돌려보내!
        if(arraySize == 0) {
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[arraySize];
        for (int i=0,j=0; i<arr.length; i++) {
            if(arr[i] % divisor ==0) answer[j++] = arr[i];
        }
        return answer;


    }
}
