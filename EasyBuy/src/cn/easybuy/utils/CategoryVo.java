package cn.easybuy.utils;

import java.io.Serializable;
import java.util.List;

import cn.easybuy.entity.Category;
import cn.easybuy.entity.Product;

/**
 * 商品分类工具类
 * @author Administrator
 *
 */
public class CategoryVo implements Serializable{
	 	private Category category;
	    private List<CategoryVo> categoryList;
	    private List<Product> productList;
	    
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public List<CategoryVo> getCategoryVoList() {
			return categoryList;
		}
		public void setCategoryVoList(List<CategoryVo> categoryList) {
			this.categoryList = categoryList;
		}
		public List<Product> getProductList() {
			return productList;
		}
		public void setProductList(List<Product> productList) {
			this.productList = productList;
		}

	   
}
