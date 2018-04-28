package cn.easybuy.service.news;

import java.sql.SQLException;
import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.Pager;

/**
 * 咨询服务层接口
 * @author Administrator
 *
 */
public interface NewsService {
	/**
	 * 保存新闻
	 * @param news
	 */
	void saveNews(News news);//保存新闻
	/**
	 * 根据id查询新闻
	 * @param parameter
	 * @return
	 */
	News findNewsById(String id);//根据ID获取新闻
	/**
	 * 查询所有的新闻
	 * @param pager
	 * @return
	 */
	List<News> getAllNews(Pager pager);//获取当页新闻
	/***
	 * 删除新闻
	 * @param parameter
	 */
	void deleteNews(String id);//删除新闻
	/***
	 * 查询新闻列表
	 * @param param
	 * @return
	 */
	List<News> queryNewsList(NewsParams param) throws SQLException;
	/***
	 * 查询数目
	 * @param param
	 * @return
	 */
	Integer queryNewsCount(NewsParams param);
}
