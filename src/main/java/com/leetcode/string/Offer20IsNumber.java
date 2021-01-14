package com.leetcode.string;

public class Offer20IsNumber {

    public boolean isNumber(String s){
        s = s.trim();
        //�ų�������գ��մ���eǰû�����֣�ֻ��.
        // \s�հ��ַ� * ���
        // ([+-]? \\.?[eE][\\s\\S]* : +-�л�û��.�л���û�У�����e����E�����հ׻���ǿհף�
        String regex = "\\s* | ([+-]?\\.?[eE][\\s\\S]*) | ([+-]?\\.)";
        if (s.matches(regex)){
            return false;
        }
        //�Բ�������������ַ�������������ƥ��
        regex = "(([+-])?\\d*\\.?\\d*)([eE][+-]?\\d+)?";
        return s.matches(regex);
    }

}
