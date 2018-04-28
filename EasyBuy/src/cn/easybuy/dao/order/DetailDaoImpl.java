package cn.easybuy.dao.order;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Order;
import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Product;
import cn.easybuy.param.DetailParam;
import cn.easybuy.param.DetailParam;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Params;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单详细Dao实现类
 * @author Administrator
 *
 */
public class DetailDaoImpl extends BaseDaoImpl implements DetailDao{

	ProductDao productDao;

    public DetailDaoImpl(Connection connection) {
        super(connection);
        productDao=new ProductDaoImpl(connection);
    }

	@Override
	public void add(Detail detail) throws Exception {
		Integer id=0;
		String sql=" insert into easybuy_order_detail(orderId,productId,quantity,cost) values(?,?,?,?) ";
        try {
            Object param[]=new Object[]{detail.getOrderId(),detail.getProduct().getId(),detail.getQuantity(),detail.getCost()};
            id=this.executeInsert(sql,param);
            detail.setId(id);
        } catch (Exception e) {
			this.closeResource();
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteById(Detail detail) throws Exception {
		String sql = " delete from easybuy_order_detail where id = ? ";
		Object params[] = new Object[] { detail.getId() };
		try {
		this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
	}

	@Override
	public Detail getDetailById(Integer id) throws Exception {
		String sql = " select orderId,productId,quantity,cost from easybuy_order_detail where id = ? ";
		ResultSet resultSet = null;
	    Detail detail = null;
		try {
			Object params[] = new Object[] { id };
			resultSet = this.executeQuery(sql, params);
			while (resultSet.next()) {
				detail = tableToClass(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeResource(resultSet);
			this.closeResource();
			return detail;
		}
	}

	@Override
	public List<Detail> getDetailList(Integer orderId) throws Exception {
		List<Detail> detailList = null;
		List<Object> paramsList=new ArrayList<Object>();
		StringBuffer sql = new StringBuffer(" select id,orderId,productId,quantity,cost FROM easybuy_order_detail where 1=1 ");
		
		if(EmptyUtils.isNotEmpty(orderId)){
			sql.append(" and orderId=? ");
			paramsList.add(orderId);
		}
		ResultSet resultSet = this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			detailList=new ArrayList<Detail>();
			while (resultSet.next()) {
				Detail detail = this.tableToClass(resultSet);
				detailList.add(detail);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource(resultSet);
			this.closeResource();
			return detailList;
		}
	}

	@Override
	public Integer queryDetailCount(DetailParam params) throws Exception {
		Integer count = 0;
		List<Detail> detailList = null;
		String sql = " select count(*) FROM easybuy_order_detail ";
		ResultSet resultSet = this.executeQuery(sql, new Object[] {});
		try {
			detailList=new ArrayList<Detail>();
			while (resultSet.next()) {
				count = resultSet.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource(resultSet);
			this.closeResource();
			return count;
		}
	}

	@Override
	public Detail tableToClass(ResultSet rs) throws Exception {
		Detail detail = new Detail();
		detail.setId(rs.getInt("id"));
		detail.setOrderId(rs.getInt("orderId"));
		detail.setProduct((Product) productDao.getProductById(rs.getInt("productId")));
		detail.setProductId(rs.getInt("productId"));
		detail.setQuantity(rs.getInt("quantity"));
		detail.setCost(rs.getFloat("cost"));
        return detail;
	}


}
