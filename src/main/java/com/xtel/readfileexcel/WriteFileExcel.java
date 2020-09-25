/**
 * 
 */
package com.xtel.readfileexcel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author TUAN
 *
 */
public class WriteFileExcel {

	Logger logger = Logger.getLogger(WriteFileExcel.class);
	
	public void writeFileExcel() throws IOException{
		logger.info("Writing file excel...");
		XSSFWorkbook workbook = new XSSFWorkbook();
		// create sheet
		XSSFSheet sheet = workbook.createSheet("Employee_Info");
		logger.warn("Creating sheet successful !");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		firstCell.setCellValue("List info employees");
		List<Employee> listemployees = new ArrayList<Employee>();
		//insert data
		listemployees.add(new Employee("NV001", "Bui Van Tuan", "buivtuan103@gmail.com", "Bac Giang", 50000));
		listemployees.add(new Employee("NV002", "Bui Van Tuan", "buivtuan103@gmail.com", "Bac Giang", 50000));
		
		for (Employee e1 : listemployees) {
			Row row = sheet.createRow(rowNum++);
			Cell c1 = row.createCell(0);
			c1.setCellValue(e1.getMaSV());
			Cell c2 = row.createCell(1);
			c2.setCellValue(e1.getTenSV());
			Cell c3 = row.createCell(2);
			c3.setCellValue(e1.getEmail());
			Cell c4 = row.createCell(3);
			c4.setCellValue(e1.getDiaChi());
			Cell c5 = row.createCell(4);
			c5.setCellValue(e1.getLuong());
			logger.info("MaNV: "+e1.getMaSV()+" TenNV: "+e1.getTenSV()+" Email: "+e1.getEmail()
			+" DiaChi: "+e1.getDiaChi()+" Luong: "+e1.getLuong());
		}
		
		File file = new File("C:\\log\\Book1.xlsx");
		if(file.exists()) {
			logger.info("Create file excel successful.!");
			logger.info("Path file: "+file.getPath());
			try {
				FileOutputStream fos = new FileOutputStream(file);
				workbook.write(fos);
				logger.info("Write file exxcel successful !");
				workbook.close();
			} catch (FileNotFoundException f) {
//				f.printStackTrace();
				logger.error("Error while write file excel. Message: "+f.getMessage());
			} catch (Exception e3) {
//				e3.printStackTrace();
				logger.error("Error: "+e3.getMessage());
			}
//			if(file.delete()==true) {
//				logger.info("Delete file excel successful!");
//			}
//			else {
//				logger.error("Delete file excel fail");
//			}
		}
		else {
			logger.error("Create file fail");
		}	
	}

}
