package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.ProductParam;

/**
 * 商品表Dao接口
 * @author Administrator
 *
 */
public interface ProductDao extends BaseDao {
	/**
	 * 更新商品库存
	 * @param id
	 * @param quantity
	 * @return
	 * @throws Exception
	 */
	public Integer updateStock(Integer id, Integer quantity) throws Exception;
	/**
	 * 添加商品
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public Integer add(Product product) throws Exception;
	/**
	 * 更新商品
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public Integer update(Product product) throws Exception;
	/**
	 * 根据Id删除商品
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteProductById(Integer id) throws Exception;
	/**
	 * 根据Id获得商品
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Product getProductById(Integer id)throws Exception;
	/**
	 * 根据起始Id,页面大小,商品名称,分类Id,标准获取商品集
	 * @param currentPageNo
	 * @param pageSize
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,String proName,Integer categoryId,Integer level)throws Exception;
	/**
	 * 根据商品名称,分类Id,标准获取商品数
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public Integer queryProductCount(String proName,Integer categoryId,Integer level)throws Exception;
}
