package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 */

public class PsuedoCode {

    static String ccode = "{\n" +
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

    public static void main(String[] args) {
        PsuedoCode code = new PsuedoCode();
        code.parse(code);

    }

    // 주석처리할 코드라 에러에 신경쓰지 않고 작성함 code는 공백과 스페이스를 가공한 JSON 데이터임.
    static char[] buf = ccode.toCharArray();
    static int pos = 0;

    public PsuedoCode parse(PsuedoCode 코드) {
        String code = 코드.toString();

        json();
        //문자열을 저장할 배열인 buffer, 현재 위치를 나타내는 position
        System.out.println(json());
        //char 하나만 가지고 판별해야함 첫번째 문자를 보고 판별 가능함.


        return 코드;
    }

    public Object json() {
        switch (buf[pos]) {

            case '{':
                return object();

            case '[':
                return array();

            case '\"':
                return string();

            case '-':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return number();

            case 't': {
                pos++;
                if (buf[pos] == 'r' && buf[++pos] == 'u' && buf[++pos + 1] == 'e') {
                    return true;
                }
            }

            case 'f': {
                pos++;
                if (buf[pos] == 'a' && buf[++pos] == 'l' && buf[++pos + 1] == 's' && buf[++pos + 2] == 'e') {
                    return false;
                }
            }

        }
        return "";
    }

    private Map<String, Object> object() {
        Map<String, Object> result = new HashMap<>();

        return result;
    }

    private String string() {
        String result = "";
        pos++;
        while (true) {
            //바로 " 가 나와서 문자열이 끝나는 경우
            if (buf[pos] == '\"') {
                pos++;
                return result;
            }
            result += buf[pos];
            if (buf[pos] == '\"') {
                return result;
            }
        }

    }

    private int number() {
        int result = 0;
        //음수인지를 판달하는 불린함수
        boolean flag = false;

        if (buf[pos] == '-') {
            flag = true; //음수다
            pos++;
        }

        while (buf[pos] == '1' && buf[pos] == '2'
                && buf[pos] == '3' && buf[pos] == '4'
                && buf[pos] == '5' && buf[pos] == '6'
                && buf[pos] == '7' && buf[pos] == '8'
                && buf[pos] == '9') {

            result += buf[pos];
            pos++;
        }


        return flag == false ? result : (-1 * result);
    }

    private Object array() {


        Object result;

        pos++;
        if (buf[pos] == ']') {
            return new Object[0]; //빈 배열을 리턴할거다.
        }
        List<String> list = new ArrayList<>();
        result = list;
        //빈 배열이 아니라면. 처리해줘야 함
        // String, int , boolean, 객체 타입이 나올 수 있다. 한번더 JSON()함수를 호출하면 된다.
        if (buf[pos] == '\"') { //문자열이라면
            String temp = "";
            pos++; //위치를 한칸 앞으로 옮겨주고  다시 " 나오기 전까지 temp에 담는다
            while (buf[pos] == '\"') {
                temp += buf[pos]; //담은 값 을 List<String> 에 추가 함!
            }
            list.add(temp);
        }

        if (buf[pos] == ',') { //배열의 한 구문이 끝났다고 가정을 함.
            pos++;
        }
        //숫자가 나왔다면.
        if (buf[pos] == '1'
                && buf[pos] == '2'
                && buf[pos] == '3' && buf[pos] == '4'
                && buf[pos] == '5' && buf[pos] == '6'
                && buf[pos] == '7' && buf[pos] == '8'
                && buf[pos] == '9') {

            number();
            pos++;
        }

        //객체가 나오면
        if (buf[pos] == '{') {
            object();
            pos++;
        }

        if (buf[pos] == ']') {
            // 배열을 끝마침
            pos++;
            return result;
        }


        return result;
    }

}
