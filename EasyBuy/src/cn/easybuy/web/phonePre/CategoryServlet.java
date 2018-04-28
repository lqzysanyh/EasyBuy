package cn.easybuy.web.phonePre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import cn.easybuy.service.product.ProductService;
import cn.easybuy.service.product.ProductServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * ������Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = {"/PCategory"},name = "PCategory")
public class CategoryServlet extends AbstractServlet {	

	//��Ʒ����
	private ProductService productService;

    public void init() throws ServletException {
        productService = new ProductServiceImpl();
    }

    @Override
    public Class getServletClass() {
        return CategoryServlet.class;
    }

}
