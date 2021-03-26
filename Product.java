package Automation;

public class Product {
	public String TCID = "";
	public String Name = "";
	public String Price  = "";
	public String Discount = "";
	public String Status = "";
	public String ActualResult = "";
	public String ExpResult = "";
	public String TCResult = "";
	
	public void setTCID (String tcID) {
		TCID = tcID; 
	}
	public void setName (String name) {
		Name = name;
	}
	public void setPrice (String price) {
		Price = price;
	}
	
	public void setDisc (String discount) {
		Discount = discount;
	}
	public void setStatus(String status) {
		Status = status; 
		
	}
	public void setExpResult (String expResult) {
		ExpResult = expResult; 
		
	}
	public void setActualResult (String actualResult) {
		ActualResult = actualResult; 
		
	}
	public void setTCResult (String tCResult) {
		TCResult = tCResult; 
		
	}

}


