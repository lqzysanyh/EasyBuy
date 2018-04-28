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
 * ��¼��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PLogin"}, name = "PLogin")
public class LoginServlet extends AbstractServlet {
	
	
	
	//�û�����
    private UserService userService;

    //��֤��
    private String checkNum;
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }
    
    /**
     * ������֤��
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
		// ��֤��֪ͨ���Žӿ�
		IndustrySMS.setTo(phoneNum);
		IndustrySMS.setCheckNum(chechNum);
		//��������
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
     * �����ֻ���¼ҳ��
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
        System.out.println("������");
        //������ȡ
        String phone=request.getParameter("phone");
        String checkNum=request.getParameter("checkNum");
        
        if(!(this.checkNum.equals(checkNum))){
        	result.returnFail("��֤���������");
        }
        //����û��ɹ�
        User user = userService.findByPhone(phone);
        if(EmptyUtils.isEmpty(user)){
        	boolean addSuccess = userService.addUserByPhone(phone, checkNum);
        	user = userService.findByPhone(phone);
        }
        if(EmptyUtils.isEmpty(user)){
            result.returnFail("�û�������");
        }else{
               //��½�ɹ�
               request.getSession().setAttribute("loginUser", user);
               result.returnSuccess("��½�ɹ�");
        }
        System.out.println("��ȥ��");

        return result;
    }
    
    /**
     * ���ص�¼����
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String toLogin(HttpServletRequest request,HttpServletResponse response)throws Exception{
        return "/phone/user/login";
    }
    
    /**
     * ��¼����
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult login(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        //������ȡ
        String loginName=request.getParameter("loginName");
        String password=request.getParameter("password");
        User user=userService.getUser(null, loginName);
        if(EmptyUtils.isEmpty(user)){
            result.returnFail("�û�������");
        }else{
           if(user.getPassword().equals(SecurityUtils.md5Hex(password))){
               //��½�ɹ�
               request.getSession().setAttribute("loginUser", user);
               result.returnSuccess("��½�ɹ�");
           }else{
               result.returnFail("�������");
           }
        }
        return result;
    }
    
    /**
     * ע������
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
            // ������ﳵ
            request.getSession().removeAttribute("cart");
            request.getSession().removeAttribute("cart2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.returnSuccess("ע���ɹ�");
        return "/phone/user/login";
    }
    
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }
}
