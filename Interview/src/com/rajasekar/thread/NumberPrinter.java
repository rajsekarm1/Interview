package com.rajasekar.thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinter implements Runnable {
    private Lock lock;
    private Condition condition;
    private String type;
    private  static AtomicBoolean oddTurn = new AtomicBoolean(true);

    public NumberPrinter(String type, Lock lock, Condition condition) {
        this.type = type;
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        int i = type.equals("odd") ? 1 : 2;
        while (i <= 10) {
            if (type.equals("odd")){
            	System.out.println("Odd Number");
                printOdd(i);
            }
            if (type.equals("even")){
            	System.out.println("Even Number");
                printEven(i);
            }
            i = i + 2;
        }
    }

    private void printOdd(int i) {
        // synchronized (lock) {
        lock.lock();
        while (!(oddTurn.get())) {
            try {
                // lock.wait();
            	System.out.println("Inside Odd While method");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(type + " " + i);
        oddTurn.set(false);
        // lock.notifyAll();
        condition.signalAll();
        lock.unlock();
    }

    // }

    private void printEven(int i) {
        // synchronized (lock) {
        lock.lock();
        while (oddTurn.get()) {
            try {
                // lock.wait();
            	System.out.println("Inside Even While method");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(type + " " + i);
        oddTurn.set(true);
        // lock.notifyAll();
        condition.signalAll();
        lock.unlock();
    }

    // }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread odd = new Thread(new NumberPrinter("odd", lock, condition));
        /*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        Thread even = new Thread(new NumberPrinter("even", lock, condition));
        odd.start();
        even.start();
    }
}
