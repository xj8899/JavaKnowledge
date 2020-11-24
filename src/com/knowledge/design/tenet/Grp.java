package com.knowledge.design.tenet;

/**
 * 合成复用原则
 * 概念：它要求在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。
 * 继承复用
 * 	优点
 * 		简单易实现
 * 	缺点
 * 		继承复用破坏了类的封装性。因为继承会将父类的实现细节暴露给子类，父类对子类是透明的，所以这种复用又称为“白箱”复用。
 * 		子类与父类的耦合度高。父类的实现的任何改变都会导致子类的实现发生变化，这不利于类的扩展与维护。
 * 		它限制了复用的灵活性。从父类继承而来的实现是静态的，在编译时已经定义，所以在运行时不可能发生变化。
 * 合成复用
 * 	优点
 * 		它维持了类的封装性。因为成分对象的内部细节是新对象看不见的，所以这种复用又称为“黑箱”复用。
 * 		新旧类之间的耦合度低。这种复用所需的依赖较少，新对象存取成分对象的唯一方法是通过成分对象的接口。
 * 		复用的灵活性高。这种复用可以在运行时动态进行，新对象可以动态地引用与成分对象类型相同的对象。
 * 	实现方法
 * 	合成复用原则是通过将已有的对象纳入新对象中，作为新对象的成员对象来实现的，新对象可以调用已有对象的功能，从而达到复用。
 */
public class Grp {

    public static void main(String[] args) {
        CalolineCar calolineCar = new CalolineCar(new Red());
        System.out.println(calolineCar.getColor());
    }

}


class Car{
    Color color;
    public Car(Color color){
        this.color = color;
    }

    public void move(){

    }

    public String getColor(){
        return color.getColor();
    }
}

class  CalolineCar extends Car {


    public CalolineCar(Color color) {
        super(color);
    }
}

class ElectricCar extends Car{

    public ElectricCar(Color color) {
        super(color);
    }
}


interface Color{

   String getColor();
}

class Red implements Color{
    public static String color = "Red";


    @Override
    public String getColor() {
        return color;
    }
}