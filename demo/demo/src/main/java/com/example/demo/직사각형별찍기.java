package com.example.demo;

import java.util.Scanner;

public class 직사각형별찍기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); //개수
        //AS-IS -> TO-BE buf[pos] += plus 장례식장 갔다 오자..
        int b = sc.nextInt(); //반복
        for (int j=0; j<b; j++) {

        for (int i=0; i<a; i++){
            System.out.print("*"); //개행안하고
        }
                System.out.println();
        }

    }
}
