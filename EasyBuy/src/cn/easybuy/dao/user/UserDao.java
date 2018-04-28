package cn.easybuy.dao.user;

import java.util.List;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.User;

/**
 * 用户Dao接口
 * @author Administrator
 *
 */
public interface UserDao  extends BaseDao{
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer add(User user) throws Exception;
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public Integer update(User user) throws Exception;
	/**
	 * 根据Id删除用户
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Integer deleteUserById(String id) throws Exception;
	/**
	 * 根据起始Id,页面大小获取用户集
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	public List<User> getUserList(Integer currentPageNo,Integer pageSize)throws Exception;
	/**
	 * 获取用户数
	 * @return
	 * @throws Exception
	 */
	public Integer count() throws Exception;
	/**
	 * 根据Id,登录名获得用户
	 * @param id
	 * @param loginName
	 * @return
	 * @throws Exception
	 */
	public User getUser(Integer id,String loginName) throws Exception;
	
	/**
	 * 根据用户Id获取用户
	 * @param id
	 * @return
	 */
	public User getById(Integer id);
	
	/**
	 * 添加用户根据电话号码和验证码
	 * @param user
	 * @return
	 */
	public int addUserByPhone(String phone,String checkNum);
	
	/**
	 * 根据手机号获取用户
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone);
}
