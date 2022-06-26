package Edit.SauceDemo;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Asignacion2 {
	String url = "https://www.saucedemo.com";
	String chromeDriverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	String firefoxDriverPath = "..\\SauceDemo\\Drivers\\geckodriver.exe";

	
	@Test
	public void HacerBusquedaEnChrome() {
		// Indicar donde está el driver del navegador
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		// Paso A y B : Abre el navegador Chrome
		WebDriver navegador = new ChromeDriver();
		navegador.get(url);
		
		// Paso C: Escriba el usuario (standard_user)
		
		WebElement usuario = navegador.findElement(By.id("user-name"));
		usuario.sendKeys("standard_user");
		
		// Paso D: Escriba la contraseña (secret_sauce)
		WebElement contraseña = navegador.findElement(By.id("password"));
		contraseña.sendKeys("secret_sauce");
		
		//Paso E: hacer cick en login
		
		WebElement ingreso = navegador.findElement(By.id("login-button"));
		ingreso.click();
		
	}}

