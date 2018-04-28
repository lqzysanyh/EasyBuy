package cn.easybuy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 * @author Administrator
 *
 */
public class Order implements Serializable {
	public static final long serialVersionUID = 8366759716422180615L;
	
	//编号
	private Integer id;
	//用户ID
	private Integer userId;
	//用户登录名
	private String loginName;
	//用户地址
	private String userAddress;
	//创建时间
	private Date createTime;
	//金额
	private Float cost;
	//状态 1待审核，2审核通过，3配货，4卖家已发货，5已收货
	private Integer status;
	//类型
	private Integer type;
	//订单号
	private String serialNumber;
	
	private List<Detail> detailList;//订单明细列表
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Order(Integer id, Integer userId, String loginName, String userAddress, Date createTime, Float cost, Integer status,
			Integer type, String serialNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.loginName = loginName;
		this.userAddress = userAddress;
		this.createTime = createTime;
		this.cost = cost;
		this.status = status;
		this.type = type;
		this.serialNumber = serialNumber;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}


	public List<Detail> getDetailList() {
		return detailList;
	}


	public void setDetailList(List<Detail> detailList) {
		this.detailList = detailList;
	}
	
	
	
	
}
