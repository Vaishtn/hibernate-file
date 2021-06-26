package com.xworkz.desktop.desktop.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "laptop")
public class LaptopDTO implements Serializable{
	@Id
	@Column(name = "laptop_id")

	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int laptopId;

	@Column(name = "laptop_name")
	private String laptopName;

	@Column(name = "color")
	private String laptopColor;

	@Column(name = "price")
	private double laptopPrice;

	public LaptopDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
	}

	public String getLaptopColor() {
		return laptopColor;
	}

	public void setLaptopColor(String laptopColor) {
		this.laptopColor = laptopColor;
	}

	public double getLaptopPrice() {
		return laptopPrice;
	}

	public void setLaptopPrice(double laptopPrice) {
		this.laptopPrice = laptopPrice;
	}

	@Override
	public String toString() {
		return "LaptopDTO [laptopId=" + laptopId + ", laptopName=" + laptopName + ", laptopColor=" + laptopColor
				+ ", laptopPrice=" + laptopPrice + "]";
	}


}
