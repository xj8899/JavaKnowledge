package com.knowledge.design.pattern;

/**
 * 简单工厂模式
 * 定义：定义一个创建产品对象的工厂接口，将产品对象的实际创建工作推迟到具体子工厂类当中。这满足创建型模式中所要求的“创建与使用相分离”的特点。
 * 介绍：一创建的产品不多，只要一个工厂类就可以完成，这种模式叫“简单工厂模式”。
 * 优点：
 *      1、工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。
 *      2、客户端无需知道所创建具体产品的类名，只需知道参数即可。
 *      3、也可以引入配置文件，在不修改客户端代码的情况下更换和添加新的具体产品类。
 * 缺点：
 *      1、简单工厂模式的工厂类单一，负责所有产品的创建，职责过重，一旦异常，整个系统将受影响。且工厂类代码会非常臃肿，违背高聚合原则。
 *      2、使用简单工厂模式会增加系统中类的个数（引入新的工厂类），增加系统的复杂度和理解难度
 *      3、系统扩展困难，一旦增加新产品不得不修改工厂逻辑，在产品类型较多时，可能造成逻辑过于复杂
 *      4、简单工厂模式使用了 static 工厂方法，造成工厂角色无法形成基于继承的等级结构。
 *      5、每增加一个产品就要增加一个具体产品类和一个对应的具体工厂类，这增加了系统的复杂度，违背了“开闭原则”。
 * 使用场景：
 *      1、对于产品种类相对较少的情况，考虑使用简单工厂模式。使用简单工厂模式的客户端只需要传入工厂类的参数，不需要关心如何创建对象的逻辑，可以很方便地创建所需产品。
 * 结构：
 *      1、简单工厂（SimpleFactory）：是简单工厂模式的核心，负责实现创建所有实例的内部逻辑。工厂类的创建产品类的方法可以被外界直接调用，创建所需的产品对象。
 *      2、抽象产品（Product）：是简单工厂创建的所有对象的父类，负责描述所有实例共有的公共接口。
 *      3、具体产品（ConcreteProduct）：是简单工厂模式的创建目标。
 */
public class SimpleFactoryPattern {

    public static void main(String[] args) {
        Product product = makeInstance(1);
        product.show();
    }

    public static Product makeInstance(int nub){
        switch (nub){
            case 1:
                return new ConcreteProduct1();
            case 2:
                return new ConcreteProduct2();
            default:
                return null;
        }

    }
}

interface Product{
    public void show();
}

class ConcreteProduct1 implements Product{

    @Override
    public void show() {
        System.out.println("产品1");
    }
}
class ConcreteProduct2 implements Product{

    @Override
    public void show() {
        System.out.println("产品2");
    }
}


