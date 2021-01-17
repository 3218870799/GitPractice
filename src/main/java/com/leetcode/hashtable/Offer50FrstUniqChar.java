package com.leetcode.hashtable;

import java.util.LinkedHashMap;
import java.util.Map;

public class Offer50FrstUniqChar {
    public static void main(String[] args) {

    }
    public char firstUniqCharByLinkedHashMap(String s) {
        //ʹ�������ϣ����д洢
        Map<Character,Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        //�����ַ��������ַ������ܵĴ洢����
        for (char c :sc) {
            dic.put(c,!dic.containsKey(c));
        }
        //���������������
        for (Map.Entry<Character,Boolean> d :dic.entrySet()) {
            //���ֻ����һ�����򷵻�key
            if (d.getValue()){
                return d.getKey();
            }
        }
        //û�У����� �� ��
        return ' ';
    }

    public char firstUniqCharByArr(String s) {
        //ʹ��������д洢
        int[] dic = new int[26];
        int MinIndex = Integer.MAX_VALUE;
        //���ַ���ת��Ϊ����
        char[] sc = s.toCharArray();
        for (char c : sc) {
            dic[c -'a']++;
        }
        for (int i = 0; i < dic.length; i++) {
          if (dic[i]==1){
              return (char) (i + 'a');
          }
        }
        return ' ';
    }

}
