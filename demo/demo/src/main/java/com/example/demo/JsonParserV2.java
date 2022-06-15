package com.example.demo;

import java.util.ArrayList;
import java.util.List;

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

    public JsonParserV2 parsing() {
        List<StringBuilder> list = new ArrayList<>();
        String kd = "";
        for(int i=0; i<data.length(); i++){
            StringBuilder sbd = new StringBuilder();

            sbd.append(data.charAt(i));

            list.add(sbd);
            kd += list.get(i);
        }
        System.out.println(kd.replace(" ",""));
        return this;
    }


    // list를 받아서 for문을 통해서 delimeter를 세고 토큰 단위로 리스트에 집어 넣는다 전부 잘라서 char화 시키면 된다.

    //리스트에 담으면 된다.

    /*
        중괄호로 Json데이터 시작 "data" 라는 이름으로 배열이 시작 [ {},{},{} ] 중괄호로 데이터 끝. 파싱해라.
        개수를 세야 할듯 {의 개수와 }의 개수가 동일해야 합니다. [이 있다면 끝까지 탐색후 [ 전에 있는 데이터의 이름으로 배열 을 설정합니다.

     */




}
