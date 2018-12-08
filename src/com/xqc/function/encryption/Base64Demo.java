package com.xqc.function.encryption;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		CommonsCodecDemo();
		bouncyCastleDemo();
		jdkDemo();
	}

	static String str = "Test";

	/**
	 * commons codec ʵ��Base64���ܽ���
	 */
	
/*	
	Maven��ַ
	
	<!-- https://mvnrepository.com/artifact/commons-codec/commons-codec -->
		<dependency>
		    <groupId>commons-codec</groupId>
		    <artifactId>commons-codec</artifactId>
		    <version>1.8</version>
		</dependency>*/

	
	
	public static void CommonsCodecDemo() {
		// ����:
		byte[] encodeBytes = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
		System.out.println("commons codecʵ��base64���ܣ�    " + new String(encodeBytes));
		// ���ܣ�
		byte[] decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
		System.out.println("commons codecʵ��base64���ܣ�    " + new String(decodeBytes));
	}

	/**
	 * bouncy castleʵ��Base64���ܽ���
	 * 
	 */
/*	
  Maven��ַ
     <!-- https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk15on -->
	   <dependency>
		    <groupId>org.bouncycastle</groupId>
		    <artifactId>bcprov-jdk15on</artifactId>
		    <version>1.56</version>
		</dependency>
		
		
		*/
	public static void bouncyCastleDemo() {
		// ����
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
		System.out.println("bouncy castleʵ��base64���ܣ�    " + new String(encodeBytes));
		// ����
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("bouncy castleʵ��base64���ܣ�" + new String(decodeBytes));
	}

	public static void jdkDemo() throws UnsupportedEncodingException {
		// ����
		String encodeBytes = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
		System.out.println("JDKʵ�ֵ�base64���ܣ�    " + encodeBytes);
		//����
		byte[] decodeBytes = Base64.getDecoder().decode(encodeBytes.getBytes("UTF-8"));
		System.out.println("JDKʵ�ֵ�base64���ܣ�  "+new String(decodeBytes));
	}
}
