package cn.easybuy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.Constants;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.RegUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.SecurityUtils;
import cn.easybuy.web.AbstractServlet;

/**
 * ע����Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/Register"}, name = "Register")
public class RegisterServlet extends AbstractServlet {
	
	//�û�����
	private UserService userService;
	
	@Override
    public void init() throws ServletException {
        userService = new UserServiceImpl();
    }
	
	/**
     * ����ע��ҳ��
     * @param request
     * @param response
     * @return
     */
    public String toRegister(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return "/pre/register";
    }
    
    /**
     * �����û�
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult saveUserToDatabase(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReturnResult result = new ReturnResult();
        try {
            User user = new User();
            String loginName = request.getParameter("loginName");
            String sex = request.getParameter("sex");
            User oldUser = userService.getUser(null, loginName);
            //�ж��û�
            if (EmptyUtils.isNotEmpty(oldUser)) {
                result.returnFail("�û��Ѿ�����");
                return result;
            }
            user.setLoginName(request.getParameter("loginName"));
            user.setUserName(request.getParameter("userName"));
            user.setSex(EmptyUtils.isEmpty(sex) ? 1 : 0);
            user.setPassword(SecurityUtils.md5Hex(request.getParameter("password")));
            user.setIdentityCode(request.getParameter("identityCode"));
            user.setEmail(request.getParameter("email"));
            user.setMobile(request.getParameter("mobile"));
            user.setType(Constants.UserType.PRE);
            result=checkUser(user);
            //�Ƿ���֤ͨ��
            if(result.getStatus()==Constants.ReturnResult.SUCCESS){
            	 if(!userService.add(user)){
                	 return result.returnFail("ע��ʧ�ܣ�");
                 }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        result.returnSuccess("ע��ɹ�");
        return result;
    }
    
    
	/**
	 * ����û�����
	 * @param user
	 * @return
	 */
	private ReturnResult checkUser(User user) {
		ReturnResult result = new ReturnResult();
    	boolean flag=true;
    	if(EmptyUtils.isNotEmpty(user.getMobile())){
    		if(!RegUtils.checkMobile(user.getMobile())){
    			return result.returnFail("�ֻ���ʽ����ȷ");
    		}
    	}
    	
    	if(EmptyUtils.isNotEmpty(user.getIdentityCode())){
    		if(!RegUtils.checkIdentityCodeReg(user.getIdentityCode())){
    			return result.returnFail("���֤���벻��ȷ");
    		}
    	}
    	
    	if(EmptyUtils.isNotEmpty(user.getEmail())){
    		if(!RegUtils.checkEmail(user.getEmail())){
    			return result.returnFail("�����ʽ����ȷ");
    		}
    	}
    	return result.returnSuccess();
	}

	@Override
	public Class getServletClass() {
		return RegisterServlet.class;
	}

}
