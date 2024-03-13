package com.mycartt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;





@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private OrderEntity order;

    @ManyToOne
    private Product product;

    private int quantity;

	public OrderItem(Long id, OrderEntity order, Product product, int quantity) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getId() {
		return id;
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

	
	public void setId(Long id) {
		this.id = id;
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

    // Other fields, getters, and setters

    // Constructors, getters, setters, and other methods
    
    
    
    
}

