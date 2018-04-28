package cn.easybuy.web.phonePre;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.easybuy.entity.Address;
import cn.easybuy.entity.User;
import cn.easybuy.service.user.AddressService;
import cn.easybuy.service.user.AddressServiceImpl;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

/**
 * 收货地址响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PAddress"}, name = "PAddress")
public class AddressServlet extends AbstractServlet {
	//地址服务
	private AddressService addressService;
	
	
	@Override
	public void init() throws ServletException {
		addressService = new AddressServiceImpl();
	}
	
	/**
	 * 进入我的地址页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User)request.getSession().getAttribute("loginUser");
		List<Address> addressList = addressService.queryAdressList(user.getId());
		return "/phone/address/userAddress";
	}
	
	/**
	 * 添加
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ReturnResult add(HttpServletRequest request, HttpServletResponse response) throws Exception {
		User user = (User)request.getSession().getAttribute("loginUser");
		ReturnResult result = new ReturnResult();
        String address = request.getParameter("address");
        String remark = request.getParameter("remark");
        int addressId = addressService.addAddress(user.getId(), address, remark);
        Address addressHui = addressService.getAddressById(addressId);
        
        String addressJson = JSON.toJSONString(addressHui);
        
        if(addressHui!=null){        	
        	result.returnSuccess(null);
        }
        return result;
    }

	@Override
	public Class getServletClass() {
		return AddressServlet.class;
	}

}
