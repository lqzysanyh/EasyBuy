package cn.easybuy.web.phonePre;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.entity.Category;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.service.product.CategoryService;
import cn.easybuy.service.product.CategoryServiceImpl;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.CategoryVo;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

/**
 * ��ҳ��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PHome"}, name = "PHome")
public class HomeServlet extends AbstractServlet{
	//��Ʒ����
    private ProductService productService;
    //��Ѷ����
    private NewsService newsService;
    //�������
    private CategoryService categoryService;
    
    
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
		newsService = new NewsServiceImpl();
		categoryService = new CategoryServiceImpl();
	}
	
	/**
	 * �����ҵ���ҳ
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String user(HttpServletRequest request, HttpServletResponse response)throws Exception {
		if(EmptyUtils.isEmpty(request.getSession().getAttribute("loginUser"))){
			return "/phone/user/login";
		}else{			
			return "/phone/my";
		}
	}

	
	/**
	 * ������ҳ
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String index(HttpServletRequest request, HttpServletResponse response)throws Exception {
        //��ѯ��Ʒ����
        List<CategoryVo> categoryVoList = categoryService.queryAllCategoryList();

        List<Product> list = productService.getProductList(1, 10, null, null, 1);
        
        
        List<News> news = newsService.getAllNews(new Pager(5, 5, 1));
        //��ѯһ��
        for (CategoryVo vo : categoryVoList) {
            List<Product> productList = productService.getProductList(1, 8, null, vo.getCategory().getId(), 1);
            //List<Product> productList = productService.getProductList(currentPageNo, pageSize, proName, categoryId, level)
            vo.setProductList(productList);
        }
        //��װ����
        request.getSession().setAttribute("categoryVoList", categoryVoList);
        request.setAttribute("news", news);
        request.setAttribute("list", list);
        return "/phone/home/index";
    }

	
	@Override
	public Class getServletClass() {
		return HomeServlet.class;
	}

}
