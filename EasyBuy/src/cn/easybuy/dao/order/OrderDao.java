package cn.easybuy.dao.order;
import java.sql.SQLException;
import java.util.List;
import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Order;
import cn.easybuy.param.NewsParams;
import cn.easybuy.param.OrderParams;

/**
 * 订单处理的dao层接口
 * @author Administrator
 *
 */
public interface OrderDao extends BaseDao {
	/**
	 * 添加订单
	 * @param order
	 */
	public void add(Order order) ;
	/**
	 * 根据Id删除订单
	 * @param id
	 */
	public void deleteById(Integer id);
	/**
	 * 根据Id获得订单
	 * @param id
	 * @return
	 */
	public Order getOrderById(Integer id) ;
	/**
	 * 根据用户Id开始页和总页面获得订单集
	 * @param userId
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<Order> getOrderList(Integer userId,Integer currentPageNo,Integer pageSize) ;
	/**
	 * 根据用户Id获得订单数
	 * @param userId
	 * @return
	 */
	public Integer count(Integer userId);
}
