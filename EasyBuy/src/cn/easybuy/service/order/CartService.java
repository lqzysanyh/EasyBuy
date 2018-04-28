package cn.easybuy.service.order;

import java.util.List;

import cn.easybuy.entity.Detail;
import cn.easybuy.param.DetailParam;
import cn.easybuy.utils.ShoppingCart;

/**
 * ���ﳵ����ӿ�
 * @author Administrator
 *
 */
public interface CartService {
	public ShoppingCart modifyShoppingCart(String productId,String quantityStr,ShoppingCart cart) throws Exception;

    public ShoppingCart calculate(ShoppingCart cart)throws Exception;
    
}