package com.xqc.utils.assemble;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * ������
 * @author xqc
 * @data 2019��1��14��
 * Description:
 */
public class AssembleUtil {

	/**
	 * ����Ĳ��ظ���Set���ϡ�
	 */
	private static Set<String> set = new TreeSet<String>();

	/**
	 *Time:2017��9��13������2:53:59
	 *@param sourceStr ��ʼ�����ַ���Դ��Ϣ
	 *@param max       ÿ������Ǽ�������
	 *@return
	 *Return:String[]
	 *Description:�����ַ�����1,2,3,4,5,6,7���ĸ�ʽ�������һ���ж��������
	 */
	public static String[] getAssemble(String sourceStr, int max) {
		String sourceList [] = sourceStr.split(",");
		String[] array = getAssemble(sourceList, max);
		return array;
	}
	
	/**
	 *Time:2017��9��13������2:53:56
	 *@param sourceArray ��ʼ�����ַ���������Ϣ
	 *@param max         ÿ������Ǽ�������
	 *@return
	 *Return:String[]
	 *Description: �����ַ���������ʽ������һ���ж���������{ "1", "2", "3", "4", "5","6","7" }
	 */
	public static String[] getAssemble(String[] sourceArray, int max) {
		for (int start = 0; start < sourceArray.length; start++) {
			doSet(sourceArray[start], sourceArray, max);
		}
		String[] arr = new String[set.size()];
		String[] array = set.toArray(arr);
		set.clear();
		return array;
	}

	/**
	 *Time:2017��9��13������3:00:18
	 *@param start
	 *@param sourceList
	 *@param max
	 *@return
	 *Return:Set<String>
	 *Description:��������
	 */
	private static Set<String> doSet(String start, String[] sourceList, int max) {
		String[] olds = start.split("_");
		if (olds.length == max) {
			set.add(start.replaceAll("_", "").trim());
		} else {
			for (int s = 0; s < sourceList.length; s++) {
				if (Arrays.asList(olds).contains(sourceList[s])) {
					continue;
				} else {
					doSet(start + "_" + sourceList[s], sourceList, max);
				}
			}
		}
		return set;
	}

	/**
	 *Time:2017��9��13������3:04:25
	 *@param args
	 *Return:void
	 *Description:���Է���
	 */
	public static void main(String[] args) {
		    
		    String[] sourceArr = new String[] { "1", "2", "3", "4", "5","6","7" };
	        String[] resultArr = getAssemble(sourceArr, 3);
	        System.out.println("�ۼ���ϣ�"+resultArr.length+","+Arrays.toString(resultArr));
	        
	        String sourceStr = "1,2,3,4,5,6,7";
	        String[] resultArr2 = getAssemble(sourceStr, 3);
	        System.out.println("�ۼ���ϣ�"+resultArr2.length+","+Arrays.toString(resultArr2));
	}
}
