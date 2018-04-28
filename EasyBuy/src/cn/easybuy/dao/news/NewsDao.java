package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

/**
 * 资讯Dao接口
 * @author Administrator
 *
 */
public interface NewsDao extends BaseDao{
	/**
	 * 添加资讯
	 * @param news
	 * @throws Exception
	 */
	public void save(News news) throws Exception;
	/**
	 * 更新资讯
	 * @param news
	 * @throws Exception
	 */
	public void update(News news) throws Exception;
	/**
	 * 根据Id删除资讯
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;
	/**
	 * 根据Id查询资讯
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News getNewsById(Integer id)throws Exception; 
	/**
	 * 根据参数查询资讯
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<News> queryNewsList(NewsParams params)throws Exception; 
	/**
	 * 根据参数查询资讯次数
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryNewsCount(NewsParams params)throws Exception; 

}
