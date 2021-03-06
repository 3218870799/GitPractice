package com.xqc.utils.encryption;

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
/*	
	Maven地址
	
	<!-- https://mvnrepository.com/artifact/commons-codec/commons-codec -->
		<dependency>
		    <groupId>commons-codec</groupId>
		    <artifactId>commons-codec</artifactId>
		    <version>1.8</version>
		</dependency>*/

	
	/**
	 * commons codec 实现Base64加密解密
	 */
	public static void CommonsCodecDemo() {
		// 加密:
		byte[] encodeBytes = org.apache.commons.codec.binary.Base64.encodeBase64(str.getBytes());
		System.out.println("commons codec实现base64加密：    " + new String(encodeBytes));
		// 解密：
		byte[] decodeBytes = org.apache.commons.codec.binary.Base64.decodeBase64(encodeBytes);
		System.out.println("commons codec实现base64解密：    " + new String(decodeBytes));
	}


/*	
  Maven地址
     <!-- https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk15on -->
	   <dependency>
		    <groupId>org.bouncycastle</groupId>
		    <artifactId>bcprov-jdk15on</artifactId>
		    <version>1.56</version>
		</dependency>		
		*/
	/**
	 * bouncy castle实现Base64加密解密
	 * 
	 */
	public static void bouncyCastleDemo() {
		// 加密
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(str.getBytes());
		System.out.println("bouncy castle实现base64加密：    " + new String(encodeBytes));
		// 解密
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("bouncy castle实现base64解密：" + new String(decodeBytes));
	}

	public static void jdkDemo() throws UnsupportedEncodingException {
		// 加密
		String encodeBytes = Base64.getEncoder().encodeToString(str.getBytes("UTF-8"));
		System.out.println("JDK实现的base64加密：    " + encodeBytes);
		//解密
		byte[] decodeBytes = Base64.getDecoder().decode(encodeBytes.getBytes("UTF-8"));
		System.out.println("JDK实现的base64解密：  "+new String(decodeBytes));
	}
}
