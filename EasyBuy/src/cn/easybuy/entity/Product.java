package cn.easybuy.entity;

import java.io.Serializable;

/**
 * 商品表
 * @author Administrator
 *
 */
public class Product implements Serializable{
	public static final long serialVersionUID = 8366759716422180613L;
	
	//编号
	private Integer id;
	//名字
	private String name;
	//描述
	private String description;
	//价格
	private Float price;
	//库存
	private Integer stock;
	//所属分类ID
	private Integer categoryLevel1Id;
	//所属二级分类ID
	private Integer categoryLevel2Id;
	//所属三级分类ID
	private Integer categoryLevel3Id;
	//上传的文件名
	private String fileName;
	//是否删除 1删除，0未删除
	private Integer idDelete;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer id, String name, String description, Float price, Integer stock, Integer categoryLevel1Id,
			Integer categoryLevel2Id, Integer categoryLevel3Id, String fileName, Integer idDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLevel1Id = categoryLevel1Id;
		this.categoryLevel2Id = categoryLevel2Id;
		this.categoryLevel3Id = categoryLevel3Id;
		this.fileName = fileName;
		this.idDelete = idDelete;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getCategoryLevel1Id() {
		return categoryLevel1Id;
	}
	public void setCategoryLevel1Id(Integer categoryLevel1Id) {
		this.categoryLevel1Id = categoryLevel1Id;
	}
	public Integer getCategoryLevel2Id() {
		return categoryLevel2Id;
	}
	public void setCategoryLevel2Id(Integer categoryLevel2Id) {
		this.categoryLevel2Id = categoryLevel2Id;
	}
	public Integer getCategoryLevel3Id() {
		return categoryLevel3Id;
	}
	public void setCategoryLevel3Id(Integer categoryLevel3Id) {
		this.categoryLevel3Id = categoryLevel3Id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getIdDelete() {
		return idDelete;
	}
	public void setIdDelete(Integer idDelete) {
		this.idDelete = idDelete;
	}
	
	
}
