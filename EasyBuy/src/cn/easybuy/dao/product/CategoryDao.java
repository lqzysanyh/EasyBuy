package cn.easybuy.dao.product;

import cn.easybuy.dao.BaseDao;
import cn.easybuy.entity.Detail;
import cn.easybuy.entity.Category;
import cn.easybuy.entity.User;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.param.DetailParam;
import cn.easybuy.utils.Params;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * 商品分类Dao接口
 * @author Administrator
 *
 */
public interface CategoryDao extends BaseDao {
	/**
	 * 根据Id删除商品分类
	 * @param parseLong
	 */
	public void deleteById(Integer parseLong);
	/**
	 * 根据商品参数获得商品分类集
	 * @param param
	 * @return
	 */
	public List<Category> queryCategorylist(CategoryParam param);
	/**
	 * 根据商品参数获得全部商品分类集
	 * @param param
	 * @return
	 */
	public List<Category> queryAllCategorylist(CategoryParam param);
	/**
	 * 根据Id获得商品分类
	 * @param id
	 * @return
	 */
	public Category queryCategoryById(Integer id);
	/**
	 * 添加商品分类
	 * @param category
	 * @return
	 */
	public Integer save(Category category) ;
	/**
	 * 查询商品分类数
	 * @param param
	 * @return
	 */
	public Integer queryCategoryCount(CategoryParam param);
	/**
	 * 更新商品分类
	 * @param category
	 */
	public void update(Category category) ;
}
