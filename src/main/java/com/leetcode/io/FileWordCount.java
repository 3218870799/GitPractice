package com.leetcode.io;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * javaʵ�ֶ�ȡӢ�����£�ͳ������ÿ�����ʳ��ֵĴ��������
 *
 */
public class FileWordCount {

    public void count() throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader("F:\\test\\english.txt"));
        StringBuffer buffer = new StringBuffer();
        String line = null;
        while( (line = reader.readLine()) != null ){
            buffer.append(line);
        }
        reader.close();
        //����������ʽƥ�䵥��
        Pattern expression = Pattern.compile("[a-zA-Z]+");
        String string = buffer.toString();
        Matcher matcher = expression.matcher(string);
        TreeMap<String,Integer> map = new TreeMap<>();
        String word = "";
        int n = 0;
        Integer times = 0;
        while(matcher.find()){		//�Ƿ�ƥ�䵥��
            word = matcher.group();		//�õ�һ�����ʣ���ӳ���еļ�
            n++;
            if( map.containsKey(word) ){	//����ü����ڣ����ʾ���ʳ��ֹ�
                times = map.get(word);		//�õ����ʳ��ֵĴ���
                map.put(word, times+1);
            } else {
                map.put(word, 1);	//���򵥴��ǵ�һ�γ��֣�ֱ�ӷ���map
            }
        }
        //����Map��value��������
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Map.Entry<String,Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(list, comparator);
        for (int i = list.size()-1; i > list.size() - 11; i--) {
            System.out.println(list.get(i).toString());
        }
        System.out.println("ͳ�Ʒ������£�");
        System.out.println("t �����е�������" + n + "��");
        System.out.println("�������Ϣ��ԭ�ļ�Ŀ¼��result.txt�ļ���");
        BufferedWriter bufw = new BufferedWriter(new FileWriter("F:\\test\\result.txt"));
        for(Map.Entry<String,Integer> me : list){
            bufw.write(me+"");
            bufw.newLine();
        }
        bufw.write("english.txt�еĵ�������" + n + "��");
        bufw.newLine();
        bufw.write("english.txt�в�ͬ����" + map.size() + "��");
        bufw.close();
    }


    public static void main(String[] args) {
        try {
            FileWordCount fwc = new FileWordCount();
            fwc.count();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
