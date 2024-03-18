package com.mycartt;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private int pid;

    @Column(length = 100)
    private String pname;

    private double pprice;
    private double pdiscount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

	public Product(int pid, String pname, double pprice, double pdiscount, List<OrderItem> orderItems) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pdiscount = pdiscount;
		this.orderItems = orderItems;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}

	public double getPprice() {
		return pprice;
	}

	public double getPdiscount() {
		return pdiscount;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public void setPprice(double pprice) {
		this.pprice = pprice;
	}

	public void setPdiscount(double pdiscount) {
		this.pdiscount = pdiscount;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pdiscount=" + pdiscount
				+ ", orderItems=" + orderItems + "]";
	}

    
}

