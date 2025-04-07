package BuyProduct;

import java.util.Properties;

import org.testng.annotations.Test;

import com.qf.genericutility.BaseClass;
import com.qf.objectrepository.UserLoginObjects;

public class LaptoPurchaseScript extends BaseClass {

//	Properties prop = new Properties();
	UserLoginObjects userloginobj;

	@Test(priority = 0)
	public void login() throws Exception {

		userloginobj= new UserLoginObjects(driver);
		userloginobj = new UserLoginObjects(driver);
		userloginobj.clickmyaccount();
		Thread.sleep(2000);
		userloginobj.clicklogin();
		
		userloginobj.enteremail("emailid");
		userloginobj.enterpassword("loginpassword");
		
		Thread.sleep(2000);
		userloginobj.clicksubmitnbtn();
		Thread.sleep(2000);
	}
}
