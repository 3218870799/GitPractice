package com.leetcode.others;

import java.util.Arrays;

public class xdeln {

    public static void main(String[] args) {
        //˼·��
        // �Ƚ������ʼ�����m-n���ַ�������res��
        //��res�ĵ�һλ��ʼ������ǰ��Ѱ�������ַ��������滻�������λ���±��Ϊmax
        //��һ�δ�max��ʼѰ�ҡ�����max�Ѿ����ù�����ֹ���ظ�ʹ�ã�������һ���ҵ�max֮������0
        String x = "1267453";
        int n = 3;
        int len = x.length();
        char[] xCharArr = x.toCharArray();
        int reslen = len - n;
        char[] result = new char[reslen];
        //��ʼ��
        for (int i = n,j=0; i < len && j<reslen; i++,j++) {
            result[j] = xCharArr[i];
        }
        //��¼��ѡ�е����ֵ���±�
        int max = 0;
        for (int i = 0; i < reslen; i++) {
            int flag = 1;
            for (int j = max; j < len - reslen + i ; j++) {
                if (result[i] <= xCharArr[j]){
                    result[i] = xCharArr[j];
                    max = j;
                    xCharArr[j] = 0;
                    flag = 0;
                }
            }
            //flagΪ1˵��iλ�ڳ�ʼ��������£��������ġ�i����Ĳ��ñȽ���
            if (flag == 1)break;
        }
        Arrays.stream(result).forEach(System.out::println);
    }

}
