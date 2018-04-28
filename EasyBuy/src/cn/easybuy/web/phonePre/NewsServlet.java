package cn.easybuy.web.phonePre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.service.news.NewsService;
import cn.easybuy.service.news.NewsServiceImpl;
import cn.easybuy.web.AbstractServlet;

/**
 * ��Ѷ��Ӧ��
 * @author Administrator
 *
 */
@WebServlet(urlPatterns={"/PNews"},name="PNews")
public class NewsServlet extends AbstractServlet {
	
	//��Ѷ����
	private NewsService newsService;
	
	public void init() throws ServletException {
        newsService = new NewsServiceImpl();
    }
	
	
	@Override
	public Class getServletClass() {
		return NewsServlet.class;
	}
	
	/**
	 * ��Ѷҳ��
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
    public String index(HttpServletRequest request, HttpServletResponse response)throws Exception{
        return "/phone/newsList";
    }
}
