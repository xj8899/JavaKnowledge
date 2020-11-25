package com.knowledge.design.pattern;

/**
 * 工厂方法模式
 * 定义：工厂方法模式”是对简单工厂模式的进一步抽象化，其好处是可以使系统在不修改原来代码的情况下引进新的产品，即满足开闭原则。
 * 优点：
 *      1、用户只需要知道具体工厂的名称就可得到所要的产品，无须知道产品的具体创建过程。
 *      2、灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
 *      3、典型的解耦框架。高层模块只需要知道产品的抽象类，无须关心其他实现类，满足迪米特法则、依赖倒置原则和里氏替换原则。
 * 缺点：
 *      1、类的个数容易过多，增加复杂度
 *      2、增加了系统的抽象性和理解难度
 *      3、抽象产品只能生产一种产品，此弊端可使用抽象工厂模式解决。
 * 应用场景：
 *      1、客户只知道创建产品的工厂名，而不知道具体的产品名。如 TCL 电视工厂、海信电视工厂等。
 *      2、创建对象的任务由多个具体子工厂中的某一个完成，而抽象工厂只提供创建产品的接口。
 *      3、客户不关心创建产品的细节，只关心产品的品牌
 *  结构：
 *      1、抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法 newProduct() 来创建产品。
 *      2、具体工厂（ConcreteFactory）：主要是实现抽象工厂中的抽象方法，完成具体产品的创建。
 *      3、抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
 *      4、具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间一一对应。
 */
public class FactoryPattern {

    public static void main(String[] args) {
        AnimalFarm af = new HorseFarm();
        Animal animal = af.newAnimal();
        animal.show();
    }
}

/**
 * 产品抽象类
 */
interface Animal {
    public void show();
}

/**
 * 马类
 */
class Horse  implements Animal {

    @Override
    public void show() {
        System.out.println("我是一匹马");
    }
}

/**
 * 牛类
 */
class Cattle  implements Animal{

    @Override
    public void show() {
        System.out.println("我是一头牛");
    }
}

/**
 * 畜牧场
 */
interface AnimalFarm {
    public Animal newAnimal();
}

/**
 * 养马场
 */
class HorseFarm  implements AnimalFarm{

    @Override
    public Animal newAnimal() {
        return new Horse();
    }
}

/**
 * 养牛厂
 */
class CattleFarm  implements AnimalFarm{

    @Override
    public Animal newAnimal() {
        return new Cattle();
    }
}
