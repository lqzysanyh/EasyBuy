package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ѷ��
 * @author Administrator
 *
 */
public class News implements Serializable{
	public static final long serialVersionUID = 8366759716422180612L;

	//���
	private Integer id ;
	//����
	private String title;
	//����
	private String content;
	//¼������
	private Date createTime;
	
	
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	public News(Integer id, String title, String content, Date createTime) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.createTime = createTime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}
