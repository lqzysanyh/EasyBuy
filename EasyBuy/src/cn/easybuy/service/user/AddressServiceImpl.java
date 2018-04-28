package cn.easybuy.service.user;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.easybuy.dao.user.AddressDao;
import cn.easybuy.dao.user.AddressDaoImpl;
import cn.easybuy.entity.Address;
import cn.easybuy.param.AddressParam;
import cn.easybuy.utils.DataSourceUtil;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> queryAdressList(Integer id) throws Exception {
		Connection connection = null;
        List<Address> addressList = null;
        try {
            connection = DataSourceUtil.openConnection();
            AddressDao addressDao = new AddressDaoImpl(connection);
            AddressParam params = new AddressParam();
            params.setUserId(id);
            addressList = addressDao.queryAddressList(params);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	DataSourceUtil.closeConnection(connection);
        }
        return addressList;
	}

	@Override
	public Address getAddressById(Integer id) {
		Connection connection = null;
        Address address= null;
        try {
            connection = DataSourceUtil.openConnection();
            AddressDao addressDao = new AddressDaoImpl(connection);
            address = (Address) addressDao.getAddressById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DataSourceUtil.closeConnection(connection);
            return  address;
        }
	}

	@Override
	public Integer addAddress(Integer userId, String address, String remark) throws Exception {
		Connection connection = null;
        Integer userAddressId = null;
        try {
            connection = DataSourceUtil.openConnection();
            AddressDao addressDao = new AddressDaoImpl(connection);
            Address address2=new Address();
            address2.setUserId(userId);
            address2.setAddress(address);
            address2.setRemark(remark);
            userAddressId = addressDao.save(address2);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	DataSourceUtil.closeConnection(connection);
        }
        return userAddressId;
	}

}
