package Automation;

import java.util.List;

public class testData {

	public static void main(String[] args) {
		Function.setup();
		Function.login("thualocpro@gmail.com", "thualocpro11");
		
		List<Product> listAddProducts = readFile.getProductFromExcel(Constant.editProductFileExcelData);

		for (int i = 0; i < listAddProducts.size(); i++) {

			Product addProductTesting = listAddProducts.get(i);

			Function.editProduct(addProductTesting);
		}

		writeFile.insertAddProductIntoExcel(listAddProducts, Constant.editProductFileResultExcel);
		
	}
	
}


