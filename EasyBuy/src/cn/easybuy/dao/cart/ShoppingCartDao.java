package cn.easybuy.dao.cart;

import java.util.List;

import cn.easybuy.entity.ShoppingCart;
import cn.easybuy.param.ShoppingCartParam;


public interface ShoppingCartDao {
	/**
	 * 添加订单购物车
	 * @param cart
	 * @throws Exception
	 */
    public void add(ShoppingCart cart) throws Exception;
    /**
     * 根据Id删除购物车
     * @param id
     * @throws Exception
     */
	public void deleteById(Integer id) throws Exception;
	/**
	 * 根据Id获得购物车
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public ShoppingCart getShoppingCartById(Integer id)throws Exception; 
	/**
	 * 根据购物车Id获得购物车详情集
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	public List<ShoppingCart> getShoppingCartByUidList(Integer uid)throws Exception;
	/**
	 * 根据购物车参数获得购物车详情数
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public Integer queryShoppingCartCount(ShoppingCartParam params)throws Exception; 
}
