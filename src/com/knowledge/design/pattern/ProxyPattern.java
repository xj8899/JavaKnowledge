package com.knowledge.design.pattern;

/**
 * 代理模式
 * 定义：由于某些原因需要给某对象提供一个代理以控制对该对象的访问。这时，访问对象不适合或者不能直接引用目标对象，代理对象作为访问对象和目标对象之间的中介。
 * 优点：
 *      1、代理模式在客户端与目标对象之间起到一个中介作用和保护目标对象的作用；
 *      2、代理对象可以扩展目标对象的功能；
 *      3、代理模式能将客户端与目标对象分离，在一定程度上降低了系统的耦合度，增加了程序的可扩展性
 * 缺点：
 *      1、代理模式会造成系统设计中类的数量增加
 *      2、在客户端和目标对象之间增加一个代理对象，会造成请求处理速度变慢；
 *      3、增加了系统的复杂度；
 * 结构：
 *      1、抽象主题（Subject）类：通过接口或抽象类声明真实主题和代理对象实现的业务方法。
 *      2、真实主题（Real Subject）类：实现了抽象主题中的具体业务，是代理对象所代表的真实对象，是最终要引用的对象。
 *      3、代理（Proxy）类：提供了与真实主题相同的接口，其内部含有对真实主题的引用，它可以访问、控制或扩展真实主题的功能。
 */
public class ProxyPattern {


    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.Request();
    }


}

/**
 * 抽象主题
 */
interface Subject{

    void Request();
}

class RealSubject implements Subject{


    @Override
    public void Request() {
        System.out.println("~~执行中~~");
    }

}

class Proxy implements Subject{

    RealSubject realSubject;

    @Override
    public void Request() {
        if (realSubject == null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();

    }

    public void preRequest(){
        System.out.println("~~前置~~");
    }

    public void postRequest(){
        System.out.println("~~后置~~");
    }
}