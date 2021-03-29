package com.knowledge.test;


public class test1218 {

    static String name = "xj";

    public static void main(String[] args) {
        Student s = new Student("24");
        ClassLoader classLoader = s.getClass().getClassLoader();
        ClassLoader classLoader1 = Thread.class.getClassLoader();
        System.out.println(classLoader1);
    }
}
class Student{

    static {
        sex =  "男";
    }

    {
        name = "xj";
    }

    Student(String age){
        this.age = age;
    }

    String name ;
    String age;
    static String  sex ;






}