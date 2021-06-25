package com.xworkz.ipl.IplTeam.service;

import com.xworkz.ipl.IplTeam.dto.IplTeamDTO;

public interface IplTeamService {
	public void validateAndSave(IplTeamDTO iplDTO);

	public IplTeamDTO validateAndGetDetailsByName(String name,int id);

	public void validateAndDeleteById(int idd);

	public void validateAndUpdateRangeByName(String name,int id, int players);


}
