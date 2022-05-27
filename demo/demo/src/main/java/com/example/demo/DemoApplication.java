package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//txAppend 실행
		System.out.println("txAppend "+txAppend("dff", "dfe"));

		//txAppendWithSpace 실행
		System.out.println("txAppendWithSpace " +txAppendWithSpace("dfdd", "dfdfd"));

		//txSubstring 실행
		System.out.println("txSubstring " + txSubstring("abcdefg", 0, 3));

		//txSubstringWithHan 실행
		System.out.println("txSubstringWithHan " + txSubstringWithHan("한글입니다",0,4));

		//txGetNotMatch

		//ifExist

		//ifNotExist

		//txLeftFillen

		//txChangeString

		//txOmit

		//txFixDownDecimalPlaces

		//txFixDate

		//txCutPadddingzero

		//txReverseSubstring

		//leftSubstring

		//rightSubstring

		//fillNumberZero

		//txGetTimeStr

		//txReplace

		//decode

		//fixNull

		//txExistCondition

		//ifExistValues

		//ifNotExistValues

		//txExitstCondition2

		//txChDateFormat

		//txChFormat

		//txToUpper

		//txToUpper

		//txToLower

		//txRemoveSpaces

		//txZeroToNull

		//codemap

		//txSplit

		//getUUID

	}

	//method 선언부

	//txAppend
	public static String txAppend(String a, String b){
		String cnt = "";
		cnt = a + b;

		return cnt;
	};

	//txAppendWithSpace
	public static String txAppendWithSpace(String a, String b){

		String cnt = "";
		cnt = a + " " + b;

		return cnt;
	};

	//txSubstring
	public static String txSubstring(String str, int a, int b){

		String cnt ="";
		cnt = str.substring(a, b);

		return cnt;
	};

	//txSubstringWithHan
	public static String txSubstringWithHan(String str, int beginBytes, int endBytes){
		int length = str.getBytes().length;
		System.out.println(length);

		return "";
	};

	//tGetNotMatch

	//iExist

	//iNotExist

	//tLeftFillen

	//tChangeString

	//tOmit

	//tFixDownDecimalPlaces

	//tFixDate

	//tCutPadddingzero

	//tReverseSubstring

	//lftSubstring

	//rghtSubstring

	//fllNumberZero

	//tGetTimeStr

	//tReplace

	//dcode

	//fxNull

	//tExistCondition

	//iExistValues

	//iNotExistValues

	//tExitstCondition2

	//tChDateFormat

	//tChFormat

	//tToUpper

	//tToUpper

	//tToLower

	//tRemoveSpaces

	//tZeroToNull

	//cdemap

	//tSplit

	//gtUUID

}
