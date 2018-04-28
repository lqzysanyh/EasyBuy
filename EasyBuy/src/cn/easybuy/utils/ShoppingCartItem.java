package cn.easybuy.utils;

import cn.easybuy.entity.Product;

import java.io.Serializable;

/**
 * ���ﳵ������
 * @author Administrator
 *
 */

public class ShoppingCartItem implements Serializable{
	private Product product;//��Ʒ
	private Integer quantity;//����
	private float cost;//�۸�

	public ShoppingCartItem(Product product, Integer quantity) {
		this.product = product;
		this.quantity = quantity;
		this.cost = product.getPrice() * quantity;
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
}
