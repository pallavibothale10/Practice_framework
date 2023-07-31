package Com.healthcare.Configuration;


import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import Com.healthcare.Configuration.ReadConfiguration_MRS;



public class ReadConfiguration_MRS {
	Properties pro;

	public ReadConfiguration_MRS() {
		String Path= "C:\\Users\\A\\eclipse-workspace1\\Maven_Framework_Practice\\src\\test\\resources\\Configuration\\Configure.properties";
		File src1 = new File(Path);
// string path = "" ;
		pro = new Properties();
		try {
			FileInputStream fis = new FileInputStream(src1);
			try {

				pro.load(fis);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			} // read a properties list(key and element pairs from the input byte stram
			
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
	}

	public String getApplicationURL() {

		String URL = pro.getProperty("BaseURL");
		return URL;
	}

	public String MethodUsername() {

		String Username = pro.getProperty("UserName");
		return Username;
	}

	public String MethodPassword() {

		String Password = pro.getProperty("PassWord");
		return Password;
	}

	public String getChromepath() {

		String Chromepath = pro.getProperty("ChromeDriver");
		return Chromepath;
	}

	public String getFirefoxpath() {
		String Firefoxpath = pro.getProperty("FirefoxDriver");
		return Firefoxpath;
	}
	public String getEdgepath() {
		String Edgepath = pro.getProperty("EdgeDriver");
		return Edgepath;
	}

}
