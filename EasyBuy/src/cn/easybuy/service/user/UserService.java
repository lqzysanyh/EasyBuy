package cn.easybuy.service.user;

import java.util.List;

import cn.easybuy.entity.User;

/**
 * 用户服务层接口
 * @author Administrator
 *
 */
public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public boolean update(User user);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	public boolean deleteUserById(Integer userId);
	/**
	 * 获得用户
	 * @param userId
	 * @param loginName
	 * @return
	 */
	public User getUser(Integer userId,String loginName);
	/**
	 * 获得用户集
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	public List<User> getUserList(Integer currentPageNo,Integer pageSize);
	/**
	 * 获得用户数量
	 * @return
	 */
	public int count();
	
	/**
	 * 根据用户Id获取用户
	 * @param id
	 * @return
	 */
	public User findById(Integer id);
	
	/**
	 * 添加用户根据电话号码和验证码
	 * @param user
	 * @return
	 */
	public boolean addUserByPhone(String phone,String checkNum);
	
	/**
	 * 根据手机号获取用户
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone);
	
}
