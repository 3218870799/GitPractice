package com.leetcode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingOffer {
	public static void main(String[] args) {
		Solution solution = new Solution();
		//���ַ�ʽ��ʼ����list�ǲ��ɸı�ģ��޷���Ӻ�ɾ��
		List<Integer> price = Arrays.asList(2,5);
		//
		List<Integer> libao1 = Arrays.asList(3,0,5);
		List<Integer> libao2 = Arrays.asList(1,2,10);
		List<List<Integer>> offer = new ArrayList<List<Integer>>();
		offer.add(libao1);
		offer.add(libao2);
		List<Integer> needs = Arrays.asList(3,2);
		System.out.println(solution.shoppingOffers(price, offer, needs));
	}	
}
class Solution {
	/**
	* @Return Type:int
	* @Parament:needs,��������
	* @Author : qcxiao
	* @Date:2020��8��29�� ����4:08:29
	 */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> offer, List<Integer> needs) {
    	//�ɲ��������ô���������ڼȲ������Ҳ��������

    	//����������ô�������ǲ���Ӧ������offer�أ��Ƿ�Լ۸񽵵�
    	//�ظ��жϣ�ѡ��ݹ�
		return shopping(price,offer,needs,0);
    }

	private int shopping(List<Integer> price, List<List<Integer>> offer, List<Integer> needs, int index) {
		
		//��������������ؼ���Ʒoffer,ʹ��ԭ�۹���
		if(index == offer.size()){
			return purchoseWithOriginalPrice(price,needs);
		}
		//�����Ƿ�Ӧ��ʹ��offer���Ǿ���Ҫ���������иı䣬�������ĳЩ�����ʣ�Ӧ�û��ݵ���ʹ�õ�ʹ�ø�offer֮ǰ
		List<Integer> clone = new ArrayList<Integer>(needs);
		int i;
		for (i = 0; i < offer.get(index).size()-1; i++) {
			//����ʹ�ô����ʣ����Ҫ����������Ӧ����Ʒ - ��Ӧ�������Ӧ��Ʒ�ĸ���
			int remain = needs.get(i) - offer.get(index).get(i);
			//����Ҫ����Ʒ����С��0������ʹ�ø����
			if(remain < 0){
				break;
			}else{
				//���Գ���ʹ�ô������������Ҫ��Ʒ����������ʱ��Ҫ����ƷΪ
				clone.set(i, remain);
			}
		}
		//���i�Ѿ�����offer�����һ�����ܼۣ�����˵��ǰ�������û������
		//�ǿ������ã����ø�����Ƿ���Լ��ټ۸��أ�
		if(i==offer.get(index).size()-1){
			//[������������Ǯ + ����ʣ���ʹ�õ�Ǯ ]   ��  [ û��ʹ�øô�����ļ۸�ļ�Ǯ ������]
			return Math.min(offer.get(index).get(i) + shopping(price,offer,clone,index), shopping(price,offer,needs,index + 1));
		}else{
			//�������ʹ�ô��������ĳһ��Ʒ�����㣬ֱ�ӻ���
			return shopping(price,offer,needs,index + 1);
		}
	}
	//ʹ��ԭ�۹���
	private int purchoseWithOriginalPrice(List<Integer> price, List<Integer> needs) {
		int sum = 0;
		//�����������飬�ܼ� = ÿ����Ʒ  * ÿ����Ʒ����  ֮��
		for (int i = 0; i < needs.size(); i++) {
			sum += needs.get(i) * price.get(i);
 		}
		return sum;
	}
}

class Solution01 {
	//
    private int min;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        min=0;
        //������Ʒ�ļ۸�
       for(int i=0;i<needs.size();i++){
            min=min+needs.get(i)*price.get(i);
       }
       //min=sum;
       dfs(price,special,needs,0,min);
       return min;
    }
      
     public void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int start,int money){
         if(start>=special.size())  return;
         //ѡ���
         List<Integer> libao=special.get(start);
         List<Integer> newneeds=new ArrayList<>();
         boolean flag=true;
         int tmp=0;
         for(int i=0;i<libao.size()-1;i++){
        	 //������˸��������Ʒ������С����Ҫ�������������ø����
             if(needs.get(i)-libao.get(i)<0){
                 flag=false;
                 break;
             }else{
                 newneeds.add(needs.get(i)-libao.get(i));
                 //���tmp���������������Ǯ��
                 tmp=tmp+libao.get(i)*price.get(i);
             }
         }
         if(flag){
             int newMoney=money-tmp+libao.get(libao.size()-1);
             min=Math.min(min,newMoney);
             dfs(price, special, newneeds, start,newMoney);
         }
         //��ѡ�����
          dfs(price, special, needs ,start+1,money);
     } 

}
