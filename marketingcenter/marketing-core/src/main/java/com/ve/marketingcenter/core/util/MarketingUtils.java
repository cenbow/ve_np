package com.ve.marketingcenter.core.util;

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.ve.marketingcenter.common.api.MarketingResponse;
import com.ve.marketingcenter.common.constant.ReturnCodeEnum;


public final class MarketingUtils {
	private MarketingUtils() {}
	
	/**
	 * 根据前台传过来的平台组合解析存往数据库的platform的值
	 * @param param
	 * @return
	 */
	public static int getCombinedPlatformDBValue(String param) {
		Preconditions.checkArgument(StringUtils.isNotBlank(param), "\"平台环境\"的值为空!");
		Iterable<String> platforms = Splitter.on(",").omitEmptyStrings().trimResults().split(param);
		int combinedValue = 0;
		for (String tmp : platforms) {
			combinedValue |= getPlatformDBValue(Integer.valueOf(tmp));
		}
		return combinedValue;
	}

	/**
	 * 平台环境的展示值到数据库值的转换
	 * 
	 * @param platform
	 *            前台展示的平台环境的value
	 * @return 存到数据库的plateform的值
	 */
	private static int getPlatformDBValue(int platform) {
		Preconditions.checkArgument(platform > 0, "\"平台环境\"的值应该是一个大于零的数。plateform = "+ platform);
		Preconditions.checkArgument(platform < 31, "\"平台环境\"的值应该是一个小于等于30的数。plateform = " + platform);
		return (int) Math.pow(2, (platform - 1));
	}
	
	/**
	 * 逆运算,根据数据库存储获取页面的platform
	 * @param param
	 * @return
	 */
	public static String getDispPlatform(int platform) {
		String binaryStr = StringUtils.reverse(Integer.toBinaryString(platform));
		StringBuffer dispValue = new StringBuffer();
		for(int i = 0;i<binaryStr.length();i++){
			if(binaryStr.charAt(i) == '1'){
				dispValue.append(i + 1).append(",");
			}
		}
		return dispValue.substring(0, dispValue.length() - 1);
	}
	
	public static <K,V> void copyProperties(K orig, V dest){
		Assert.notNull(orig, "source object must not be null");
		Assert.notNull(dest, "target object must not be null");
//		Assert.state(!source.getClass().isAssignableFrom(target.getClass()) && 
//				!target.getClass().isAssignableFrom(source.getClass()),"the source and the target are different types objects");
		Method[] sourceMethods = orig.getClass().getDeclaredMethods();
		for(Method sourceMethod:sourceMethods){
			String srcMethodName = sourceMethod.getName();
			if(!StringUtils.startsWith(srcMethodName, "set")){
				continue;
			}
			Method targetMethod = null;
			try {
				targetMethod = dest.getClass().getMethod(srcMethodName,sourceMethod.getParameterTypes());
			} catch (Exception e) {
				continue;
			}
			
			String getMethodName = "get"+srcMethodName.substring(3);
			
			try {
				targetMethod.invoke(dest, orig.getClass().getMethod(getMethodName).invoke(orig));
			} catch (Exception e) {
				throw new RuntimeException("copy properties error.orig:"+JSONObject.toJSONString(orig)+",dest:"+ JSONObject.toJSONString(dest));
			}
		}
	}
	
	
	public static <T> MarketingResponse<T> getSuccessResponse(){
		return new MarketingResponse<T>(ReturnCodeEnum.SUCCESS);
	}
	
	public static <T> MarketingResponse<T> getSuccessResponse(T module,int total){
		MarketingResponse<T> response = new MarketingResponse<T>(module,total);
		response.setResCode(ReturnCodeEnum.SUCCESS.getCode());
		response.setMessage(ReturnCodeEnum.SUCCESS.getMessage());
		return response;
	}
	
	public static <T> MarketingResponse<T> getSuccessResponse(T module){
		return getSuccessResponse(module,1);
	}
	
	public static <T> MarketingResponse<T> getFailResponse(String errorCode,String msg){
		return new MarketingResponse<T>(errorCode,msg);
	}
	
	
	public static void main(String[] args) {
		String a = "1,3,5";
		String b = "6";
		
		System.out.println(getCombinedPlatformDBValue(a));
		System.out.println(getCombinedPlatformDBValue(b));
		
		System.out.println(getCombinedPlatformDBValue(b) & getCombinedPlatformDBValue(a));
		
//		System.out.println(getDispPlatform(getCombinedPlatformDBValue(a)));
		
		List<Integer> list = Lists.newArrayList(1,2,3,4,5);
		for(Iterator<Integer> inte = list.iterator();inte.hasNext();){
			Integer aaa = inte.next();
			if(aaa == 1){
				inte.remove();
			}
		}
		
		for(Integer intea : list){
			if(intea == 2){
				list.remove(intea);
			}
		}
	}
}