package com.example.demo;

public class ArrayFactorial
{


    //팩토리얼 연산 시작 !
    public static void main(String[] args) {

        ArrayFactorial arr = new ArrayFactorial(1000);
        System.out.println("팩토리얼 값은 ?  : " +arr.getFact());

    }

    int index;
    int[] product = new int[10000];

    //생성자 생성 index값 배열의 크기 값 계산
    public ArrayFactorial(int num) {
        //초기값 설정.
        index = 0;
        product[index] = 1;


        //0번째 인덱스를 제외한 나머지 인덱스 값들을 -1로 fix
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
            //{4,3,2,2} 와 {1,2,3,2,1}로 나뉘게 된다.
            if(product[i] > 9){

                if(product[i + 1] == -1){
                    //해당하는 다음 인덱스 값을 -1에서 0으로 변경해준다. 즉 {1,2,3,12}인 경우 {1,2,3,12,0}으로 변경.
                    product[++index] = 0;
                }

                product[i + 1] += (product[i]/10); //몫
                product[i] %= 10; //나머지

            }

        }
    }




}
