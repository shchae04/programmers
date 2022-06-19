package com.example.demo;

import java.util.Arrays;
import java.util.Comparator;

public class FailureRatio {

    /*KAKAO BLIND 채용 코딩테스트

    실패율

     실패율은 다음과 같이 정의한다.
    스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
    전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때
    , 실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

    제한사항

    스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
    stages의 길이는 1 이상 200,000 이하이다.
    stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
    각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
    단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
    만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
    스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

    N	stages	                    result
    5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
    4	[4,4,4,4,4]             	[4,1,2,3]

    */

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        // 1. 실패율 저장을 위해 double형, 각 스테이지와 실패율 매칭을 위해 1개의 열을 더 추가한다.
        double[][] cnt = new double[N+1][3];

        // 2. stages 탐색, 현재 스테이지가 N+1인 경우는 고려할 필요가 없다.
        for(int i = 0 ; i<stages.length;i++){
            if(stages[i]>N) continue;
            // 2-1. 각 스테이지 별 막힌 사용자 수를 증가.
            cnt[stages[i]][0]++;
        }

        // 3. 1스테이지를 도달한 사용자 수는 전체 사용자 수와 같으며, 1번 인덱스의 3번째 열에 스테이지를 매칭시킨다.
        cnt[1][1] = stages.length;
        cnt[1][2] = 1;

        // 4. 2번 인덱스부터 반복.
        for(int i = 2; i<cnt.length;i++){
            // 4-1. 각 스테이지에 도달한 사람의 수 = 이전 스테이지에 도달한 사람 수 - 이전 스테이지에 막힌 사람 수
            cnt[i][1] = (int)(cnt[i-1][1] - cnt[i-1][0]);
            // 4-2. 인덱스 별 스테이지 정보를 매칭시킨다.
            cnt[i][2] = i;
        }

        // 5. 2차원 배열을 탐색한다.
        for(int i = 1; i<cnt.length;i++){
            // 5-1. 각 스테이지에 도달한 사람이 없을 경우, 실패율은 0이다.
            if(cnt[i][1] == 0) {
                cnt[i][0] = 0;
                continue;
            }
            // 5-2. 문제의 정의에 따라 실패율을 0번 열에 저장한다.
            cnt[i][0] = cnt[i][0]/cnt[i][1];
        }

        // 6. Comparator 인터페이스의 compare 메소드 구현.
        Arrays.sort(cnt,new Comparator<double[]>(){
            @Override
            public int compare(double[] o1,double[] o2){
                // 6-1. 2차원 배열에서 고려하지 않는 0번 인덱스는 무시하기 위해 작성.
                if(o1[2] == 0 || o2[2] == 0 ) return 0;
                // 6-2. 실패율이 같다면, 스테이지를 오름차순으로 정렬한다.
                if(o1[0] == o2[0]) return Double.compare(o1[2],o2[2]);
                    // 6-3. 나머지는 실패율에 따라 내림차순 정렬한다.
                else return Double.compare(o2[0],o1[0]);

            }
        });

        // 7. 정렬된 스테이지 정보 저장.
        for(int i = 1; i<cnt.length;i++){
            answer[i-1] = (int)cnt[i][2];
        }

        return answer;
    }

}
