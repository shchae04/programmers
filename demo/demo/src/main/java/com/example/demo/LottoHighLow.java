package com.example.demo;
import java.util.Arrays;

public class LottoHighLow {
    //로또의 최저순위와 최고순위를 나타내면 된다.

    // 구매한 로또 배열과 당첨 배열 중 일치하는 숫자만큼은 이미 보장된 당첨 개수이므로 모르는 번호가 다 당첨되지 않게 되면 최저 당첨 개수
    // 구매한 로또 배열에서 0으로 된 모르는 번호들은 당첨 번호일 가능성이 있는 번호들이므로 0으로 된 번호가 모두 당첨될 번호라면 최고 당첨 개수
    // 당첨될 번호들을 등수로 환산 -> 6 - 당첨된 번호 + 1 등수
    // 두 배열의 길이가 같고 중복을 고려하지 않아도 됨.

    //이중 for문으로 개수를 세서 등수를 리턴합니다.

    public int[] solution(int[] lottos, int[] win_nums){

        int[] answer = {0, 0};
        //lottos : 민우가 구매한 로또 번호를 담은 배열
        //win_nums : 당첨 번호를 담은 배열

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        int num = 0, zero = 0;

        for(int i = 0; i<6; i++) {
            if(lottos[i] == 0){
                zero++;
            }
            for(int j=0; j < 6; j ++) {
                if(lottos[i] == win_nums[j]){
                    num++;
                    break;
                }
            }




        }
            int high = num + zero;
            int low = num;

            return answer;

    }
    public int rank(int num){

        switch (num){
            case 0: return 6;
            case 1: return 6;
            case 2: return 5;
            case 3: return 4;
            case 4: return 3;
            case 5: return 2;
            case 6: return 1;
            default:return 0;


        }
    }

}
