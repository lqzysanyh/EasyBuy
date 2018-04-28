package com.miaodiyun.httpApiDemo;

import java.util.Random;

public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// 获取开发者账号信息
		// AccountInfo.execute();

		String chechNum = (int)(Math.random()*1000000)+"";
		// 验证码通知短信接口
		IndustrySMS.setTo("17673492473");
		IndustrySMS.setCheckNum(chechNum);
		IndustrySMS.aa();
		IndustrySMS.execute();
		
		System.out.println(chechNum);
		// 会员营销短信接口
		// AffMarkSMS.execute();

		// 语音验证码
		// VoiceCode.execute();

	}
}
