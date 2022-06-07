package com.example.demo;

import java.util.*;

public class ParserJson {

    public static void main(String[] args) {
        ParserJson p = new ParserJson();
        p.getJson("[{\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"color\": \"Purple\"\n" +
                "}, {\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"color\": \"Yellow\"\n" +
                "}, {\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"color\": \"Crimson\"\n" +
                "}, {\n" +
                "  \"gender\": \"Female\",\n" +
                "  \"color\": \"Pink\"\n" +
                "}]","color");

    }
    /*
    1. String 형태로 Json데이터가 들어옴
    2. [] 기호삭제
    3. {} 삭제
    4. ", " 기준으로 배열에 담음
    5. "gender":"female","color":"yellow"형태로 넘어온 파일.
    6 "," 로 split 하여 배열에 담는다
    7. "gender":"female" , "color":"yellow" 넘겨온 파일을 리스트에 담는다
    8. list에 담긴 값을 get*** 를 통해서 get("gender")  list.get("gender")하면 female을 반환하는 로직을 짜면됨.*/


    public List<String> getJson(String data,String key){
        //json 데이터를 받음, []기호 삭제,{}삭제
        String delPro = data.replace("[","").
                        replace("]","").
                        replace("{","").
                        replace("}","");

        String[] insertListArray = delPro.split(", ");

        List<String> list = insertList(insertListArray);

        System.out.println(list.get(0).split(",")[0]);
        //Json으로 넘겨받은 한객체
        System.out.println(list.get(3)); //"gender": "Female","color": "Pink"
        //한 객체를 , 단위로 쪼개서 임시 배열에 담음
        System.out.println(list.get(3).split(","));
        // 쪼개진 객체를 분리 해서 key값과 value값을 얻어냄
        String a1 = list.get(3).split(",")[0];
        String[] b1 = a1.replace(" ","").replace("\"","").split(":");

        System.out.println(b1[0]);

        if(b1[0].equals(key) || key.isEmpty() || key == "" ){
            List<String> valueList = new ArrayList<>();
            valueList.add(b1[1]);
            return valueList;
        }

        String a2 = list.get(3).split(",")[1];




//        if(key.equals())





        return list;
    }




    //리스트 담기
    public List<String> insertList(String[] s){

        List<String> list = new ArrayList<>();

        for(String str : s){
            list.add(str);
        }

        return list;
    }

}
