package cn.easybuy.entity;

import java.io.Serializable;

/**
 * ��Ʒ������
 * @author Administrator
 *
 */
public class Category implements Serializable{
	public static final long serialVersionUID = 8366759716422180614L;
	//���
	private Integer id;
	//����
	private String name;
	//������
	private Integer parentId;
	//���� 1һ�����࣬2�������࣬3��������
	private Integer type;
	private String iconClass;
	private String parentName;
	
	
	public Category(Integer id){
		this.id=id;
	}
	
	
	public Category(Integer id, String name, Integer parentId, Integer type, String iconClass, String parentName) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
		this.iconClass = iconClass;
		this.parentName = parentName;
	}
	public Category(Integer id, String name, Integer parentId, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.parentId = parentId;
		this.type = type;
	}
	public Category() {
		super();
	}

	public int getId() {
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
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getIconClass() {
		return iconClass;
	}
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	
}
