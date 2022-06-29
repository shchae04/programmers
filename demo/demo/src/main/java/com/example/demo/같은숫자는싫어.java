package com.example.demo;

import java.util.ArrayList;

public class 같은숫자는싫어 {
    /*
    배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다.
    이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다.
     단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,
    arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
    arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
    배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

    제한사항
    배열 arr의 크기 : 1,000,000 이하의 자연수
    배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
    입출력 예
    arr	answer
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3]	[4,3]

    Collection 인터페이스가 아니라 배열로 풀 수 있는 방법이 있을까? 그렇게 풀면 좋을 것 같다. 배열의 크기는 정해지지
    않았으므로 같은것이 나오면 count++, 다른게 나와도 ++이뤄쿵 저러쿵 해서 count의 개수만큼 배열을 선언하고 받은 값을 집어
    넣어주면 될 것 같다.
     */

        public int[] solution(int []arr) {
            int[] answer = {};

            ArrayList<Integer> arrList = new ArrayList<Integer>();

            int num = 10;
            for (int i=0; i<arr.length; i++) {
                if (arr[i] != num) {
                    arrList.add(arr[i]);
                    num = arr[i];
                }
            }

            answer = new int[arrList.size()];
            for (int i=0; i<answer.length; i++) {
                answer[i] = arrList.get(i);
            }

            return answer;
        }

}
