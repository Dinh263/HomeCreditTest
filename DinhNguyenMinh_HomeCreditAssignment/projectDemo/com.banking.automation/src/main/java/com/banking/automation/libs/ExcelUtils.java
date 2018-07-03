package com.banking.automation.libs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtils {
	
	private XSSFWorkbook wb;
	private XSSFSheet sheet;
	public ExcelUtils(String fileName, String sheetName) throws IOException {
		File fileExcel = new File (fileName);
		InputStream inputStr = new FileInputStream(fileExcel);
		wb = new XSSFWorkbook(inputStr);
		sheet = wb.getSheet(sheetName);
	}
	
	
	/**
	 * This function is used for get total rows in a sheet.
	 * @return total row number.
	 */
	public int getTotalRows() {
		try {
			return sheet.getLastRowNum()-sheet.getFirstRowNum();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return -1;
		}
	}
	
	/**
	 * This function is used for get total column in a sheet.
	 * @return total column number.
	 */
	public int getTotalColumns() {
		return sheet.getRow(0).getLastCellNum();
	}
	
	/**
	 * This function is used for getting the value at the row number and column number.
	 * @param rowNum row number.
	 * @param colNum column number.
	 * @return
	 */
	public String getValueAt(int rowNum, int colNum) {
		try {
			if(rowNum<0) {
				return "";
			}
			
			XSSFRow row = sheet.getRow(rowNum);
			if(row == null) {
				return "";
			}
			
			XSSFCell cell = row.getCell(colNum);
			if(cell==null) {
				return "";
			}
			
			if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
				return cell.getErrorCellString();
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 +"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cellText;
				}
				return cellText;
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
			else {
				return String.valueOf(cell.getBooleanCellValue());
			}
			
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return "row: "+rowNum+" and column: "+colNum+" dont exist";
		}
	}
	
	/**
	 * This function is used for getting the value at column name and row number.
	 * @param colName column name. 
	 * @param rowNum row number.
	 * @return
	 */
	public String getValueAt(String colName, int rowNum) {
		try {
			if(rowNum<0) {
				return "";
			}
			int col_Num = -1;
			XSSFRow row = sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++) {
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
					col_Num=i;
					break;
				}
			}
			
			if(col_Num==-1) {
				return "";
			}
			row = sheet.getRow(rowNum);
			if(row==null) {
				return "";
			}
			
			XSSFCell cell = row.getCell(col_Num);
			if(cell == null) {
				return "";
			}
			
			if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue();
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String cellText = String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell)) {
					double d = cell.getNumericCellValue();
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 +"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+cellText;
				}
				return cellText;
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK) {
				return "";
			}
			else {
				return String.valueOf(cell.getBooleanCellValue());
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return "row: "+rowNum+" and column name: "+colName+" dont exist";
		}
	}

	/**
	 * This function is used for getting data source (array 2 dimension) for data driven testing.
	 * @return Object[][]
	 */
	public Object[][] getDataSource(){
		int totalRows = getTotalRows();
		int totalCols = getTotalColumns();
		Object[][] data = new Object[totalRows][totalCols];
		for(int i= 0;i<totalRows;i++) {
			for(int j =0 ;j<totalCols;j++) {
				int temp = i+1;
				data[i][j]=getValueAt(temp, j);
			}
		}
		return data;
	}
}
