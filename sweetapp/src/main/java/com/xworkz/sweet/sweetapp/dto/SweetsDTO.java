package com.xworkz.sweet.sweetapp.dto;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sweet_table")
public class SweetsDTO implements Serializable {
	@Id
	@Column(name="sweet_id")
	private int sweet_id;
	@Column(name="sweet_name")
	private String name;
	@Column(name="sweet_color")
	private String color;
	@Column(name="sweet_price")
	private double price;
	@Column(name="sweet_shape")
	private String shape;
	
	public SweetsDTO() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

	

	@Override
	public String toString() {
		return "SweetsDTO [sweet_id=" + sweet_id + ", name=" + name + ", color=" + color + ", price=" + price
				+ ", shape=" + shape + "]";
	} 



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public int getSweet_id() {
		return sweet_id;
	}

	public void setSweet_id(int sweet_id) {
		this.sweet_id = sweet_id;
	}
	
}
