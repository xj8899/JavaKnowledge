package com.knowledge.design.tenet;


public class Isp {


    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.Count();
        teacher.Input();
        teacher.Print();
    }

}


interface InputModule{
    void Input();
}

interface CountModule{
    void Count();
}

interface PrintModule{
    void Print();
}

class Teacher implements InputModule,CountModule,PrintModule{

    @Override
    public void Input() {
        System.out.println("Input");
    }

    @Override
    public void Count() {
        System.out.println("Count");
    }

    @Override
    public void Print() {
        System.out.println("Print");
    }
}