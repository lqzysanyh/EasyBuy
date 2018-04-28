package cn.easybuy.dao.cart;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.dao.product.ProductDao;
import cn.easybuy.dao.product.ProductDaoImpl;
import cn.easybuy.dao.user.UserDao;
import cn.easybuy.dao.user.UserDaoImpl;
import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ShoppingCart;
import cn.easybuy.entity.User;
import cn.easybuy.param.ShoppingCartParam;

public class ShoppingCartDaoImpl extends BaseDaoImpl implements ShoppingCartDao {

	ProductDao productDao ;
	UserDao userDao;
	
	public ShoppingCartDaoImpl(Connection connection) {
		super(connection);
		productDao = new ProductDaoImpl(connection);
		userDao = new UserDaoImpl(connection);
	}

	@Override
	public void add(ShoppingCart cart) throws Exception {
		Integer id=0;
		String sql=" insert into easybuy_shoppingcart(uid,pid,quantity,cost) values(?,?,?,?) ";
        try {
            Object param[]=new Object[]{cart.getUser().getId(),cart.getProduct().getId(),cart.getQuantity(),cart.getCost()};
            id=this.executeInsert(sql,param);
            cart.setId(id);
        } catch (Exception e) {
			this.closeResource();
            e.printStackTrace();
        }finally{
			this.closeResource();
		}

	}

	@Override
	public void deleteById(Integer id) throws Exception {
		String sql = " delete from easybuy_shoppingcart where id = ? ";
		Object params[] = new Object[] { id };
		try {
			this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
	}

	@Override
	public ShoppingCart getShoppingCartById(Integer id) throws Exception {
		ShoppingCart shoppingCart = new ShoppingCart();
		String sql = "select * from easybuy_shoppingcart where id = ? ";
		Object params[] = new Object[] { id };
		ResultSet rs =null;
		try {
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				shoppingCart = (ShoppingCart)this.tableToClass(rs);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource(rs);
			this.closeResource();
		}
		return shoppingCart;
	}

	@Override
	public List<ShoppingCart> getShoppingCartByUidList(Integer uid) throws Exception {
		List<ShoppingCart> list =new ArrayList<ShoppingCart>();
		String sql = "select * from easybuy_shoppingcart where id = ? ";
		Object params[] = new Object[] { uid };
		ResultSet rs =null;
		try {
			rs = this.executeQuery(sql, params);
			while (rs.next()) {
				list.add((ShoppingCart)this.tableToClass(rs));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource(rs);
			this.closeResource();
		}
		return list;
	}

	@Override
	public Integer queryShoppingCartCount(ShoppingCartParam params) throws Exception {
		Integer count = 0;
		List<ShoppingCart> shoppingCartList = null;
		String sql = " select count(1) FROM easybuy_shoppingcart where userId = ? ";
		ResultSet resultSet = this.executeQuery(sql, new Object[] {params.getUser().getId()});
		try {
			shoppingCartList=new ArrayList<ShoppingCart>();
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
	public Object tableToClass(ResultSet rs) throws Exception {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setQuantity(rs.getInt("quantity"));
		shoppingCart.setCost(rs.getFloat("cost"));
		shoppingCart.setUser((User) userDao.getById(rs.getInt("userId")));
		shoppingCart.setProduct((Product) productDao.getProductById(rs.getInt("productId")));
		return shoppingCart;
	}
	
}
