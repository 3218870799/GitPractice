package com.xqc.array;


public class MoreThanHalfNum {
    public static void main(String[] args) {
        int[] a = {1,5,2,2,3,4,2,2};
        int resutl = getMoreThanHalfNum(a);
    }
    private static Integer getMoreThanHalfNum(int[] array) {
        //�������Ϊ��
        if (array == null)
            return null;
        Integer number = null;
        int count = 0;
        Integer resultInteger = null;
        //�����������
        for (int i = 0; i < array.length; i++) {
            //���û�и�ֵ
            if (number == null) {
                number = array[i];
                count++;
            } else {
                //����ͬ�ͼ�ȥ��ֱ��Ϊ0�����¸���
                if (array[i] != number){
                    if (count == 0) {
                        //�������Ϊ�㣬������Ҫ������һ�����֣����Ѵ�����Ϊ1
                        number = array[i];
                        count = 1;
                    } else {
                        count--;
                    }
                }else {
                    //��ͬ�������һ
                    count++;
                }
            }
            //���һ��count��Ϊ1����Ϊ����һ�����
            if (count == 1)
                resultInteger = number;
        }
        return resultInteger;
    }
}
