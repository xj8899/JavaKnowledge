package com.knowledge.design.pattern;

/**
 * 原型模式
 * 定义：用一个已经创建的实例作为原型，通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 优点：
 *      1、Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
 *      2、可以使用深克隆方式保存对象的状态，使用原型模式将对象复制一份，并将其状态保存起来，简化了创建对象的过程，以便在需要的时候使用（例如恢复到历史某一状态），可辅助实现撤销操作。
 * 缺点：
 *      1、需要为每一个类都配置一个 clone 方法
 *      2、clone 方法位于类的内部，当对已有类进行改造的时候，需要修改代码，违背了开闭原则。
 *      3、当实现深克隆时，需要编写较为复杂的代码，而且当对象之间存在多重嵌套引用时，为了实现深克隆，每一层对象对应的类都必须支持深克隆，实现起来会比较麻烦。因此，深克隆、浅克隆需要运用得当。
 * 结构：
 *      1、抽象原型类：规定了具体原型对象必须实现的接口。
 *      2、具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。
 *      3、访问类：使用具体原型类中的 clone() 方法来复制新的对象。
 * 实现：
 *      1、浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 *      2、深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 */
public class Prototype{


    public static void main(String[] args) {
        PrototypeTest prototypeTest = new PrototypeTest();
        prototypeTest.setName("许杰");
        prototypeTest.setAge(25);
        try {
            PrototypeTest   prototypeTest1  = (PrototypeTest) prototypeTest.clone();
            System.out.println(prototypeTest1);
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }

        }

}


class PrototypeTest implements Cloneable{
    PrototypeTest(){

    }

    private String name ;
    private Integer age;

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

    @Override
    public String toString() {
        return "PrototypeTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Object clone() throws CloneNotSupportedException {
        return (PrototypeTest)super.clone();
    }
}
