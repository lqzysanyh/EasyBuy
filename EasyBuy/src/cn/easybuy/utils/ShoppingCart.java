package cn.easybuy.utils;

import cn.easybuy.entity.Order;
import cn.easybuy.entity.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ﳵ��
 * @author Administrator
 *
 */
public class ShoppingCart implements Serializable{
	public List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
	private Double sum;

	//��ȡ���ﳵ��������Ʒ
	public List<ShoppingCartItem> getItems() {
		return items;
	}	
	//���һ��
	public ReturnResult addItem(Product product, Integer quantity) {
		ReturnResult result=new ReturnResult();
		int flag=0;
		for(int i=0;i<items.size();i++){
			//�жϹ��ﳵ���Ƿ����д���Ʒ����������ۼ�����
			if((items.get(i).getProduct().getId()).equals(product.getId())){
				if(items.get(i).getQuantity()+quantity>product.getStock()){
					return result.returnFail("��Ʒ��������");
				}else{
					items.get(i).setQuantity(items.get(i).getQuantity()+quantity);
					flag=1;
				}
			}
		}
		if(quantity>product.getStock()){
			return result.returnFail("��Ʒ��������");
		}
		if(flag==0){
			items.add(new ShoppingCartItem(product, quantity));
		}
		return result.returnSuccess();
	}

	//�Ƴ�һ��
	public void removeItem(int index) {
		items.remove(index);
	}

	//�޸�����
	public void modifyQuantity(int index, Integer quantity) {
		items.get(index).setQuantity(quantity);
	}

	//�����ܼ۸�
	public float getTotalCost() {
		float sum = 0;
		for (ShoppingCartItem item : items) {
			sum = sum + item.getCost();
		}
		return sum;
	}

	public void setItems(List<ShoppingCartItem> items) {
		this.items = items;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}
}
