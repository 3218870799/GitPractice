package com.xqc.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;

public class LambdaDemo {

	//����һ������ʽ�ӿ�
	interface Printer{
		void printer(String val);
	}
	public void pringSomething(String something,Printer printer){
		
	}
	
	public static void main(String[] args) {

		//���¶�����
		TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1,o2);
			}
		});

		TreeSet<Integer> set1 = new TreeSet<>((x,y)->Integer.compare(x,y));
		//�﷨һ���޲��޷���ֵ
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("���ĳЩ����");
			}
		};
		//��ʵ��
		Runnable runnable1 = ()->System.out.println("���ĳЩ����");
		//�﷨������һ���������޷���ֵ
		Consumer<String> com = new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		};
		//��ʵ��
		//���ֻ��һ��������(x)Ҳ����ֱ��д��x
		Consumer<String> com1 = (x)->{System.out.println(x);};
		com1.accept("��һ���������޷���ֵ,�������");
		//�﷨��������������з���ֵ������ִ�����
		Comparator<Integer> com2 = (x,y)->{
			System.out.println("ִ��ĳЩ����");
			return Integer.compare(x,y);
		};
		//���ֻ��һ����䣬return �ʹ����Ŷ�����ʡ��
		Comparator<Integer> com3 = (x,y)->Integer.compare(x,y);
		//�﷨��������ָ������
		//�﷨����Ȼ����ִ�У�����ΪJVM���������ƶ�
		Comparator<Integer> com4 = (Integer x ,Integer y)->Integer.compare(x,y);



		/**
		Thread t = new  Thread(()->{
			for (int i = 0; i < 10; i++) {
				System.out.println(i);
			}
		});
		t.start();
		*/
	      ArrayList<Integer> list = new ArrayList<>();
	      Collections.addAll(list, 1,2,3,4,5);
	      //lambda���ʽ ��������
	      list.forEach(System.out::println);
	      list.forEach(element -> {
	        if (element % 2 == 0) {
	          System.out.println(element);
	        }
	      });
		
	}

}
