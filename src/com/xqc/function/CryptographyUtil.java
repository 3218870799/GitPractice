package com.xqc.function;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * ���ܹ���
 * @author A Cang��xqc��
 *
 */
public class CryptographyUtil {
	
	/**
	 * Md5����
	 * @param str
	 * @param salt
	 * @return
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	public static void main(String[] args) {
		System.out.println(md5("MD5","salt"));
	}
	

}
