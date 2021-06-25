package com.xworkz.ipl.IplTeam;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.xworkz.ipl.IplTeam.dto.IplTeamDTO;
import com.xworkz.ipl.IplTeam.service.IplTeamService;
import com.xworkz.ipl.IplTeam.service.IplTeamServiceImpl;

public class Tester {
public static void main(String[] args) throws IOException {
		
		System.out.println("Ipl data ");
		Scanner sc = new Scanner(System.in);
		System.out.println("How do you prefer adding data:");
		System.out.println("Press \"D\" to enter dynamically or press \" E \"to import from Excel ");
		if(sc.next().equalsIgnoreCase("D")) {
		
		
		System.out.println("Enter no of new records to store");
		int rec = sc.nextInt();
		for(int i=0;i<rec;i++) {
			
			System.out.println("enter team  name");
			String s1 = sc.next();
			System.out.println("enter  no of players in team");
			int p1 = sc.nextInt();
			System.out.println("enter team home location");
			String s3 = sc.next();
			
		IplTeamDTO iplDTO = new IplTeamDTO();
		iplDTO.setTeamName(s1);
		iplDTO.setNoOfPlayers(p1);
		iplDTO.setLocation(s3);
		
		IplTeamService iplService = new IplTeamServiceImpl();
		iplService.validateAndSave(iplDTO);
		
		}
		}
		else {
			readXLSXFile("C:\\Users\\DELL\\Desktop\\exel\\IplTeam.xlsx");
			
		}
		
		System.out.println("Enter no of details to get by Name:");
		int up = sc.nextInt();
		for(int j=0;j<up;j++) {
			
			System.out.println("Enter team name");
			String name = sc.next();
			System.out.println("Enter correct team id");
			int id1 = sc.nextInt();			
		IplTeamService iplService = new IplTeamServiceImpl();

		IplTeamDTO iDTO= iplService.validateAndGetDetailsByName(name,id1);
		
		writeXLSXFile("C:\\Users\\DELL\\Desktop\\exel\\IplTeam.xlsx",iDTO);
		
		
		
		
		}
}

private static void writeXLSXFile(String file1, IplTeamDTO iDTO)throws IOException {
	// TODO Auto-generated method stub
	XSSFWorkbook wrk = new XSSFWorkbook();
	XSSFSheet sht = wrk.createSheet("Sheet2");
	
	sht.createRow(iDTO.getTeamId());
	sht.getRow((iDTO.getTeamId())).createCell(0).setCellValue(iDTO.getTeamId());
	sht.getRow((iDTO.getTeamId())).createCell(1).setCellValue(iDTO.getTeamName());
	sht.getRow((iDTO.getTeamId())).createCell(2).setCellValue(iDTO.getNoOfPlayers());
	sht.getRow((iDTO.getTeamId())).createCell(3).setCellValue(iDTO.getLocation());
	
	FileOutputStream osfile = null;
	try {
		osfile = new FileOutputStream(file1);
		wrk.write(osfile);
	} catch (IOException e) {
		e.printStackTrace();
	} 
	
	wrk.close();
	
}

private static void readXLSXFile(String file) {
	// TODO Auto-generated method stub
	try {
		XSSFWorkbook work=new XSSFWorkbook(new FileInputStream(file));
		XSSFSheet sheet=work.getSheet("Sheet1");
	//XSSFRow row=sheet.getRow(1);
		XSSFRow row =null;
		
		int i=1;
		while((row=sheet.getRow(i))!=null) {
			IplTeamDTO ipldto=new IplTeamDTO();
		
			ipldto.setTeamName(row.getCell(1).getStringCellValue());
			
		int m=(int)(row.getCell(2).getNumericCellValue());
		ipldto.setNoOfPlayers(m);
	ipldto.setLocation(row.getCell(3).getStringCellValue());
		i++;
		IplTeamService iplService = new IplTeamServiceImpl();
		iplService.validateAndSave(ipldto);
		
		}
		
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}



}
