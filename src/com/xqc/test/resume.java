package com.xqc.test;

/**
 * @ClassName resume
 * @Description TODO
 * @Author Administrator
 * @Date 2019/3/5/005 10:27
 * @Version 1.0
 **/
public class resume {
	public static void main(String[] args){
        boolean ApplicationResult = false;
        while(!ApplicationResult) {
            ApplicationResult = SendApplication("�ֽ�����");
            if (ApplicationResult) {
                //log.info("successful!");
                StriveToRealizeYourValue();
                break;
            } else {
                //log.error("weak capacity");
                Improvetechnology();
            }
        }
    }
    public static boolean SendApplication(String company){
        return false;

    }
    public static void StriveToRealizeYourValue(){
        System.out.println("Ŭ��ʵ���Լ��ļ�ֵ");

    }
    public static void Improvetechnology(){
    	System.out.println("Ŭ��ѧϰ�������Լ���");
    }
}
