package com.example.demo;
import java.util.*;

//Json Data(String)을 받은 JsonParser(data)를 생성. getJson-> data(0) = {}, data(1) =  {}, ~~~ map을 리턴 함.
public class JsonParser {

    //실행함수
    public static void main(String[] args) {
        String jsonData = "{\n" +
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

        JsonParser parser = new JsonParser(jsonData);
        System.out.println("<<<<<<<<<<<< "+parser.getJson().getResult(1).getValue("address") +" >>>>>>>>>>>");
        //Jsondata를 생성자에 전달-> Jsondata중 원하는 행을 선택 -> key값을 입력 -> value값이 나옴.

    }

    private String data;

    JsonParser(String data) {
        this.data = data;
    }


    //Json(String)을 전달받아서 자른후 map에 넣어줌.
    private JsonParser getJson() {

        //문자열 필터링.
        String[] altStr = filtStr(data).data.split(" ,");

        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < altStr.length; i++) {

            map.put("data" + i, altStr[i]);
        }


        return this;
    }

    ;

    private JsonParser filtStr(String str) {

        //변환
        String[] tempStr = str.substring(str.indexOf("[") + 1, str.indexOf("]"))
                .split("}");
        String returnStr = "";

        for (String s : tempStr) {

            returnStr += s.replace("{", "").replace("}", "");

        }
        System.out.println("filtStr 리턴값: " + returnStr);

        data = returnStr;
        return this;
    }

    ;


    private JsonParser getResult(int num) {

        data = data.split(" ,")[num];
        return this;
    }

    private String getValue(String id) {

        //Json의 여러 데이터중 한개를 받아옴 {"n1":"2","n2":"3", ~~~} 이런 형식으로 받아옴.
        String[] temp = data.replace(" ", "").split(",");

        //이중 배열 선언
        String[][] arrTemp = new String[100][100];

        String get = "";
       loop: for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                arrTemp[i][j] = temp[j];
                //정상적으로 배열에 들어감.
                System.out.println(arrTemp[i][j]);
                System.out.println(arrTemp[i][j].replace("\"","").trim().split(":")[0]);
                get = arrTemp[i][j].replace("\"","").trim().split(":")[0];
                if (get.equals(id)){
                    data = arrTemp[i][j].replace("\"","").trim().split(":")[1];
                    break loop;
                }

            }
        }


        /*
        if (arrTemp[i][j].matches(id)){
                    data = arrTemp[i][j].replace("\"","").trim().split(":")[1];
                    break loop;
                }
        */

//               System.out.println("배열 출력 "+ arrTemp[0][1] + " 배열 입니다");

        return data;
    }


}


//JsonParser