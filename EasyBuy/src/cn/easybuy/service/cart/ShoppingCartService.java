package cn.easybuy.service.cart;

import java.util.List;

import cn.easybuy.entity.ShoppingCart;
import cn.easybuy.entity.User;

public interface ShoppingCartService {

	/**
	 * 添加购物车
	 * @param shoppingCart
	 */
	void addShoppingCart(ShoppingCart shoppingCart);
		
	/**
	 * 删除购物车
	 * @param id
	 */
	void delShoppingCart(Integer id);
	
	
	
	/**
	 * 获取用户购物车
	 * @param user
	 * @return
	 */
	List<ShoppingCart> getShoppingCarts(User user);
	
}
