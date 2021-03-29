package com.knowledge.test.Feb.fives;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.awt.*;
import java.io.Console;
import java.util.LinkedList;

/**
 * @author xj
 * @create Y E A R − {YEAR}-YEAR−{MONTH}-05 4:57 下午
 */
public class EventQueue {

    private int max;

    private final LinkedList<Event> eventList = new LinkedList<>();

    private final static int DEFAULT_MAX_EVENT = 10 ;

    public EventQueue() {
        this(DEFAULT_MAX_EVENT);
    }

    public EventQueue(int max){
        this.max = max;
    }

    public void offer(Event event){
        synchronized (eventList){
            if (eventList.size()>max){
                try {
                    console("the queue is full");
                    eventList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            console("the new event is submited");
            eventList.add(event);
            eventList.notify();
        }
    }

    public Event take(){
        synchronized (eventList){
            if (eventList.isEmpty()){
                console("the queue is empty");
                try {
                    eventList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Event event =  eventList.removeFirst();
            this.eventList.notify();
            console("the event"+event+"is handled.");
            return event;
        }
    }


    private void console(String message){
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.println("%s:%s\n"+Thread.currentThread().getName()+message);
    }
}
