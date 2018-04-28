package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.Address;

/**
 * ��ַ�����ӿ�
 * @author Administrator
 *
 */
public interface AddressService {
	 /**
     * ����loginName ��ѯ�û���ַ
     * @param id
     * @return
     * @throws Exception
     */
    public List<Address> queryAdressList(Integer id) throws Exception;
    /**
     * ���û���ӵ�ַ
     * @param id
     * @param address
     * @return
     */
    public Integer addAddress(Integer id, String address, String remark) throws Exception;
    /**
     * ����id��ѯ��ַ
     * @param id
     * @return
     */
    public Address getAddressById(Integer id);
}
