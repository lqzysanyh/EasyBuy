package cn.easybuy.dao.user;
import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Address;
import cn.easybuy.entity.Product;
import cn.easybuy.param.AddressParam;
import cn.easybuy.utils.EmptyUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 地址Dao实现类
 * @author Administrator
 *
 */
public class AddressDaoImpl extends BaseDaoImpl implements AddressDao {

    public AddressDaoImpl(Connection connection) {
        super(connection);
    }

	@Override
	public List<Address> queryAddressList(AddressParam params) {
		List<Object> paramsList=new ArrayList<Object>();   
		List<Address> addresseList=new ArrayList<Address>();
		StringBuffer sql=new StringBuffer("  select id,userId,address,createTime,isDefault,remark from easybuy_user_address  where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getUserId())){
			sql.append(" and userId = ? ");
			paramsList.add(params.getUserId());
		}
		if(EmptyUtils.isNotEmpty(params.getAddress())){
			sql.append(" and address like ? ");
			paramsList.add("%"+params.getAddress()+"%");
		}
		if(EmptyUtils.isNotEmpty(params.getSort())){
			sql.append(" order by " + params.getSort()+" ");
		}
		if(params.isPage()){
			sql.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
		}
		ResultSet resultSet = this.executeQuery(sql.toString(),paramsList.toArray());
		try {
			while (resultSet.next()) {
				Address address = this.tableToClass(resultSet);
				addresseList.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return addresseList;
	}

	@Override
	public Integer save(Address address) {
		Integer id=0;
		String sql=" INSERT into easybuy_user_address(userId,address,createTime,isDefault,remark) VALUES(?,?,?,?,?) ";
        try {
            Object param[]=new Object[]{address.getUserId(),address.getAddress(),new Date(),0,address.getRemark()};
            id=this.executeInsert(sql,param);
            address.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }
        return id;
	}

	@Override
	public Address getAddressById(Integer addressId) {
		List<Object> paramsList=new ArrayList<Object>();   
		StringBuffer sql=new StringBuffer(" select id,userId,address,createTime,isDefault,remark from easybuy_user_address  where id=? ");
		Address address =null;
		ResultSet resultSet = this.executeQuery(sql.toString(),new Object[]{addressId});
		try {
			while (resultSet.next()) {
				address= this.tableToClass(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return address;
	}

	@Override
	public Address tableToClass(ResultSet rs) throws Exception {
		Address address = new Address();
		address.setId(rs.getInt("id"));
		address.setAddress(rs.getString("address"));
		address.setUserId(rs.getInt("userId"));
		address.setCreateTime(rs.getDate("createTime"));
		address.setRemark(rs.getString("remark"));
        return address;
	}

    
}
