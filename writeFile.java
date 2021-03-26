package Automation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class writeFile {
	public static boolean insertDataIntoExcel(List<Account> data, String fileName) {
		if (fileName != null && !fileName.isEmpty()) {
			File file = new File(fileName);			
			return writeData(data, file);
		}
		return false;
	}

	public static boolean writeData(List<Account> listAccounts, File file) {
		if (file != null) {
			try {
				  DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm");
				  LocalDateTime now = LocalDateTime.now();
				  String daterun =  now.format(dtf1).toString();
				  String timeSheet =  now.format(dtf2).toString();				  		 			
				
				// Create a new workbook
				XSSFWorkbook workbook = new XSSFWorkbook();
						
				if (workbook != null) {
					// Create a new sheet
					XSSFSheet sheet = workbook.createSheet("Result_" + timeSheet);
					if (sheet != null) {
						// Create header row
						Row header = sheet.createRow(0);

						// TC Title
						Cell cell = header.createCell(0);
						cell.setCellValue("TCs Title");

						// User Name
						cell = header.createCell(1);
						cell.setCellValue("Email");

						// Password
						cell = header.createCell(2);
						cell.setCellValue("Password");
						
						// Confirm Password
						cell = header.createCell(3);
						cell.setCellValue("Confirm Password");
						
						// Name
						cell = header.createCell(4);
						cell.setCellValue("Name");
						
						// Company
						cell = header.createCell(5);
						cell.setCellValue("Company");
						
						// Phone
						cell = header.createCell(6);
						cell.setCellValue("Phone");
						
						// Result
						cell = header.createCell(7);
						cell.setCellValue("Run Date");

						// Actual Result
						cell = header.createCell(8);
						cell.setCellValue("Actual Result");
						
						// Expected Result
						cell = header.createCell(9);
						cell.setCellValue("Expected Result");
						
						// Result
						cell = header.createCell(10);
						cell.setCellValue("TCs Result");

						// Create content rows
						int length = listAccounts != null ? listAccounts.size() : 0 ;											
						for (int i = 0; i < length; i++) {
							Account acc = listAccounts.get(i);
							if (acc != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);

								// TC Title
								cell = row.createCell(0);
								cell.setCellValue(listAccounts.get(i).TCID);

								// Email
								cell = row.createCell(1);
								cell.setCellValue(listAccounts.get(i).Email);

								// Password
								cell = row.createCell(2);
								cell.setCellValue(listAccounts.get(i).Password);
								
								// Confirm  Password
								cell = row.createCell(3);
								cell.setCellValue(listAccounts.get(i).ConfPass);
								
								// Name
								cell = row.createCell(4);
								cell.setCellValue(listAccounts.get(i).Name);
								
								// Company
								cell = row.createCell(5);
								cell.setCellValue(listAccounts.get(i).Company);
								
								// Phone
								cell = row.createCell(6);
								cell.setCellValue(listAccounts.get(i).Phone);

								// Run date
								cell = row.createCell(7);
								cell.setCellValue(daterun);								
								
								 //actual Result
								cell = row.createCell(8);
								cell.setCellValue(listAccounts.get(i).ActualResult);

								 //expected Result
								cell = row.createCell(9);
								cell.setCellValue(listAccounts.get(i).ExpResult);
								
								 //TC Result
								cell = row.createCell(10);
								if (listAccounts.get(i).ActualResult.equals(listAccounts.get(i).ExpResult)) {
									cell.setCellValue("Passed"); 
								}else cell.setCellValue("Failed"); 
						//		cell.setCellValue(listAccounts.get(i).TCResult);	

							}
						}
					}
					FileOutputStream fileOutputStream = new FileOutputStream(file);
					workbook.write(fileOutputStream);
					workbook.close();
					
					return true;
				}
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean insertProductIntoExcel(List<Product> data, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return writeProduct(data, file);
		}

		return false;
	}
	public static boolean writeProduct(List<Product> listProduct, File file) {
		if (file != null) {
			try {	
				  DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm");
				  LocalDateTime now = LocalDateTime.now();
				  String daterun =  now.format(dtf1).toString();
				  String timeSheet =  now.format(dtf2).toString();
				  		 			 
				  // Create a new workbook
				  XSSFWorkbook workbook = new XSSFWorkbook();
						
				  if (workbook != null) {

					  // Create a new sheet
					  XSSFSheet sheet = workbook.createSheet("Result_" + timeSheet);

					  if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// TCs Title
						Cell cell = header.createCell(0);
						cell.setCellValue("TCs Title");

						// Product_Name
						cell = header.createCell(1);
						cell.setCellValue("Description");

						// Product_Price
						cell = header.createCell(2);
						cell.setCellValue("Date");
						
						// Product_Discount
						cell = header.createCell(3);
						cell.setCellValue("Time");						
						
						// Run Date
						cell = header.createCell(4);
						cell.setCellValue("Date Run");

						// Actual Result
						cell = header.createCell(5);
						cell.setCellValue("Actual Result");
						
						// Expected Result
						cell = header.createCell(6);
						cell.setCellValue("Expected Result");
						
						// Result
						cell = header.createCell(7);
						cell.setCellValue("TCs Result");

						// Create content rows
						int length = listProduct != null ? listProduct.size() : 0 ;
											
						for (int i = 0; i < length; i++) {

							Product product = listProduct.get(i);

							if (product != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);

								// TC Title
								cell = row.createCell(0);
								cell.setCellValue(listProduct.get(i).TCID);

								// Product_Name
								cell = row.createCell(1);
								cell.setCellValue(listProduct.get(i).Name);

								// Product_Price
								cell = row.createCell(2);
								cell.setCellValue(listProduct.get(i).Price);
								
								// Product_Discount
								cell = row.createCell(3);
								cell.setCellValue(listProduct.get(i).Discount);

								// Run date
								cell = row.createCell(5);
								cell.setCellValue(daterun);
																
								 //Actual Result
								cell = row.createCell(6);
								cell.setCellValue(listProduct.get(i).ActualResult);

								 //Expected Result
								cell = row.createCell(7);
								cell.setCellValue(listProduct.get(i).ExpResult);
								
								 //TC Result
								cell = row.createCell(8);
								if (listProduct.get(i).ActualResult.equals(listProduct.get(i).ExpResult)) {
									cell.setCellValue("Passed"); 
								}else cell.setCellValue("Failed"); 
							}
						}
					}

					FileOutputStream fileOutputStream = new FileOutputStream(file);

					workbook.write(fileOutputStream);

					workbook.close();

					return true;
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return false;
	}

	
	
	public static boolean insertAddProductIntoExcel(List<Product> data, String fileName) {

		if (fileName != null && !fileName.isEmpty()) {

			File file = new File(fileName);

			return writeAddProduct(data, file);
		}

		return false;
	}

	public static boolean writeAddProduct(List<Product> listProduct, File file) {

		if (file != null) {

			try {		
				  DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				  DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd.MM.yyyy-HH.mm");
				  LocalDateTime now = LocalDateTime.now();
				  String daterun =  now.format(dtf1).toString();
				  String timeSheet =  now.format(dtf2).toString();
				  		 			 
				
				// Create a new workbook
				XSSFWorkbook workbook = new XSSFWorkbook();
						
				if (workbook != null) {

					// Create a new sheet
					XSSFSheet sheet = workbook.createSheet("Result_" + timeSheet);

					if (sheet != null) {

						// Create header row
						Row header = sheet.createRow(0);

						// TC Title
						Cell cell = header.createCell(0);
						cell.setCellValue("TCs Title");

						// Product_Name
						cell = header.createCell(1);
						cell.setCellValue("Name");

						// Product_Price
						cell = header.createCell(2);
						cell.setCellValue("Product Price");
						
						// Product_Discount
						cell = header.createCell(3);
						cell.setCellValue("Product Discount");
						
						// Run Date
						cell = header.createCell(4);
						cell.setCellValue("Date Run");

						// Actual Result
						cell = header.createCell(5);
						cell.setCellValue("Actual Result");
						
						// Expected Result
						cell = header.createCell(6);
						cell.setCellValue("Expected Result");
						
						// Result
						cell = header.createCell(7);
						cell.setCellValue("TCs Result");

						// Create content rows
						int length = listProduct != null ? listProduct.size() : 0 ;
											
						for (int i = 0; i < length; i++) {

							Product product = listProduct.get(i);

							if (product != null) {

								// Create content row
								Row row = sheet.createRow(i + 1);

								// TC Title
								cell = row.createCell(0);
								cell.setCellValue(listProduct.get(i).TCID);

								// Product_Name
								cell = row.createCell(1);
								cell.setCellValue(listProduct.get(i).Name);

								// Product_Price
								cell = row.createCell(2);
								cell.setCellValue(listProduct.get(i).Price);
								
								// Product_Discount
								cell = row.createCell(3);
								cell.setCellValue(listProduct.get(i).Discount);
								
								// Run Date
								cell = row.createCell(4);
								cell.setCellValue(daterun);								
								
								 //Actual Result
								cell = row.createCell(5);
								cell.setCellValue(listProduct.get(i).ActualResult);

								 //Expected Result
								cell = row.createCell(6);
								cell.setCellValue(listProduct.get(i).ExpResult);
								
								 //TC Result
								cell = row.createCell(7);
								if (listProduct.get(i).ActualResult.equals(listProduct.get(i).ExpResult)) 
								{
									cell.setCellValue("Passed"); 
								}
								else cell.setCellValue("Failed"); 						
							}
						}
					}
					FileOutputStream fileOutputStream = new FileOutputStream(file);

					workbook.write(fileOutputStream);

					workbook.close();

					return true;
				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		return false;
	}
}
