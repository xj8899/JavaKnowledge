package com.knowledge.design.pattern;

import java.math.BigDecimal;

/**
 * 模板方法
 * 定义：定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变该算法结构的情况下重定义该算法的某些特定步骤。它是一种类行为型模式
 * 优点：
 *      1、它封装了不变部分，扩展可变部分。它把认为是不变部分的算法封装到父类中实现，而把可变部分算法由子类继承实现，便于子类继续扩展。
 *      2、它在父类中提取了公共的部分代码，便于代码复用。
 *      3、部分方法是由子类实现的，因此子类可以通过扩展方式增加相应的功能，符合开闭原则。
 * 缺点：
 *      1、对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象，间接地增加了系统实现的复杂度。
 *      2、父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度。
 *      3、由于继承关系自身的缺点，如果父类添加新的抽象方法，则所有子类都要改一遍。
 * 结构：
 *      1、模板方法：定义了算法的骨架，按某种顺序调用其包含的基本方法。
 *      2、基本方法：是整个算法中的一个步骤，包含以下几种类型。
 *      3、抽象方法：在抽象类中声明，由具体子类实现。
 *      4、具体方法：在抽象类中已经实现，在具体子类中可以继承或重写它。
 *      5、钩子方法：在抽象类中已经实现，包括用于判断的逻辑方法和需要子类重写的空方法两种。
 *
 */
public class TemplateMethod {

    public static void main(String[] args) {
        AbstractTest a = new ConcreteClass();
        AbstractTest b =new ConcreteClass();
        b.setMoney(new BigDecimal(100));
        a.setMoney(new BigDecimal(100));
        System.out.println("B transferAccounts A");
        b.transferAccounts(a,50);
        System.out.println("Amoney:"+a.getMoney());
        System.out.println("Bmoney:"+b.getMoney());
        System.out.println("B Collection A");
        b.Collection(a,150);
        System.out.println("Amoney:"+a.getMoney());
        System.out.println("Bmoney:"+b.getMoney());
    }


}

/**
 *  抽象类
 */
abstract class AbstractTest{

   private  BigDecimal money;
    /**
     * 模板方法
     */
    public void transferAccounts(AbstractTest obj ,int nb){
        BigDecimal bigDecimal = convertDecimal(nb);
        add(obj,bigDecimal);
    }

    /**
     * 模板方法
     */
    public void Collection(AbstractTest obj ,int nb1){
        BigDecimal bigDecimal = convertDecimal(nb1);
        subtract(obj,bigDecimal);
    }



    private BigDecimal convertDecimal(int nb){
        return new BigDecimal(nb);
    }

    protected abstract void add(AbstractTest obj,BigDecimal nb);

    protected abstract void subtract(AbstractTest obj,BigDecimal nb);

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money =money;
    }

    @Override
    public String toString() {
        return money.toPlainString();
    }
}

/**
 * 具体子类
 */
class ConcreteClass extends AbstractTest{


    @Override
    protected void add(AbstractTest obj, BigDecimal nb) {
        setMoney(getMoney().subtract(nb));
        obj.setMoney(obj.getMoney().add(nb));
    }

    @Override
    protected void subtract(AbstractTest obj, BigDecimal nb) {
        BigDecimal money = obj.getMoney();
        obj.setMoney(money.subtract(nb));
        setMoney(getMoney().add(nb));
    }


}
