package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CJSON {

    //클래스 전역에서 사용할 Object 타입의 변수 선언.
    public Object data;

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

        chae.allTrim().charList();


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
            list.add(s);
        }

        return list;
    }


}
