package com.mycartt;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int customerId;

    @Column(length = 100)
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<OrderEntity> orders = new ArrayList<>();

	public Customer(int customerId, String name, List<OrderEntity> orders) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.orders = orders;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", orders=" + orders + "]";
	}

    
}

