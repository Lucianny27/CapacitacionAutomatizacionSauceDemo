package Pruebas;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Paginas.HomePage;
import Utilities.CapturaEvidencia;



public class SauceDemoTest {

	String url = "https://www.saucedemo.com/";
	String DriverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite

	public void AbrirPaginaSauceDemo() {
		System.setProperty("webdriver.chrome.driver", DriverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test
	public void Login() {
		HomePage Inicio = new HomePage(driver);
		
		Inicio.IngresarUsuario("standard_user");
		
		Inicio.IngresarPasword("secret_sauce");
		
		Inicio.ClickEnLogin();
		
	}
	                   
	                   
	
			
	
	
	

	
}
