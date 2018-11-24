package com.xqc.classic;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * һ����Hash�㷨
 *
 * @param <T> �ڵ�����
 */
public class ConsistentHash<T> {
    /**
     * Hash������������Զ���hash�㷨
     */
    HashFunc hashFunc;
    /**
     * ���ƵĽڵ����
     */
    private final int numberOfReplicas;
    /**
     * һ����Hash��
     */
    private final SortedMap<Long, T> circle = new TreeMap<>();

    /**
     * ���죬ʹ��JavaĬ�ϵ�Hash�㷨
     * @param numberOfReplicas ���ƵĽڵ����������ÿ���ڵ�ĸ��ƽڵ������ڸ��ؾ���
     * @param nodes            �ڵ����
     */
    public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        this.hashFunc = new HashFunc() {

            @Override
            public Long hash(Object key) {
//                return fnv1HashingAlg(key.toString());
                return md5HashingAlg(key.toString());
            }
        };
        //��ʼ���ڵ�
        for (T node : nodes) {
            add(node);
        }
    }

    /**
     * ����
     * @param hashFunc         hash�㷨����
     * @param numberOfReplicas ���ƵĽڵ����������ÿ���ڵ�ĸ��ƽڵ������ڸ��ؾ���
     * @param nodes            �ڵ����
     */
    public ConsistentHash(HashFunc hashFunc, int numberOfReplicas, Collection<T> nodes) {
        this.numberOfReplicas = numberOfReplicas;
        this.hashFunc = hashFunc;
        //��ʼ���ڵ�
        for (T node : nodes) {
            add(node);
        }
    }

    /**
     * ���ӽڵ�<br>
     * ÿ����һ���ڵ㣬�ͻ��ڱջ������Ӹ������ƽڵ���<br>
     * ���縴�ƽڵ�����2����ÿ���ô˷���һ�Σ�������������ڵ㣬�������ڵ�ָ��ͬһNode
     * ����hash�㷨�����node��toString�������ʰ���toStringȥ��
     *
     * @param node �ڵ����
     */
    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hashFunc.hash(node.toString() + i), node);
        }
    }

    /**
     * �Ƴ��ڵ��ͬʱ�Ƴ���Ӧ������ڵ�
     *
     * @param node �ڵ����
     */
    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hashFunc.hash(node.toString() + i));
        }
    }

    /**
     * ���һ�������˳ʱ��ڵ�
     *
     * @param key Ϊ������ȡHash��ȡ��˳ʱ�뷽���������һ������ڵ��Ӧ��ʵ�ʽڵ�
     * @return �ڵ����
     */
    public T get(Object key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hashFunc.hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, T> tailMap = circle.tailMap(hash); //���ش�ӳ��Ĳ�����ͼ��������ڵ��� hash
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        //��������
        return circle.get(hash);
    }

    /**
     * ʹ��MD5�㷨
     * @param key
     * @return
     */
    private static long md5HashingAlg(String key) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
            md5.reset();
            md5.update(key.getBytes());
            byte[] bKey = md5.digest();
            long res = ((long) (bKey[3] & 0xFF) << 24) | ((long) (bKey[2] & 0xFF) << 16) | ((long) (bKey[1] & 0xFF) << 8)| (long) (bKey[0] & 0xFF);
            return res;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    /**
     * ʹ��FNV1hash�㷨
     * @param key
     * @return
     */
    private static long fnv1HashingAlg(String key) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < key.length(); i++)
            hash = (hash ^ key.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash;
    }

    /**
     * Hash�㷨���������Զ���hash�㷨
     */
    public interface HashFunc {
        public Long hash(Object key);
    }
}
