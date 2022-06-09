package com.example.demo;

public class MakePrimeNumber {

    /*
    주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
    nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

    nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
    nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.


    1. 임의의 요소 3가지 선택
    2. 요소의 합의 소수 여부 판별
    소수: 1과 자기자신만을 약수로 가지는 수 즉 나누어 떨어지지 않는 수.
    */
    public int solution(int[] nums)
    {
        int answer = 0;

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                for (int k = j + 1; k < nums.length; k++)
                {
                    int sum = nums[i] + nums[j] + nums[k];
                    //임의의 세가지 요소를 구했다.
                    answer += isPrime(sum) ? 1 : 0;
                }
            }
        }

        return answer;
    }

    /**
     * 소수 여부 반환 메서드
     *
     * @param num: [int] 숫자
     *
     * @return [boolean] 소수 여부
     */
    private boolean isPrime(int num)
    {
        for (int i = 2; i <= Math.sqrt(num); i++)
        {
            // 나눠 떨어질 경우
            if (num % i == 0)
            {
                return false;
            }
        }

        return true;
    }
}
