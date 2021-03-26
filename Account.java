package Automation;

public class Account {
	
	public String Email = "";
	public String Password = "";
	public String TCID = "";
	public String ExpResult = "";
	public String ActualResult = "";
	public String TCResult = "";
	public String ConfPass = "";
	public String Company = "";
	public String Name = "";
	public String Phone = "";
	public String excuseResult;
	
	public void setTCID (String tcID) {
		TCID = tcID; 
		
	}
	public void setConfPass(String confPass) {
		ConfPass = confPass; 
		
	}
	public void setCompany(String company) {
		Company = company; 
		
	}
	public void setName(String name) {
		Name = name; 
		
	}
	public void setPhone(String phone) {
		Phone = phone; 
		
	}
	public void setEmail(String email) {
		Email = email; 
		
	}
	public void setPassword (String password) {
		Password = password; 
		
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

