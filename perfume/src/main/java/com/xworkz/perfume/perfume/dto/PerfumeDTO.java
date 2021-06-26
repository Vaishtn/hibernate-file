package com.xworkz.perfume.perfume.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "perfume_table")
public class PerfumeDTO {
@Id
	
	@GeneratedValue(strategy= GenerationType.AUTO) 
	@Column(name ="perfume_id")
	private int perfumeId;
	@Column(name ="perfume_name")
	private String perfumeName;
	@Column(name ="perfume_color")
	private String perfumeColor;
	@Column(name ="perfume_price")
	private double perfumePrice;
	@Column(name ="perfume_fragnance")
	private String perfumeFragnance;
	
	public PerfumeDTO() {
		System.out.println(this.getClass().getSimpleName()+"created");
		
	}
	

	@Override
	public String toString() {
		return "PerfumeDTO [perfumeId=" + perfumeId + ", perfumeName=" + perfumeName + ", perfumeColor=" + perfumeColor
				+ ", perfumePrice=" + perfumePrice + ", perfumeFragnance=" + perfumeFragnance + "]";
	}


	public int getPerfumeId() {
		return perfumeId;
	}

	public void setPerfumeId(int perfumeId) {
		this.perfumeId = perfumeId;
	}

	public String getPerfumeName() {
		return perfumeName;
	}

	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}

	public String getPerfumeColor() {
		return perfumeColor;
	}

	public void setPerfumeColor(String perfumeColor) {
		this.perfumeColor = perfumeColor;
	}

	public double getPerfumePrice() {
		return perfumePrice;
	}

	public void setPerfumePrice(double perfumePrice) {
		this.perfumePrice = perfumePrice;
	}

	public String getPerfumeFragnance() {
		return perfumeFragnance;
	}

	public void setPerfumeFragnance(String perfumeFragnance) {
		this.perfumeFragnance = perfumeFragnance;
	}
	
	
	
	
	


}
