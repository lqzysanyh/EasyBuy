package cn.easybuy.web.pre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.service.user.AddressService;
import cn.easybuy.service.user.AddressServiceImpl;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

/**
 * �ջ���ַ��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/Address"}, name = "Address")
public class AddressServlet extends AbstractServlet {
	//��ַ����
	private AddressService addressService;
	
	
	
	@Override
	public void init() throws ServletException {
		addressService = new AddressServiceImpl();
	}

	@Override
	public Class getServletClass() {
		return AddressServlet.class;
	}

}
