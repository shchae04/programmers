package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonParserV2 {

    /*
        기존 JsonParser같은 경우에는 JSON data안에 객체 안에 객체가 있는 경우에는 파싱이 불가능했다.
        이러한점을 보완하고자 JsonParserV2를 만들어보자.
     */


    public static void main(String[] args) {
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

        JsonParserV2 v2 = new JsonParserV2(jsondata);
        v2.parsing();
    }

    private String data;

    public JsonParserV2(String data) {
        this.data = data;
    }

    /*
    parsing() 함수는 JsonParserV2를 받아서 data의 공백을 제거하고 char단위로 나누어서 리스트에 담아주는 역할을 하는 함수.
     */
    public JsonParserV2 parsing() {
        //trim();
        this.data = data.replace(" ", "").replace("\n","");

        //char 단위로 나누어서 List에 담기
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            list.add(data.charAt(i));
        }
        System.out.println(list);


        // 1. 호출
        tokenizer(list);

        return this;
    }

    // Character가 담겨있는 리스트를 받아서 delimeter 의 개수를 카운트 해주는 함수 tokenizer()
    public JsonParserV2 tokenizer(List<Character> list) {

        //JSON data 에 있는 delimter.
        char sBrace = '{'; // 중괄호 시작
        char eBrace = '}'; // 중괄호 끝
        char sBraket = '['; // 대괄호 시작
        char eBraket = ']'; // 대괄호 끝
        char dot = '\"'; // " 시작

        int countSbrace = 0;
        int countEbrace = 0;
        int countSbraket = 0;
        int countEbraket = 0;
        int countDOt = 0;

        //현재 문자열의 인덱스 위치를 나타냄 위치판단의 지표
        int curIdx = 0;

        int braceCount = 0;

        int braketCount = 0;

            String JsonArr = "";
        for (curIdx = 0; curIdx < list.size(); curIdx++) {
            JsonArr += list.get(curIdx);
            // { 를 만난 경우 json 토큰의 시작으로 간주 subString할  int 값 저장할 변수 선언.
            if (list.get(curIdx).equals(sBrace)) {
                countSbrace++;
                braceCount++;
            }
            // } 를 만난 경우
            if (list.get(curIdx).equals(eBrace)) {
                countEbrace++;
                braceCount--;
            }
            // [ 를 만난 경우
            if (list.get(curIdx).equals(sBraket)) {
                countSbraket++;
                braketCount++;
            }
            // ] 를 만난 경우
            if (list.get(curIdx).equals(eBraket)) {
                countEbraket++;
                braketCount--;
                // " 를 만난 경우
            }
            if (list.get(curIdx).equals(dot)) {
                countDOt++;
            }
        }

        // 개수를 세면서 잘라 줄 함수.

        System.out.println("중괄호 시작 개수 :" + countSbrace);
        System.out.println("중괄호 끝 개수 :" + countEbrace);
        System.out.println("대괄호 시작 개수 :" + countSbraket);
        System.out.println("대괄호 끝 개수 :" + countEbraket);
        System.out.println("'\"' 개수" + countDOt);
        //4, 4, 1, 1 개수 끝까지 파싱해보면 된다.

        // { 기호를 가지고 나왔을 경우 먹어치운다. [ 기호가 나오면 cnt + 1을 하고 ] 기호가 나오면 cnt - 1처리 하고 그중간 값을 리턴.
        // } 기호 까지 묶어서 리스트에 담아서 리턴합니다.
        List<String> jsonList = new ArrayList<>();

        // {"data":[{"id":1,"name":"공유","address":"서울"},{"id":2,"name":"박서준","address":"부산"},{"id":3,"name":"수박","address":"제주도"}]}
        System.out.println(JsonArr);
        data = JsonArr;

        byteTokenizer(list);

        return this;
    }


    // char값을 받아서 토큰화 하는 함수 tokenizing
    public JsonParserV2 byteTokenizer(List<Character> list) {

        int pivot =0; //기준값으로 설정. 비교할 값! 리스트에서 비교할 거라서 따로 생각할 필요는 없을듯.
        //시작값
        int begin = 0;
        //끝값
        int end = list.size();

        while (begin < end) {
            String str = "";
            str += "dfas";
            pivot++;

        }


        return this;
    }


    /*
        중괄호로 Json데이터 시작 "data" 라는 이름으로 배열이 시작 [ {},{},{} ] 중괄호로 데이터 끝. 파싱해라.
        개수를 세야 할듯 {의 개수와 }의 개수가 동일해야 합니다. [이 있다면 끝까지 탐색후 [ 전에 있는 데이터의 이름으로 배열 을 설정합니다.

     */


}