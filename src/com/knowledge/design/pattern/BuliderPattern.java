package com.knowledge.design.pattern;

/**
 * 建造者模式
 * 定义：
 * 将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。
 * 它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。
 * 它将变与不变相分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。
 * 优点：
 *      1、封装性好，构建和表示分离。
 *      2、扩展性好，各个具体的建造者相互独立，有利于系统的解耦。
 *      3、客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。
 * 缺点：
 *      1、产品的组成部分必须相同，这限制了其使用范围。
 *      2、如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。
 * 结构：
 *      1、产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。
 *      2、抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的dd接口，通常还包含一个返回复杂产品的方法 getResult()。
 *      3、具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。
 *      4、指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。
 *
 */
public class BuliderPattern {
    public static void main(String[] args) {
        BuilderDirector b = new BuilderDirector(new Concrete1());
        BuilderProduct construct = b.construct();
        String name = construct.getName();
        System.out.println(name);


        Computer computer=new Computer.ComputerBuilder().Cpu("R7-5800x").build();
    }
}

/**
 * 抽象建造者
 */
abstract class Builder{
    abstract void builderName();

    abstract BuilderProduct getResult();
}

/**
 * 具体建造者
 */
class Concrete1 extends Builder{
    BuilderProduct builderProduct = new BuilderProduct();

    @Override
    void builderName() {
        builderProduct.setName("Lvturen");
    }

    @Override
    BuilderProduct getResult() {
        return builderProduct;
    }
}

/**
 * 角色
 */
class BuilderProduct{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/**
 * 指挥类
 */
class BuilderDirector{
    Builder builder = null;
    public BuilderDirector(Builder builder){
        this.builder = builder;
    }

   public BuilderProduct construct(){
        builder.builderName();
        return builder.getResult();
    }
}

    /**
     * 进阶版
      */
class Computer{
    Computer(String cpu,String screen,String hhd,String board){
        this.CPU= cpu;
        this.Screen = screen;
        this.HHD = hhd;
        this.Board = board;
    }

    private String CPU;

    private String Screen;

    private String HHD;

    private String Board;



    public  static class ComputerBuilder{
        private String CPU;

        private String Screen;

        private String HHD;

        private String Board;

        public  ComputerBuilder Cpu(String cpu){
            this.CPU = cpu;
            return this;
        }
        public  ComputerBuilder Screen(String screen){
            this.Screen = screen;
            return this;
        }
        public ComputerBuilder HHD(String hhd){
            this.HHD = hhd;
            return this;
        }
        public ComputerBuilder Board(String board){
            this.Board = board;
            return this;
        }
        public Computer build(){
            return new Computer(this.CPU,this.Screen,this.HHD,this.Board);
        }
    }


    }



