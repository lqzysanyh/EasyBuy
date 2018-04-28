package cn.easybuy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@WebServlet(urlPatterns = {"/Login"}, name = "Login")
public class LoginServlet extends AbstractServlet {

	//�û�����
    private UserService userService;

    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }
    
    /**
     * ���ص�¼����
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public String toLogin(HttpServletRequest request,HttpServletResponse response)throws Exception{
        return "/pre/login";
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
            User user=(User)request.getSession().getAttribute("loginUser");
            request.getSession().removeAttribute("loginUser");
            // ������ﳵ
            request.getSession().removeAttribute("cart");
            request.getSession().removeAttribute("cart2");
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.returnSuccess("ע���ɹ�");
        return "/pre/login";
    }
    
    @Override
    public Class getServletClass() {
        return LoginServlet.class;
    }
}
