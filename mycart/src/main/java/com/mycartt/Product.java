package com.mycartt;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pId;
    
	private String pName;
	
    @Column(length = 1500)
	private String pDescription;
    
	private int pPrice;
	
	private int pDiscount;
	
	@ManyToOne
	private Category category;
	
	public Product() {
		
	}


	private int pQuantity;
	
	
	public Product(Category category,String pName, String pDescription, int pPrice, int pDiscount, int pQuantity) {
		super();
		this.pName = pName;
		this.pDescription = pDescription;
		this.pPrice = pPrice;
		this.pDiscount = pDiscount;
		this.pQuantity = pQuantity;
		this.category = category;
	}




	public Category getCategory() {
		return category;
	}
	
	

	public void setCategory(Category category) {
		this.category = category;
	}




	public int getpId() {
		return pId;
	}


	public String getpName() {
		return pName;
	}


	public String getpDescription() {
		return pDescription;
	}


	public int getpPrice() {
		return pPrice;
	}


	public int getpDiscount() {
		return pDiscount;
	}


	public int getpQuantity() {
		return pQuantity;
	}


	public void setpId(int pId) {
		this.pId = pId;
	}


	public void setpName(String pName) {
		this.pName = pName;
	}


	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}


	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}


	public void setpDiscount(int pDiscount) {
		this.pDiscount = pDiscount;
	}


	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}


	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pDescription=" + pDescription + ", pPrice=" + pPrice
				+ ", pDiscount=" + pDiscount + ", pQuantity=" + pQuantity + "]";
	}
	
	

}
