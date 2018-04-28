package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ��ַ��
 * @author Administrator
 *
 */
public class Address implements Serializable{
	public static final long serialVersionUID = 8366759716422180611L;
	private Integer id;

    private String address;//��ַ

    private Integer userId;//�û�ID

    private Date createTime;//����ʱ��

    private String remark;//��ע

    
    
    public Address(Integer id, String address, Integer userId, Date createTime, String remark) {
		super();
		this.id = id;
		this.address = address;
		this.userId = userId;
		this.createTime = createTime;
		this.remark = remark;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
