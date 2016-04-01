package com.travel.common.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
/** 
 * <p>Title: Base64Util.java</p>
 * <p>Package Name: com.drolay.common.util</p>  
 * <p>Description:TODO </p> 
 *  
 * @author liujq
 * @date  :2015年6月24日 
 * @version :1.0
 */

@SuppressWarnings("restriction")
public class Base64Util {
	/**
	 * 加密/解密算法/工作模式/填充方式
	 * */
	public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";
	public static final String SHORT_ALGORITHM = "DESede/ECB/NoPadding";
	/**
	 * 密钥算法
	 * */
	public static final String KEY_ALGORITHM = "DESede";
	/**
	 * 转换密钥
	 * 
	 * @param key
	 *            二进制密钥
	 * @return Key 密钥
	 * */
	private static Key toKey(byte[] key) throws Exception {
		DESedeKeySpec dks = new DESedeKeySpec(key); //实例化Des密钥
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);//实例化密钥工厂
		SecretKey secretKey = keyFactory.generateSecret(dks);//生成密钥
		return secretKey;
	}
	private static byte[] getKey() {
		final byte[] keyBytes = new byte[] { (byte) 0x9c, 0x3a, (byte) 0xe7,
				(byte) 0xcc, 0x51, 0xd, 0x77, (byte) 0xa5, 0x6e, (byte) 0xdd,
				0x3b, 0x5d, 0x7c, 0x15, (byte) 0xa3, 0x29, (byte) 0x9c, 0x3a,
				(byte) 0xe7, (byte) 0xcc, 0x51, 0xd, 0x77, (byte) 0xa5 };// 24字节的密钥,BOSS系统提供的密钥
		return keyBytes;
	}

	/**
	 * 加密数据
	 * @param data 待加密数据
	 * @param key  密钥
	 * @return byte[] 加密后的数据
	 * */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key);//还原密钥
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);//实例化
		cipher.init(Cipher.ENCRYPT_MODE, k);//初始化，设置为加密模式
		return cipher.doFinal(data);//执行操作
	}
	/**
	 * 加密数据
	 * @param str
	 * @return
	 */
	public static String dataEncrypt(String str) {
		String encrypt = null;
		try {
			byte[] ret = encrypt(str.getBytes("UTF-8"), getKey());
			encrypt = new String(Base64.encode(ret));
		} catch (Exception e) {
			e.printStackTrace();
			encrypt = str;
		}
		return encrypt;
	}

	/**
	 * 解密数据
	 * @param str
	 * @return
	 */
	public static String dataDecrypt(String str) {
		String decrypt = null;
		try {
			byte[] ret = decrypt(Base64.decode(str), getKey());
			decrypt = new String(ret, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			decrypt = str;
		}
		return decrypt;
	}
	/**
	 * 解密数据
	 * @param data 待解密数据
	 * @param key 密钥 
	 * @return byte[] 解密后的数据
	 * */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		Key k = toKey(key); //欢迎密钥
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM); //实例化
		cipher.init(Cipher.DECRYPT_MODE, k); //初始化，设置为解密模式
		return cipher.doFinal(data);//执行操作
	}	
	public static void main(String[] args) {
		System.out.println(Base64Util.dataEncrypt("http://localhost:8090/drolay/&admin"));
		System.out.println(Base64Util.dataDecrypt(Base64Util.dataEncrypt("http://localhost:8090/drolay/&admin")));
	}
}
