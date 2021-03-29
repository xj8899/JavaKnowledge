package com.knowledge.test.Feb.eight;

import com.sun.scenario.effect.Offset;
import sun.jvm.hotspot.code.Location;

import java.awt.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xj
 * @create Y E A R − {YEAR}-YEAR−{MONTH}-08 11:04 上午
 */
public class NotifyAndWithDemo {


    public static void main(String[] args) {

        EventQueue eventQueue = new EventQueue();

//        for(int i = 0;i<30; i++){
//            new Thread(()->{
//                    eventQueue.offer(new EventQueue.Event());
//            },"offer"+i).start();
//
//            new Thread(()->{
//                    eventQueue.take();
//            },"takeThread"+i).start();
//        }

        new Thread(()->{
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"offer1").start();
        new Thread(()->{
            for (;;){
                eventQueue.offer(new EventQueue.Event());
            }
        },"offer2").start();





    }
}

class EventQueue{
    private  int max ;

    private static final int DEFAULT_MAX_VALUE = 10;

    LinkedList<Event> eventQueue = new LinkedList();


    static class Event{

    }
    public EventQueue(){
        this(DEFAULT_MAX_VALUE);
    }

    public EventQueue(int max){
        this.max = max;
    }

    /**
     * 加入队列
     * @param event
     */
    public void offer(Event event){
        synchronized (eventQueue){
            System.out.println(Thread.currentThread().getName());
            if (eventQueue.size()>max){
                try {
                    System.out.println("eventQueue is full");
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+111);
            eventQueue.addLast(event);
            System.out.println("event put list"+eventQueue.size());
            eventQueue.notify();
        }
    }

    /**
     * 取出任务
     */
    public Event take(){
        synchronized (eventQueue){
            System.out.println(Thread.currentThread().getName());
            if (eventQueue.isEmpty()){
                System.out.println("eventQueueList is empty");
                try {
                    eventQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event = eventQueue.removeFirst();
            System.out.println("get first event"+"剩余："+eventQueue.size());
            eventQueue.notify();
            return event;
        }
    }



}
