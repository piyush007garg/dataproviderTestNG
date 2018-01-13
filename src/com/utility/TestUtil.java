package com.utility;

import java.util.ArrayList;

import com.XL.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;

	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData =new ArrayList<Object[]>();
		
		try{
			reader= new Xls_Reader("C:/Users/DELL/workspace/DataDriven/src/com/excel/FirstExcel.xls");
		}catch (Exception e){
			e.printStackTrace();
		}
		
		reader.addColumn("IRCTC", "Status");
		
		for(int rowNum =2;rowNum<=reader.getRowCount("IRCTC");rowNum++){
			String 	firstname = reader.getCellData("IRCTC", "firstname", rowNum);
			String 	lastname = reader.getCellData("IRCTC", "lastname", rowNum);
			String 	mobileName = reader.getCellData("IRCTC", "mobileName", rowNum);
			String 	password = reader.getCellData("IRCTC", "password", rowNum);
			
			Object ob[]= {firstname,lastname,mobileName,password};
			myData.add(ob);

			
			reader.setCellData("IRCTC", "Status", rowNum, "pass");
		}
		
		return myData;
	}
	
}
