package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class ExcelUtility {

	static FileInputStream f;//READ from excel
	static XSSFWorkbook w;//represents entire excel workbook
	static XSSFSheet sh;//represents excel sheet

	public static String readStringData(int row, int col,String sheet) throws IOException {
		f = new FileInputStream(Constant.TEST_DATA);//excel file path read
		w = new XSSFWorkbook(f);//to load excelfile into memory using apache poi
		sh = w.getSheet(sheet);//select sheet
		XSSFRow r = sh.getRow(row);//get the rw content based on row number passed as parameter.
		XSSFCell c = r.getCell(col);//get the col content based on col number passed as parameter.
		return c.getStringCellValue();//return as text format
		}
	
	public static String readIntegerData(int row, int col,String sheet) throws IOException {
		f = new FileInputStream(Constant.TEST_DATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);//get decimal value 
		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting(to remove decimal value)
		return String.valueOf(val);   //convert int to string using valueOf() method

	
	}

}
