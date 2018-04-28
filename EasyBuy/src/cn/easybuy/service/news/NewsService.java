package cn.easybuy.service.news;

import java.sql.SQLException;
import java.util.List;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.Pager;

/**
 * ��ѯ�����ӿ�
 * @author Administrator
 *
 */
public interface NewsService {
	/**
	 * ��������
	 * @param news
	 */
	void saveNews(News news);//��������
	/**
	 * ����id��ѯ����
	 * @param parameter
	 * @return
	 */
	News findNewsById(String id);//����ID��ȡ����
	/**
	 * ��ѯ���е�����
	 * @param pager
	 * @return
	 */
	List<News> getAllNews(Pager pager);//��ȡ��ҳ����
	/***
	 * ɾ������
	 * @param parameter
	 */
	void deleteNews(String id);//ɾ������
	/***
	 * ��ѯ�����б�
	 * @param param
	 * @return
	 */
	List<News> queryNewsList(NewsParams param) throws SQLException;
	/***
	 * ��ѯ��Ŀ
	 * @param param
	 * @return
	 */
	Integer queryNewsCount(NewsParams param);
}
