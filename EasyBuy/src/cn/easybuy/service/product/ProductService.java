package cn.easybuy.service.product;

import java.util.List;

import cn.easybuy.entity.Product;

/**
 * ��Ʒ�����ӿ�
 * @author Administrator
 *
 */
public interface ProductService {
	/**
	 * �����Ʒ
	 * @param product
	 * @return
	 */
	public boolean add(Product product);
	/**
	 * ������Ʒ
	 * @param product
	 * @return
	 */
	public boolean update(Product product);
	/**
	 * ɾ����Ʒ
	 * @param productId
	 * @return
	 */
	public boolean deleteProductById(Integer productId);
	/**
	 * �����Ʒ
	 * @param productId
	 * @return
	 */
	public Product getProductById(Integer productId);
	/**
	 * ������ʼId,ҳ���С,��Ʒ����,����Id,��׼�����Ʒ��
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
	 * ������Ʒ��,����Id,��׼�����Ʒ��
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 */
	public int count(String proName,Integer categoryId,Integer level);
	/**
	 * ������Ʒ���
	 * @param productId
	 * @param stock
	 * @return
	 */
	public boolean updateStock(Integer productId,Integer stock);
}
