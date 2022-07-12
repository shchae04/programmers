package com.example.demo;

public class CJSONTest {

/*
string() -> 원하는 값; -> data, id, name, address, 서울, id, name, address, 부산, id, name, 수박, address, 제주도
받은 값 -> data, id, name, 공유, address, 서울, {, id, name, 박서준, address, 부산
 */
}

/*

        while (pos < buf.length) {
            if (buf[pos] == '{') {
                object();
            }
            if (buf[pos] == '[') {
                array();
            }

            if (buf[pos] == '\"') {
                return result;
            }

            if (buf[pos] == '1' || buf[pos] == '2'
                    || buf[pos] == '3' || buf[pos] == '4'
                    || buf[pos] == '5' || buf[pos] == '6'
                    || buf[pos] == '7' || buf[pos] == '8'
                    || buf[pos] == '9') number();


            if (buf[pos] == ':') pos++;


            //pos가 총길이의 -1 보다 작다면 pos++ 초과한다면 pos++를 하지 않는다.
            if (pos < buf.length - 1) {
                result += buf[pos];
                pos++;
            }
            if (buf[pos] == ',') {
                pos++;
            }

            if (buf[pos] == '\"') break;
        }
        System.out.println("string()메서드로 반환하는 값 : >>>");
        return result;
 */