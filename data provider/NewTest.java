package Edit.SauceDemo;


import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.CapturaEvidencia;


public class Ejemplo {
	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	
	@BeforeSuite
	public void abrirPagina() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test(description="Ingreso", priority=1)
	public void Ingreso () throws InvalidFormatException, IOException, InterruptedException {
	
	
	driver.findElement(By.id("user-name")).sendKeys("standard_user");    // Escriba el usuario (standard_user)
	
	driver.findElement(By.id("password")).sendKeys("secret_sauce");        //  Escriba la contraseña (secret_sauce)


	driver.findElement(By.id("login-button")).click();  //hacer cick en login
			
	}
	
	
	
	public class NewTest {
		  @Test(dataProvider = "authenticationData")
		  public void login(Integer n, String s) {
		  }
	
		
	 @DataProvider (name = "authenticationData")
	  public Object[][] getData() {
	    Object[][] data = new Object [2][2];
	    data [0][0]= "standard_user"; data[0][1] = "secret_sauce";
	    data [1][0]= "standard_user"; data[1][1] = "secret_sauce";
	     return data;
	     
	 }
	     @AfterClass
	     public void afterClass() {
	     
	    };
}}
	 