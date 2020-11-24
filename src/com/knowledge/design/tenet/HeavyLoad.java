package com.knowledge.design.tenet;


/**
 * 里氏替换原则
 */
public class HeavyLoad {

    public static void main(String[] args) {
        Son son = new Son("xujie");
        son.sayHello(21);
        son.sayHello("Hello");
    }


}



class Parent{

    Parent(String name){
        this.name = name;
    }

    Parent(Integer age){
        this.age = age;
    }

    Parent(String name , Integer age){
        this.name = name ;
        this.age  = age ;
    }
    private String name;

    private Integer age;

    public void sayHello(String msg){
        System.out.println(name+":"+msg);
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Son extends Parent{

    Son(String name) {
        super(name);
    }

    Son(Integer age) {
        super(age);
    }

    Son(String name, Integer age) {
        super(name, age);
    }

    public void sayHello(int age){
        System.out.println(this.getName()+":"+age);
    }

}