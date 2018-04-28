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
 * 购物车响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/Cart"}, name = "Cart")
public class CartServlet extends AbstractServlet {
	
	//商品服务
    private ProductService productService;
    //订单服务
    private OrderService orderService;
    //用户服务
    private UserService userService;
    //分类服务
    private CategoryService categoryService;
    //购物车服务
    private CartService cartService;
    //地址服务
    private AddressService addressService;
    //当前用户
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
     * 添加到购物车 
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
        //查询出商品
        Product product = productService.getProductById(Integer.valueOf(id));
        if(product.getStock()<quantity){
        	return result.returnFail("商品数量不足");
        }
        //获取购物车
        ShoppingCart cart = getCartFromSession(request);
        //往购物车放置商品
        result=cart.addItem(product, quantity);
        if(result.getStatus()==Constants.ReturnResult.SUCCESS){
        	cart.setSum((EmptyUtils.isEmpty(cart.getSum()) ? 0.0 : cart.getSum()) + (product.getPrice() * quantity * 1.0));
        }
        return result;
    }
    
    

    /**
     * 刷新购物车 
     * @param request
     * @param response
     * @return
     */
    public String refreshCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //HttpSession session = request.getSession();
        ServletContext application = request.getServletContext();
    	ShoppingCart cart = getCartFromSession(request);
        cart = cartService.calculate(cart);
        application.setAttribute(getUserFromSession(request).getUserName(), cart);//全部的商品
        return "/common/pre/searchBar";
    }

    /**
     * 跳到结算页面 
     * @param request
     * @param response
     * @return
     */
    public String toSettlement(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<CategoryVo> categoryVoList = categoryService.queryAllCategoryList();
        //封装返回
        request.setAttribute("categoryVoList", categoryVoList);
        return "/pre/settlement/toSettlement";
    }

    /**
     * 跳转到购物车页面 
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
     * 获得地址
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
     * 生成订单 
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
        //新增地址
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
        
        //生成订单
        Order order = orderService.payShoppingCart(cart,user,address.getAddress());
        clearCart(request, response);
        request.setAttribute("currentOrder", order);
        return "/pre/settlement/settlement3";
    }

    /**
     * 清空购物车 
     * @param request
     * @param response
     */
    public ReturnResult clearCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ReturnResult result = new ReturnResult();
        //结账后清空购物车
        request.getServletContext().removeAttribute(getUserFromSession(request).getUserName());
        result.returnSuccess(null);
        return result;
    }

    /**
     * 修改购物车信息 
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
    			return result.returnFail("商品数量不足");
        	}
    	}
        cart = cartService.modifyShoppingCart(id, quantityStr, cart);
        application.setAttribute(getUserFromSession(request).getUserName(), cart);//全部的商品
        return result.returnSuccess();
    }

    /**
     * 从session中获取购物车 
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
     * 检查购物车
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
        	   return result.returnFail(product.getName()+"商品数量不足");
           }
        }
    	return result.returnSuccess();
    }

    /**
     * 获得所登录的用户
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
