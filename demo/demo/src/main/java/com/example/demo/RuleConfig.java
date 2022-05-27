package com.example.demo;

import com.sun.org.apache.xpath.internal.objects.XString;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.lang.model.util.SimpleElementVisitor6;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class RuleConfig {


    public static void main(String[] args) {

        //txAppend 실행
        System.out.println("txAppend "+txAppend("dff", "dfe"));

        //txAppendWithSpace 실행
        System.out.println("txAppendWithSpace " +txAppendWithSpace("dfdd", "dfdfd"));

        //txSubstring 실행
        System.out.println("txSubstring " + txSubstring("abcdefg", 0, 3));

        //txSubstringWithHan 실행
        System.out.println("txSubstringWithHan " + txSubstringWithHan("가나다라마",0,6));

        //txGetNotMatch 실행
        System.out.println("txGetNotMatch " + txGetNotMatch("가나","가나","가나다라"));

        //ifExist
        System.out.println("ifExist "+ ifExist("ab","ab","TRUE"));

        //ifNotExist
        System.out.println("ifNotExist "+ ifNotExist("av","av","dfdf"));

        //txLeftFillen
        System.out.println("txLeftFillen " + txLeftFillen("-ABCDEF",10,"#"));

        //txRightFillLen
        System.out.println("txRightFillLen " + txRightFillLen("ABCDEF",10,"#"));

        //txChangeSpace
        System.out.println("txChangeSpace "+ txChangeSpace("","1234"));

        //txChangeString
        System.out.println("txChangeString " + txChangeString("ab","ab","cde"));

        //txOmit
        System.out.println("txOmit "+ txOmit("###ab###","#"));

        //txFixDownDecimalPlaces
        System.out.println("txFixDownDecimalPlaces " + txFixDownDecimalPlaces(123456,3));

        //txFixDate
        System.out.println("txFixDate " + txFixDate("150602",6));

        //txCutPadddingzero
        System.out.println("txCutPadddingzero " + txCutPadddingzero("001234"));

        //txReverseSubstring
        System.out.println("txReverseSubstring "+ txReverseSubstring("ABCDEFG",2,4));

        //leftSubstring
        System.out.println("leftSubstring " + leftSubstring("ABCDEFG",2));

        //rightSubstring
        System.out.println("rightSubstring " + rightSubstring("ABCDEFG",3));

        //fillNumberZero
        System.out.println("fillNumberZero "+ fillNumberZero("ABCDEFG",10));

        //txGetTimeStr
        System.out.println("txGetTimeStr " +txGetTimeStr(new Date()));
        //txReplace
        System.out.println("txReplace " + txReplace("ABCDEEFF","E","H"));

        //decode
        System.out.println("decode " + decode("ABC","A","1","AB","2","3"));
        //txExistCondition
        System.out.println(txExistCondition("ABC","DEF","GHI"));
        //ifExistValues
        System.out.println(ifExistValues("ABC"));
        //ifNotExistValues
        System.out.println(ifNotExistValues("ABC"));
        //txExitstCondition2
        System.out.println(txExistCondition2("ABC","DEF"));
        //txChDateFormat
        System.out.println(txChDateFormat("20150625","ddMMyyyy"));
        //txChFormat
        System.out.println("txChFormat "+  txChFormat("20150625","yyyyMMdd","yyyy-MM-dd"));
        //txToUpper 실행
        System.out.println("txToUpper "+ txToUpper("abcde"));

        //txToLower 실행
        System.out.println("txToLower " + txToLower("ABCDE"));

        //txRemoveSpaces 실행
        System.out.println("txRemoveSpaces " +txRemoveSpaces("abc de ef"));

        //txZeroToNull 실행
        System.out.println("txZeroToNull " + txZeroToNull(0));

        //codemap 실행
        System.out.println("codemap "+ codemap("A","A","B","C","D"));

        //txSplit 실행
        System.out.println("txSplit "+txSplit("ABCDE","C",1));

        //getUUID 실행
        System.out.println("getUUID " + getUUID());


        //1000! 계산
        System.out.println(factorial(1000));

    }


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

    //txSubstringWithHan Byte로 입력받음
    public static String txSubstringWithHan(String str, int beginBytes, int endBytes){

        //문자열이 비어있을 경우
        if(str == null || str.getBytes().length == 0){
            return "";
        }

        //시작 바이트 값이 0보다 작을 경우
        if(beginBytes < 0){
            beginBytes = 0;
        }

        //끝 바이트 값이 1보다 작을 경우
        if(endBytes < 1){
            return "";
        }

        //문자열의 길이
        int strLength = str.length();
        int beginIndex = -1;
        int endIndex = 0;

        //현재 바이트
        int curBytes = 0;
        //String 하나씩 잘라서 보관할 변수
        String ch = null;

        for(int i=0; i<strLength; i++){
            //하나씩 자르면서
            ch = str.substring(i, i+1);
            System.out.println(ch);

            curBytes += ch.getBytes().length;
            System.out.println(curBytes);

            //시작 인덱스 값이 -1이거나, 현재 바이트가 시작 바이트보다 클때 시작인덱스의 값을 i로 설정
            if(beginIndex == -1 && curBytes >= beginBytes){
                beginIndex = i;
            }

            //현재 바이트값이 끝바이트값보다 커지면 stop;
            if(curBytes > endBytes){
                break;
            } else {
                endIndex = i+1;
            }
        }

        return str.substring(beginIndex,endIndex);
    };

    //tGetNotMatch
    //2~n까지 가변인자.
    public static String txGetNotMatch(String a,String...str){

       if(a == null || str == null || str.equals("")){
           return "";
       }
       String contemp = "";
       for(String s : str){
           if(!a.equals(s)){
               contemp = s;
           }
       }
       return contemp;
    };

    //ifExist
    public static String ifExist(String s1, String s2, String s3){
        //s1이 s2에 속해있으면 s3리턴 그렇지 않으면 ""리턴

        if(s2.contains(s1)){
            return s3;
        } else {
            return "";
        }
    };

    //ifNotExist
    public static String ifNotExist(String s1, String s2, String s3){
        //s1이 s2에 속해있지않으면 s3리턴 그렇지 않으면 ""리턴

        if(!s2.contains(s1)){
            return s3;
        } else {
            return "";
        }
    };

    //txLeftFillen
    public static String txLeftFillen(String str, int num, String addStr){
        //두번째 param만큼 자리수를 늘리고 세번째 문자열을 채운다. 두번째 파라미터수가 첫번쨰 자리수보다 작으면
        //빈 문자열 리턴

        StringBuilder tempStr = new StringBuilder(str);
        System.out.println(tempStr);

        //문자열 앞에 - 가있는 경우 마지막에 붙이기
        if(str.startsWith("-")){
            tempStr.delete(0,1);
            tempStr.append("-");
        }

        //두번째 파라미터가 첫번째 문자열 자리수보다 작을 경우 빈 문자열 리턴
        if(str.length() > num){
            return "";
        }

        //두번째 파라미터 수만큼 자리수 늘리기
        for(int i=0; i<num; i++){
            tempStr.insert(0,addStr);
            if(tempStr.length() == num){
                break;
            }
        }

        return tempStr.toString();
    };

    //txRightFillLen
    public static String txRightFillLen(String str, int num, String addStr){
        StringBuilder tempStr = new StringBuilder(str);

        for(int i=0; i<num; i++){
            tempStr.append(addStr);
            if(tempStr.length() == num){
                break;
            }
        }

        return tempStr.toString();
    };

    //txChangeSpace
    public static String txChangeSpace(String s1, String s2){
      if(s1.isEmpty()){
          return s2;
      }
      return s1;
    };
    //txChangeString
    public static String txChangeString(String str1, String str2, String strValue){
      if(str1 == null){
          System.out.println("값입력");
      }
        if(str1.equals(str2)){
          return strValue;
      } else return str1;
    };

    //txOmit
    public static String txOmit(String str, String delStr){
        //첫번째 문자열에 두번째 문자열이 있을 경우 제거하고 리턴
        //문자열은 불변 ***************************이거 까먹어서 엄청 오래걸렸다..

        String text = str.replace(delStr,"");

    return text;
    };
    //txFixDownDecimalPlaces
    public static String txFixDownDecimalPlaces(double realNum, int cNum){
    //첫번째 파라미터를 두번째 파라미터만큼 소수점 처리 소수점이 없으면 두번째 파라미터 수만큼 0처리

        System.out.println(String.format("%."+cNum+"f",realNum));
        String formatNum = String.format("%."+cNum+"f",realNum);
        System.out.println("길이" + formatNum.length());
        System.out.println("길이" + realNum);

        StringBuilder sbd = new StringBuilder(formatNum);

        if(!formatNum.contains(".")){
            sbd.append("0");
        }

        return sbd.toString();
    };
    //txFixDate //사용 미권장 메서드
    public static String txFixDate(String birth,int se){
        //20150602 or 150602
        if(birth.length() != 6 || birth.length() !=8 && se != 6 || se != 8){
           return birth;
        }
        SimpleDateFormat df = new SimpleDateFormat("YYYYMMDD");
        SimpleDateFormat df2 = new SimpleDateFormat("YYMMDD");


        //se 가 6이냐 8이냐.
        if(se == 6){
            String six = df2.format(birth);
            return six;
        }else if(se == 8){
            String eight = df.format(birth);
            return eight;
        }

        return df.toString();
    };


    //txCutPadddingzero
    public static String txCutPadddingzero(String num){

        //String으로 받는경우와 int로 받는 경우로 구분함.
//        String regexNum = Integer.toString(num);
//        System.out.println(regexNum);

        String tempStr = num.replace("0","");
        return tempStr;

//        return regexNum;
    };

    //txReverseSubstring
    public static String txReverseSubstring(String str, int begin, int end){
      //문자열을 거꾸로 subString한다 1. 배열을 뒤집어서 자른후 다시 뒤집는다. 2. 반복문으로 뒤에서부터 자른다.

        if((begin > end) || !(begin >=0) || !(end >=1)){
            return "잘못된 정보";
        }

        //1.
        StringBuilder sbd = new StringBuilder(str);
        sbd.reverse();
        String toStr = sbd.substring(begin,end);
        StringBuilder realStr = new StringBuilder(toStr);
        realStr.reverse();
        System.out.println(realStr.reverse().toString());

      return realStr.reverse().toString();
    };

    //leftSubstring
    public static String leftSubstring(String str, int cnt){
        //문자열의 왼쪽부터 subString

        return str.substring(0,cnt);

    };
    //rightSubstring
    public static String rightSubstring(String str, int cnt){
        int strLength = str.length();
        System.out.println(strLength);
        return str.substring(strLength-cnt, strLength);
    };
    //fillNumberZero
    public static String fillNumberZero(String str, int cnt) {

        StringBuilder exStr = new StringBuilder(str);

        if(str.contains("-")){
            exStr = new StringBuilder(str.replace("-", ""));
            exStr.append("-");
        }

        //자리수 늘리기
        for(int i=0; i<cnt; i++){
            exStr.insert(0,"0");
            if(exStr.length() == cnt){
                break;
            }
        }
        return exStr.toString();
    };

    //txGetTimeStr
    public static String txGetTimeStr(Date dater){
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");


        return date.format(new Date());

    };
    //txReplace
    public static String txReplace(String str,String exStr,String coStr){
       return str.replace(exStr,coStr);
    };

    //decode
    public static String decode(String data,String key1,String value1,String key2,String value2,
                                String value3){

        if(data.equals(key1)){
            return value1;
        } else if (data.equals(key2)) {
            return value2;
        } else if (!data.equals(key1) && !data.equals(key2)) {
            return value3;
        }
    return data;

    };

    //fixNull
    public static String fixNull(String str){
        if(str == null){
            return "";
        } else return str;
    };

    //txExistCondition
    public static String txExistCondition(String str1, String str2, String str3){

        if(str1 == null || str1 ==""){
            return str2;
        } else {
            return str3;
        }
    };

    //ifExistValues
    public static String ifExistValues(String...s){
      if(s != null){
          return "ExistValues";
      }
      return "";
    };

    //ifNotExistValues
    public static String ifNotExistValues(String...str){
      for(String s : str){
          if(s.equals(null)){
              return "NotExistValues";
          }
      }
      return "";
    };

    //
    public static String txExistCondition2(String str1, String str2){
      if(str1 != null | str1 != ""){
          return str1;
      } else return str2;
    };

    //txChDateFormat
    public  static String txChDateFormat(String str,String formatted){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(str,formatter);
        System.out.println(date.toString());
        String[] tempArr = date.toString().split("-");
        System.out.println(tempArr[0]);
        String convDate = tempArr[2] + tempArr[1] + tempArr[0];

    return convDate;
    };
    //txChFormat
    public static String txChFormat(String str,String format1, String format2){
        //세번째 파라미터 형태로 리턴 format2 format1?,,
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//        LocalDate date = LocalDate.parse(str,formatter);
//        System.out.println(date.toString());

        //변환할 문자열
        System.out.println(str);

        //데이터 패턴
        String convFormat = format2;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

        SimpleDateFormat formatting = new SimpleDateFormat(format2);
        try {
            //변환전 시간
            Date date = format.parse(str);
            System.out.println(date.getTime());

            String strDate = formatting.format(date);
            System.out.println(strDate);
            return strDate;
        } catch (Exception e) {
            e.printStackTrace();
        };

    return "ParseError";

    };

    //txToUpper
    public static String txToUpper(String str){

        String exStr = str.toUpperCase();

        return exStr;
    };

    //txToLower
    public static String txToLower(String str){

        String exStr = str.toLowerCase();

        return exStr;
    };

    //txRemoveSpaces
    public static String txRemoveSpaces(String str){
        String exStr = str.replace(" ","");
        System.out.println(exStr);
        return  exStr;
    };

    //txZeroToNull
    public static String txZeroToNull(int zero){
        //0을 빈문자열로 리턴

        return "";
    };

    //codemap
    public static String codemap(String data, String key1,String value1, String key2, String value2){

        if(data.equals(key1)){
            return value1;
        } else if (data.equals(key2)){
            return value2;
        }
        return data;
    };

    //txSplit
    public static String txSplit(String str, String spStr, int cut){

        String[] arr = str.split(spStr);
        if(cut >= arr.length){
            return "err";
        }
        return arr[cut].toString();
    };

    //getUUID
    public static String getUUID(){
        return UUID.randomUUID().toString();
    };

    //팩토리얼 계산
    static int factorial(int n) {
        if(n>0) {
            return n*factorial(n-1);
        }
        else {
            return 1;
        }

    }





}
