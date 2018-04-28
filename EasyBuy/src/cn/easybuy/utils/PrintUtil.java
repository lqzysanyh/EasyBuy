package cn.easybuy.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * 打印工具类
 * @author Administrator
 *
 */
public class PrintUtil {
	
	
	/**
	 * 打印方法
	 * @param msg
	 * @param response
	 */
	private static void print(String msg,HttpServletResponse response){
        PrintWriter writer=null;
		try {
            if(null != response){
                writer=response.getWriter();
                writer.print(msg);
                writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
            writer.close();
        }
    }
	/**
	 * 写入方法
	 * @param obj
	 * @param response
	 */
	public static void write(Object obj,HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
		String json = JSONObject.toJSONString(obj);
		print(json,response);
	}
}
