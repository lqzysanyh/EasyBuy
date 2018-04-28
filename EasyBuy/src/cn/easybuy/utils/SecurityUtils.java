package cn.easybuy.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * MD5������
 * @author Administrator
 *
 */
public class SecurityUtils {
	
	/**
	 * md5����
	 * @param value
	 * @return
	 */
	public static String md5Hex(String value){
		return DigestUtils.md5Hex(value);
	}
	
	/**
	 * ����md5����
	 * @param value
	 * @return
	 */
	public static String md5Hex3(String value){
		for (int i = 0; i < 3; i++) {
			value =  DigestUtils.md5Hex(value);
		}
		return value;
	}
	
	/**
	 * sha256����
	 * @param value
	 * @return
	 */
	public static String sha256Hex(String value){
		return DigestUtils.sha256Hex(value);
	}
	/**
	 * sha512����
	 * @param value
	 * @return
	 */
	public static String sha512Hex(String value){
		return DigestUtils.sha512Hex(value);
	}
	public static void main(String[] args){
		System.out.println(SecurityUtils.md5Hex("123456"));
	}
}

