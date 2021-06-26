package com.xworkz.cartoon.cartoon.dao;

import java.util.List;

import com.xworkz.cartoon.cartoon.dto.CartoonDTO;

public interface CartoonDAO {
	public void save(CartoonDTO cartoonDTO);

	public CartoonDTO getCartoonByName(int id);

	public void updateRatingByName(int id, String name, int rating);

	public void deleteByName(int id, String name);

	public List<CartoonDTO> getAllCartoon();

	public CartoonDTO getCartoonByCartoonId(int id);

	public String getChannelNameByCartoonCharacterName(String characterName);

	public Object[] getNameAndRatingByChannelName(String cName);
	
	public List<Object[]> getAllNameAndRatingByChannelName(String chName);


}
