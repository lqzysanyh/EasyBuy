package cn.easybuy.web.backend;
import cn.easybuy.entity.Category;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.service.product.CategoryService;
import cn.easybuy.service.product.CategoryServiceImpl;
import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.utils.Constants;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;
import cn.easybuy.utils.ReturnResult;
import cn.easybuy.web.AbstractServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 * 后台分类响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = { "/admin/category" }, name = "adminCategory")
public class AdminCategoryServlet extends AbstractServlet{

    private CategoryService categoryService;
    
    private ProductService productService;

    public void init() throws ServletException {
        this.categoryService = new CategoryServiceImpl();
        this.productService=new ProductServiceImpl();
    }
    /**
     * 订单的主页面
     * @param request
     * @param response
     * @return
     */
    public String index(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //获取当前页数
        String currentPageStr = request.getParameter("currentPage");
        //获取页大小
        String pageSize = request.getParameter("pageSize");
        int rowPerPage  = EmptyUtils.isEmpty(pageSize)?8:Integer.parseInt(pageSize);
        int currentPage = EmptyUtils.isEmpty(currentPageStr)?1:Integer.parseInt(currentPageStr);
        CategoryParam params =new CategoryParam();
        int total=categoryService.queryCategoryCount(params);
        Pager pager=new Pager(total,rowPerPage,currentPage);
        params.openPage((pager.getCurrentPage()-1)*pager.getRowPerPage(),pager.getRowPerPage());
        pager.setUrl("/admin/category?action=index");
        List<Category> categoryList=categoryService.queryCategoryList(params);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("pager", pager);
        request.setAttribute("menu", 4);
        return "/backend/category/categoryList";
    }
    /**
     * 添加商品分类
     * @param request
     * @param response
     * @return
     */
    public String toAddCategory(HttpServletRequest request,HttpServletResponse response)throws Exception{
        //查询一级分类 全部
        List<Category> categoryList=null;
        CategoryParam params =new CategoryParam();
        params.setType(1);
        categoryList=categoryService.queryCategoryList(params);
        request.setAttribute("categoryList1",categoryList);
        request.setAttribute("category",new Category());
        return "/backend/category/toAddCategory";
    }
    /**
     * 修改商品分类
     * @param request
     * @param response
     * @return
     */
    public String toUpdateCategory(HttpServletRequest request,HttpServletResponse response)throws Exception{
        String id=request.getParameter("id");
        Category category= categoryService.getById(Integer.parseInt(id));
        List<Category> categoryList1=null;
        List<Category> categoryList2=null;
        List<Category> categoryList3=null;
        request.setAttribute("category",category);
        //判断分类级别
        if(category.getType()>=1){
        	CategoryParam params =new CategoryParam();
        	params.setType(1);
            categoryList1=categoryService.queryCategoryList(params);
        }
        if(category.getType()>=2){
        	CategoryParam params =new CategoryParam();
        	params.setType(2);
            categoryList2=categoryService.queryCategoryList(params);
            request.setAttribute("parentCategory",categoryService.getById(category.getParentId()));
        }
        if(category.getType()>=3){
            List<Category> categoryList=null;
            CategoryParam params =new CategoryParam();
            params.setType(3);
            categoryList3=categoryService.queryCategoryList(params);
        }
        request.setAttribute("categoryList1",categoryList1);
        request.setAttribute("categoryList2",categoryList2);
        request.setAttribute("categoryList3",categoryList3);
        return "/backend/category/toUpdateCategory";
    }

    @Test
    public void test(){
    	TreeSet<String> ts = new TreeSet<String>();
    	SortedSet<String> sortedSet = ts.headSet(ts.first());
    	
    	
    	
    }
    
    
    /**
     * 查询子分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult queryCategoryList(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        String parentId=request.getParameter("parentId");
        List<Category> productCategoryList=null;
        CategoryParam params =new CategoryParam();
        params.setParentId(EmptyUtils.isEmpty(parentId)?0:Integer.parseInt(parentId));
        productCategoryList=categoryService.queryCategoryList(params);
        result.setStatus(Constants.ReturnResult.SUCCESS);
        result.setData(productCategoryList);
        return result;
    }
    /**
     * 修改商品分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult modifyCategory(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        Integer parentId=0;
        String id=request.getParameter("id");
        String productCategoryLevel1=request.getParameter("productCategoryLevel1");
        String productCategoryLevel2=request.getParameter("productCategoryLevel2");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        if(type.equals("1")){
            parentId =0;
        }else if(type.equals("2")){
            parentId =Integer.parseInt(productCategoryLevel1);
        }else{
            parentId =Integer.parseInt(productCategoryLevel2);
        }
        Category category  =new Category();
        category.setId(Integer.parseInt(id));
        category.setParentId(parentId);
        category.setName(name);
        category.setType(Integer.parseInt(type));
        categoryService.modifyCategory(category);
        result.returnSuccess();
        return result;
    }
    /**
     * 添加商品分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult addCategory(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        Integer parentId=0;
        //获取分类级别
        String type=request.getParameter("type");
        String categoryLevel1=request.getParameter("categoryLevel1");
        String categoryLevel2=request.getParameter("categoryLevel2");
        String name=request.getParameter("name");
        if(type.equals("1")){
            parentId =0;
        }else if(type.equals("2")){
            parentId =Integer.parseInt(categoryLevel1);
        }else{
            parentId =Integer.parseInt(categoryLevel2);
        }
        Category category =new Category();
        category.setName(name);
        category.setParentId(parentId);
        category.setType(Integer.parseInt(type));
        category.setIconClass("");
        categoryService.addCategory(category);
        result.returnSuccess();
        return result;
    }
    /**
     * 删除商品分类
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ReturnResult deleteCategory(HttpServletRequest request,HttpServletResponse response)throws Exception{
        ReturnResult result=new ReturnResult();
        //获取分类id
        String id=request.getParameter("id");
        String type=request.getParameter("type");
        //查询是否有子类
        CategoryParam categoryParam=new CategoryParam();
        categoryParam.setParentId(Integer.parseInt(id));
        int count=categoryService.queryCategoryCount(categoryParam);
        if(count>0){
        	return result.returnFail("已经存在子分类，不能删除");
        }
        //查询是否有商品
        count=productService.count(null,Integer.parseInt(id),null);
        if(count>0){
        	return result.returnFail("已经存在商品，不能删除");
        }
        categoryService.deleteById(Integer.parseInt(id));
        result.returnSuccess();
        return result;
    }

    @Override
    public Class getServletClass() {
        return AdminCategoryServlet.class;
    }
}
