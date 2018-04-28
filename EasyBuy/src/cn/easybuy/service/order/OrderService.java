package cn.easybuy.service.order;

import java.util.List;

import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Order;
import cn.easybuy.entity.User;
import cn.easybuy.utils.ShoppingCart;

/**
 * ���������ӿ�
 * @author Administrator
 *
 */
public interface OrderService {
	
	/**
	 * ���㶩��
	 * @param cart
	 * @param user
	 * @param address
	 * @return
	 */
	public Order payShoppingCart(ShoppingCart cart, User user,String address);
	/**
	 * ���ݲ�ѯ����
	 * @param userId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<Order> getOrderList(Integer userId,Integer currentPageNo,Integer pageSize);
	/**
	 * ����������ѯ�������ܼ�¼��
	 * @param userId
	 * @return
	 */
    public int count(Integer userId);
    /**
     * ���ݶ���id��ѯ������ϸ�б�
     * @param orderId
     * @return
     */
    public List<Detail> getDetailList(Integer orderId);

}
