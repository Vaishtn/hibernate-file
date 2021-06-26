package com.xworkz.cartoon.cartoon.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name = "cartoon")
public class CartoonDTO {
	@Id
	@Column(name="cartoon_id")
	
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	private int cartoonId;
	
	@Column(name="cartoon_character_name")
	private String cartoonCharacterName;
	
	@Column(name="channel_name")
	private String channelName;
	
	@Column(name="rating")
	private int rating;
	
	public CartoonDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getCartoonId() {
		return cartoonId;
	}

	public void setCartoonId(int cartoonId) {
		this.cartoonId = cartoonId;
	}

	public String getCartoonCharacterName() {
		return cartoonCharacterName;
	}

	public void setCartoonCharacterName(String cartoonCharacterName) {
		this.cartoonCharacterName = cartoonCharacterName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "CartoonDTO [cartoonId=" + cartoonId + ", cartoonCharacterName=" + cartoonCharacterName
				+ ", channelName=" + channelName + ", rating=" + rating + "]";
	}
}
