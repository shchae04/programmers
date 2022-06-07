package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class JsonParser {

    private String id;
    private String name;
    private String address;



    public static void main(String[] args) {
        JsonParser p = new JsonParser();
        Map<String,String> getMap =  p.jsonToString("{\n" +
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
                "    }  ");



        System.out.println(getMap.get("data0")+"이걸 어떻게 활용하냐?");
        String[] param = getMap.get("data0").split(",");
        System.out.println(param[0]);
        String[] temp = param[0].replace("\"","").split(":");
        System.out.println(temp[0]); // id
        System.out.println(temp[1]); // 1


        //요구사항 getMap.get("data0").get("id") = 3이 나와야 한다.
         getMap.get("data1").split(",");

         String key ="";
         String value ="";

         for(int i=0; i< temp.length; i++){
            if(key.equals(temp[i])){
                value = temp[1];
            }
            return;

         }



    }


    //JAVA JSON PARSER
    /*
    {
  "data": [
    {
      "id": 1,
      "name": "공유",
      "address": "서울"
    },
    {
      "id": 2,
      "name": "박서준",
      "address": "부산"
    },
    {
      "id": 3,
      "name": "수박",
      "address": "제주도"
    }
  ]
    }                   JSON 데이터 전송 받는 형식.
    */

    //변환해서 String 전달
    public Map<String, String> jsonToString(String jsonFile){

        String altStr = jsonFile.substring(jsonFile.indexOf("[")+1,jsonFile.indexOf("]"));
//        System.out.println(altStr.split("},")[0].replace("{",""));
        String[] strSize = altStr.split("},");

        Map<String,String> map = new HashMap<>();

        for(int i=0; i< strSize.length; i++){
            String alterStr = strSize[i].replace("{","").replace("}","");
            map.put("data"+i,alterStr);
        }
//        System.out.println(altStr.replace("{","").replace("}",""));
        System.out.println(map.get("data2"));

        return map;
    }

    //p라는 객체가 JsonToString해서 map이라는 값을 들고 있다 이 map이라는 값을 받는 메서드를 만들자.


}
