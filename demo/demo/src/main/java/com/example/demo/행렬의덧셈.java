package com.example.demo;

public class 행렬의덧셈 {
    /*
    행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
     2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

    제한 조건
    행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
    입출력 예
    arr1	        arr2	        return
    [[1,2],[2,3]]	[[3,4],[5,6]]	[[4,6],[7,9]]
    [[1],[2]]	    [[3],[4]]	    [[4],[6]]
     */

    public int[][] solution(int[][] arr1, int[][] arr2) {

        ///for문을 돌려서 첫쨰값 더하고 둘째값 더하면 되겠다. i , i++, i++; 해서,
        //행렬의 크기가 같으므로 기준을 arr1으로 잡아도 결과는 같게 나올것이다. 열과 행이 같다.
        for (int i=0; i<arr1.length; i++) {
            for (int j=0; j<arr1[0].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
