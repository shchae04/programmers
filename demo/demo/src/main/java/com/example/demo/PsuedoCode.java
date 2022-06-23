package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public class PsuedoCode {

        static String ccode ="dasfdasfljasdlkfjaksdjflasdjflsadkj";

    public static void main(String[] args) {
        PsuedoCode code = new PsuedoCode();
        code.parse(code);

    }
   // 주석처리할 코드라 에러에 신경쓰지 않고 작성함 code는 공백과 스페이스를 가공한 JSON 데이터임.
        static char[] buf = ccode.toCharArray();
        static int pos = 0;
    public PsuedoCode parse(PsuedoCode 코드) {
        String code = 코드.toString();


        //문자열을 저장할 배열인 buffer, 현재 위치를 나타내는 position

        //char 하나만 가지고 판별해야함 첫번째 문자를 보고 판별 가능함.


        return 코드;
    }
        public Object json() {
            switch (buf[pos]) {

                case '{' : return object();

                case '[' : return array();

                case '\"' : return string();

                case  '-':
                case  '1':
                case  '2':
                case  '3':
                case  '4':
                case  '5':
                case  '6':
                case  '7':
                case  '8':
                case  '9': return number();

                case 't' : {
                    pos++;
                    if (buf[pos] == 'r' && buf[++pos] == 'u' && buf[++pos + 1] == 'e') {
                        return true;
                    }
                }

                case  'f': {
                    pos++;
                    if (buf[pos]=='a'&& buf[++pos] == 'l' && buf[++pos + 1] == 's' && buf[++pos + 2] == 'e') {
                        return false;
                    }
                }

            }
        return "";
    }

    private Map<String,Object> object() {
        Map<String,Object> result = new HashMap<>();

        return result;
    }

    private String string() {
        String result = "";
        pos++;
        while (true) {
            //바로 " 가 나와서 문자열이 끝나는 경우
            if(buf[pos] == '\"') {
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

        if(buf[pos] == '-'){
            flag = true; //음수다
            pos++;
        }

        while(buf[pos] == '1' && buf[pos] == '2'&& buf[pos] == '3'&& buf[pos] == '4'&& buf[pos] == '5'&& buf[pos] == '6'&& buf[pos] == '7'&& buf[pos] == '8'&& buf[pos] == '9' ) {

                result += buf[pos];
                pos++;
        }


        return flag == false ? result : (-1*result);
    }

    private Object[] array() {


        Object[] result = new Object[buf.length];

        pos++;
        if(buf[pos] == ']') {
            return new Object[0]; //빈 배열을 리턴할거다.
        }
        
        //빈 배열이 아니라면. 처리해줘야 함 이건 내일 해보도록하자!! 헤헤

        return result;
    }

}
