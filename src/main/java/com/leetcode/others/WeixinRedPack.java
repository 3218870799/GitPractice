package com.leetcode.others;

public class WeixinRedPack {

    public static void main(String[] args) {
        //������
        double money = 20;
        //�������
        int totalCount = 5;
        //�ѽ���ɷ�
        int smallMoney = (int)(money * 100);
        //ʣ����
        int remainMoney = smallMoney;
        //ʣ������
        int remainCount = totalCount;

        for (int i = 1; i <= totalCount; i++) {
            int amount = 0;
            //�������һ���ˣ����������������һ����Ҫʣ�µ�
            if(i!=totalCount){
                amount = (int)(Math.random() * (remainMoney -remainCount * 100)) + 1;
                System.out.printf(String.valueOf(amount/100.00));
            }else {
                amount = remainMoney;
                System.out.printf(String.valueOf(amount/100.00));
            }
            //�������
            remainMoney = remainMoney - amount;
        }
    }
}
