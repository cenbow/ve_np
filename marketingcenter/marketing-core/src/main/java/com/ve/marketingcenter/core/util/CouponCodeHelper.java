package com.ve.marketingcenter.core.util;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;


public class CouponCodeHelper {
	//优惠券编码长度
	private static final int CODE_LENGTH = get_code_length(8);
	
	private static int get_code_length(int length){
		return length;
	}
	
	public static Set<String> generate(int count) {
		Set<String> set = new HashSet<String>();
		for(;;) {
			String couponCode = doGen();
			if(set.contains(couponCode)){
				continue;
			}else{
				set.add(encode(couponCode));
				count --;
			}
			if(count == 0){
				break;
			}
		}
		return set;
	}
	
	private static String doGen(){
		StringBuffer serialNo = new StringBuffer();
		for (int i = 1; i <= CODE_LENGTH; i++) {
			int a = (int) (Math.random() * 3);
			switch(a){
			case 0:
				serialNo.append((char)((int)(Math.random() * ('Z' - 'A' + 1)) + 'A'));
				break;
			case 1:
				serialNo.append((char)((int)(Math.random() * ('z' - 'a' + 1)) + 'a'));
				break;
			case 2:
				serialNo.append((char)((int)(Math.random() * ('9' - '0' + 1)) + '0'));
				break;
			default:
				break;
			}
		}
		return serialNo.toString();
	}
	
	public static String encode(String couponCode){
		return new String(Base64.encodeBase64(couponCode.getBytes()));
	}
	
	public static String decode(String encrypt){
		return new String(Base64.decodeBase64(encrypt.getBytes()));
	}
	
	public static void main(String[] args) {
		Set<String> set = generate(1);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		for(String str:set){
			System.out.println(str);
			System.out.println(decode(str));
		}
		
	}
}