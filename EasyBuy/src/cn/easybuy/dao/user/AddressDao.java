package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.Address;
import cn.easybuy.param.AddressParam;

/**
 * 地址Dao接口
 * @author Administrator
 *
 */
public interface AddressDao extends BaseDao {
	/**
	 * 根据地址参数获取地址集
	 * @param param
	 * @return
	 */
	public List<Address> queryAddressList(AddressParam param);
	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	public Integer save(Address address);
	/**
	 * 根据地址Id获取地址
	 * @param addressId
	 * @return
	 */
	public Address getAddressById(Integer addressId);

}
