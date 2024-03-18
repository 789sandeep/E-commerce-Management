package com.mycartt;


import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int itemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

	public int getItemId() {
		return itemId;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderItem(int itemId, OrderEntity order, Product product, int quantity) {
		super();
		this.itemId = itemId;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", order=" + order + ", product=" + product + ", quantity=" + quantity
				+ "]";
	}

	

    
}


