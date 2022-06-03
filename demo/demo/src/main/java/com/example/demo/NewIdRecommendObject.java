package com.example.demo;

public class NewIdRecommendObject {
    // 신규 아이디 추천
    public String solution(String new_id) {

    // 코드의 재사용성, 캡슐화

        String s = new KAKAOID(new_id)
                .rePlaceToLowerCase()
                .filter().toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();

        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID rePlaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;

        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", "");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuffer sbd = new StringBuffer(s);
            while (sbd.length() <= 2) {
                sbd.append(sbd.charAt(sbd.length() - 1));
            }
            s = sbd.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
