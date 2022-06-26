package Edit.SauceDemo;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Utilities.CapturaEvidencia;



public class AsignacionClase5 { 

	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\SauceDemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String dirEvidencias = "..\\SauceDemo\\Evidencias\\";
	String nombreDocumento = "SauceDemo.docx";
	

	
@BeforeSuite
public void abrirPagina() {   // setUp
		// Todas las instrucciones que son comunes a ambos @Test al inicio 
		System.setProperty("webdriver.chrome.driver", driverPath);
		
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
		
		@Test(description="Ingreso", priority=1)
		public void Ingreso () throws InvalidFormatException, IOException, InterruptedException {
			// configurando el documento de evidencias
		CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Documento de Evidencias de Prueba",18);
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Principal"); 
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");    // Escriba el usuario (standard_user)
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");        //  Escriba la contraseña (secret_sauce)
	
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Luego de Completar datos de Inicio"); // Evidencia: Luego de Completar datos de Inicio
			
		driver.findElement(By.id("login-button")).click();  //hacer cick en login
				
		}
		
				
		@Test(description="Seleccion Producto y completar compra", priority=2)
		public void login()throws InvalidFormatException, IOException, InterruptedException {
			// configurando el documento de evidencias
			
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Seleccion Producto"); //Evidencia: Seleccion producto
						
			driver.findElement(By.cssSelector("div.page_wrapper div.inventory_container div.inventory_list div.inventory_item:nth-child(1) div.inventory_item_img a:nth-child(1) > img.inventory_item_img")).click(); // Seleccionar producto
				
			driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click(); // Añadir al carrito
			
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Añadir al Carrito"); // Evidencia: Añadir al carrito
				
			driver.findElement(By.xpath("//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]")).click(); // Ir al carrito
				
			driver.findElement(By.cssSelector("#checkout")).click(); // Check Out
				
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Formulario"); // Evidencia: Formulario
				
			driver.findElement(By.cssSelector("#first-name")).sendKeys("Maria"); // Nombre
				
			driver.findElement(By.cssSelector("#last-name")).sendKeys("Perez"); // Apellido
				
			driver.findElement(By.cssSelector("#postal-code")).sendKeys("75201"); // CP
				
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Completar Formulario"); //  Evidencia: Datos de formulario completo
												
			driver.findElement(By.cssSelector("#continue")).click(); //7 Click Continuar
				
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Finalizar Compra"); // Evidencia: Finalizar compra  
				
			driver.findElement(By.cssSelector("#finish")).click(); //7 Click Finalizar 
			
			CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "img.jpg", dirEvidencias + nombreDocumento, "Pantalla Final de compra"); // Evidencia: Pantalla Final de compra
			
								
		
				// Comprobaciones para verificar que la busqueda se realizó
				// >>> La URL cambió, el título cambió
				String urlEsperada = "https://www.saucedemo.com/checkout-complete.html";
				String tituloEsperado = "Swag Labs";
				
				String urlActual = driver.getCurrentUrl(); // Devuelve la URL actual de la pagina
				String tituloActual = driver.getTitle(); // Devuelve el titulo actual de la pagina
				
				Assert.assertEquals(urlActual, urlEsperada);
				Assert.assertEquals(tituloActual, tituloEsperado);

		
		}
		


		@AfterSuite
		public void cerrarPagina() {   // tearDown
			driver.close();
				
		}

		
			}

		
				



				
				