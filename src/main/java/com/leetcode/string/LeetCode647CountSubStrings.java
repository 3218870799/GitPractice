package com.leetcode.string;

public class LeetCode647CountSubStrings {

    public static void main(String[] args) {
        String a = "aaa";
        int resutl = countSubstringsByCenterExpansion(a);
    }
    public int countSubstringsByManacher(String s) {
        int n = s.length();
        //���´����ַ�������$��ͷ����!��β���м��ַ�����#
        StringBuffer t = new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n = t.length();
        t.append('!');
        //��f(i)Ϊ��s�ĵ�iλΪ�������Ŀ�����չ���������İ뾶
        int[] f = new int[n];
        int iMax = 0, rMax = 0, ans = 0;
        for (int i = 1; i < n; ++i) {
            // ��ʼ�� f[i]
            f[i] = i <= rMax ? Math.min(rMax - i + 1, f[2 * iMax - i]) : 1;
            // ������չ
            while (t.charAt(i + f[i]) == t.charAt(i - f[i])) {
                ++f[i];
            }
            // ��̬ά�� iMax �� rMax
            if (i + f[i] - 1 > rMax) {
                iMax = i;
                rMax = i + f[i] - 1;
            }
            // ͳ�ƴ�, ��ǰ����Ϊ (f[i] - 1) / 2 ��ȡ��
            ans += f[i] / 2;
        }
        return ans;
    }

    //������չ
    static int totalCount = 0;
    public static int countSubstringsByCenterExpansion(String s) {
        if (s==null){
            return 0;
        }
        //�����ַ�����������iλ��Ϊ���ĵ��ַ����ǻ��Ĵ��ĸ���
        for (int i = 0; i < s.length(); i++) {
            //�����������Ĵ�
            count(s,i,i);
            //����ż�����Ĵ�
            count(s,i,i+1);
        }
        return totalCount;
    }
    public static void count(String s ,int i,int j){
        //��iΪ������������չ�����������ȣ����ǻ��ģ���1��������ȣ�������Ҳ����������
        while (i>=0 && j<=s.length()-1 && s.charAt(i) == s.charAt(j)){
            i--;j++;
            totalCount++;
        }
    }

    public int countSubstrings(String s) {
        int n = s.length();
        //����ӵ�i����jλ�õ��Ӵ��ǲ��ǻ��Ĵ�
        boolean[][] dp = new boolean[n][n];
        //��¼���Ĵ��ĸ���
        int count = 0;
        //��ֻ��һ���ַ�ʱ��ȫ��Ϊture
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        //��ֻ�������ַ�ʱ
        for (int i = 0; i < n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1] = true;
                count++;
            }
        }
        //�������ַ�����ʱ
        for (int len = 3; len <= n; len++) {
            //���Ϊi���յ�Ϊj�����Ϊlen��
            for (int i = 0; i + len <=n ; i++) {
                int j = i + len -1;
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
