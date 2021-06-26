package com.xworkz.cartoon.cartoon.service;

import java.util.List;

import com.xworkz.cartoon.cartoon.dao.CartoonDAO;
import com.xworkz.cartoon.cartoon.dao.CartoonDAOImpl;
import com.xworkz.cartoon.cartoon.dto.CartoonDTO;

public class CartoonServiceImpl implements CartoonService{
private CartoonDAO cDAO;
	
	public CartoonServiceImpl() {
		cDAO = new CartoonDAOImpl();
	}
	@Override
	public void save(CartoonDTO cartoonDTO) {
		if (cartoonDTO != null) {
			cDAO.save(cartoonDTO);
		} else {
			System.out.println("object cant be empty");
		}

		
	}

	@Override
	public CartoonDTO getCartoonById(int id) {
		if (id > 0) {
			return cDAO.getCartoonByName(id);
		} else {
			System.out.println("Name cant be null");
		}
		return null;
	}

	@Override
	public void updateRatingByName(int id, String name, int rating) {
		// TODO Auto-generated method stub
		if (name != null) {
			cDAO.updateRatingByName(id, name, rating);
		} else {
			System.out.println("Name cannot be null");
		}

	}

	@Override
	public void deleteByName(int id, String name) {
		if (name != null) {
			cDAO.deleteByName(id, name);
		} else {
			System.out.println("Name cant be null");
		}
		
	}

	@Override
	public List<CartoonDTO> getAllCartoon() {
		return cDAO.getAllCartoon();
	}

	@Override
	public CartoonDTO getCartoonByCartoonId(int id) {
		return cDAO.getCartoonByCartoonId(id);
	}

	@Override
	public String getChannelNameByCartoonCharacterName(String characterName) {
		return cDAO.getChannelNameByCartoonCharacterName(characterName);
	}

	@Override
	public Object[] getNameAndRatingByChannelName(String cName) {
		// TODO Auto-generated method stub
		return cDAO.getNameAndRatingByChannelName(cName);
	}
	@Override
	public List<Object[]> getAllNameAndRatingByChannelName(String chName) {
		// TODO Auto-generated method stub
		return cDAO.getAllNameAndRatingByChannelName(chName);
	}
}
