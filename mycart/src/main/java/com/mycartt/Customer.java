package com.mycartt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    
	public Customer(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
    
    
    
}
