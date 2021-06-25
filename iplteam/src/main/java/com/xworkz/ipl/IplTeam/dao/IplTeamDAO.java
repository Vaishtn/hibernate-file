package com.xworkz.ipl.IplTeam.dao;

import com.xworkz.ipl.IplTeam.dto.IplTeamDTO;

public interface IplTeamDAO {
	 public void save(IplTeamDTO iplDTO);

		public IplTeamDTO getDetailsByName(String name,int id);

		public void deleteDetails(int idd);

		public void updateDetails(String name, int id, int players);
		

}
