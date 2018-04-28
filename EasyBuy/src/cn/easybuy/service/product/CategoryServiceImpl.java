package cn.easybuy.service.product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.product.CategoryDao;
import cn.easybuy.dao.product.CategoryDaoImpl;
import cn.easybuy.entity.Category;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.utils.CategoryVo;
import cn.easybuy.utils.DataSourceUtil;
import cn.easybuy.utils.EmptyUtils;

/**
 * ��Ʒ��������ʵ����
 * @author Administrator
 *
 */
public class CategoryServiceImpl implements CategoryService {

	@Override
	public Category getById(Integer id) {
		Connection connection = null;
		Category category = null;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			category = categoryDao.queryCategoryById(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
		return category;
	}

	@Override
	public List<Category> queryCategoryList(CategoryParam params) {
		Connection connection = null;
		List<Category> list = null;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			list = categoryDao.queryCategorylist(params);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
		return list;
	}

	@Override
	public int queryCategoryCount(CategoryParam params) {
		Connection connection = null;
		int count = 0;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			count = categoryDao.queryCategoryCount(params);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
		return count;
	}

	@Override
	public void modifyCategory(Category category) {
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			categoryDao.update(category);;			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
	}

	@Override
	public void addCategory(Category category) {
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			categoryDao.save(category);;			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
	}

	@Override
	public void deleteById(Integer id) {
		Connection connection = null;
		try {
			connection = DataSourceUtil.openConnection();
			CategoryDao categoryDao = new CategoryDaoImpl(connection);
			categoryDao.deleteById(id);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DataSourceUtil.closeConnection(connection);
		}
	}

	@Override
	public List<CategoryVo> queryAllCategoryList() {
		//��ѯһ��������б�
        List<CategoryVo> category1VoList = new ArrayList<CategoryVo>();
        //��ѯһ������
        List<Category> category1List = getCategories(null);
        //��ѯ��������
        for (Category category1 : category1List) {
            //��װһ������
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setCategory(category1);
            List<CategoryVo> categoryVo1ChildList = new ArrayList<CategoryVo>();
            //����һ�������ѯ��������
            List<Category> productCategory2List = getCategories(category1.getId());
            for (Category category2 : productCategory2List) {
                CategoryVo categoryVo2 = new CategoryVo();
                categoryVo1ChildList.add(categoryVo2);
                categoryVo2.setCategory(category2);
                List<CategoryVo> categoryVo2ChildList = new ArrayList<CategoryVo>();
                categoryVo2.setCategoryVoList(categoryVo2ChildList);
                //���ݶ��������ѯ����������б�
                List<Category> category3List = getCategories(category2.getId());
                for (Category category3 : category3List) {
                    CategoryVo categoryVo3 = new CategoryVo();
                    categoryVo3.setCategory(category3);
                    categoryVo2ChildList.add(categoryVo3);
                }
            }
            categoryVo.setCategoryVoList(categoryVo1ChildList);
            category1VoList.add(categoryVo);
        }
        return category1VoList;
	}

	@Override
	public List<Category> queryCategorylistBySql(CategoryParam params) {
		Connection connection = null;
        List<Category> list = null;
        try {
            connection = DataSourceUtil.openConnection();
            CategoryDao productCategoryDao = new CategoryDaoImpl(connection);
            list = productCategoryDao.queryCategorylist(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
        }
        return list;
	}
	
	public List<Category> getCategories(Integer parentId) {//���ݸ�ID��ѯ��������Ʒ����
        Connection connection = null;
        List<Category> productCategoryList = null;
        try {
            connection = DataSourceUtil.openConnection();
            CategoryDao categoryDao = new CategoryDaoImpl(connection);
            CategoryParam params = new CategoryParam();
            if (EmptyUtils.isNotEmpty(parentId)) {
            	params.setParentId(parentId);
            } else {
            	params.setParentId(0);
            }
            productCategoryList = categoryDao.queryCategorylist(params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeConnection(connection);
            return productCategoryList;
        }
    }
}
