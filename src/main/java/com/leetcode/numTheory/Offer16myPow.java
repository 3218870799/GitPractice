package com.leetcode.numTheory;

public class Offer16myPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        //����
        if(x == 0){
            return 0;
        }
        long b = n;
        double result = 1.0;
        //���С���㣬��
        if (b < 0){
            b = -b;
            x = 1/x;
        }
        while(b > 0){
            //���������
            if ((b%1)==1){
                result *= x;
            }
            //����ƽ����ָ������
            b >>=1;
            x *=x;
        }
        return result;
    }

}
