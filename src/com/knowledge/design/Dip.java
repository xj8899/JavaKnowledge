package com.knowledge.design;

/**
 * 依赖倒置原则
 * 作用：
 *      1、依赖倒置原则可以降低类间的耦合性。
 *      2、依赖倒置原则可以提高系统的稳定性。
 *      3、依赖倒置原则可以减少并行开发引起的风险。
 *      4、依赖倒置原则可以提高代码的可读性和可维护性。
 * 实现方法:
 *      1、每个类尽量提供接口或抽象类，或者两者都具备。
 *      2、变量的声明类型尽量是接口或者是抽象类。
 *      3、任何类都不应该从具体类派生。
 *      4、使用继承时尽量遵循里氏替换原则。
 */
public class Dip {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.shopping(new JiNangShop());
        customer.shopping(new JiNingShop());
    }

}
class Customer{
    public void shopping(Shop shop){
        shop.sell();
    }
}
interface Shop{
    //卖
    void sell();
}

class JiNingShop implements Shop{

    @Override
    public void sell() {
        System.out.println("济宁特产售卖");
    }
}
class JiNangShop implements Shop{

    @Override
    public void sell() {
        System.out.println("济南特产售卖");
    }
}