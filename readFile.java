package Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readFile {
	public static List<Account> getAccFromExcel(String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);
		
			return readData(file);
		}
		return null;
	}

	public static List<Account> readData(File file) {

		if (file != null && file.canRead()) {
			


			try {
				FileInputStream fileInputStream = new FileInputStream(file);

				// HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

				if (workbook != null) {
					

					// Get first sheet
					XSSFSheet sheet = workbook.getSheetAt(0);

					if (sheet != null && sheet.getLastRowNum() > 0) {

						List<Account> listAccs = new ArrayList<Account>();
						// Because first row is header, i index will start at 1
						for (int i = 1; i <= sheet.getLastRowNum(); i++) {

							Row row = sheet.getRow(i);
							
							if (row != null && row.getLastCellNum() > 0) {

								Account acc = new Account();

								// Cell 0: TCs Title
								Cell cell = row.getCell(0);
								acc.setTCID(cell.getStringCellValue());
							
								// Cell 1: Email
								cell = row.getCell(1);
								acc.setEmail(cell.getStringCellValue());
								

								// Cell 2: Password
								cell = row.getCell(2);
								acc.setPassword(cell.getStringCellValue());
								
								// Cell 3 : Confirm password
								cell = row.getCell(3);
								acc.setConfPass(cell.getStringCellValue());
								
								// Cell 4: Name
								cell = row.getCell(4);
								acc.setName(cell.getStringCellValue());
								
								// Cell 5: Company
								cell = row.getCell(5);
								acc.setCompany(cell.getStringCellValue());
								
								// Cell 6: Phone
								cell = row.getCell(6);
								acc.setPhone(cell.getStringCellValue());
							
								// Cell 7: ExpectedResult
								cell = row.getCell(7);
								acc.setExpResult(cell.getStringCellValue());
								
								listAccs.add(acc);
							}
						}

						// Note: You have to close workbook.
						workbook.close();

						return listAccs;
					}
					workbook.close();
				}
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<Product> getProductFromExcel(String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);
		
			return readProduct(file);
		}
		return null;
	}
	
	public static List<Product> readProduct(File file) {

		if (file != null && file.canRead()) {
		try {
				FileInputStream fileInputStream = new FileInputStream(file);

				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

				if (workbook != null) {
					// Get first sheet
					XSSFSheet sheet = workbook.getSheetAt(0);

					if (sheet != null && sheet.getLastRowNum() > 0) {

						List<Product> listProducts = new ArrayList<Product>();
						// Because first row is header, i index will start at 1
						for (int i = 1; i <= sheet.getLastRowNum(); i++) {

							Row row = sheet.getRow(i);
							
							if (row != null && row.getLastCellNum() > 0) {

								Product product = new Product();

								// Cell 0: TC Title
								Cell cell = row.getCell(0);
								product.setTCID(cell.getStringCellValue());
							
								// Cell 1: Name
								cell = row.getCell(1);
								product.setName(cell.getStringCellValue());
								System.out.println("test");
								// Cell 2: Price
								cell = row.getCell(2);
								product.setPrice(cell.getStringCellValue());
								
								// Cell 3 : Discount
								cell = row.getCell(3);
								product.setDisc(cell.getStringCellValue());														
								
								// Cell 4: ExpResult
								cell = row.getCell(4);
								product.setExpResult(cell.getStringCellValue());																
								
								listProducts.add(product);
							}
						}
						// Note: You have to close workbook.
						workbook.close();

						return listProducts;
					}

					workbook.close();
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return null;
	}
}
