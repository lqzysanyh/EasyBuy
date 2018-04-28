package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.Address;
import cn.easybuy.param.AddressParam;

/**
 * ��ַDao�ӿ�
 * @author Administrator
 *
 */
public interface AddressDao extends BaseDao {
	/**
	 * ���ݵ�ַ������ȡ��ַ��
	 * @param param
	 * @return
	 */
	public List<Address> queryAddressList(AddressParam param);
	/**
	 * ��ӵ�ַ
	 * @param address
	 * @return
	 */
	public Integer save(Address address);
	/**
	 * ���ݵ�ַId��ȡ��ַ
	 * @param addressId
	 * @return
	 */
	public Address getAddressById(Integer addressId);

}
