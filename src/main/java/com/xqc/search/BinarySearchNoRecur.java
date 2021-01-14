package com.xqc.search;

/**
 * 
 * @ClassName:BinarySearchNoRecur.java
 * @Author qcxiao
 * @Date:2020��8��10������1:42:14
 * @Version:1.0
 * @Description:���ֲ��ҷǵݹ�ʵ��
 */
public class BinarySearchNoRecur {

	public static void main(String[] args) {
		//����
		int[] arr = {1,3, 8, 10, 11, 67, 100};
		int index = binarySearch(arr, 100);
		System.out.println("index=" + index);
	}
	
	//���ֲ��ҵķǵݹ�ʵ��
	/**
	 * 
	 * @param arr �����ҵ�����, arr����������
	 * @param target ��Ҫ���ҵ���
	 * @return ���ض�Ӧ�±꣬-1��ʾû���ҵ�
	 */
	public static int binarySearch(int[] arr, int target) {
		
		int left = 0;
		int right = arr.length - 1;
		//˵����������
		while(left <= right) {
			int mid = (left + right) / 2;
			if(arr[mid] == target) {
				return mid;
			} else if ( arr[mid] > target) {
				//��Ҫ����߲���
				right = mid - 1;
			} else {
				//��Ҫ���ұ߲���
				left = mid + 1;
			}
		}
		return -1;
	}

}
