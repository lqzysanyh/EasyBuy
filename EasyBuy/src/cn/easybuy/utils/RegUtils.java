package cn.easybuy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式验证类
 * @author Administrator
 *
 */
public class RegUtils {

	static String emailReg="^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
	static String mobileReg="^\\d{5,11}$";
	static String identityCodeReg="^\\w{18}$";
	
	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean checkEmail(String email){
		Pattern pattern=Pattern.compile(emailReg);
		Matcher matcher=pattern.matcher(email);
		System.out.println(matcher.matches());
		return matcher.matches();
	}
	/**
	 * 验证手机号
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile){
		Pattern pattern=Pattern.compile(mobileReg);
		Matcher matcher=pattern.matcher(mobile);
		System.out.println(matcher.matches());
		return matcher.matches();
	}
	/**
	 * 验证身份证号码
	 * @param identityCode
	 * @return
	 */
	public static boolean checkIdentityCodeReg(String identityCode){
		Pattern pattern=Pattern.compile(identityCodeReg);
		Matcher matcher=pattern.matcher(identityCode);
		System.out.println(matcher.matches());
		return matcher.matches();
	}
}
