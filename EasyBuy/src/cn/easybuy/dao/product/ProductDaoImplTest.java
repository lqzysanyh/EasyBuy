package cn.easybuy.dao.product;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.easybuy.entity.Product;
import cn.easybuy.utils.DataSourceUtil;

public class ProductDaoImplTest {

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
	public void testGetProductList() throws Exception {
		ProductDao productDao = new ProductDaoImpl(DataSourceUtil.openConnection());
		List<Product> list = productDao.getProductList(1, 8,"ÏãÄÎ¶ù",548 , 2);
		for (Product product : list) {
			System.out.println(product.getId());
			System.out.println(product.getName());
			System.out.println(product.getFileName());
			System.out.println(product.getCategoryLevel1Id());
			System.out.println(product.getCategoryLevel2Id());
			System.out.println(product.getCategoryLevel3Id());
			System.out.println(product.getPrice());
			System.out.println(product.getStock());
			System.out.println(product.getDescription());
		}
	}

}
