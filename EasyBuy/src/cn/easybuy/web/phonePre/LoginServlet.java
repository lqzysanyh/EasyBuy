package cn.easybuy.web.phonePre;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.miaodiyun.httpApiDemo.IndustrySMS;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.web.AbstractServlet;

/**
 * 登录响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PLogin"}, name = "PLogin")
public class LoginServlet extends AbstractServlet {
	
	
	
	//用户服务
    private UserService userService;

    //验证码
    private String checkNum;
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }
    
    /**
     * 发送验证码
     * @param request
     * @param response
     * @throws Exception
     */
    public void sendCheckNum(HttpServletRequest request,HttpServletResponse response)throws Exception{
    	request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String phoneNum = request.getParameter("phone");
		String chechNum = (int)(Math.random()*1000000)+"";
		this.checkNum = chechNum;
		// 验证码通知短信接口
		IndustrySMS.setTo(phoneNum);
		IndustrySMS.setCheckNum(chechNum);
		//调用内容
		IndustrySMS.aa();
		if(IndustrySMS.execute()==1){
			//userService.addUserByPhone(phoneNum, chechNum);
			out.print("{\"result\":1}");
		}else{
			out.print("{\"result\":0}");
		}
		
		out.flush();
		out.close();
    }
    
    /**
     * 返回手机登录页面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String toPhoneLogin(HttpServletRequest request,HttpServletResponse response)throws Exception{
    	return "phone/user/phoneLogin";
    }
    
    public ReturnResult phoneLogin(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        System.out.println("进来了");
        //参数获取
        String phone=request.getParameter("phone");
        String checkNum=request.getParameter("checkNum");
        
        if(!(this.checkNum.equals(checkNum))){
        	result.returnFail("验证码输入错误");
        }
        //添加用户成功
        User user = userService.findByPhone(phone);
        if(EmptyUtils.isEmpty(user)){
        	boolean addSuccess = userService.addUserByPhone(phone, checkNum);
        	user = userService.findByPhone(phone);
        }
        if(EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在");
        }else{
               //登陆成功
               request.getSession().setAttribute("loginUser", user);
               result.returnSuccess("登陆成功");
        }
        System.out.println("出去了");

        return result;
    }
    
    /**
     * 返回登录界面
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String toLogin(HttpServletRequest request,HttpServletResponse response)throws Exception{
        return "/phone/user/login";
    }
    
    /**
     * 登录方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult login(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        //参数获取
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=userService.getUser(null, loginName);
        if(EmptyUtils.isEmpty(user)){
            result.returnFail("用户不存在");
        }else{
           if(user.getPassword().equals(SecurityUtils.md5Hex(password))){
               //登陆成功
               request.getSession().setAttribute("loginUser", user);
               result.returnSuccess("登陆成功");
           }else{
               result.returnFail("密码错误");
           }
        }
        return result;
    }
    
    /**
     * 注销方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String loginOut(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        try {
            //User user=(User)request.getSession().getAttribute("loginUser");
            request.getSession().removeAttribute("loginUser");
            // 清除购物车
            request.getSession().removeAttribute("cart");
            request.getSession().removeAttribute("cart2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.returnSuccess("注销成功");
        return "/phone/user/login";
    }
    
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }
}
