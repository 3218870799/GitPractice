package com.netclass.problem;

/**
 * @author xqc
 * @data 2020��4��3��
 * Description:������������6=1+2+3;
 * �ҳ�1��100֮�е�������
 */
public class PerferNum {
	
	public static void main(String[] args) {
		for (int i = 1; i <100; i++) {
			int sum =0;
			//��ÿ��i�ҵ������������Ӻ�
			for (int j = 1; j <i; j++) {
				if(i%j==0){
					sum+=j;
				}
			}
			if(sum==i){
				System.out.println(sum);
			}
			
			
		}
	}

}
