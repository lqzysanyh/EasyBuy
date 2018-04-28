package cn.easybuy.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

/**
 * ��ӡ������
 * @author Administrator
 *
 */
public class PrintUtil {
	
	
	/**
	 * ��ӡ����
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
	 * д�뷽��
	 * @param obj
	 * @param response
	 */
	public static void write(Object obj,HttpServletResponse response){
		response.setContentType("text/html; charset=utf-8");
		String json = JSONObject.toJSONString(obj);
		print(json,response);
	}
}
