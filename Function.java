package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Function {
	static WebDriver driver = null;
	static Select slt = null;
	public static String actualResult = "";
	// public static String excuseResult;

	public static void setup() {
		System.setProperty(Constant.chromeDiver, Constant.pathWebDriver);
		driver = new ChromeDriver();
		driver.get(Constant.URL);
	}

	public static void close() {
		driver.close();
	}

//	public static void register(String email, String pass, String confPass, String name, String company, String phone) {
//		driver.get(Constant.URL);
//
//		boolean isExitingEmail = Find(Constant.emailID);
//		Boolean isExitingPass = Find(Constant.passID);
//		if (isExitingEmail && isExitingPass) {
//
//			WebElement emailField = driver.findElement(By.id(Constant.emailID));
//			emailField.clear();
//			emailField.sendKeys(email);
//
//			WebElement passField = driver.findElement(By.id(Constant.passID));
//			passField.clear();
//			passField.sendKeys(pass);
//
//			WebElement confPassField = driver.findElement(By.id(Constant.confPassID));
//			confPassField.clear();
//			confPassField.sendKeys(confPass);
//
//			WebElement nameField = driver.findElement(By.id(Constant.nameID));
//			nameField.clear();
//			nameField.sendKeys(name);
//
//			WebElement companyField = driver.findElement(By.id(Constant.compID));
//			companyField.clear();
//			companyField.sendKeys(company);
//
//			WebElement phoneField = driver.findElement(By.id(Constant.phoneID));
//			phoneField.clear();
//			phoneField.sendKeys(phone);
//
//			WebElement regBtn = driver.findElement(By.name(Constant.RegBtnName));
//			regBtn.click();
//
//			CheckResult();
//
//		}
//
//		// driver.close();
//	}

	public static void register(Account accTesting) {
		driver.get(Constant.URL);

		boolean isExitingEmail = Find(Constant.emailID);
		Boolean isExitingPass = Find(Constant.passID);
		if (isExitingEmail && isExitingPass) {

			WebElement emailField = driver.findElement(By.id(Constant.emailID));
			emailField.clear();
			emailField.sendKeys(accTesting.Email);

			WebElement passField = driver.findElement(By.id(Constant.passID));
			passField.clear();
			passField.sendKeys(accTesting.Password);

			WebElement confPassField = driver.findElement(By.id(Constant.confPassID));
			confPassField.clear();
			confPassField.sendKeys(accTesting.ConfPass);

			WebElement nameField = driver.findElement(By.id(Constant.nameID));
			nameField.clear();
			nameField.sendKeys(accTesting.Name);

			WebElement companyField = driver.findElement(By.id(Constant.compID));
			companyField.clear();
			companyField.sendKeys(accTesting.Company);

			WebElement phoneField = driver.findElement(By.id(Constant.phoneID));
			phoneField.clear();
			phoneField.sendKeys(accTesting.Phone);

			WebElement regBtn = driver.findElement(By.name(Constant.RegBtnName));
			regBtn.click();

			CheckResult(accTesting);

		}

		// driver.close();
	}

	public static boolean Find(String name) {
		try {
			driver.findElement(By.name(name));
		} catch (NoSuchElementException e) {
			return false;
		}
		return true;

	}

//	public static void CheckResult() {
//
//		String actualResultText = driver.findElement(By.xpath("//*[@id=\"nothing\"]/div[7]/div/p")).getText();
//		if ("Register success!".equals(actualResultText)) {
//			System.out.println("Dang ky thanh cong ");
//
//			// excuseResult ="P";
//		}
//		else {
//			System.out.println("Dang ky khong thanh cong");
//		}
//	}

	public static void CheckResult(Account accTesting) {

		String actualResultText = driver.findElement(By.xpath("//*[@id=\"nothing\"]/div[7]/div/p")).getText();
		if ("Register success!".equals(actualResultText)) {
			accTesting.ActualResult = "Register Successfully";
		}
		else {
			accTesting.ActualResult = "Register Unsuccessfully";
		}

	}

	public static void login(String email, String pass) {
		driver.get(Constant.URL);
		boolean isExitingEmail = Find(Constant.emailLoginID);
		Boolean isExitingPass = Find(Constant.passLoginID);
		if (isExitingEmail && isExitingPass) {

			WebElement emailFieldLogin = driver.findElement(By.id(Constant.emailLoginID));
			emailFieldLogin.clear();
			emailFieldLogin.sendKeys(email);

			WebElement passFieldLogin = driver.findElement(By.id(Constant.passLoginID));
			passFieldLogin.clear();
			passFieldLogin.sendKeys(pass);

			WebElement loginBtn = driver.findElement(By.name(Constant.btnLoginName));
			loginBtn.click();

		}

		boolean result = Find(Constant.btnLoginName);

		if (result == true)
			System.out.println("Dang nhap khong thanh cong");
		else
			System.out.println("Dang nhap thanh cong");

		// driver.close();
	}

	public static void addProduct (Product addProductTesting) {
		
		System.out.println("Test");
			driver.findElement(By.linkText("Products")).click();
			driver.findElement(By.linkText("Create Product")).click();
			driver.findElement(By.linkText("New Product")).click();
			
			driver.findElement(By.id(Constant.AddProductNameID)).sendKeys(addProductTesting.Name);
			driver.findElement(By.id(Constant.AddProductPriceID)).sendKeys(addProductTesting.Price);
			driver.findElement(By.id(Constant.AddProductDiscoundID)).sendKeys(addProductTesting.Discount);

			driver.findElement(By.name(Constant.AddProductBtnName)).click();
			
			System.out.println(addProductTesting.ActualResult);
			
			boolean result = Find(Constant.AddProductBtnName);
			if(result) {
				addProductTesting.ActualResult = "Create Product Unsuccessfully";
			} else addProductTesting.ActualResult = "Create Product Successfully";
			System.out.println(addProductTesting.ActualResult);
//		}
	}
	public static void editProduct(Product ProductTesting) {
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[5]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"productform:j_idt72_data\"]/tr[1]/td[4]/div/div/a")).click();
		
		WebElement descField = driver.findElement(By.name(Constant.EditProductName));
		descField.clear();
		descField.sendKeys(ProductTesting.Name);
		
		WebElement dateField = driver.findElement(By.name(Constant.EditProductPrice));
		dateField.clear();
		dateField.sendKeys(ProductTesting.Price);
		
		WebElement timeField = driver.findElement(By.name(Constant.EditProductDiscount));
		timeField.clear();
		timeField.sendKeys(ProductTesting.Discount);

		driver.findElement(By.xpath(Constant.SaveProductBtnName)).click();
		
		boolean result = Find(Constant.SaveProductBtnName);
	
		if (result) {
			ProductTesting.ActualResult = "Edit Product Unsuccessfully";
			
		} else ProductTesting.ActualResult = "Edit Product Successfully";
		
	}
	
}
