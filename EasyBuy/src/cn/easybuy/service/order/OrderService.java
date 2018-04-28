package cn.easybuy.service.order;

import java.util.List;

import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Order;
import cn.easybuy.entity.User;
import cn.easybuy.utils.ShoppingCart;

/**
 * 订单服务层接口
 * @author Administrator
 *
 */
public interface OrderService {
	
	/**
	 * 结算订单
	 * @param cart
	 * @param user
	 * @param address
	 * @return
	 */
	public Order payShoppingCart(ShoppingCart cart, User user,String address);
	/**
	 * 根据查询条件
	 * @param userId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<Order> getOrderList(Integer userId,Integer currentPageNo,Integer pageSize);
	/**
	 * 根据条件查询订单表总记录数
	 * @param userId
	 * @return
	 */
    public int count(Integer userId);
    /**
     * 根据订单id查询订单明细列表
     * @param orderId
     * @return
     */
    public List<Detail> getDetailList(Integer orderId);

}
