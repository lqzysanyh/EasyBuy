package cn.easybuy.dao.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.User;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.Pager;

/**
 * 用户Dao实现类
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDaoImpl implements UserDao{

	public UserDaoImpl(Connection connection) {
		super(connection);
		
	}
	
	@Override
	public Integer add(User user) throws Exception {
		Integer id=0;
    	try {
    		String sql=" INSERT into easybuy_user(loginName,userName,password,sex,identityCode,email,mobile) values(?,?,?,?,?,?,?) ";
            try {
                Object param[]=new Object[]{user.getLoginName(),user.getUserName(),user.getPassword(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile()};
                id=this.executeInsert(sql,param);
                user.setId(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }
    	return id;
	}

	@Override
	public Integer update(User user) throws Exception {
		Integer count=0;
		try {
        	Object[] params = new Object[] {user.getLoginName(),user.getUserName(),user.getType(),user.getSex(),user.getIdentityCode(),user.getEmail(),user.getMobile(),user.getId()};
        	String sql = " UPDATE easybuy_user SET loginName=?,userName =?,type=?,sex =?, identityCode =?, email =?, mobile =? WHERE id =?  ";
			count=this.executeUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
			return count;
        }
	}

	@Override
	public Integer deleteUserById(String id) throws Exception {
		Integer count=0;
		String sql = " delete from easybuy_user where id = ? ";
		Object params[] = new Object[] { id };
		try{
			this.executeUpdate(sql.toString(), params);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
        	this.closeResource();
			return count;
		}
	}

	@Override
	public List<User> getUserList(Integer currentPageNo, Integer pageSize) throws Exception {
		List<Object> paramsList=new ArrayList<Object>();   
		List<User> userList=new ArrayList<User>();
		StringBuffer sql=new StringBuffer(" select id,loginName,password,userName,sex,identityCode,email,mobile,type from easybuy_user where 1=1 ");
		ResultSet resultSet = null;
		try {
			int total = count();
			Pager pager = new Pager(total, pageSize, currentPageNo);
			sql.append(" limit  " + (pager.getCurrentPage() - 1) * pager.getRowPerPage() + "," + pager.getRowPerPage());
			resultSet=this.executeQuery(sql.toString(),paramsList.toArray());
			while (resultSet.next()) {
				User user = (User) this.tableToClass(resultSet);
				userList.add(user);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return userList;
	}

	@Override
	public Integer count() throws Exception {
		List<Object> paramsList=new ArrayList<Object>();   
		StringBuffer sql=new StringBuffer(" select count(*) count from easybuy_user where 1=1 ");
		Integer count=0;
		ResultSet resultSet = this.executeQuery(sql.toString(),paramsList.toArray());
		try {
			while (resultSet.next()) {
				count=resultSet.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return count;
	}

	@Override
	public User getUser(Integer id, String loginName) throws Exception {
		List<Object> paramsList=new ArrayList<Object>();   
		List<User> userList=new ArrayList<User>();
		StringBuffer sql=new StringBuffer("  select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user where 1=1  ");

		if(EmptyUtils.isNotEmpty(id)){
			sql.append(" and id=? ");
			paramsList.add(id);
		}

		if(EmptyUtils.isNotEmpty(loginName)){
			sql.append(" and loginName=? ");
			paramsList.add(loginName);
		}

		ResultSet resultSet = this.executeQuery(sql.toString(),paramsList.toArray());
		User user=null;
		try {
			while (resultSet.next()) {
				user = (User) this.tableToClass(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return user;
	}

	@Override
	public Object tableToClass(ResultSet rs) throws Exception {
		User user = new User();
        user.setLoginName(rs.getString("loginName"));
        user.setUserName(rs.getString("userName"));
        user.setPassword(rs.getString("password"));
        user.setSex(rs.getInt("sex"));
        user.setIdentityCode(rs.getString("identityCode"));
        user.setEmail(rs.getString("email"));
        user.setMobile(rs.getString("mobile"));
        user.setType(rs.getInt("type"));
        user.setId(rs.getInt("id"));
        return user;
	}

	@Override
	public User getById(Integer id) {
		List<Object> paramsList=new ArrayList<Object>();   
		List<User> userList=new ArrayList<User>();
		StringBuffer sql=new StringBuffer("  select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user where 1=1  ");

		if(EmptyUtils.isNotEmpty(id)){
			sql.append(" and id=? ");
			paramsList.add(id);
		}

		ResultSet resultSet = this.executeQuery(sql.toString(),paramsList.toArray());
		User user=null;
		try {
			while (resultSet.next()) {
				user = (User) this.tableToClass(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return user;
	}



	@Override
	public int addUserByPhone(String phone, String checkNum) {
		int result=0;
    	try {
    		String sql=" INSERT into easybuy_user(loginName,userName,password,mobile,type) values(?,?,?,?,0) ";
            try {
                Object param[]=new Object[]{phone,phone,checkNum,phone};
                result=this.executeInsert(sql,param);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }
    	return result;
	}



	@Override
	public User findByPhone(String phone) {
		List<User> userList=new ArrayList<User>();
		StringBuffer sql=new StringBuffer("  select id,loginName,userName,password,sex,identityCode,email,mobile,type from easybuy_user where 1=1  ");
		sql.append(" and mobile=? ");
		
		ResultSet resultSet = this.executeQuery(sql.toString(),phone);
		User user=null;
		try {
			while (resultSet.next()) {
				user = (User) this.tableToClass(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return user;
	}
	
}
