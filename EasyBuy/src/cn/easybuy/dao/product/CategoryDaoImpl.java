package cn.easybuy.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.easybuy.dao.BaseDaoImpl;
import cn.easybuy.entity.Category;
import cn.easybuy.param.CategoryParam;
import cn.easybuy.utils.EmptyUtils;
/**
 * 商品分类Dao实现类
 * @author Administrator
 *
 */
public class CategoryDaoImpl extends BaseDaoImpl implements CategoryDao{

	private int judge=0;
	
	public CategoryDaoImpl(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void deleteById(Integer id) {
		String sql = " delete from easybuy_product_category where id = ? ";
		Object params[] = new Object[] { id };
		this.executeUpdate(sql.toString(), params);	
	}

	@Override
	public List<Category> queryCategorylist(CategoryParam params) {
		List<Object> paramsList=new ArrayList<Object>();   
		List<Category> categoryList=new ArrayList<Category>();
		StringBuffer sql=new StringBuffer("SELECT epc1.*,epc2.name as parentName FROM easybuy_product_category epc1 LEFT JOIN easybuy_product_category epc2 ON epc1.parentId=epc2.id where 1=1");
		ResultSet resultSet=null;
		try {
			if(EmptyUtils.isNotEmpty(params.getName())){
				sql.append(" and epc1.name like ? ");
				paramsList.add("%"+params.getName()+"%");
			}
			if(EmptyUtils.isNotEmpty(params.getParentId())){
				sql.append(" and epc1.parentId = ? ");
				paramsList.add(params.getParentId());
			}
			if(EmptyUtils.isNotEmpty(params.getType())){
				sql.append(" and epc1.type = ? ");
				paramsList.add(params.getType());
			}
			if(params.isPage()){
				sql.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
			}
			resultSet=this.executeQuery(sql.toString(), paramsList.toArray());
			while (resultSet.next()) {
				Category category =  this.tableToClass(resultSet);
				categoryList.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return categoryList;
	}

	@Override
	public List<Category> queryAllCategorylist(CategoryParam params) {
		List<Category> list=new ArrayList<Category>();
		List<Object> paramsList=new ArrayList<Object>();
		StringBuffer sqlBuffer=new StringBuffer("SELECT epc1.*,epc2.name as parentName FROM easybuy_product_category epc1 LEFT JOIN easybuy_product_category epc2 ON epc1.parentId=epc2.id where 1=1 ");
		ResultSet resultSet=null;
		try{
			if(EmptyUtils.isNotEmpty(params.getName())){
				sqlBuffer.append(" and epc1.name like ? ");
				paramsList.add("%"+params.getName()+"%");
			}
			if(EmptyUtils.isNotEmpty(params.getParentId())){
				sqlBuffer.append(" and epc1.parentId = ? ");
				paramsList.add(params.getParentId());
			}
			if(EmptyUtils.isNotEmpty(params.getSort())){
				sqlBuffer.append(" order by " + params.getSort()+" ");
			}
			if(params.isPage()){
				sqlBuffer.append(" limit  " + params.getStartIndex() + "," + params.getPageSize());
			}
			resultSet=this.executeQuery(sqlBuffer.toString(),paramsList.toArray());
			ResultSetMetaData md=resultSet.getMetaData();
			Map<String,Object> rowData=new HashMap<String,Object>();
			int count=md.getColumnCount();
			for(int i=1;i<=count;i++){
				rowData.put(md.getColumnLabel(i),resultSet.getObject(i));
			}
			list.add(mapToClass(rowData));
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}

		
		return list;
	}

	@Override
	public Category queryCategoryById(Integer id) {
		List<Object> paramsList=new ArrayList<Object>();   
		Category category=null;
		StringBuffer sql=new StringBuffer("SELECT id,name,parentId,type,iconClass  FROM easybuy_product_category where id = ? ");
		ResultSet resultSet=this.executeQuery(sql.toString(),new Object[]{id});
		try {
			judge=0;
			while (resultSet.next()) {
				category = this.tableToClass(resultSet);
			}
			if(category.getType()!=1){//如果不是以及主题，那么就再查一次
				judge=1;
				StringBuffer sql2 = new StringBuffer("SELECT e1.id,e1.name,e1.parentId,e1.type,e1.iconClass,e2.name as parentName "
						+ " FROM easybuy_product_category AS e1,easybuy_product_category AS e2 "
						+ "WHERE e2.id=? AND e1.id =? ");
				ResultSet resultSet2=this.executeQuery(sql.toString(),new Object[]{category.getParentId(),category.getId()});
				while (resultSet2.next()) {
					
					category = this.tableToClass(resultSet2);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return category;
	}

	@Override
	public Integer save(Category category) {
		Integer id=0;
    	try {
    		String sql=" INSERT into easybuy_product_category(name,parentId,type,iconClass) values(?,?,?,?) ";
            Object param[]=new Object[]{category.getName(),category.getParentId(),category.getType(),category.getIconClass()};
            id=this.executeInsert(sql,param);
            category.setId(id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }
    	return id;
	}

	@Override
	public Integer queryCategoryCount(CategoryParam params) {
		List<Object> paramsList=new ArrayList<Object>();   
		Integer count=0;
		StringBuffer sql=new StringBuffer("SELECT count(*) count FROM easybuy_product_category where 1=1 ");
		if(EmptyUtils.isNotEmpty(params.getName())){
			sql.append(" and name like ? ");
			paramsList.add("%"+params.getName()+"%");
		}
		if(EmptyUtils.isNotEmpty(params.getParentId())){
			sql.append(" and parentId = ? ");
			paramsList.add(params.getParentId());
		}
		ResultSet resultSet=this.executeQuery(sql.toString(), paramsList.toArray());
		try {
			while (resultSet.next()) {
				count=resultSet.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
			this.closeResource(resultSet);
		}
		return count;
	}

	@Override
	public void update(Category category) {
		try {
        	Object[] params = new Object[] {category.getName(),category.getParentId(),category.getType(),category.getIconClass(),category.getId()};
        	String sql = " UPDATE easybuy_product_category SET name=?,parentId=?,type=?,iconClass=? WHERE id =?  ";
    		this.executeUpdate(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        	this.closeResource();
        }	
	}

	public Category mapToClass(Map map) throws Exception {
		Category category = new Category();
		Object idObject=map.get("id");
		Object nameObject=map.get("name");
		Object parentIdObject=map.get("parentId");
		Object typeObject=map.get("type");
		Object iconClassObject=map.get("iconClass");
		Object parentNameObject=map.get("parentName");
		category.setId(EmptyUtils.isEmpty(idObject)?null:(Integer)idObject);
		category.setName(EmptyUtils.isEmpty(nameObject)?null:(String)nameObject);
		category.setParentId(EmptyUtils.isEmpty(parentIdObject)?null:(Integer)parentIdObject);
		category.setType(EmptyUtils.isEmpty(typeObject)?null:(Integer)typeObject);
		category.setIconClass(EmptyUtils.isEmpty(iconClassObject)?null:(String)iconClassObject);
		category.setParentName(EmptyUtils.isEmpty(parentNameObject)?null:(String)parentNameObject);
		return category;	
	}
	
	@Override
	public Category tableToClass(ResultSet rs) throws Exception {
		Category category = new Category();
		category.setId(rs.getInt("id"));
		category.setName(rs.getString("name"));
		category.setParentId(rs.getInt("parentId"));
		Integer parentId =category.getParentId();
		category.setType(rs.getInt("type"));
		if(parentId!=null&&parentId.intValue()!=0){
			category.setParentName(rs.getString("parentName"));
		}
		category.setIconClass(rs.getString("iconClass"));
		return category;
	}

	
}
