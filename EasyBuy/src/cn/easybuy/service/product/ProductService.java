package cn.easybuy.service.product;

import java.util.List;

import cn.easybuy.entity.Product;

/**
 * 商品服务层接口
 * @author Administrator
 *
 */
public interface ProductService {
	/**
	 * 添加商品
	 * @param product
	 * @return
	 */
	public boolean add(Product product);
	/**
	 * 更新商品
	 * @param product
	 * @return
	 */
	public boolean update(Product product);
	/**
	 * 删除商品
	 * @param productId
	 * @return
	 */
	public boolean deleteProductById(Integer productId);
	/**
	 * 获得商品
	 * @param productId
	 * @return
	 */
	public Product getProductById(Integer productId);
	/**
	 * 根据起始Id,页面大小,商品名称,分类Id,标准获得商品集
	 * @param currentPageNo
	 * @param pageSize
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 */
	public List<Product> getProductList(Integer currentPageNo,Integer pageSize,
										String proName,Integer categoryId,Integer level);
	/**
	 * 根据商品名,分类Id,标准获得商品数
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 */
	public int count(String proName,Integer categoryId,Integer level);
	/**
	 * 更新商品库存
	 * @param productId
	 * @param stock
	 * @return
	 */
	public boolean updateStock(Integer productId,Integer stock);
}
