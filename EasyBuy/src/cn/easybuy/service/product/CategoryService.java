package cn.easybuy.service.product;

import java.util.List;

import cn.easybuy.entity.Category;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.utils.CategoryVo;

/**
 * ��Ʒ�������ӿ�
 * @author Administrator
 *
 */
public interface CategoryService {
	 /**
     * ����id��ѯ��Ʒ����
     * @param id
     * @return
     */
    public Category getById(Integer id);
    /**
     * ��ѯ��Ʒ�����б�
     * @param params
     * @return
     */
    public List<Category> queryCategoryList(CategoryParam params);
    /**
     * ��ѯ��Ŀ
     * @param params
     * @return
     */
    public int queryCategoryCount(CategoryParam params);
    /**
     * �޸���Ʒ����
     * @param params
     */
    public void modifyCategory(Category category);
    /**
     * �����Ʒ����
     * @param params
     */
    public void addCategory(Category category);
    /**
     * ����idɾ��
     * @param id
     */
    public void deleteById(Integer id);
    /**
     * ��ѯȫ������Ʒ����
     * @return
     */
    public List<CategoryVo> queryAllCategoryList();
    /**
     * ����sql��ѯ��Ʒ����
     * @param params
     * @return
     */
    public List<Category> queryCategorylistBySql(CategoryParam params);
    /**
     * ���ݸ�ID��ѯ��������Ʒ����
     * @param parentId
     * @return
     */
    public List<Category> getCategories(Integer parentId);
}
