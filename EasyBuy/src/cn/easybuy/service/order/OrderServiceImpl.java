package cn.easybuy.service.order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;


import cn.easybuy.dao.order.*;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.utils.*;
import cn.easybuy.entity.Order;
import cn.easybuy.entity.Detail;
import cn.easybuy.entity.User;

/**
 * 订单服务层实现类
 * @author Administrator
 *
 */
public class OrderServiceImpl implements OrderService {

	@Override
	public Order payShoppingCart(ShoppingCart cart, User user, String address) {
		 Connection connection = null;
	        Order order = new Order();
	        try {
	            connection = DataSourceUtil.openConnection();
	            connection.setAutoCommit(false);
	            ProductDao productDao = new ProductDaoImpl(connection);
	            OrderDao orderDao = new OrderDaoImpl(connection);
	            DetailDao detailDao = new DetailDaoImpl(connection);
	            //增加订单
	            order.setUserId(user.getId());
	            order.setLoginName(user.getLoginName());
	            order.setUserAddress(address);
	            order.setCreateTime(new Date());
	            order.setCost(cart.getTotalCost());
	            order.setSerialNumber(StringUtils.randomUUID());
	            orderDao.add(order);
	            //增加订单对应的明细信息
	            for (ShoppingCartItem item : cart.getItems()) {
	                Detail orderDetail = new Detail();
	                orderDetail.setOrderId(order.getId());
	                orderDetail.setCost(item.getCost());
	                orderDetail.setProduct(item.getProduct());
	                orderDetail.setQuantity(item.getQuantity());
	                detailDao.add(orderDetail);
	                //更新商品表的库存
	                productDao.updateStock(item.getProduct().getId(), item.getQuantity());
	                connection.commit();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	            e.printStackTrace();
	            try {
	                connection.rollback();
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            }
	            order = null;
	        } finally {
	        	try {
	        		connection.setAutoCommit(true);
	        	} catch (SQLException e) {
	        		e.printStackTrace();
	        	}
	            DataSourceUtil.closeConnection(connection);
	        }
	        return order;
	}

	@Override
	public List<Order> getOrderList(Integer userId, Integer currentPageNo, Integer pageSize) {
		 Connection connection = null;
	        List<Order> orderList = new ArrayList<Order>();
	        try {
	            connection = DataSourceUtil.openConnection();
	            OrderDao orderDao = new OrderDaoImpl(connection);
	            DetailDao orderDetailDao=new DetailDaoImpl(connection);
	            orderList = orderDao.getOrderList(userId, currentPageNo, pageSize);
	            for(Order order:orderList){
	            	order.setDetailList(orderDetailDao.getDetailList(order.getId()));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DataSourceUtil.closeConnection(connection);
	            return orderList;
	        }
	}

	@Override
	public int count(Integer userId) {
		Connection connection = null;
		 Integer count=0;
	        try {
	            connection = DataSourceUtil.openConnection();
	            OrderDao orderDao = new OrderDaoImpl(connection);
	            count=orderDao.count(userId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DataSourceUtil.closeConnection(connection);
	            return count;
	        }
	}

	@Override
	public List<Detail> getDetailList(Integer orderId) {
		 Connection connection = null;
	        List<Detail> detailList = new ArrayList<Detail>();
	        try {
	            connection = DataSourceUtil.openConnection();
	            DetailDao detailDao = new DetailDaoImpl(connection);
	            detailList = detailDao.getDetailList(orderId);
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DataSourceUtil.closeConnection(connection);
	            return detailList;
	        }
	}

}
