package cn.easybuy.entity;

import java.io.Serializable;

public class ShoppingCart  implements Serializable{
	private Integer id;//���
	private User user;//�û�
	private Product product;//��Ʒ
	private Integer quantity;//����
	private float cost;//�۸�

	public ShoppingCart(){
		
	}

	public ShoppingCart(Integer id,User user,Product product, Integer quantity) {
		this.id=id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.cost = product.getPrice() * quantity;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
		this.cost = product.getPrice() * quantity;
	}

	public Product getProduct() {
		return product;
	}

	public float getCost() {
		return cost;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
