package cn.easybuy.web.phonePre;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.easybuy.entity.User;
import cn.easybuy.entity.Product;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.MemcachedUtils;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

/**
 * 收藏响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PFavorite"}, name = "PFavorite")
public class FavoriteServlet extends AbstractServlet {

	//商品服务
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
	}
	
	/**
     * 跳转到历史记录
     * @param request
     * @param response
     * @return
     */
    public String toFavoriteList(HttpServletRequest request, HttpServletResponse response)throws Exception {
        List<Product> recentProducts=queryFavoriteList(request);
        request.setAttribute("recentProducts",recentProducts);
        return "/phone/product/favoriteList";
    }

    /**
     * 添加到收藏
     * @return
     */
    public ReturnResult addFavorite(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ReturnResult result = new ReturnResult();
        String id = request.getParameter("id");
        Product product = productService.getProductById(Integer.valueOf(id));
        List<Product> favoriteList = queryFavoriteList(request);
        //判断是否满了
        if (favoriteList.size() > 0 && favoriteList.size() == 5) {
            favoriteList.remove(0);
        }
        boolean temp = false;
        for (int i = 0; i < favoriteList.size(); i++) {
            if (favoriteList.get(i).getId().equals(product.getId())) {
                temp = true;
                break;
            }
        }
        if (!temp) {
            favoriteList.add(favoriteList.size(), product);
        }
        MemcachedUtils.add(getFavoriteKey(request),favoriteList);
        result.returnSuccess();
        return result;
    }
	
	 /**
     * 查询最近商品
     * @return
     */
    private List<Product> queryFavoriteList(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        //判断用户是否登录
        String key = EmptyUtils.isEmpty(user) ? session.getId() : user.getLoginName();
        List<Product> recentProducts = (List<Product>) MemcachedUtils.get(key);
        if (EmptyUtils.isEmpty(recentProducts)) {
            recentProducts = new ArrayList<Product>();
        }
        return recentProducts;
    }
    /**
     * 获得收藏品
     * @param request
     * @return
     */
    private String getFavoriteKey(HttpServletRequest request)throws Exception{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("loginUser");
        return EmptyUtils.isEmpty(user) ? session.getId() : user.getLoginName();
    }
	

	@Override
	public Class getServletClass() {
		// TODO Auto-generated method stub
		return FavoriteServlet.class;
	}

}
