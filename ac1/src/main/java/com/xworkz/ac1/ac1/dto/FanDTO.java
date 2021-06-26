package com.xworkz.ac1.ac1.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor

@Entity
@Table(name = "fan")
public class FanDTO implements Serializable{
	@Id
	@Column(name="fan_id")
	
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int fanId;
	
	@Column(name="fan_id")
	private String fanName;
	
	@Column(name="color")
	private String fanColor;
	
	@Column(name="price")
	private String fanPrice;

}
