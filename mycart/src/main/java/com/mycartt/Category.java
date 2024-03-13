package com.mycartt;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

	public Category(Long id, String name, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	
	public List<Product> getProducts() {
		return products;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public void setProducts(List<Product> products) {
		this.products = products;
	}

    // Other fields, getters, and setters

    // Constructors, getters, setters, and other methods
    
    
}
