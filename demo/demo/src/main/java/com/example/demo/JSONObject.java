package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//JSONObject의 형식을 지정할 클래스
public class JSONObject {

    String data;

    static Map<String, List<String>> map = new HashMap<>();

    public JSONObject() {
    }

    //String값을 넣는다
    public void put(String id, String object) {
        List<String> list = new ArrayList<>();
        list.add(object);
        map.put(id, list);
    }

    //배열을 받음
    public void put(String id, List<String> li) {
        List<String> list = new ArrayList<>();
        for (String s : li) {
            list.add(s);
        }
        map.put(id, list);
    }

    //get
    public JSONObject get(String id) {

        return this;
    }


    // JSON DATA를 String
    public JSONObject parse(Object obj) {

        data = (String) obj;

        return this;
    }

    //Nested Class JSONArray
    static class JSONArray {
        static List<Object> jsonArray = new ArrayList<>();

    }

}
