package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RuleConfig {


    public static void main(String[] args) {

        RuleConfig r = new RuleConfig();
        //run 메서드 실행
//        System.out.println("|txAppend|@2013|@231 전달함 값은? "+r.run("|txAppend|@2013|@231"));


        //Append 실행
        System.out.println("Append " + append("dff", "dfe"));

        //AppendWithSpace 실
        System.out.println("AppendWithSpace " + appendWithSpace("dfdd", "dfdfd"));

        //Substring 실행
        System.out.println("Substring " + substring("abcdefg", 0, 3));

        //SubstringWithHan 실행
        System.out.println("SubstringWithHan " + substringWithHan("가나다라마", 0, 6));

        //GetNotMatch 실행
        System.out.println("GetNotMatch " + getNotMatch("가나", "가나", "가나다라"));

        //ifExist
        System.out.println("ifExist " + ifExist("ab", "ab", "TRUE"));

        //ifNotExist
        System.out.println("ifNotExist " + ifNotExist("av", "av", "dfdf"));

        //LeftFillen
        System.out.println("LeftFillen " + LeftFillen("-ABCDEF", 10, "#"));

        //RightFillLen
        System.out.println("RightFillLen " + RightFillLen("ABCDEF", 10, "#"));

        //ChangeSpace
        System.out.println("ChangeSpace " + ChangeSpace("", "1234"));

        //ChangeString
        System.out.println("ChangeString " + ChangeString("ab", "ab", "cde"));

        //Omit
        System.out.println("Omit " + Omit("###ab###", "#"));

        //FixDownDecimalPlaces
        System.out.println("FixDownDecimalPlaces " + FixDownDecimalPlaces(123456, 3));

        //FixDate
        System.out.println("FixDate " + FixDate("150602", 6));

        //CutPadddingzero
        System.out.println("CutPadddingzero " + cutPadddingzero("001234"));

        //ReverseSubstring
        System.out.println("ReverseSubstring " + ReverseSubstring("ABCDEFG", 2, 4));

        //leftSubstring
        System.out.println("leftSubstring " + leftSubstring("ABCDEFG", 2));

        //rightSubstring
        System.out.println("rightSubstring " + rightSubstring("ABCDEFG", 3));

        //fillNumberZero
        System.out.println("fillNumberZero " + fillNumberZero("ABCDEFG", 10));

        //GetTimeStr
        System.out.println("GetTimeStr " + GetTimeStr(new Date()));
        //Replace
        System.out.println("Replace " + Replace("ABCDEEFF", "E", "H"));//decode
        System.out.println("decode " + decode("ABC", "A", "1", "AB", "2", "3"));
        //ExistCondition
        System.out.println(ExistCondition("ABC", "DEF", "GHI"));
        //ifExistValues
        System.out.println(ifExistValues("ABC"));
        //ifNotExistValues
        System.out.println(ifNotExistValues("ABC"));
        //ExitstCondition2
        System.out.println(ExistCondition2("ABC", "DEF"));
        //ChDateFormat
        System.out.println(ChDateFormat("20150625", "ddMMyyyy"));
        //ChFormat
        System.out.println("ChFormat " + ChFormat("20150625", "yyyyMMdd", "yyyy-MM-dd"));
        //ToUpper 실행
        System.out.println("ToUpper " + ToUpper("abcde"));

        //ToLower 실행
        System.out.println("ToLower " + ToLower("ABCDE"));

        //RemoveSpaces 실행
        System.out.println("RemoveSpaces " + RemoveSpaces("abc de ef"));

        //ZeroToNull 실행
        System.out.println("ZeroToNull " + ZeroToNull(0));

        //codemap 실행
        System.out.println("codemap " + codemap("A", "A", "B", "C", "D"));

        //Split 실행
        System.out.println("Split " + Split("ABCDE", "C", 1));

        //getUUID 실행
        System.out.println("getUUID " + getUUID());

        //getFact
        System.out.println(getFactorial(1000));

        //run1 실행
        System.out.println("method run1실행" + run1("|txAppend|@2013|@231"));

    }


    //Append
    public static String append(String a, String b) {


        return a + b;
    }

    //AppendWithSpace
    public static String appendWithSpace(String a, String b) {

        String cnt = "";
        cnt = a + " " + b;

        return cnt;
    }

    //Substring
    public static String substring(String str, int a, int b) {


        return str.substring(a, b);
    }

    //SubstringWithHan Byte로 입력받음
    public static String substringWithHan(String str, int beginBytes, int endBytes) {

        //문자열이 비어있을 경우
        if (str == null || str.getBytes().length == 0) {
            return "";
        }

        //시작 바이트 값이 0보다 작을 경우
        if (beginBytes < 0) {
            beginBytes = 0;
        }

        //끝 바이트 값이 1보다 작을 경우
        if (endBytes < 1) {
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

        for (int i = 0; i < strLength; i++) {
            //하나씩 자르면서
            ch = str.substring(i, i + 1);
            System.out.println(ch);

            curBytes += ch.getBytes().length;
            System.out.println(curBytes);

            //시작 인덱스 값이 -1이거나, 현재 바이트가 시작 바이트보다 클때 시작인덱스의 값을 i로 설정
            if (beginIndex == -1 && curBytes >= beginBytes) {
                beginIndex = i;
            }

            //현재 바이트값이 끝바이트값보다 커지면 stop;
            if (curBytes > endBytes) {
                break;
            } else {
                endIndex = i + 1;
            }
        }

        return str.substring(beginIndex, endIndex);
    }

    //GetNotMatch
    //2~n까지 가변인자.
    public static String getNotMatch(String a, String... str) {

        if (a == null || str == null || str.equals("")) {
            return "";
        }
        String contemp = "";
        for (String s : str) {
            if (!a.equals(s)) {
                contemp = s;
            }
        }
        return contemp;
    }

    //ifExist
    public static String ifExist(String s1, String s2, String s3) {
        //s1이 s2에 속해있으면 s3리턴 그렇지 않으면 ""리턴

        if (s2.contains(s1)) {
            return s3;
        } else {
            return "";
        }
    }

    //ifNotExist
    public static String ifNotExist(String s1, String s2, String s3) {
        //s1이 s2에 속해있지않으면 s3리턴 그렇지 않으면 ""리턴

        if (!s2.contains(s1)) {
            return s3;
        } else {
            return "";
        }
    }

    //LeftFillen
    public static String LeftFillen(String str, int num, String addStr) {
        //두번째 param만큼 자리수를 늘리고 세번째 문자열을 채운다. 두번째 파라미터수가 첫번쨰 자리수보다 작으면
        //빈 문자열 리턴

        StringBuilder tempStr = new StringBuilder(str);
        System.out.println(tempStr);

        //문자열 앞에 - 가있는 경우 마지막에 붙이기
        if (str.startsWith("-")) {
            tempStr.delete(0, 1);
            tempStr.append("-");
        }

        //두번째 파라미터가 첫번째 문자열 자리수보다 작을 경우 빈 문자열 리턴
        if (str.length() > num) {
            return "";
        }

        //두번째 파라미터 수만큼 자리수 늘리기
        for (int i = 0; i < num; i++) {
            tempStr.insert(0, addStr);
            if (tempStr.length() == num) {
                break;
            }
        }

        return tempStr.toString();
    }

    //RightFillLen
    public static String RightFillLen(String str, int num, String addStr) {
        StringBuilder tempStr = new StringBuilder(str);

        for (int i = 0; i < num; i++) {
            tempStr.append(addStr);
            if (tempStr.length() == num) {
                break;
            }
        }

        return tempStr.toString();
    }

    //ChangeSpace
    public static String ChangeSpace(String s1, String s2) {
        if (s1.isEmpty()) {
            return s2;
        }
        return s1;
    }

    //ChangeString
    public static String ChangeString(String str1, String str2, String strValue) {
        if (str1 == null) {
            System.out.println("값입력");
        }
        if (str1.equals(str2)) {
            return strValue;
        } else return str1;
    }

    //Omit
    public static String Omit(String str, String delStr) {
        //첫번째 문자열에 두번째 문자열이 있을 경우 제거하고 리턴
        //문자열은 불변 ***************************이거 까먹어서 엄청 오래걸렸다..

        String text = str.replace(delStr, "");

        return text;
    }

    //FixDownDecimalPlaces
    public static String FixDownDecimalPlaces(double realNum, int cNum) {
        //첫번째 파라미터를 두번째 파라미터만큼 소수점 처리 소수점이 없으면 두번째 파라미터 수만큼 0처리

        System.out.println(String.format("%." + cNum + "f", realNum));
        String formatNum = String.format("%." + cNum + "f", realNum);
        System.out.println("길이" + formatNum.length());
        System.out.println("길이" + realNum);

        StringBuilder sbd = new StringBuilder(formatNum);

        if (!formatNum.contains(".")) {
            sbd.append("0");
        }

        return sbd.toString();
    }

    //FixDate //사용 미권장 메서드
    public static String FixDate(String birth, int se) {
        //20150602 or 150602
        if (birth.length() != 6 || birth.length() != 8 && se != 6 || se != 8) {
            return birth;
        }
        SimpleDateFormat df = new SimpleDateFormat("YYYYMMDD");
        SimpleDateFormat df2 = new SimpleDateFormat("YYMMDD");


        //se 가 6이냐 8이냐.
        if (se == 6) {
            String six = df2.format(birth);
            return six;
        } else if (se == 8) {
            String eight = df.format(birth);
            return eight;
        }

        return df.toString();
    }


    //CutPadddingzero
    public static String cutPadddingzero(String num) {

        //String으로 받는경우와 int로 받는 경우로 구분함.
//        String regexNum = Integer.toString(num);
//        System.out.println(regexNum);

        String tempStr = num.replace("0", "");
        return tempStr;

//        return regexNum;
    }

    //ReverseSubstring
    public static String ReverseSubstring(String str, int begin, int end) {
        //문자열을 거꾸로 subString한다 1. 배열을 뒤집어서 자른후 다시 뒤집는다. 2. 반복문으로 뒤에서부터 자른다.

        if ((begin > end) || !(begin >= 0) || !(end >= 1)) {
            return "잘못된 정보";
        }

        //1.
        StringBuilder sbd = new StringBuilder(str);
        sbd.reverse();
        String toStr = sbd.substring(begin, end);
        StringBuilder realStr = new StringBuilder(toStr);
        realStr.reverse();
        System.out.println(realStr.reverse());

        return realStr.reverse().toString();
    }

    //leftSubstring
    public static String leftSubstring(String str, int cnt) {
        //문자열의 왼쪽부터 subString

        return str.substring(0, cnt);

    }

    //rightSubstring
    public static String rightSubstring(String str, int cnt) {
        int strLength = str.length();
        System.out.println(strLength);
        return str.substring(strLength - cnt, strLength);
    }

    //fillNumberZero
    public static String fillNumberZero(String str, int cnt) {

        StringBuilder exStr = new StringBuilder(str);

        if (str.contains("-")) {
            exStr = new StringBuilder(str.replace("-", ""));
            exStr.append("-");
        }

        //자리수 늘리기
        for (int i = 0; i < cnt; i++) {
            exStr.insert(0, "0");
            if (exStr.length() == cnt) {
                break;
            }
        }
        return exStr.toString();
    }

    //GetTimeStr
    public static String GetTimeStr(Date dater) {
        SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");


        return date.format(new Date());

    }

    //Replace
    public static String Replace(String str, String exStr, String coStr) {
        return str.replace(exStr, coStr);
    }

    //decode
    public static String decode(String data, String key1, String value1, String key2, String value2, String value3) {

        if (data.equals(key1)) {
            return value1;
        } else if (data.equals(key2)) {
            return value2;
        } else if (!data.equals(key1) && !data.equals(key2)) {
            return value3;
        }
        return data;

    }

    //fixNull
    public static String fixNull(String str) {
        if (str == null) {
            return "";
        } else return str;
    }

    //ExistCondition
    public static String ExistCondition(String str1, String str2, String str3) {

        if (str1 == null || str1 == "") {
            return str2;
        } else {
            return str3;
        }
    }

    //ifExistValues
    public static String ifExistValues(String... s) {
        if (s != null) {
            return "ExistValues";
        }
        return "";
    }

    //ifNotExistValues
    public static String ifNotExistValues(String... str) {
        for (String s : str) {
            if (s.equals(null)) {
                return "NotExistValues";
            }
        }
        return "";
    }

    //
    public static String ExistCondition2(String str1, String str2) {
        if (str1 != null | !Objects.equals(str1, "")) {
            return str1;
        } else return str2;
    }

    //chDateFormat
    public static String ChDateFormat(String str, String formatted) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(str, formatter);
        System.out.println(date.toString());
        String[] tempArr = date.toString().split("-");
        System.out.println(tempArr[0]);
        String convDate = tempArr[2] + tempArr[1] + tempArr[0];

        return convDate;
    }

    //ChFormat
    public static String ChFormat(String str, String format1, String format2) {
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
        }

        return "ParseError";

    }

    //ToUpper
    public static String ToUpper(String str) {

        String exStr = str.toUpperCase();

        return exStr;
    }

    //ToLower
    public static String ToLower(String str) {

        String exStr = str.toLowerCase();

        return exStr;
    }

    //RemoveSpaces
    public static String RemoveSpaces(String str) {
        String exStr = str.replace(" ", "");
        System.out.println(exStr);
        return exStr;
    }

    //ZeroToNull
    public static String ZeroToNull(int zero) {
        //0을 빈문자열로 리턴

        return "";
    }

    //codemap
    public static String codemap(String data, String key1, String value1, String key2, String value2) {

        if (data.equals(key1)) {
            return value1;
        } else if (data.equals(key2)) {
            return value2;
        }
        return data;
    }

    //Split
    public static String Split(String str, String spStr, int cut) {

        String[] arr = str.split(spStr);
        if (cut >= arr.length) {
            return "err";
        }
        return arr[cut];
    }

    //getUUID
    public static String getUUID() {
        return UUID.randomUUID().toString();
    }


    //1000! 사용 String
    public static double getFactorial(int num) {
        if (num <= 1) {
            return num;
        } else {
            return getFactorial(num - 1) * num;
        }

    }


    public static String run(String txParam) {
        //파라미터를 이렇게 받는다
        // |txFixdate|@2013|@231

        String oneStr = txParam.replaceAll("\\|", "");
        System.out.println("성공적으로 잘린 문자열" + oneStr);
        //@를 기준으로 문자열 자르기 몇개가 나올지는 모른다.
        String[] argParam = oneStr.split("@");

        HashMap<String, Object> map = new HashMap<>();

        //param이 몇개 있을지 모르니깐 반복으로 처리
        for (int i = 0; i < argParam.length; i++) {
            //param의 1번째 값은 rule , 2번째 부터... param.
            System.out.println(argParam[i]);
            if (i == 0) {
                map.put("data", argParam[i]);
                continue;
            }
            map.put("param" + i, argParam[i]);

        }
        //정상적으로 자름.
        System.out.println(map);

        // run 함수 이름에 따라서 Rule Function List
        //map.get object 타입을 매번 형변환 할 수 없으니 미리 변환시켜놓기

        Object answer = "";

        switch ((String) map.get("data")) {
            case "Append":
                System.out.println("Append 함수");
                answer = append((String) map.get("param1"), (String) map.get("param2"));
                System.out.println("param1값: " + map.get("param1"));
                System.out.println("param2값: " + map.get("param2"));
//                System.out.println(answer.toString());
                break;

            case "AppendWithSpace":
                System.out.println("AppendWithSpace 함수");
//                appendWithSpace();
        }
//        System.out.println("이거이거"+answer.toString());
        return answer.toString();
    }

    //벡터를 사용한 run1

    // Java Collection Vector는 Thread-Safe하다. 동기화가 순차적으로 이루어지기 때문이다. 선형구조인 ArrayList와 동일한 구조 인덱스를 삭제하면 인덱스가 앞으로 당겨집니다. 크키가 가변적이다 .
    // ArrayIndexOutOfBoundsException을 일으킬 수 있다.
    //여러 쓰레드에서 같은 리스트를 쓴다면 Vector를 쓰는것이 동기화 오류를 만들지 않는다. 벡터는 동작마다 동기화를 걸어줍니다. 속도를 떨어뜨리게하지만
    //멀티 쓰레드 환경에서는 안전한 작업입니다. Multi-Thread환경이라면 Vector를 사용하고 단일쓰레드를 사용한다면 Arraylist를 사용하면 됩니다.

    public static String run1(String txtParam) {

        Vector<String> vector = new Vector<>();

        String vecStr = txtParam.replaceAll("\\|", "");
        System.out.println("성공적으로 잘린 문자열" + vecStr);

        String[] argParam = vecStr.split("@");

        // data로 들어갈 값
        vector.add(argParam[0]);

        // param 값으로 들어갈 값
        for (int i = 1; i < argParam.length; i++) {
            vector.add(argParam[i]);
        }

        String answer = "";

        switch (vector.get(0)) {
            case "Append":
                System.out.println("Append 함수 실행");
                answer = append(vector.get(1), vector.get(2));
                break;
            case "AppendWithSpace":
                System.out.println("AppendWithSpace 함수 실행");
                answer = appendWithSpace(vector.get(1), vector.get(2));
                break;
            case "Substring":
                System.out.println("Substring 함수 실행");
                answer = substring(vector.get(0), Integer.parseInt(vector.get(1)), Integer.parseInt(vector.get(2)));
                break;

            //Case : 추가하면 됩니다.
        }

        return answer;
    }




}
