package com.xqc.function;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadCreate {
	public static void main(String[] args) {
		
		
		
		myExtendsThread myT = new myExtendsThread();
		myT.start();

		
		
		Runnable implRunnable = new ImplRunnableThread();
		new Thread(implRunnable).start();
		
		
		Callable implCallable = new ImplCallable();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(implCallable);
        new Thread(futureTask).start();
        
        //ʹ��Executors�������еķ��������̳߳�
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo demo = new ThreadPoolDemo();
        //Ϊ�̳߳��е��̷߳�������,ʹ��submit����������Ĳ���������Runnable��ʵ���࣬Ҳ������Callable��ʵ����
        pool.submit(demo);
        //�ر��̳߳�
        //shutdown �� ��һ��ƽ�͵ķ�ʽ�ر��̳߳أ��ڹر��̳߳�֮ǰ����ȴ��̳߳��е����е����񶼽��������ڽ���������
        //shutdownNow �� �����ر��̳߳�
        pool.shutdown();
		
		
		
		Thread t = new  Thread(()->{
			System.out.println("lambal"+Thread.currentThread().getName());
		});
		t.start();
		
		
		System.out.println("main"+Thread.currentThread().getName());

	}

}
class myExtendsThread extends Thread{
	@Override
	public void run() {
		
		System.out.println("myExtendsThread"+Thread.currentThread().getName());
	}
}

class ImplRunnableThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("ImplRunnableThread"+Thread.currentThread().getName());
	}
	
}

class ImplCallable implements Callable{

	@Override
	public Integer call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return null;
	}
	
}

class ThreadPoolDemo implements Runnable{

    /**���̵߳Ĺ�������*/
    private int i = 0;

    @Override
    public void run() {
       System.out.println(Thread.currentThread().getName()+"---");
    }
}
