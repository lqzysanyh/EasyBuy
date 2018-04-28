package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.User;

/**
 * �û�Dao�ӿ�
 * @author Administrator
 *
 */
public interface UserDao  extends BaseDao{
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer add(User user) throws Exception;
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer update(User user) throws Exception;
	/**
	 * ����Idɾ���û�
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteUserById(String id) throws Exception;
	/**
	 * ������ʼId,ҳ���С��ȡ�û���
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(Integer currentPageNo,Integer pageSize)throws Exception;
	/**
	 * ��ȡ�û���
	 * @return
	 * @throws Exception
	 */
	public Integer count() throws Exception;
	/**
	 * ����Id,��¼������û�
	 * @param id
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public User getUser(Integer id,String loginName) throws Exception;
	
	/**
	 * �����û�Id��ȡ�û�
	 * @param id
	 * @return
	 */
	public User getById(Integer id);
	
	/**
	 * ����û����ݵ绰�������֤��
	 * @param user
	 * @return
	 */
	public int addUserByPhone(String phone,String checkNum);
	
	/**
	 * �����ֻ��Ż�ȡ�û�
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone);
}
