package com.xworkz.colddrinks.colddrinks.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="soft_drinks_table")

public class SoftDrinksDTO implements Serializable{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="soft_drink_name")
	private String name;
	
	@Column(name="soft_drink_price")
	private double price;
	
	@Column(name="soft_drink_color")
	private String color;
	
	@Column(name="soft_drik_mfg_year")
	private int mfgYear;

	@Override
	public String toString() {
		return "SoftDrinksDTO [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", mfgYear="
				+ mfgYear + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getMfgYear() {
		return mfgYear;
	}

	public void setMfgYear(int mfgYear) {
		this.mfgYear = mfgYear;
	}
	
	
	

}
