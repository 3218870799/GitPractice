package com.xqc.recursion;
/**
 * @ClassName:Hanoi.java
 * @Author qcxiao
 * @Date:2020��8��10������1:50:11
 * @Version:1.0
 * @Description:���人ŵ������
 */
public class Hanoi {
	//��ŵ�����ƶ��ķ���
	//ʹ�÷����㷨
	/**
	* @Function: Hanoi.java
	* @Description: �����ŵ���ƶ��Ĺ���
	*
	* @Return Type:void
	* @Parament:num�����̵�����
	* @Parament:from����ʼ�ƶ�������
	* @Parament:help������������
	* @Parament:to ����Ŀ������
	*
	* @Version: v1.0.0
	* @Author : qcxiao
	* @Date:2020��8��10�� ����1:51:09
	 */
	public static void hanoiTower(int num,String from,String help,String to) {
		//���ֻ��һ����
		if(num == 1) {
			System.out.println("��1���̴� " + from + "->" + to);
		} else {
			//��������� n >= 2 ������������ǿ��Կ����������� 1.���±ߵ�һ���� 2. �����������
			//1. �Ȱ� ������������� A->B�� �ƶ����̻�ʹ�õ� c
			hanoiTower(num - 1, from, to, help);
			//2. �����±ߵ��� A->C
			System.out.println("��" + num + "���̴� " + from + "->" + to);
			//3. ��B���������� �� B->C , �ƶ�����ʹ�õ� a��  
			hanoiTower(num - 1, help, from , to);
			
		}
	}
	public static void main(String[] args) {
		hanoiTower(3, "��", "��", "��");
	}
}

