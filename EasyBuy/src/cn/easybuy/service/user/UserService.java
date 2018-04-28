package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.User;

/**
 * �û������ӿ�
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * ����û�
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	/**
	 * �����û�
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	/**
	 * ɾ���û�
	 * @param userId
	 * @return
	 */
	public boolean deleteUserById(Integer userId);
	/**
	 * ����û�
	 * @param userId
	 * @param loginName
	 * @return
	 */
	public User getUser(Integer userId,String loginName);
	/**
	 * ����û���
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserList(Integer currentPageNo,Integer pageSize);
	/**
	 * ����û�����
	 * @return
	 */
	public int count();
	
	/**
	 * �����û�Id��ȡ�û�
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	
	/**
	 * ����û����ݵ绰�������֤��
	 * @param user
	 * @return
	 */
	public boolean addUserByPhone(String phone,String checkNum);
	
	/**
	 * �����ֻ��Ż�ȡ�û�
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone);
	
}
