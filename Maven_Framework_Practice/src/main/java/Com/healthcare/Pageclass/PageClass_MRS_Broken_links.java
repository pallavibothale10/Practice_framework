package Com.healthcare.Pageclass;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.healthcare.Baseclass.BaseClass_OpenMRS;

public class PageClass_MRS_Broken_links extends BaseClass_OpenMRS {

	public PageClass_MRS_Broken_links(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	@FindBy(tagName = "a") // links
	public List<WebElement> AllLinks;

	public void getLinks() throws IOException {

		List<WebElement> Linkslist = driver.findElements(By.tagName("a"));

		Linkslist.addAll(driver.findElements(By.tagName("img")));

		System.out.println("Total links ==" + Linkslist.size());
		int brokenlinks = 0;

		List<WebElement> activelinks = new ArrayList<WebElement>();

		// for
		for (int i = 0; i < Linkslist.size(); i++) {
			if (Linkslist.get(i).getAttribute("href") != null
					&& (!Linkslist.get(i).getAttribute("href").contains("javascript"))) {
				activelinks.add(Linkslist.get(i));
			}

		}

		System.out.println("Active links ==" + activelinks.size());

		for (int j = 0; j < activelinks.size(); j++) {
			HttpURLConnection.setFollowRedirects(false);
			HttpURLConnection connection = (HttpURLConnection) new URL(activelinks.get(j).getAttribute("href"))
					.openConnection();
			connection.connect();
			String response = connection.getResponseMessage();

			int Statuscode = connection.getResponseCode();

			if (connection.getResponseCode() >= 400) {

				System.out
						.println(Statuscode + "--->" + activelinks.get(j).getAttribute("href") + "Is---> brokn links");
				brokenlinks++; // 1
			} else {
				System.out.println(Statuscode + "--->" + activelinks.get(j).getAttribute("href") + "Is--->Valid inks");
			}

		}
		System.out.println("Number of broken links:" + brokenlinks);

	}

//		System.out.println("Total links -->" + AllLinks.size());
//
//		int Bronkenlinks = 0;
//
//		for (WebElement getLinks : AllLinks) {
//
//			// By using the href we can get the URL of the required link
//			String url = getLinks.getAttribute("href");
//
//			if (url == null || url.isEmpty()) {
//
//				System.out.println("url is empty or null");
//			}
//
//			URL LinkURL = new URL(url);
//			
//			CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
//			HttpURLConnection httpscode = (HttpURLConnection) LinkURL.openConnection();
//			httpscode.connect();
//			// 200--ok
//			// 400--bad request
//
//			if (httpscode.getResponseCode() >= 400) {
//
//				System.out.println(httpscode.getResponseCode() + "--->" + url + "is--> broken link");
//				Bronkenlinks++;
//
//			} else {
//
//				System.out.println(httpscode.getResponseCode() + "--->" + url + "is--> Valid link");
//
//			}
//
//		}
//		System.out.println("No. of broken links-->" + Bronkenlinks);
//
//	}
}
