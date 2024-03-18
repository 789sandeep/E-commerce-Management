package com.mycartt;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();



	public OrderEntity(int orderId, User user, Customer customer, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.customer = customer;
		this.orderItems = orderItems;
	}

	public OrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public User getUser() {
		return user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

    
}

