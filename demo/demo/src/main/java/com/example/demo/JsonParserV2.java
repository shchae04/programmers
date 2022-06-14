package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class JsonParserV2 {

    /*
        기존 JsonParser같은 경우에는 JSON data안에 객체 안에 객체가 있는 경우에는 파싱이 불가능했다.
        이러한점을 보완하고자 JsonParserV2를 만들어보자.
     */

    private String data;

    public JsonParserV2(String data) {
        this.data = data;
    }

    public JsonParserV2 pasing() {
        List<StringBuilder> list = new ArrayList<>();

        for(int i=0; i<data.length(); i++){
            StringBuilder sbd = new StringBuilder();

            sbd.append(data.charAt(0));

            list.add(sbd);
        }
        System.out.println(list.toString());
        return this;
    }

}
