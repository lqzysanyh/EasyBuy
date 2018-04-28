package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.Address;

/**
 * 地址服务层接口
 * @author Administrator
 *
 */
public interface AddressService {
	 /**
     * 根据loginName 查询用户地址
     * @param id
     * @return
     * @throws Exception
     */
    public List<Address> queryAdressList(Integer id) throws Exception;
    /**
     * 给用户添加地址
     * @param id
     * @param address
     * @return
     */
    public Integer addAddress(Integer id, String address, String remark) throws Exception;
    /**
     * 根据id查询地址
     * @param id
     * @return
     */
    public Address getAddressById(Integer id);
}
