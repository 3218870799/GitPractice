package com.leetcode.Thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class NumAndChar {
    //���Ա�֤�����߳�1ִ��
    public void NumAndByCondition(){
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        //�൱��t1�ĵȴ�����
        Condition conditionT1 = lock.newCondition();
        //�൱��t2�ĵȴ�����
        Condition conditionT2 = lock.newCondition();

        new Thread(()->{
            //���Ի�ȡ��
            lock.lock();
            try {
                //doSomeThing();
                conditionT2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t1").start();

        new Thread(()->{
            lock.lock();
            try {
                //doSomeThing();
                conditionT1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        },"t2").start();
    }





    //���Ա�֤�����߳�1ִ��
    public void NumAndByCountDown(){
        //�൱��˨��˨��˨��һ����˨
        CountDownLatch latch = new CountDownLatch(1);
        //��ʾ����һ����
        final Object o = new Object();
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        new Thread(()->{

            try {
                //�ȴ�latchΪ0
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //����
            synchronized (o) {
                for (char c : num){
                    System.out.print(c);
                    try {
                        //���ѵȴ���������̣߳��ó���
                        o.notify();
                        //�Լ�����
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //���룬�����޷�ֹͣ����
                o.notify();
            }
        },"t1").start();

        new Thread(()->{

            //����
            synchronized (o) {
                for (char c : ac){
                    System.out.print(c);
                    //������1
                    latch.countDown();
                    try {
                        //���ѵȴ���������̣߳��ó���
                        o.notify();
                        //�Լ�����
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //���룬�����޷�ֹͣ����
                o.notify();
            }
        },"t2").start();
    }

    public void NumAndBySyncWaitNotify(){
        //��ʾ����һ����
        final Object o = new Object();
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        new Thread(()->{
            //����
            synchronized (o) {
                for (char c : num){
                    System.out.print(c);
                    try {
                        //���ѵȴ���������̣߳��ó���
                        o.notify();
                        //�Լ�����
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //���룬�����޷�ֹͣ����
                o.notify();
            }
        },"t1").start();

        new Thread(()->{
            //����
            synchronized (o) {
                for (char c : ac){
                    System.out.print(c);
                    try {
                        //���ѵȴ���������̣߳��ó���
                        o.notify();
                        //�Լ�����
                        o.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                //���룬�����޷�ֹͣ����
                o.notify();
            }
        },"t2").start();
    }



    public  void NumAndCharByLockSupport() {
        char[] num = "1234567".toCharArray();
        char[] ac = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char c : num ){
                System.out.println(c);
                //����t2
                LockSupport.unpark(t2);
                //T1���� ��ǰ�߳�����
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for (char c : ac ){
                //t2����
                LockSupport.park();
                System.out.println(c);
                //����t2
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
