package com.leetcode;

public class LongestPalindrome {
	
	class Solution {
	    public String longestPalindrome(String s) {
	    	//��Ԥ�����ַ���
			StringBuffer str  = new StringBuffer();
			int lenTemp = s.length();
			str.append('#');
			for(int i=0;i<lenTemp;i++){
				str.append(s.charAt(i));
				str.append('#');
			}
	    	//�������ַ�������
	    	int len = str.length();
	    	//�ұ߽�
	    	int rightSide = 0;
	    	//�ұ߽��Ӧ�Ļ��Ĵ�����
	    	int rightSideCenter = 0;
	    	//������ÿ���ַ�Ϊ���ĵĻ��ĳ���һ�루����ȡ����
	    	int[] halfLenArr = new int[len];
	    	//��¼�������ĳ���
	    	int center = 0;
	    	//��¼����ĳ���
	    	int longestHalf = 0;
	    	
	    	for(int i = 0; i<len;i++){
	            // �Ƿ���Ҫ������չ
	            boolean needCalc = true;
	            // ������ұ߽�ĸ���֮��
	            if(rightSide > i) {
	                // �������rightSideCenter�ĶԳ�λ��
	                int leftCenter = 2 * rightSideCenter - i;
	                // ���ݻ������ʵõ��Ľ���
	                halfLenArr[i] = halfLenArr[leftCenter];
	                // ����������ұ߽磬���е���
	                if(i + halfLenArr[i] > rightSide) {
	                    halfLenArr[i] = rightSide - i;
	                }
	                // ���������֪��������ó��������С���ұ߽磬����Ҫ��չ��
	                if(i + halfLenArr[leftCenter] < rightSide) {
	                    // ֱ���Ƴ�����
	                    needCalc = false;
	                }
	            }
	            // ������չ
	            if(needCalc) {
	                while(i - 1 - halfLenArr[i] >= 0 && i + 1 + halfLenArr[i] < len) {
	                    if(str.charAt(i + 1 + halfLenArr[i]) == str.charAt(i - 1 - halfLenArr[i])) {
	                        halfLenArr[i]++;
	                    } else {
	                        break;
	                    }
	                }
	                // �����ұ߽缰����
	                rightSide = i + halfLenArr[i];
	                rightSideCenter = i;
	                // ��¼����Ĵ�
	                if(halfLenArr[i] > longestHalf) {
	                    center = i;
	                    longestHalf = halfLenArr[i];
	                }
	            }
	    	}
	        // ȥ��֮ǰ��ӵ�#
	        StringBuffer sb = new StringBuffer();
	        for(int i = center - longestHalf + 1; i <= center + longestHalf; i += 2) {
	            sb.append(str.charAt(i));
	        }
	        return sb.toString();
	    }
	}

	public String preHandleString(String s) {
		StringBuffer sb  = new StringBuffer();
		int len = s.length();
		sb.append('#');
		for(int i=0;i<len;i++){
			sb.append(s.charAt(i));
			sb.append('#');
		}
		return sb.toString();
	}
	
	class SolutionBest {
	    public String longestPalindrome(String s) {
	        if (s == null || s.length() < 1){
	            return "";
	        }
	        int maxLength = 0;
	        int center = 0;
	        for (int i = 0; i < s.length(); i++) {
	            // ����Ĵ�����Ϊ����
	            int begin = centerExpand(s, i, i);
	            // ����Ĵ�����Ϊż��
	            int end = centerExpand(s, i, i + 1);
	            if (maxLength < Math.max(begin, end)) {
	                // ��centerΪ����
	                center = i;
	                // ����Ĵ�����
	                maxLength = Math.max(begin, end);
	            }
	        }
	        // ������ǵĻ��Ĵ��ĳ���Ϊż������ô������ߵĳ��Ȼ���ұߵĳ���С1
	        return s.substring(center - (maxLength - 1) / 2, center + maxLength / 2 + 1);
	    }

	    private int centerExpand(String s, int left, int right) {
	        int L = left, R = right;
	        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
	            L--;
	            R++;
	        }
	        return R - L - 1;
	    }
	}
	

}
