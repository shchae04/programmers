package com.example.demo;

public class Person {
    static int age;
    static String name;
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public static void main(String[] args) {
        Person p = new Person(25,"cddc");
        p.method_1();
    }


    public void method_1() {
        Person person = new Person(25, "NiCholas");
        System.out.println("method_2 호출 전 나이, 이름 :" + person.age + ", " + person.name);
        method_2(person);
        System.out.println("method_2 호출 후 나이, 이름 :" + person.age + ", " + person.name);
    }

    public void method_2(Person person) {
        Person.age = 22;
        Person.name = "ANNA";
        System.out.println("method_2 내 나이, 이름 :" + person.age + ", " + person.name);

    }


}
