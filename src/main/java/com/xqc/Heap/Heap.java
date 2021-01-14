package com.xqc.Heap;

//�Ѵ���
public class Heap<T extends Comparable<T>> {
    //�洢���е�Ԫ��
    private T[] items;
    //��¼����Ԫ�صĸ���
    private int N;

    public Heap(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    //�ж϶�������i����Ԫ���Ƿ�С������j����Ԫ��
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    //��������i������j��������ֵ
    private void exch(int i, int j) {
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }

    //�����в���һ��Ԫ��
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    //ɾ����������Ԫ��,������������Ԫ��
    public T delMax() {
        T max = items[1];
        //��������1��������N����ֵ
        exch(1, N);
        //ɾ�����λ���ϵ�Ԫ��
        items[N] = null;
        N--;//����-1
        sink(1);
        return max;
    }

    //ʹ���ϸ��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
    private void swim(int k) {
        //����Ѿ����˸���㣬�Ͳ���Ҫѭ����
        while (k > 1) {
            //�Ƚϵ�ǰ�����丸���
            if (less(k / 2, k)) {
                //�����С�ڵ�ǰ��㣬��Ҫ����
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    //ʹ���³��㷨��ʹ����k����Ԫ�����ڶ��д���һ����ȷ��λ��
    private void sink(int k) {
        //�����ǰ�Ѿ�����ײ��ˣ��Ͳ���Ҫѭ����
        while (2 * k <= N) {
            //�ҵ��ӽ���еĽϴ���
            int max;
            if (2 * k + 1 <= N) {//�������ӽ��
                if (less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {//���������ӽ��
                max = 2 * k;
            }
            //�Ƚϵ�ǰ�����ӽ���еĽϴ��ߣ������ǰ��㲻С�������ѭ��
            if (!less(k, max)) {
                break;
            }
            //��ǰ���С���򽻻���
            exch(k, max);
            k = max;
        }
    }
}

