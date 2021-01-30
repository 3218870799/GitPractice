package com.xqc.designPattern;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        Composite china = new Composite();
        //Ϊchina���ʡ�ݳ��е�
        //����ͳ��
        System.out.printf(china.count()+"");
    }
}

/**
 * �˿��ղ�ӿ�
 */
interface Counter{
    int count();
}

/**
 * Ҷ�ӽڵ㣬���У�Ҫʵ���˿��ղ飬ʵ�ʽ���ͳ��
 */
class City implements Counter{
    private int sum = 0;
    public City(int sum){
        this.sum = sum;
    }
    @Override
    public int count() {
        return sum;
    }
}
class Composite implements Counter{
    //���������б�
    private List<Counter> counterList = new ArrayList<>();
    @Override
    public int count() {
        int sum = 0;
        //����ÿһ�����н�����ֵ���
        for (Counter counter : counterList){
            sum += counter.count();
        }
        return sum;
    }
}