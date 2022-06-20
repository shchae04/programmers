package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CJSON {

    public static void main(String[] args) {
        CJSON json = new CJSON(data);
        json.get("did");
    }

    //클래스 전역에서 사용할 Object 타입의 변수 선언.
    public static Object data;

    //Json형식 String 데이터를 받는 생성자를 생성.
    public CJSON(Object data) {
        this.data = data;
    }

    // 파싱할 데이터
    String jsondata = "{\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 1,\n" +
            "      \"name\": \"공유\",\n" +
            "      \"address\": \"서울\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"name\": \"박서준\",\n" +
            "      \"address\": \"부산\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"name\": \"수박\",\n" +
            "      \"address\": \"제주도\"\n" +
            "    }\n" +
            "  ]\n" +
            "    } ";


    //Json parser에 값을 달라고할 id
    public String get(String id) {

        CJSON chae = new CJSON(jsondata);

        List<String> list = tokenDivisor(chae.allTrim().charList());

        System.out.println(list.toString());


        return "";
    }

    // 공백과 엔터를 제공해주는 메서드 allTrim()선언
    public CJSON allTrim() {

        String temp = (String) data;
        temp.replace("\n", "").replace(" ", "");

        data = temp;

        return this;
    }

    // object를 담아서 char 단위로 나누고 list에 담는 함수 char값이 담긴 list를 리턴합니다.
    public List<Character> charList() {

        String temp = (String) data;

        List<Character> list = new ArrayList<>();
        char[] cha = temp.toCharArray();
        for (char s : cha) {
            if(s == '\n' || s==' ') {
                continue;
            }
            list.add(s);
        }

        return list;
    }


    // List를 받아서 토큰값을 return 하는 tokenDivisor()
    public List<String> tokenDivisor(List<Character> list) {

        //배열을 돌면서 찾을 char들
        char sBrace = '{';
        char eBrace = '}';
        char sBraket = '[';
        char eBraket = ']';

        list.add(sBrace);

        //값을 담을 List선언
        List<String> strList = new ArrayList<>();

        //뒤집기


        //반복문에서 나올 변수를 담을 getV 선언
        String getV = "";

        for (char s : list) {
            getV += s;
        }

        //인덱스 값을 찾을 반복문문
        for (int i = 0; i < list.size(); i++) {


            //초기화할 변수
            int temp = 0;
            int endTemp = 0;

            for (int j = list.size() - 1; j >= 0; j--) {


                if (list.get(i).equals(sBrace)) {
                    temp = i;
                    if (list.get(j).equals(eBrace)){
                        endTemp = j;
                        strList.add(getV.substring(i,j));
                        temp = 0; endTemp = 0;
                    }

                }


                // [ 시작하는 인덱스부터 ] 까지 짤라내서 strList에 add
                if (list.get(i).equals(sBraket)) {
                    temp = i;
                    if (list.get(j).equals(eBraket)) {
                        endTemp = j;
                        strList.add(getV.substring(i, j));
                        temp = 0;
                        endTemp = 0;
                    }
                }

            }


            //초기화.
            temp = 0;
            endTemp = 0;
//
//
//           // 처음 {를 찾으면
//           if(list.get(i).equals(sBrace)) {
//                temp = i;
//            }
//           if(list.get(i).equals(eBrace)){
//               endTemp = i;
//           }
//
//           getV += list.get(i);
//
//           getV.substring(temp,endTemp);


        } // end of for


        //getV에 list에 모든 문자가 담겼다 getV를 쪼개서 list에 담아야 하는데.


        return strList;
    }

    JSONPObject

}
