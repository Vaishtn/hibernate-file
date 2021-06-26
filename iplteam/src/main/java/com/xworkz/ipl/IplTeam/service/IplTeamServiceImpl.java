package com.xworkz.ipl.IplTeam.service;

import java.util.List;

import com.xworkz.ipl.IplTeam.dao.IplTeamDAO;
import com.xworkz.ipl.IplTeam.dao.IplTeamDAOImpl;
import com.xworkz.ipl.IplTeam.dto.IplTeamDTO;

public class IplTeamServiceImpl implements IplTeamService {
private IplTeamDAO iplDAO;
	
	public IplTeamServiceImpl() {
		iplDAO = new IplTeamDAOImpl();
	}
	
	

	public void validateAndSave(IplTeamDTO iplDTO) {
		if(iplDTO!=null) {
			
			iplDAO.save(iplDTO);
			
		}
		else {
			System.out.println("Object cant be empty");
		}
		
	}



	public IplTeamDTO validateAndGetDetailsByName(String name,int id) {
		
		if(name!= null) {
			return iplDAO.getDetailsByName(name,id);
		}
		else {
			System.out.println("name cant be empty");
		}
		return null;
	}



	public void validateAndDeleteById(int idd) {
		if(idd!=0) {
			iplDAO.deleteDetails(idd);
		}
		else {
			System.out.println("id cant be empty");
		}
	}



	public void validateAndUpdateRangeByName(String name,int id, int players) {
		if(name!=null&&players>10&&players<14) {
			iplDAO.updateDetails(name,id,players);
		}
		
	}



	@Override
	public List<IplTeamDTO> validateAndGetAllDetails() {
		// TODO Auto-generated method stub
		return iplDAO.getAllDetails();

	}



	@Override
	public String validateAndGetIplTeamLocationByIplTeamName(String name) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return iplDAO.getIplTeamLocationByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}
		
		return null;
	}



	@Override
	public IplTeamDTO validateAndGetDetailsByIplTeamName(String name) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return iplDAO.getDetailsByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}

		return null;
	}



	@Override
	public Object[] validateAndGetIplTeamLocationAndNoOfPlayersByIplTeamName(String name) {
		// TODO Auto-generated method stub
		if(name!=null) {
			return iplDAO.getIplTeamLocationAndNoOfPlayersByIplTeamName(name);
		}
		else {
			System.out.println("name cant be empty");
		}

		return null;
	}
}
