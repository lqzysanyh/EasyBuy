package cn.easybuy.web.pre;

import cn.easybuy.entity.*;
import cn.easybuy.service.order.CartService;
import cn.easybuy.service.order.CartServiceImpl;
import cn.easybuy.service.order.OrderService;
import cn.easybuy.service.order.OrderServiceImpl;
import cn.easybuy.service.product.CategoryService;
import cn.easybuy.service.product.CategoryServiceImpl;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.service.user.AddressService;
import cn.easybuy.service.user.AddressServiceImpl;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.Constants;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.CategoryVo;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.utils.ShoppingCartItem;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ���ﳵ��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/Cart"}, name = "Cart")
public class CartServlet extends AbstractServlet {
	
	//��Ʒ����
    private ProductService productService;
    //��������
    private OrderService orderService;
    //�û�����
    private UserService userService;
    //�������
    private CategoryService categoryService;
    //���ﳵ����
    private CartService cartService;
    //��ַ����
    private AddressService addressService;
    //��ǰ�û�
    private User user;

    public void init() throws ServletException {
        productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
        categoryService = new CategoryServiceImpl();
        cartService = new CartServiceImpl();
        addressService = new AddressServiceImpl();
        
    }

    @Override
    public Class getServletClass() {
        return CartServlet.class;
    }

    /**
     * ��ӵ����ﳵ 
     * @return
     */
    public ReturnResult add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        ReturnResult result = new ReturnResult();
        String id = request.getParameter("entityId");
        String quantityStr = request.getParameter("quantity");
        Integer quantity = 1;
        if (!EmptyUtils.isEmpty(quantityStr))
            quantity = Integer.parseInt(quantityStr);
        //��ѯ����Ʒ
        Product product = productService.getProductById(Integer.valueOf(id));
        if(product.getStock()<quantity){
        	return result.returnFail("��Ʒ��������");
        }
        //��ȡ���ﳵ
        ShoppingCart cart = getCartFromSession(request);
        //�����ﳵ������Ʒ
        result=cart.addItem(product, quantity);
        if(result.getStatus()==Constants.ReturnResult.SUCCESS){
        	cart.setSum((EmptyUtils.isEmpty(cart.getSum()) ? 0.0 : cart.getSum()) + (product.getPrice() * quantity * 1.0));
        }
        return result;
    }
    
    

    /**
     * ˢ�¹��ﳵ 
     * @param request
     * @param response
     * @return
     */
    public String refreshCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
    	ShoppingCart cart = getCartFromSession(request);
        cart = cartService.calculate(cart);
        application.setAttribute(getUserFromSession(request).getUserName(), cart);//ȫ������Ʒ
        return "/common/pre/searchBar";
    }

    /**
     * ��������ҳ�� 
     * @param request
     * @param response
     * @return
     */
    public String toSettlement(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CategoryVo> categoryVoList = categoryService.queryAllCategoryList();
        //��װ����
        request.setAttribute("categoryVoList", categoryVoList);
        return "/pre/settlement/toSettlement";
    }

    /**
     * ��ת�����ﳵҳ�� 
     * @param request
     * @param response
     * @return
     */
    public String settlement1(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ShoppingCart cart = getCartFromSession(request);
    	cart = cartService.calculate(cart);
    	request.getServletContext().setAttribute(getUserFromSession(request).getUserName(),cart);
    	return "/pre/settlement/settlement1";
    }

    /**
     * ��õ�ַ
     * @param request
     * @param response
     * @return
     */
    public String settlement2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = getUserFromSession(request);
        List<Address> addressList = addressService.queryAdressList(user.getId());
        request.setAttribute("addressList", addressList);
        return "/pre/settlement/settlement2";
    }

    /**
     * ���ɶ��� 
     * @param request
     * @param response
     * @return
     */
    public Object settlement3(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ShoppingCart cart = getCartFromSession(request);
        cart = cartService.calculate(cart);
        User user = getUserFromSession(request);
        ReturnResult result=checkCart(request);
        if(result.getStatus()==Constants.ReturnResult.FAIL){
        	return result;
        }
        //������ַ
        String addressId=request.getParameter("addressId");
        String newAddress=request.getParameter("newAddress");
        String newRemark=request.getParameter("newRemark");
        Address address=new Address();
        if(addressId.equals("-1")){
        	address.setRemark(newRemark);
        	address.setAddress(newAddress);
        	address.setId(addressService.addAddress(user.getId(),newAddress,newRemark));
        }else{
        	address=addressService.getAddressById(Integer.parseInt(addressId));
        }
        
        //���ɶ���
        Order order = orderService.payShoppingCart(cart,user,address.getAddress());
        clearCart(request, response);
        request.setAttribute("currentOrder", order);
        return "/pre/settlement/settlement3";
    }

    /**
     * ��չ��ﳵ 
     * @param request
     * @param response
     */
    public ReturnResult clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReturnResult result = new ReturnResult();
        //���˺���չ��ﳵ
        request.getServletContext().removeAttribute(getUserFromSession(request).getUserName());
        result.returnSuccess(null);
        return result;
    }

    /**
     * �޸Ĺ��ﳵ��Ϣ 
     * @param request
     * @return
     */
    public ReturnResult modCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	ReturnResult result = new ReturnResult();
    	ServletContext application = request.getServletContext();
        String id = request.getParameter("entityId");
        String quantityStr = request.getParameter("quantity");
        ShoppingCart cart = getCartFromSession(request);
    	Product product=productService.getProductById(Integer.valueOf(id));
    	if(EmptyUtils.isNotEmpty(quantityStr)){
    		if(Integer.parseInt(quantityStr)>product.getStock()){
    			return result.returnFail("��Ʒ��������");
        	}
    	}
        cart = cartService.modifyShoppingCart(id, quantityStr, cart);
        application.setAttribute(getUserFromSession(request).getUserName(), cart);//ȫ������Ʒ
        return result.returnSuccess();
    }

    /**
     * ��session�л�ȡ���ﳵ 
     * @param request
     * @return
     */
    private ShoppingCart getCartFromSession(HttpServletRequest request) throws Exception {
    	ServletContext application = request.getServletContext();
        ShoppingCart cart = (ShoppingCart) application.getAttribute(getUserFromSession(request).getUserName());
        if (cart == null) {
            cart = new ShoppingCart();
            application.setAttribute(getUserFromSession(request).getUserName(), cart);
        }
        return cart;
    }
    /**
     * ��鹺�ﳵ
     * @param request
     * @return
     * @throws Exception
     */
    private ReturnResult checkCart(HttpServletRequest request) throws Exception {
    	ReturnResult result = new ReturnResult();
    	ShoppingCart cart = getCartFromSession(request);
    	cart = cartService.calculate(cart);
    	for (ShoppingCartItem item : cart.getItems()) {
           Product product=productService.getProductById(item.getProduct().getId());
           if(product.getStock()<item.getQuantity()){
        	   return result.returnFail(product.getName()+"��Ʒ��������");
           }
        }
    	return result.returnSuccess();
    }

    /**
     * �������¼���û�
     * @param request
     * @return
     */
    private User getUserFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        this.user = user;
        return user;
    }
}
