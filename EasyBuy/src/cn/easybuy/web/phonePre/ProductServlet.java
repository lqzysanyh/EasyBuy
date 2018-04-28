package cn.easybuy.web.phonePre;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.easybuy.entity.Product;
import cn.easybuy.service.product.CategoryService;
import cn.easybuy.service.product.CategoryServiceImpl;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.CategoryVo;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;
import cn.easybuy.web.AbstractServlet;

/**
 * ��Ʒ��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PProduct"}, name = "PProduct")
public class ProductServlet extends AbstractServlet{
	 //��Ʒ����
	 private ProductService productService;
	 //��Ʒ�������
	 private CategoryService categoryService;
	 
	 
	 
	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImpl();
		categoryService = new CategoryServiceImpl();
	}
	
	/**
	 * ��ȡ��Ʒ�б�
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String queryProductList(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String category = request.getParameter("category");
        String levelStr = request.getParameter("level");
        String currentPageStr = request.getParameter("currentPage");
        String keyWord = request.getParameter("keyWord");
        //��ȡҳ��С
        String pageSizeStr = request.getParameter("pageSize");
		int rowPerPage = EmptyUtils.isEmpty(pageSizeStr)?6:Integer.valueOf(pageSizeStr);
		int currentPage = EmptyUtils.isEmpty(currentPageStr) ? 1 : Integer.parseInt(currentPageStr);
		int  level=EmptyUtils.isNotEmpty(levelStr)?Integer.parseInt(levelStr):0;
        int total = productService.count(keyWord, EmptyUtils.isEmpty(category)?null:Integer.valueOf(category), level);
		//ʵ������ҳ��
        Pager pager = new Pager(total, rowPerPage, currentPage);
        pager.setUrl("/PProduct?action=queryProductList&level="+level+"&category="+(EmptyUtils.isEmpty(category)?"":category));
        if(EmptyUtils.isNotEmpty(keyWord)){
        	pager.setUrl(pager.getUrl()+"&keyWord="+keyWord);
        }
        List<CategoryVo> categoryVoList = categoryService.queryAllCategoryList();
        List<Product> productList = productService.getProductList(currentPage, rowPerPage, keyWord, EmptyUtils.isEmpty(category)?null:Integer.valueOf(category), level);
        request.setAttribute("productList", productList);
        request.setAttribute("pager", pager);
        request.setAttribute("total", total);
        request.setAttribute("keyWord", keyWord);
        request.setAttribute("categoryVoList", categoryVoList);
        return "/phone/product/queryProductList";
	}
	
	/**
	 * ��Ʒ����
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
   public String queryProductDeatil(HttpServletRequest request, HttpServletResponse response) throws Exception{
       String id = request.getParameter("id");
       Product product = productService.getProductById(Integer.valueOf(id));
       List<Product> productList = productService.getProductList(1, 6, null, product.getCategoryLevel1Id(), 1);
       List<CategoryVo> categoryVoList = categoryService.queryAllCategoryList();
       request.setAttribute("product", product);
       request.setAttribute("productList", productList);
       request.setAttribute("categoryVoList", categoryVoList);
       addRecentProduct(request,product);
       return "/phone/product/deatil";
   }
   
   /**
    * ��ѯ�����Ʒ
    * @param request
    * @return
    * @throws Exception
    */
   private List<Product> queryRecentProducts(HttpServletRequest request)throws Exception{
       HttpSession session=request.getSession();
       List<Product> recentProducts= (List<Product>) session.getAttribute("recentProducts");
       if(EmptyUtils.isEmpty(recentProducts)){
           recentProducts=new ArrayList<Product>();
       }
       return recentProducts;
   }
   
   /**
    * �����������Ʒ
    * @param request
    * @param product
    * @throws Exception
    */
   private void addRecentProduct(HttpServletRequest request,Product product)throws Exception{
       HttpSession session=request.getSession();
       List<Product> recentProducts=queryRecentProducts(request);
       //�ж��Ƿ�����
       if(recentProducts.size()>0 &&  recentProducts.size()==10){
         recentProducts.remove(0);
       }
       recentProducts.add(recentProducts.size(),product);
       session.setAttribute("recentProducts",recentProducts);
   }

   

	@Override
	public Class getServletClass() {
		return ProductServlet.class;
	}

}
