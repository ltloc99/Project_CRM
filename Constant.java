package Automation;

public class Constant {

	public static final String URL = "http://14.176.232.213:8080/CRMweb/faces/login.xhtml";
	public static final String chromeDiver = "webdriver.chrome.driver";
	public static final String pathWebDriver = "D:\\Testing\\ChrDriver\\chromedriver.exe";
	
	//Register
	public static final String emailID = "nothing:email1";
	public static final String passID = "nothing:p";
	public static final String confPassID = "nothing:cp"; 
	public static final String nameID = "nothing:Name";
	public static final String compID ="nothing:Company";
	public static final String phoneID = "nothing:phone";
	public static final String RegBtnName = "nothing:j_idt30";
	
	//Login 
	public static final String emailLoginID = "campaigntypeform:email";
	public static final String passLoginID = "campaigntypeform:pass";
	public static final String btnLoginName = "campaigntypeform:j_idt14";
	
	//Link Excel
	public static final String addProductFileExcelData = "D:\\Testing\\inputFile_AddPro.xlsx";
	public static final String addProductFileResultExcel = "D:\\Testing\\outputFile_AddPro.xlsx";
	public static final String editProductFileExcelData = "D:\\Testing\\inputFile_EditPro.xlsx";
	public static final String editProductFileResultExcel = "D:\\Testing\\outputFile_EditPro.xlsx";
	
	//Link Products
	public static final String AddProductNameID = "bookForm:pn";
	public static final String AddProductPriceID = "bookForm:pp";
	public static final String AddProductDiscoundID = "bookForm:pd";
	public static final String AddProductBtnName = "bookForm:j_idt77";
	
	// edit Products
	public static final String EditProductName = "bookForm:pn";
	public static final String EditProductPrice = "bookForm:pp";
	public static final String EditProductDiscount = "bookForm:pd";
	public static final String EditProductBtnName = "bookForm:j_idt77";
	public static final String SaveProductBtnName = "//input[@name='bookForm:j_idt79']";
	public static final String statusEditProductName = "";
}
