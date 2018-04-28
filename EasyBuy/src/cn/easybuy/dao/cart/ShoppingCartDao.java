package cn.easybuy.dao.cart;

import java.util.List;

import cn.easybuy.entity.ShoppingCart;
import cn.easybuy.param.ShoppingCartParam;


public interface ShoppingCartDao {
	/**
	 * ��Ӷ������ﳵ
	 * @param cart
	 * @throws Exception
	 */
    public void add(ShoppingCart cart) throws Exception;
    /**
     * ����Idɾ�����ﳵ
     * @param id
     * @throws Exception
     */
	public void deleteById(Integer id) throws Exception;
	/**
	 * ����Id��ù��ﳵ
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ShoppingCart getShoppingCartById(Integer id)throws Exception; 
	/**
	 * ���ݹ��ﳵId��ù��ﳵ���鼯
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public List<ShoppingCart> getShoppingCartByUidList(Integer uid)throws Exception;
	/**
	 * ���ݹ��ﳵ������ù��ﳵ������
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryShoppingCartCount(ShoppingCartParam params)throws Exception; 
}
