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
 * ��Ʒ����Dao�ӿ�
 * @author Administrator
 *
 */
public interface CategoryDao extends BaseDao {
	/**
	 * ����Idɾ����Ʒ����
	 * @param parseLong
	 */
	public void deleteById(Integer parseLong);
	/**
	 * ������Ʒ���������Ʒ���༯
	 * @param param
	 * @return
	 */
	public List<Category> queryCategorylist(CategoryParam param);
	/**
	 * ������Ʒ�������ȫ����Ʒ���༯
	 * @param param
	 * @return
	 */
	public List<Category> queryAllCategorylist(CategoryParam param);
	/**
	 * ����Id�����Ʒ����
	 * @param id
	 * @return
	 */
	public Category queryCategoryById(Integer id);
	/**
	 * �����Ʒ����
	 * @param category
	 * @return
	 */
	public Integer save(Category category) ;
	/**
	 * ��ѯ��Ʒ������
	 * @param param
	 * @return
	 */
	public Integer queryCategoryCount(CategoryParam param);
	/**
	 * ������Ʒ����
	 * @param category
	 */
	public void update(Category category) ;
}
