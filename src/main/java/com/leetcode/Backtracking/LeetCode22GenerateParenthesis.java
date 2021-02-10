package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22GenerateParenthesis {

    //���ؿ������ɵ��б�
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    public void backtrack(List<String> result, StringBuilder cur, int leftNum, int rightNum, int n) {
        //һ�ַ����Ѿ��Ϸ�����2n�ĳ��ȣ�������뵽�����
        if (cur.length() == n * 2) {
            result.add(cur.toString());
            return;
        }
        //�������������С��n�����Լ�����������ţ��ȼ������ţ��ȼ�������һ�����Ϸ�
        if (leftNum < n) {
            cur.append('(');
            //�ݹ�������
            backtrack(result, cur, leftNum + 1, rightNum, n);
            //����ǰ��ӵ�ɾ�����Ա��������
            cur.deleteCharAt(cur.length() - 1);
        }
        //�������������С����������������������������
        if (rightNum < leftNum) {
            cur.append(')');
            backtrack(result, cur, leftNum, rightNum + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
