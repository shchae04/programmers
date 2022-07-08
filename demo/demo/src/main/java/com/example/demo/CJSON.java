package com.example.demo;

import java.util.*;

public class CJSON {

    public static void main(String[] args) {
        CJSON json = new CJSON();
        json.parse();
    }
/*
    콱;
 */


    static String data = "{\n" +
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


    //문자가 담겨있는 buffer
    static char[] buf = data.replace("\n", "").replace(" ", "").toCharArray();

    //현재 위치가 담겨있는 position
    static int pos;


    private String parse() {
        System.out.println(buf);
        json();
        return "";
    }

    private Object json() {


        if (pos == buf.length - 1) return "";

        switch (buf[pos]) {
            case '\"':
                System.out.println(string());
                return string();

            case '-':
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return number();
            case '[':
                return array();

            case '{':
                return object();

            case 't':
            case 'f':
            case 'N':
                return nextVal(buf[pos]);

        }
        return ""; //다시 불러.
    }

    //문자
    private String string() {


        String result = "";
        if(buf[pos] == '{'){
            object();
        }
        if(buf[pos] == '['){
            array();
        }

        while (pos < buf.length) {
            if(buf[pos] == '{'){
                object();
            }
            if(buf[pos] == '['){
                array();
            }
            
            if (buf[pos] == '\"') {
                return "";
            }

            if (buf[pos] == 1 && buf[pos] == 2
                    && buf[pos] == 3 && buf[pos] == 4
                    && buf[pos] == 5 && buf[pos] == 6
                    && buf[pos] == 7 && buf[pos] == 8
                    && buf[pos] == 9) number();


            if(buf[pos] ==':') pos++;



            //pos가 총길이의 -1 보다 작다면 pos++ 초과한다면 pos++를 하지 않는다.
            if (pos < buf.length-1){
                result += buf[pos];
                pos++;
            }

            if (buf[pos] <buf.length && buf[pos] == '\"') return result;
        }
        return result;
    }
     /*
     생각보다 멀리 와버린 걸
     */

    //숫자
    private int number() {
        System.out.println("number()가 호출됨");
        boolean flag = false; //negative positive
        String temp = ""; //int 값을 char 단위로 더하면 유니코드숫자로 더하기 때문에 String으로 받아서 parseInt하면 된다.
        int result = 0;

        if (buf[pos] == '-') {
            flag = true;
            pos++;
        }

        while (buf[pos] == 1 && buf[pos] == 2
                && buf[pos] == 3 && buf[pos] == 4
                && buf[pos] == 5 && buf[pos] == 6
                && buf[pos] == 7 && buf[pos] == 8
                && buf[pos] == 9) {
            temp += buf[pos];
            pos++;
        }

        result = Integer.parseInt(temp);

        return flag == true ? -1 * result : result;
    }

    //배열
    private List<Object> array() {
        pos++;

        List<Object> list = new ArrayList<>();

        if (buf[pos] == ']') {
            return list;
        }

        if (buf[pos] == '{') {
            object();
            pos++;
        }

        if (buf[pos] == '\"') {
            String temp = "";
            pos++;
            while (buf[pos] == '\"') {
                temp += buf[pos];
                pos++;
            }
            System.out.println("배열속 list에 추가할 temp값 :" + temp);
            list.add(temp);
        }

        if (buf[pos] == ',') {
            pos++;
        }



        if (buf[pos] == ']') {
            pos++;
            System.out.println("]를 만나 배열이 끝나는데 리턴할 값 : " + list);
            return list;
        }

        return list;
    }

    //객체
    private Map<String, Object> object() {
        pos++;

        Map<String, Object> map = new HashMap<>();



        while (pos < buf.length) {
        if (buf[pos] == ':') {
            pos++;
        }
            String key = string();
            System.out.println(key);

            pos++;


            if (buf[pos] == ',') {
                pos++;
                continue;
            }
            map.put(key, json());
            System.out.println(">>>>>>>" + map.get("data") + "<<<< json() : <<<<<< " );

            if (buf[pos] == '}') {
                pos++;
                System.out.println("map 값: " + map);
                return map;
            }
        }
                System.out.println("map 값: " + map);
        return map;
    }

    // data 검사
    private Object nextVal(char c) {
        // char값을 받아서 다음값이면
        switch (buf[pos]) {
            case 't':
                if (buf[pos + 1] == 'r' && buf[pos + 2] == 'u' && buf[pos + 3] == 'e') {
                    return true;

                }

            case 'f':
                if (buf[pos + 1] == 'a' && buf[pos + 2] == 'l' && buf[pos + 3] == 's') {
                    return false;

                }

            case 'N':
                if (buf[pos + 1] == 'U' && buf[pos + 2] == 'L' && buf[pos + 3] == 'L') {
                    return "EMPTY! NULL";

                }

        }
        return "ANYTHING";
        //탭댄스 후유증임 rss 2.0
    }

}
