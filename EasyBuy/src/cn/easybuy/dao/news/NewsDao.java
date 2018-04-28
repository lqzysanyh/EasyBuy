package cn.easybuy.dao.news;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;

/**
 * ��ѶDao�ӿ�
 * @author Administrator
 *
 */
public interface NewsDao extends BaseDao{
	/**
	 * �����Ѷ
	 * @param news
	 * @throws Exception
	 */
	public void save(News news) throws Exception;
	/**
	 * ������Ѷ
	 * @param news
	 * @throws Exception
	 */
	public void update(News news) throws Exception;
	/**
	 * ����Idɾ����Ѷ
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(Integer id) throws Exception;
	/**
	 * ����Id��ѯ��Ѷ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public News getNewsById(Integer id)throws Exception; 
	/**
	 * ���ݲ�����ѯ��Ѷ
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<News> queryNewsList(NewsParams params)throws Exception; 
	/**
	 * ���ݲ�����ѯ��Ѷ����
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryNewsCount(NewsParams params)throws Exception; 

}
