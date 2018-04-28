package cn.easybuy.service.order;

import java.sql.Connection;

import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.ShoppingCart;
import cn.easybuy.utils.ShoppingCartItem;

public class CartServiceImpl implements CartService {

	@Override
	public ShoppingCart modifyShoppingCart(String productId, String quantityStr, ShoppingCart cart) throws Exception {
		Integer quantity = 0;
    	Connection connection = null;
    	if (!EmptyUtils.isEmpty(quantityStr))
            quantity = Integer.parseInt(quantityStr);
        //�������ﳵѰ�Ҹ���Ʒ �޸�������
        for (ShoppingCartItem item : cart.getItems()) {
            if (item.getProduct().getId().toString().equals(productId)) {
                if (quantity == 0 || quantity < 0) {
                    cart.getItems().remove(item);
                    break;
                } else {
                    item.setQuantity(quantity);
                }
            }
        }
        //���¼�����
        calculate(cart);
        return cart;
	}

	@Override
	public ShoppingCart calculate(ShoppingCart cart) throws Exception {
		double sum = 0.0;
        for (ShoppingCartItem item : cart.getItems()) {
            sum = sum + item.getQuantity() * item.getProduct().getPrice();
            item.setCost(item.getQuantity() * item.getProduct().getPrice());
        }
        cart.setSum(sum);
        return cart;
	}

}
