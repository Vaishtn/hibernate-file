package com.xworkz.desktop.desktop.service;

import java.util.List;

import com.xworkz.desktop.desktop.dao.LaptopDAO;
import com.xworkz.desktop.desktop.dao.LaptopDAOImpl;
import com.xworkz.desktop.desktop.dto.LaptopDTO;

public class LaptopServiceImpl implements LaptopService{
	private LaptopDAO pDAO;
	public LaptopServiceImpl() {
		pDAO= new LaptopDAOImpl();
	}
		@Override
		public void save(LaptopDTO laptopDTO) {
			// TODO Auto-generated method stub
			if (laptopDTO != null) {
				pDAO.save(laptopDTO);
			} else {
				System.out.println("object cant be empty");
			}

		}

		@Override
		public LaptopDTO getLaptopByName(int id) {
			// TODO Auto-generated method stub
			if (id > 0) {
				return pDAO.getLaptopByName(id);
			} else {
				System.out.println("Name cant be null");
			}
			return null;
		}

		@Override
		public void updatePriceByName(int id, String name, double price) {
			// TODO Auto-generated method stub
			if (name != null) {
				pDAO.updatePriceByName(id, name, price);
			} else {
				System.out.println("Name cannot be null");
			}
		}

		@Override
		public void deleteByName(int id, String name) {
			// TODO Auto-generated method stub
			if (name != null) {
				pDAO.deleteByName(id, name);
			} else {
				System.out.println("Name cant be null");
			}
		}

		@Override
		public List<LaptopDTO> getAllLoptop() {
			// TODO Auto-generated method stub
			
			return pDAO.getAllLoptop();
		}

		@Override
		public LaptopDTO getLaptopByLaptopId(int id) {
			// TODO Auto-generated method stub
			
			return pDAO.getLaptopByLaptopId(id);
		}

		@Override
		public String getColorByLaptopName(String pname) {
			// TODO Auto-generated method stub
			return pDAO.getColorByLaptopName(pname);
		}

		@Override
		public Object[] getNameAndPriceByColor(String color) {
			// TODO Auto-generated method stub
			return pDAO.getNameAndPriceByColor(color);
		}

		@Override
		public List<Object[]> getAllNameAndPriceByColor(String cname) {
			// TODO Auto-generated method stub
			return pDAO.getAllNameAndPriceByColor(cname);
		}

		@Override
		public int updatePriceByName(String name, double price) {
			// TODO Auto-generated method stub
			if(name!=null) {
				return pDAO.updatePriceByName(name,price);
			}
			return 0;
		}

		@Override
		public int updateColorByName(String name, String color) {
			// TODO Auto-generated method stub
			if(name!=null) {
				return pDAO.updateColorByName(name,color);
			}
			return 0;
		}

		@Override
		public int deleteByName(String name) {
			// TODO Auto-generated method stub
			if(name!=null) {
				return pDAO.deleteByName(name);
			}
			return 0;
		}

		@Override
		public int deleteByPrice(double price) {
			// TODO Auto-generated method stub
			
			if(price!=0) {
				return pDAO.deleteByPrice(price);
			}return 0;
		}

}
