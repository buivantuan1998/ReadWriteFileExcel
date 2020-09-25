/**
 * 
 */
package com.xtel.readfileexcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author TUAN
 *
 */
public class ReadFileExcel {
	
	Logger logger = Logger.getLogger(ReadFileExcel.class);

	//Read file excel
		public void readFileExcel() throws IOException{
			logger.info("Reading file excel...");
			File file = new File("C:\\log\\Book1.xlsx");
			if(file.exists()) {
				logger.info("Path file: "+file.getPath());
				try {
					FileInputStream fis = new FileInputStream(file);
					Workbook workbook = new XSSFWorkbook(fis);
					Sheet sheet = workbook.getSheetAt(0);
					logger.info("Name sheet: "+sheet.getSheetName());
					DataFormatter dft = new DataFormatter();
					Iterator<Row> iterator = sheet.iterator();
					Row firstRow = iterator.next();
					Cell firstCell = firstRow.getCell(0);
					logger.info("Title: "+firstCell);
					List<Employee> listemployees = new ArrayList<Employee>();
					while(iterator.hasNext()) {
						Row currentRow = iterator.next();
						logger.info("Row: "+currentRow.getRowNum());
						Employee e = new Employee();
						e.setMaSV(currentRow.getCell(0).getStringCellValue());
						e.setTenSV(currentRow.getCell(1).getStringCellValue());
						e.setEmail(currentRow.getCell(2).getStringCellValue());
						e.setDiaChi(currentRow.getCell(3).getStringCellValue());
						e.setLuong(Double.parseDouble(dft.formatCellValue(currentRow.getCell(4))));
						logger.info("MaNV: "+e.getMaSV()+" TenNV: "+e.getTenSV()+" Email: "+e.getEmail()
						+" DiaChi: "+e.getDiaChi()+" Luong: "+e.getLuong());
						listemployees.add(e);
					}
					
					//Show info data employee
					System.out.println(firstCell.getStringCellValue());
					for (Employee e : listemployees) {
						System.out.println("MaNV: "+e.getMaSV()+" TenNV: "+e.getTenSV()+" Email: "+e.getEmail()
						+" DiaChi: "+e.getDiaChi()+" Luong: "+e.getLuong());
					}
					
					workbook.close();
				} catch (FileNotFoundException e) {
//					e.printStackTrace();
					logger.error("Error while read file. Message: "+e.getMessage());
				}catch (Exception e) {
//					e.printStackTrace();
					logger.error("Error: "+e.getMessage());
				}
			}
			else {
				logger.error("Not foud file");
			}
		}
}
