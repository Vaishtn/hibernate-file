package com.xworkz.ipl.IplTeam;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXLSX {
	public static void main(String[] args) {
		readXLSXFILE("C:\\Users\\DELL\\Desktop\\exel\\IplTeam.xlsx");
	}

	private static void readXLSXFILE(String file ) {
		// TODO Auto-generated method stub
		try {
			XSSFWorkbook work=new XSSFWorkbook(new FileInputStream(file));
			XSSFSheet sheet=work.getSheet("Sheet1");
		//XSSFRow row=sheet.getRow(1);
			XSSFRow row;
			int i=0;
			while((row=sheet.getRow(i))!=null) {
				System.out.println("cust id:"+row.getCell(1).getStringCellValue());
			System.out.println("cust Name:"+row.getCell(1).getStringCellValue());
			i++;
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
