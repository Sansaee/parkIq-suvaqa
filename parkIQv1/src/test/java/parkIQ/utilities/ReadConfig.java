package parkIQ.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//properties object
	Properties pro;
	
	//constructor to load the config file
	public ReadConfig()
	{
		File  src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis); 
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	//methods for reading each variable in config.properties
	//use properties class objects
	public String getURL()
	{
		String url =pro.getProperty("baseURL");
		return url;
	}
	
	public String getEmail()
	{
		String email =pro.getProperty("email");
		return email;
	}
	
	public String getInvalidEmail() 
	{
		String invalidemail=pro.getProperty("invalidemail");
		return invalidemail;
	}
	
	public String getPassword()
	{
		String pswrd =pro.getProperty("password");
		return pswrd;
	}
	
	public String getInvalidPassword() 
	{
		String invalidpassword=pro.getProperty("invalidpassword");
		return invalidpassword;
	}
	
	public String getChromePath()
	{
		String chromePath =pro.getProperty("chromedriverPath");
		return chromePath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxPath =pro.getProperty("geckodriverPath");
		return firefoxPath;
	}
	
	public String getMsEdgePath()
	{
		String msedgePath =pro.getProperty("msedgedriverPath");
		return msedgePath;
	}
	
	public String getOperaPath()
	{
		String operaPath =pro.getProperty("operadriverPath");
		return operaPath;
	}
	

}
