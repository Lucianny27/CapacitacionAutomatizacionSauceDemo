package Edit.SauceDemo;

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import Utilities.DatosExcel;

public class Asignacion7 {
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

	@Test(dataProvider = "Datos Login-GenerarOrdenSauceDemo")

	public void generarOrden(String Usuario, String Contraseña, String Nombre, String Apellido, String CodigoPostal) {

		driver.findElement(By.id("user-name")).clear(); // Limpiar Usuario

		driver.findElement(By.id("user-name")).sendKeys(Usuario); // ingresar Usuario

		driver.findElement(By.id("password")).clear(); // Limpiar contraseña

		driver.findElement(By.id("password")).sendKeys(Contraseña); // Ingresar Contraseña

		driver.findElement(By.id("login-button")).click(); // hacer cick en login

		String urlEsperadaLogin = "https://www.saucedemo.com/inventory.html"; // Verificaciones
		String urlActualLogin = driver.getCurrentUrl();
		Assert.assertEquals(urlActualLogin, urlEsperadaLogin);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60)); // Esperas
		wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#add-to-cart-sauce-labs-backpack")));

		driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-backpack")).click(); // Añadir carrito

		driver.findElement(By.xpath(
				"//body/div[@id='root']/div[@id='page_wrapper']/div[@id='contents_wrapper']/div[@id='header_container']/div[1]/div[3]/a[1]"))
				.click(); // Ir al carrito

		driver.findElement(By.cssSelector("#checkout")).click(); // Check Out

		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Datos personales
		wait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#first-name")));

		driver.findElement(By.cssSelector("#first-name")).sendKeys(Nombre); // Nombre

		driver.findElement(By.cssSelector("#last-name")).sendKeys(Apellido); // Apellido

		driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(CodigoPostal); // CP

		driver.findElement(By.cssSelector("#continue")).click(); // 7 Click Continuar

		String urlCheckOut = "https://www.saucedemo.com/checkout-step-one.html";
		Assert.assertNotEquals(driver.getCurrentUrl(), urlCheckOut);

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait3.until(ExpectedConditions.elementToBeClickable(By.name("finish")));

		driver.findElement(By.cssSelector("#finish")).click(); // 7 Click Finalizar

		String urlEsperada = "https://www.saucedemo.com/checkout-complete.html"; // //Comprobaciones
		String TituloEsperado = "Swag Labs";
		String urlActual = driver.getCurrentUrl();
		String TituloActual = driver.getTitle();

		Assert.assertEquals(urlActual, urlEsperada); // Asserts
		Assert.assertEquals(TituloActual, TituloEsperado);

		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click(); // Logout

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#logout_sidebar_link")));

		driver.findElement(By.cssSelector("#logout_sidebar_link")).click();

	}

	@DataProvider(name = "Datos Login-GenerarOrdenSauceDemo")
	public Object[][] obtenerDatosExcel() throws Exception {
		return DatosExcel.leerExcel("../SauceDemo/Datos/Datos Login-GenerarOrdenSauceDemo.xlsx", "Datos");

	}

	@AfterSuite

	public void CerrarNavegador() {
		driver.close();

	}

}
