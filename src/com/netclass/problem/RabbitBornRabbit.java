package com.netclass.problem;

/**
 * 
 * @author xqc
 * @data 2020��3��22��
 * Description:
 * ��һֻ���ӣ��ӵ�3���¿�ʼÿ����1ֻ���ӣ�С���ӳ�����3���¿�ʼÿ����Ҳ����1ֻ���ӣ�
 * �������Ӷ���������ÿ���µ����������Ƕ��٣�
 * 
 * ������
 * էһ����������ͦ���ӣ���ϸ����֮���֣�
 * ����2���¼�2�������ϵ��������µ�1����ÿֻ������1ֻ���ӡ�
 * �����µ��������˵��֮ǰ����2���¼�2�������ϵ����Ӿ���2����ǰ������������
 * Ҳ����˵�µ�1���������1�������ӵ���������2����ǰ����������
 * ��ʵ���ǵ��µ�����������ǰ�����µ�������֮�͡�
 * 
 * ���ࣺ쳲�������
 * 
 */
public class RabbitBornRabbit {
	
	public static void main(String[] args) {
		//��������
		int sum_rabbit =1;
		//һ����ǰ��������
		int one_ago = 1;
		//������ǰ����������==�µ�һ����������������
		int two_ago = 1;
		
		for(int i =1;i<=10;i++){
			if(i<3){
				sum_rabbit =1;
			}else{
				sum_rabbit = one_ago+two_ago;
				two_ago = one_ago;
				one_ago = sum_rabbit;
			}
		}
		System.out.println(sum_rabbit);
	}
	
	

}
