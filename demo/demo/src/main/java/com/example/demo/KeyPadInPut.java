package com.example.demo;

public class KeyPadInPut

{

    /*
    - 현재 왼손과 오른손의 위치를 기억해야한다
    1,4,7  --- 3,6,9 손의 위치가 정해져있다.
    0 -> 11로 전환 (위치상)
    1 -> 4 3의차이 이동거리 1
    옆의 번호는 1의 차이 이동거리 1
    눌러야 하는 키패드 - 왼손의 위치 를 거리로 나타내면 어떻게 될까
    2,5,8,0 일 때의 위치를 계산해야함.
    2,5,8,11
    처음 왼손가락 위치 : 10
    5를 눌러야 할때 : 2,5,8,0은 위치가 중앙에이따 위치 1 위로 2 총이동거리는 3인데
    우측 1 이동 위 2 이동 은 어떻게 계산 할건지가 관건이다.

    처음 우측손가락 위치 : 13
    */

    public String solution(int[] numbers, String hand){

        StringBuilder sbd = new StringBuilder();

        int curLeft = 10;
        int curRight = 12;
        //키패드
        // 1 | 2 | 3
        // 4 | 5 | 6
        // 7 | 8 | 9
        //10 |1 1| 12

        //좌표상
        /*
        (0,0) (1,0) (2,0)
        (0,1) (1,1) (2,1)
        (0,2) (1,2) (2,2)
        (0,3) (1,3) (2,3) 위치상으로 계산하자!
        */

        //가로를 위치라 하면 1,2,3 으로 나눌수 있고
        //세로를 위치로 하면 1,2,3,4로 할수있다.

        for(int number : numbers){
            if(number == 1 || number == 4 || number == 7){
                sbd.append("L");
                curLeft = number;
            } else if (number == 3 || number == 6 || number == 9){
                sbd.append("R");
                curRight = number;
            } else {
                //2,5,8,11을 누른 경우
                int lLength = distance(curLeft,number);
                int rLength = distance(curRight,number);

                if(lLength > rLength){
                    sbd.append("R");
                    curRight = number;
                } else if (lLength < rLength){
                    sbd.append("L");
                    curLeft = number;
                } else {
                    if (hand.equals("right")){
                        sbd.append("R");
                        curRight = number;
                    } else {
                        sbd.append("L");
                        curLeft = number;
                    }
                }


            }
        }

        return sbd.toString();
    }

    public int distance(int index, int number){

        //index = 현재손가락위치
        //좌표상으로 생각하자 0 > 11로 변환!
        index = (index == 0) ? 11 : index;
        number = (number == 0) ? 11 :number;

        int x = (index - 1) / 3;
        int y = (index -1) % 3;

        int numberX = number / 3;
        int numberY = 1; //2,5,8,11은 값 고정

        return Math.abs(x - numberX) + Math.abs(y - numberY);

    }
}
