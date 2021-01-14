package com.xqc.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//ʱ�临�Ӷ���ҪΪ����O(nlogn)
public class ListUnion {

    public static void main(String[] args) {
        //?union([?2,?1,?3],?[?2,?3,?4])?==??[1,?2,?3,?4]
        System.out.println(union(Arrays.asList(2, 1, 3), Arrays.asList(2, 3, 4)));
    }

    static List<Integer> union(List<Integer> a, List<Integer> b) {
        //?�����ʵ��
        //����������ֱ�����
        a = sortListTopDown(a);
        b = sortListTopDown(b);

        //�ϲ��������������
        return merge(a,b);
    }

    public static List<Integer> sortListTopDown(List<Integer> head) {
        //
        if (head == null || head.size()==1) {
            return head;
        }
        int mid = head.size()/2;

        //��������ָ�������ߵ��м�
        List<Integer> l1 = head.subList(0, mid);
        List<Integer> l2 = head.subList(mid, head.size());
        List<Integer> l1result = sortListTopDown(l1);
        List<Integer> l2result = sortListTopDown(l2);
        return merge(l1result, l2result);
    }

    //�����ȥ�أ��������ж�ʱ����if(temp<temp1 || temp <temp2)�ٽ��룬����ָ��ֻ������
    private static List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        List<Integer> dummyHead = new ArrayList<Integer>();
        //��ʼ�����һ��С����
        dummyHead.add(0);
        int index = 0;
        int index1 = 0;
        int index2 = 0;
        //����С��һ�������µ�������
        while (index1 < l1.size() && index2 < l2.size()) {
            //
            if (l1.get(index1) < l2.get(index2) && dummyHead.get(index) < l1.get(index1)) {
                dummyHead.add(l1.get(index1));
                index1++;
            } else if (l1.get(index1) > l2.get(index2) && dummyHead.get(index) < l2.get(index2)) {
                dummyHead.add(l2.get(index2));
                index2++;
            } else if(l1.get(index1) == l2.get(index2) && dummyHead.get(index) < l2.get(index2)){
                dummyHead.add(l2.get(index2));
                index1++;
                index2++;
            }
            index++;
        }
        //���l1��ʣ�࣬��l1��ʣ��ļ��뵽�����У�����l2���뵽������
        if (index1 < l1.size()) {
            while (index1 < l1.size()) {
                if (dummyHead.get(index) < l1.get(index1)) {
                    dummyHead.add(l1.get(index1));
                    index++;
                }
                index1++;
            }
        } else {
            while (index2 < l2.size()) {
                if (dummyHead.get(index) < l2.get(index2)) {
                    dummyHead.add(l2.get(index2));
                    index++;
                }
                index2++;
            }
        }
        return dummyHead.subList(1, dummyHead.size());
    }
}
