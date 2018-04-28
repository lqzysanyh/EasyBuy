package cn.easybuy.web.phonePre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import cn.easybuy.entity.Product;
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
import cn.easybuy.utils.MemcachedUtils;

/**
 * 其他响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/POther"}, name = "POther")
public class OtherServlet extends HttpServlet {

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
    Map<String, Object> map = new HashMap<String, Object>();
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
        orderService = new OrderServiceImpl();
        userService = new UserServiceImpl();
        categoryService = new CategoryServiceImpl();
        cartService = new CartServiceImpl();
        addressService = new AddressServiceImpl();
        map.put("productList", productService.getProductList(1, 10000, null, null, null));
        //MemcachedUtils.add("productList", productService.getProductList(1, 10000, null, null, null));
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		String count = request.getParameter("count");
		
		List<Product> list = (List<Product>)map.get("productList");
		int dataBaseSize = productService.count(null, null, null);
		int index = Integer.valueOf(count);//起始位置
		if(index>=dataBaseSize){
			return ;
		}else{
			int size = list.size();
			if(dataBaseSize>size){//如果数据库的数量有变化则再查询
				map.put("productList", productService.getProductList(1, 10000, null, null, null));
			}
			List<Product> list2 = null;
			if(index==size){
				
			}else if(index+10>size){//如果到了最后一页,只获取所剩的
				list2 = list.subList(index,size);
			}else {			
				list2 = list.subList(index,index+10);
			}
			String json = JSON.toJSONString(list2);
			
			out.print(json);
		
		}
		
		out.flush();
		out.close();
	}
	
	@Test
	public void test(){
		productService = new ProductServiceImpl();
		//int index = Integer.valueOf("10")+1;
		List<Product> list = productService.getProductList(2, 10, null, null, 1);
		String json = JSON.toJSONString(list);
		System.out.println(json);
		
		
	}

}
