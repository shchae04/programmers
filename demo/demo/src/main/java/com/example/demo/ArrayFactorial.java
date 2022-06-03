package com.example.demo;

import com.sun.javafx.binding.BidirectionalBinding;
import org.apache.tomcat.util.collections.SynchronizedStack;

public class ArrayFactorial
{


    //팩토리얼 연산 시작 !
    public static void main(String[] args) {

        ArrayFactorial arr = new ArrayFactorial(14);
        System.out.println("팩토리얼 값은 ?  : " +arr.getFact());

    }

    int index;
    int[] product = new int[100000];

    //생성자 생성 index값 배열의 크기 값 계산
    public ArrayFactorial(int num) {
        //초기값 설정.
        index = 0;
        product[index] = 1;


        //0번째 인덱스를 제외한 나머지 인덱스 값들을 -1로 fix 012345 로하면 값 찾기 힘듬.
        for(int i=1; i< product.length; i++) product[i] = -1;
            //{1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
            //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        //현재 배열 상태
        //[1][-1][-1][-1][-1][-1][-1][-1]......
        //가장 큰 수가 마지막 즉 출력할 때는 역순으로 해야 한다는 것을 인식.
        //전달받은 num 값을 기준으로 팩토리얼 계산식
        for(int n = 2; n <= num; n++){ // * 2, 3, 4, 5, 6 ... num 까지
            //계산하는 메서드 선언!
            calcFac(n);
        }

    }
    //출력하기 출력은 정상적으로 이루어졌음 Arrayoutof!~~~~ Exception음.
    public String getFact(){
        String factorial = "";

        for (int i = index; i >= 0; i--) factorial += product[i];

        return factorial;
    }

    // 곱해주는 Func
    private void calcFac(int num){
        for (int i=0; i<=index; i++){
            product[i] *= num;
            //0번째 인덱스부터 차례로 곱해야 하기 때문에 0,1,2,3,4,5,6... 곱해주는 메서드
            //여기서 만약에 곱해진 값이 0~9가 아니라 9를 초과한다면 앞자리를 올려주고 뒷자리를 남겨주는 로직 /, % 사용하면 될듯.
            //만약에 {12,5,3,2} 라는 배열이라면 {2,6,3,2} 라는 결과를 내도록 메서드를 짜면 된다.
            //{10,3,2,1} -> {0,4,2,1} 0일때는 0 {1,3,5,10} -> {1,3,5,0,1} 나오게 하면 된다.
            //모든 인덱스 값들을 검사해서 올려주면 되는것 같다. ---> 하나의 기능. ReArrangeMent
        }
            ReArrangeMent();
    }

    private void ReArrangeMent(){
        //모든 index를 검사
        for (int i=0; i<= index; i++){
            //배열의 상태 1,3,5,12,44,22,3,1,0,1,-1,-1,-1,-1,-1,-1,-1........ int[] size = 10000
            //배열의 인덱스에 해당하는 값이 > 9 이면 나누어 주면 된다. 그런데 그 값이 중간에 껴있을때랑 맨 앞에 있을때가 좀 다르다.
            //예를 들어 {4,3,12,1} 경우와 {1,2,3,12}인 경우 -> 맨 앞자리가 두자리인 경우에는 그 앞 인덱스 값이 -1이면 값이 비어있다.
            //{4,3,2,2} 와 {1,2,3,2,1}로 나뉘게 된다. 나뉘는 순간 전부 달라집니다.
            if(product[i] > 9){

                if(product[i + 1] == -1){
                    //해당하는 다음 인덱스 값을 -1에서 0으로 변경해준다. 즉 {1,2,3,12}인 경우 {1,2,3,12,0}으로 변경.
                    //다음에 해당하는 값을 0으로 설정한후 2,1 로 변경해주면 된다. 변경했으면 해라 다 다 하면된당.
                    product[++index] = 0;
                }

                product[i + 1] += (product[i]/10); //몫
                product[i] %= 10; //나머지

            }

        }
    }

    /*
    배열로 팩토리얼 구하기 10! = 3628800

10 * 9 * 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1

정수를 입력 받아서 배열을 반환.

   | 1 | 0 |
 x       9                           0번째 idx = 0  1번째 idx = 1
= | 9 | 0 |
 x       8
= | 7 | 2 | 0 |
 x           7
= | 5 | 0 | 4 | 0 |
x                 6
= | 3 | 0 | 0 | 2 | 4 | 0 |
x                         5
= | 1 | 5 | 1 | 2 | 0 | 0 |
x                         4
= | 6 | 0 | 4 | 8 | 0 | 0 |
x                         3
= | 1 | 8 | 1 | 4 | 4 | 0 | 0
x                              2
= | 3 | 6 | 2 | 8 | 8 | 0 | 0 |
x                              1
= | 3 | 6 | 2 | 8 | 8 | 0 | 0 | - > | 0 | 0 | 8 | 8 | 2 | 6 | 3 | 실제 배열에 저장된 값 -> 역순으로 String에 담아서 출력한다.
                                        3
                                        0  0   4   6   8  8  0  1

1.  index = 0, product[0] = 1 로 설정한다 첫번째 숫자를 초기화.
[][][][][][][][][]][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]~~~ 배열의 크기를 늘려놓는다
배열의 나머지 숫자를 -1로 설정
for ~~ = -1

배열의 상태 [1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1][-1]
: 초기의 배열상태 설정 완료.

정수 2를 넘겨 받았다고하자 n=2; 곱해라 -> for(int i=0 i<=index 인덱스는 0 ~ 9999 까지

배열의 인덱스 하나 곱해라 product[0] = product[0] * 2
product[0] = 2가 되겠다 이러한 상황에서 자릿수가 9를 넘어가서 앞쪽 자리수를 올려줘야 하는 경우가
생긴다 4 * 8 =  32인데

과정 : 4 * 8 = 32 % 10 = 2나머지를 기존의 배열에 집어 넣는다
32 / 10 나눈 값 : 3 을 인덱스를 증가시키고 기존의 배열에 더한다 ex : product[n + 1] += (product[n] / 10);


인덱스의 해당하는 값이 초기에 설정하였던 -1인 경우 인덱스를 증가시키고 값을 : 0으로 반환!

다 메서드로 나누면 될듯.. 잘?,
     */
}