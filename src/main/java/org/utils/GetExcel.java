package org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcel {
	
	public static List<String> fetch(String pathName, String sheetName, int rowNo) throws IOException { 
		
	List<String> stringList = new ArrayList<>();
	
	File file = new File(pathName); 
	FileInputStream stream = new FileInputStream(file); 
	Workbook workbook = new XSSFWorkbook(stream) ; 
	Sheet sheet =workbook.getSheet (sheetName) ; 
	Row row = sheet.getRow(rowNo) ;
	
	for (int i =0; i < row.getLastCellNum(); i++) { 
			Cell cell = row.getCell(i);
			CellType type = cell.getCellType(); 
			
				switch(type) {
					case STRING: 
						stringList.add(cell.getStringCellValue());
						break; 
						
					case NUMERIC: 
						if(DateUtil.isCellDateFormatted(cell)) {
							
							Date dateCellValue = cell.getDateCellValue(); 
							SimpleDateFormat sdm = new SimpleDateFormat("MM/dd/yyyy"); 
							stringList.add(sdm.format(dateCellValue));
							
						} else{ 
							
								double numericCellValue = cell.getNumericCellValue();
								long l = (long) numericCellValue;
								stringList.add(String.valueOf(l)); 
								
								}
						
							break; 
							
						
						default: 
							break;
							}
	}
						
			workbook.close(); 
			return (stringList);
			}
	
	}

	
	
	


