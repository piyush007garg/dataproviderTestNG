package com.script;

import com.XL.Xls_Reader;

public class LoginPage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		Xls_Reader reader = new Xls_Reader("C:/Users/DELL/workspace/DataDriven/src/com/excel/FirstExcel.xls");
		int rowCount = reader.getRowCount("IRCTC");
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++){
		
		
		String data = reader.getCellData("IRCTC", "firstname", rowNum);
		System.out.println(data);
		}
	}

}
