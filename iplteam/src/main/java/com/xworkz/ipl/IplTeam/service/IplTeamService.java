package com.xworkz.ipl.IplTeam.service;

import java.util.List;

import com.xworkz.ipl.IplTeam.dto.IplTeamDTO;

public interface IplTeamService {
	public void validateAndSave(IplTeamDTO iplDTO);

	public IplTeamDTO validateAndGetDetailsByName(String name,int id);

	public void validateAndDeleteById(int idd);

	public void validateAndUpdateRangeByName(String name,int id, int players);
	public List<IplTeamDTO> validateAndGetAllDetails();

	public String validateAndGetIplTeamLocationByIplTeamName(String name);

	public IplTeamDTO validateAndGetDetailsByIplTeamName(String name);

	public Object[] validateAndGetIplTeamLocationAndNoOfPlayersByIplTeamName(String name);



}
