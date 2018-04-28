package cn.easybuy.dao.product;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.ProductParam;

/**
 * ��Ʒ��Dao�ӿ�
 * @author Administrator
 *
 */
public interface ProductDao extends BaseDao {
	/**
	 * ������Ʒ���
	 * @param id
	 * @param quantity
	 * @return
	 * @throws Exception
	 */
	public Integer updateStock(Integer id, Integer quantity) throws Exception;
	/**
	 * �����Ʒ
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public Integer add(Product product) throws Exception;
	/**
	 * ������Ʒ
	 * @param product
	 * @return
	 * @throws Exception
	 */
	public Integer update(Product product) throws Exception;
	/**
	 * ����Idɾ����Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteProductById(Integer id) throws Exception;
	/**
	 * ����Id�����Ʒ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Product getProductById(Integer id)throws Exception;
	/**
	 * ������ʼId,ҳ���С,��Ʒ����,����Id,��׼��ȡ��Ʒ��
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
	 * ������Ʒ����,����Id,��׼��ȡ��Ʒ��
	 * @param proName
	 * @param categoryId
	 * @param level
	 * @return
	 * @throws Exception
	 */
	public Integer queryProductCount(String proName,Integer categoryId,Integer level)throws Exception;
}
