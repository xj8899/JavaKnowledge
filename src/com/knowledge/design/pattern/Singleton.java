package com.knowledge.design.pattern;


import java.util.concurrent.atomic.AtomicReference;

/**
 * 模式：对象创建模式
 * 单例方法
 * 定义：一个类只有一个实例，且该类能自行创建这个实例的一种模式
 * 特点：
 *      1、单例类只有一个实例对象。
 *      2、该单例对象必须由单例类自行创建。
 *      3、单例类对外提供一个访问该单例的全局访问点。
 * 优点：
 *      1、单例模式可以保证内存里只有一个实例，减少了内存的开销。
 *      2、可以避免对资源的多重占用。
 *      3、单例模式设置全局访问点，可以优化和共享资源的访问。
 * 缺点：
 *      1、单例模式一般没有接口，扩展困难。如果要扩展，则除了修改原来的代码，没有第二种途径，违背开闭原则。
 *      2、在并发测试中，单例模式不利于代码调试。在调试过程中，如果单例中的代码没有执行完，也不能模拟生成一个新的对象。
 *      3、单例模式的功能代码通常写在一个类中，如果功能设计不合理，则很容易违背单一职责原则。
 *      4、不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。
 * 注意事项：
 *      1、不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。
 *      2、使用懒单例模式时注意线程安全问题
 *      3、饿单例模式和懒单例模式构造方法都是私有的，因而是不能被继承的，有些单例模式可以被继承（如登记式模式）。
 * 使用情景：
 *      1、需要频繁创建的一些类，使用单例可以降低系统的内存压力，减少 GC。
 *      2、某类只要求生成一个对象的时候。
 *      3、某些类创建实例时占用资源较多，或实例化耗时较长，且经常使用。
 *      4、某类需要频繁实例化，而创建的对象又频繁被销毁的时候，如多线程的线程池、网络连接池等。
 *      5、频繁访问数据库或文件的对象。
 *      6、对于一些控制硬件级别的操作，或者从系统上来讲应当是单一控制逻辑的操作，如果有多个实例，则系统会完全乱套。
 *      7、当对象需要被共享的场合。由于单例模式只允许创建一个对象，共享该对象可以节省内存，并加快对象访问速度。如 Web 中的配置对象、数据库的连接池等。
 * 结构：
 *      1、单例类：包含一个实例且能自行创建这个实例的类。
 *      2、访问类：使用单例的类。
 */
public class Singleton {

    Singleton(){}

    public static void main(String[] args) {
        //饿汉模式
        Singleton hungrySingleton = HungrySingleton.getInstance();
        //懒汉模式
        Singleton lazySingleton = LazySingleton.getInstance();
        //线程安全懒汉模式
        Singleton syncLazySingleton = SyncLazySingleton.getInstance();
        //静态内部类
        Singleton internalSingleton = InternalSingleton.getInstance();
        //双重校验
        Singleton doubleCheckSingleton = DoubleCheckSingleton.getInstance();
        //CAS单例获取
        Singleton atomicReferenceSingleton = AtomicReferenceSingleton.getInstance();
    }


}


/**
 * 饿汉模式
 * 优点
 *     1.线程安全
 *     2.在类加载的同时已经创建好一个静态对象，调用时反应速度快
 * 缺点
 *     资源效率不高，可能getInstance()永远不会执行到，但执行该类的其他静态方法或者加载了该类（class.forName)，那么这个实例仍然初始化
 */
class HungrySingleton{

    HungrySingleton(){

    }

    private static final Singleton hungrySingleton = new Singleton();

    /**
     * 获取实例
     * 模式：饿汉模式
     * @return
     */
    public static Singleton getInstance(){
        return hungrySingleton;
    }

}


/**
 * 懒汉模式
 * 优点：
 *     避免了饿汉式的那种在没有用到的情况下创建事例，资源利用率高，不执行getInstance()就不会被实例，可以执行该类的其他静态方法。
 * 缺点：
 *     懒汉式在单个线程中没有问题，但多个线程同事访问的时候就可能同事创建多个实例，而且这多个实例不是同一个对象，虽然后面创建的实例会覆盖先创建的实例，但是还是会存在拿到不同对象的情况。解决这个问题的办法就是加锁synchonized，第一次加载时不够快，多线程使用不必要的同步开销大。
 */
class LazySingleton{

    LazySingleton(){

    }

    private static Singleton lazySingleton = null;

    public static Singleton getInstance(){
        if (lazySingleton==null){
            lazySingleton = new Singleton();
        }
        return lazySingleton;
    }
}


/**
 * 线程安全懒汉模式
 */
class SyncLazySingleton{

    SyncLazySingleton(){

    }

    private static volatile Singleton syncLazySingleton = null;

    public static synchronized Singleton getInstance(){

        if (syncLazySingleton == null){
            syncLazySingleton = new Singleton();
        }
        return syncLazySingleton;
    }


}

/**
 * 静态内部类
 * 优点
 *     资源利用率高，不执行getInstance()不被实例，可以执行该类其他静态方法
 * 缺点
 *     第一次加载时反应不够快
 */
class InternalSingleton{

    InternalSingleton(){}

    private static class InternalSingletonIntance{
        private static Singleton internalSingleton = new Singleton();
    }

    public static Singleton getInstance(){
        return InternalSingletonIntance.internalSingleton;
    }
}


/**
 * 双重锁懒汉模式
 * 双重锁的⽅式是⽅法级锁的优化，减少了部分获取实例的耗时。
 * 同时这种⽅式也满⾜了懒加载。
 */
class DoubleCheckSingleton{

    private static Singleton  doubleCheckSingleton = null;


    public static Singleton getInstance(){
        if (doubleCheckSingleton==null){
            synchronized (DoubleCheckSingleton.class){
                if (doubleCheckSingleton==null){
                    doubleCheckSingleton = new Singleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}


/**
 * CAS单例模式
 * java并发库提供了很多原⼦类来⽀持并发访问的数据安全
 * 性； AtomicInteger 、 AtomicBoolean 、 AtomicLong 、 AtomicReference 。
 * AtomicReference 可以封装引⽤⼀个V实例，⽀持并发访问如上的单例⽅式就是使⽤了这样的⼀个
 * 特点。
 * 使⽤CAS的好处就是不需要使⽤传统的加锁⽅式保证线程安全，⽽是依赖于CAS的忙等算法，依赖
 * 于底层硬件的实现，来保证线程安全。相对于其他锁的实现没有线程的切换和阻塞也就没有了额外
 * 的开销，并且可以⽀持较⼤的并发性。
 * 当然CAS也有⼀个缺点就是忙等，如果⼀直没有获取到将会处于死循环中。
 */
class AtomicReferenceSingleton{

    private static Singleton atomicReferenceSingleton = null;

    private static final AtomicReference<Singleton> INSTANCE = new AtomicReference<>();


    public static Singleton getInstance(){

        if (atomicReferenceSingleton == null){
            for (;;) {
                Singleton atomicReferenceSingleton = INSTANCE.get();
                if (atomicReferenceSingleton == null){
                    INSTANCE.compareAndSet(null,new Singleton());
                }else{
                    return INSTANCE.get();
                }
            }
        }

        return atomicReferenceSingleton;
    }

}


enum EnumSingleton{

}
