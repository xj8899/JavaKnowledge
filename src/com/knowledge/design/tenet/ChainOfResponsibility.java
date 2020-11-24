package com.knowledge.design.tenet;

/**
 * 职责链模式
 * 优点：
 *      降低了对象之间的耦合度。该模式使得一个对象无须知道到底是哪一个对象处理其请求以及链的结构，发送者和接收者也无须拥有对方的明确信息。
 *      增强了系统的可扩展性。可以根据需要增加新的请求处理类，满足开闭原则。
 *      增强了给对象指派职责的灵活性。当工作流程发生变化，可以动态地改变链内的成员或者调动它们的次序，也可动态地新增或者删除责任。
 *      责任链简化了对象之间的连接。每个对象只需保持一个指向其后继者的引用，不需保持其他所有处理者的引用，这避免了使用众多的 if 或者 if···else 语句。
 *      责任分担。每个类只需要处理自己该处理的工作，不该处理的传递给下一个对象完成，明确各类的责任范围，符合类的单一职责原则。
 * 缺点:
 *      不能保证每个请求一定被处理。由于一个请求没有明确的接收者，所以不能保证它一定会被处理，该请求可能一直传到链的末端都得不到处理。
 *      对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响。
 *      职责链建立的合理性要靠客户端来保证，增加了客户端的复杂性，可能会由于职责链的错误设置而导致系统出错，如可能会造成循环调用。
 * 模式结构：
 *      抽象处理者（Handler）角色：定义一个处理请求的接口，包含抽象处理方法和一个后继连接。
 *      具体处理者（Concrete Handler）角色：实现抽象处理者的处理方法，判断能否处理本次请求，如果可以处理请求则处理，否则将该请求转给它的后继者。
 *      客户类（Client）角色：创建处理链，并向链头的具体处理者对象提交请求，它不关心处理细节和请求的传递过程。
 * tips:
 *      责任链模式的本质是解耦请求与处理，让请求在处理链中能进行传递与被处理；理解责任链模式应当理解其模式，而不是其具体实现。责任链模式的独到之处是将其节点处理者组合成了链式结构，并允许节点自身决定是否进行请求处理或转发，相当于让请求流动起来。
 *
 */
public class ChainOfResponsibility {


}

/**
 * 客户类
 */
class ChainOfResponsibilityPattern{

    public static void main(String[] args) {
        Handler c1 = new ConcreteHandler1();
        Handler c2 = new ConcreteHandler2();
        c1.setNext(c2);
        c1.request("two");
    }
}

/**
 * 抽象处理者
 */
abstract class  Handler{

    private Handler next;

    public abstract void request(String request);

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }
}

class ConcreteHandler1 extends Handler{
    @Override
    public void request(String request) {
        if (request.equals("one")){
            System.out.println("ConcreteHandler1进行处理");
        }else{
            if (getNext() ==null){
                System.out.println("无后续处理");
            }else{
                getNext().request(request);
            }
        }
    }
}

class ConcreteHandler2 extends Handler{

    @Override
    public void request(String request) {
        if (request.equals("two")){
            System.out.println("ConcreteHandler2进行处理");
        }else{
            if (getNext() ==null){
                System.out.println("无后续处理");
            }else{
                getNext().request(request);
            }
        }
    }
}
