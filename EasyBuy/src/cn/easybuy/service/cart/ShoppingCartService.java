package cn.easybuy.service.cart;

import java.util.List;

import cn.easybuy.entity.ShoppingCart;
import cn.easybuy.entity.User;

public interface ShoppingCartService {

	/**
	 * ��ӹ��ﳵ
	 * @param shoppingCart
	 */
	void addShoppingCart(ShoppingCart shoppingCart);
		
	/**
	 * ɾ�����ﳵ
	 * @param id
	 */
	void delShoppingCart(Integer id);
	
	
	
	/**
	 * ��ȡ�û����ﳵ
	 * @param user
	 * @return
	 */
	List<ShoppingCart> getShoppingCarts(User user);
	
}
