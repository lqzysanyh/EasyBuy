package cn.easybuy.service.news;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.easybuy.entity.News;
import cn.easybuy.param.NewsParams;
import cn.easybuy.utils.Pager;
import cn.easybuy.utils.Params;

public class NewsServiceImplTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindNewsById() {
		NewsService newsService  = new NewsServiceImpl();
		News news = newsService.findNewsById("531");
		System.out.println(news.getTitle());
		System.out.println(news.getCreateTime());
		System.out.println(news.getContent());
		
	}

	@Test
	public void testGetAllNews() {
		Pager pager = new Pager(5, 5, 1);
		NewsService newsService  = new NewsServiceImpl();
		List<News> list = newsService.getAllNews(pager);
		for (News news : list) {
			System.out.println(news.getId());
			System.out.println(news.getTitle());
			System.out.println(news.getCreateTime());
			System.out.println(news.getContent());
		}
	}

	@Test
	public void testQueryNewsPageList() throws SQLException {
		NewsParams params = new NewsParams();
		NewsService newsService  = new NewsServiceImpl();
		List<News> list = newsService.queryNewsList(params);
	}

	@Test
	public void testQueryNewsList() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryNewsCount() {
		fail("Not yet implemented");
	}

}
