package cn.easybuy.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * 分布对象缓存类
 * @author Administrator
 *
 */
public class MemcachedUtils {
	static MemCachedClient client = null;
	//static String[] connectUrls = new String[]{"172.20.10.13:11311"};
	static String[] connectUrls = new String[]{"127.0.0.1:11211"};
	
	//初始化连接
	static{
		String[] attr = connectUrls;
		client = new MemCachedClient();
		SockIOPool pool = SockIOPool.getInstance();
		pool.setServers(attr);
		pool.setWeights(new Integer[]{3});
		pool.setInitConn(5);
		pool.setMinConn(5);		
		pool.setMaxConn(200);
		pool.setMaxIdle(1000*30*30);
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketConnectTO(30);
		pool.initialize();
	}
	/**
	 * 添加数据
	 * @param key
	 * @param object
	 */
	public static void add(String key,Object object){
		client.set(key, object);
	}
	/**
	 * 删除数据
	 * @param key
	 */
	public static void del(String key){
		client.delete(key);
	}
	/**
	 * 获得数据
	 * @param key
	 * @return
	 */
	public static Object get(String key){
		return client.get(key);
	}
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("abc");
		list.add("efg");
		client.add("first", list);
		
		List<String> list2 =(List<String>)client.get("first");
		for (String string : list2) {
			System.out.println(string);
		}
		
		
		/*List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		list.add("abc");
		list.add("efg");
		
		
		System.out.println(list.subList(4, 6));*/
		
		
 	}
}
