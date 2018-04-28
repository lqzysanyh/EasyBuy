package com.miaodiyun.httpApiDemo;

import java.net.URLEncoder;

import javax.json.Json;

import com.alibaba.fastjson.JSON;
import com.miaodiyun.httpApiDemo.common.Config;
import com.miaodiyun.httpApiDemo.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	private static String to = "15173042592";
	private static String checkNum;
	private static String smsContent;

	
	
	public static String getTo() {
		return to;
	}

	public static void setTo(String to) {
		IndustrySMS.to = to;
	}

	public static String getCheckNum() {
		return checkNum;
	}

	public static void setCheckNum(String checkNum) {
		IndustrySMS.checkNum = checkNum;
	}

	public static void aa(){
		smsContent = "【楚游网】欢迎您注册楚游网，您的验证码为"+checkNum+"，验证码即登录密码，请于3分钟内正确输入，如非本人操作，请忽略此短信。";
	}
	
	/**
	 * 验证码通知短信
	 */
	public static int execute()
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	    if(result.indexOf("成功")!=-1){
	    	return 1;
	    }else {
			return -1;
		}
	    
	}
}
