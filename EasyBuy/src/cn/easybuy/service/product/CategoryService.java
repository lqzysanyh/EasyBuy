package cn.easybuy.service.product;

import java.util.List;

import cn.easybuy.entity.Category;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.utils.CategoryVo;

/**
 * 商品分类服务接口
 * @author Administrator
 *
 */
public interface CategoryService {
	 /**
     * 根据id查询商品分类
     * @param id
     * @return
     */
    public Category getById(Integer id);
    /**
     * 查询商品分类列表
     * @param params
     * @return
     */
    public List<Category> queryCategoryList(CategoryParam params);
    /**
     * 查询数目
     * @param params
     * @return
     */
    public int queryCategoryCount(CategoryParam params);
    /**
     * 修改商品分类
     * @param params
     */
    public void modifyCategory(Category category);
    /**
     * 添加商品分类
     * @param params
     */
    public void addCategory(Category category);
    /**
     * 根据id删除
     * @param id
     */
    public void deleteById(Integer id);
    /**
     * 查询全部的商品分类
     * @return
     */
    public List<CategoryVo> queryAllCategoryList();
    /**
     * 根据sql查询商品分类
     * @param params
     * @return
     */
    public List<Category> queryCategorylistBySql(CategoryParam params);
    /**
     * 根据父ID查询所有子商品分类
     * @param parentId
     * @return
     */
    public List<Category> getCategories(Integer parentId);
}
