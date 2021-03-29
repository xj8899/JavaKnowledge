package com.knowledge.basis.reflection;

import sun.tools.asm.CatchData;

import javax.sound.midi.Soundbank;
import java.lang.reflect.*;
import java.util.Calendar;

/**
 * 反射
 * java的反射机制是在程序的运行过程中，对于任何一个类，都能够知道它的所有属性和方法；对于任意一个对象，都能够知道调用它扽任意属性和方法，这种动态获取信息记忆动态调用对象方法扽功能成为java语言的反射机制
 * 反射机制主要提供了一下几个功能
 * 在运行是判断任意一个对象所属的类
 * 在运行时构造任意一个类的对象
 * 在运行时判断任意一个类所有扽成员变量和方法
 * 在运行时调用任意一个对象的方法
 */
public class Reflection {


    public static void main(String[] args) {
        Class person = null;
        try {
            person =  Class.forName("com.knowledge.basis.reflection.Student");
//            method(person);
            method1(person);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 方法
     * @param clazz
     */
    public static void method (Class clazz){
        //获取对象的所有属性,但不包含继承的
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
//            System.out.println(declaredField);
        }

        //获得对象中所有共有属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
//            System.out.printlnintln(field);
        }

        //获取对象中指定的属性
        try{
            Field field =  clazz.getField("name");
//            System.Systemout.println(field);
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //获取对象所有方法，不包含继承
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
//            System.out.println(declaredMethod);
        }

        //获取对象所有的构造方法
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < declaredConstructors.length; i++) {
            Constructor declaredConstructor = declaredConstructors[i];
//            System.out.println(declaredConstructor);
        }


        //获取对象的共有构造方法
        try {
            Constructor constructor = clazz.getConstructor();
//            System.out.println(constructor);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //实例化对象并赋值
        try {
            Student student = (Student) clazz.newInstance();
            student.setName("xj");
//            System.out.println(student.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        // 通过构造方法实例化对象
        try {
            Student student = (Student) clazz.getConstructor().newInstance();
            student.setName("xj");
//            System.out.println(student.toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //调用方法
        try {
            Method study = clazz.getMethod("study");
            study.invoke(((Student)clazz.getConstructor(String.class).newInstance("xj")));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }


    public static void method1(Class clazz){
        //获取对象所有的构造方法

        try {
            Constructor declaredConstructor = clazz.getDeclaredConstructor();
            System.out.println(declaredConstructor);
        } catch (NoSuchMethodException noSuchMethodException) {
            noSuchMethodException.printStackTrace();
        }
    }




}


class Person{

    public  String name;

    private Integer age;

    protected  float weight;

    int  height;


    Person(){

    }

    public Person(String name) {
        this.name = name;
    }


    public Person(String name, Integer age, float weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}

class Student extends Person{

    private String classname;

    public Student(){
        super();
    }

    public Student(String name){
        super(name,null,0,0);
    }

    public void study(){
        System.out.println(this.getName() + "学习中");
    }


    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", classname='" + classname + '\'' +
                '}';
    }
}

