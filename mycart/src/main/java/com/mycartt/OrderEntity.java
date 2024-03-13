package com.mycartt;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    
	public OrderEntity(Long id, User user, List<OrderItem> orderItems) {
		super();
		this.id = id;
		this.user = user;
		this.orderItems = orderItems;
	}

	
	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	
	public User getUser() {
		return user;
	}

	
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public void setUser(User user) {
		this.user = user;
	}

	
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
    // Other fields, getters, and setters

    // Constructors, getters, setters, and other methods
    
}

