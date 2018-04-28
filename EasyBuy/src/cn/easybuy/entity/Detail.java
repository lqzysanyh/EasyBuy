package cn.easybuy.entity;

import java.io.Serializable;
/**
 * ���������
 * @author Administrator
 *
 */
public class Detail implements Serializable {
	private static final long serialVersionUID = 8366759716422180616L;
	//���
	private Integer id;
	//����ID
	private Integer orderId;
	//��ƷID
	private Integer productId;
	//����
	private Integer quantity;
	//���
	private Float cost;
	
	private Product product;//��Ʒ
	
	public Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Detail(Integer id, Integer orderId, Integer productId, Integer quantity, Float cost) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.cost = cost;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
