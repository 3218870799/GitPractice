package com.xqc.designPattern;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        Cooking cooking = new CookEgg();
        cooking.cook();

    }
}
abstract class Cooking{
    protected abstract void step1();
    protected abstract void step2();
    public void cook(){
        System.out.print("������ʼ");
        step1();
        step2();
        System.out.print("��������");
    }
}
class CookEgg extends Cooking{

    @Override
    protected void step1() {
        System.out.println("���������ͼ���");

    }

    @Override
    protected void step2() {
        System.out.println("�ٷ��ζ��ζ��");
    }
}
