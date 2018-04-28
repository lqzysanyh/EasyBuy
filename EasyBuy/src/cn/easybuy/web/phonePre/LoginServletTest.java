package cn.easybuy.web.phonePre;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cn.easybuy.entity.User;
import cn.easybuy.service.user.UserService;
import cn.easybuy.service.user.UserServiceImpl;
import cn.easybuy.utils.EmptyUtils;
import cn.easybuy.utils.SecurityUtils;

public class LoginServletTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		 String loginName="admin";
		 String password="123456";
		UserService userService = new UserServiceImpl();
		 User user=userService.getUser(null, loginName);
	        if(EmptyUtils.isEmpty(user)){
	           System.out.println("用户不存在");
	        }else{
	           if(user.getPassword().equals(SecurityUtils.md5Hex(password))){
	               //登陆成功
	        	   System.out.println(SecurityUtils.md5Hex(password));
	               System.out.println("登陆成功");
	           }else{
	        	   System.out.println("密码错误");
	           }
	        }
	}

}
