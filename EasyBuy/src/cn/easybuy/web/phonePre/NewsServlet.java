package cn.easybuy.web.phonePre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * 资讯响应类
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={"/PNews"},name="PNews")
public class NewsServlet extends AbstractServlet {
	
	//资讯服务
	private NewsService newsService;
	
	public void init() throws ServletException {
        newsService = new NewsServiceImpl();
    }
	
	
	@Override
	public Class getServletClass() {
		return NewsServlet.class;
	}
	
	/**
	 * 资讯页面
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "/phone/newsList";
    }
}
