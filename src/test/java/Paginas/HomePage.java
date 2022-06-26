package Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class HomePage {



	// Elementos de la Pagina web
	
	@FindBy(id="user-name")  //Usuario
	WebElement TxtUserName;
	
	@FindBy(id="password") // Clave
	WebElement TxtPasword;
	
	@FindBy(id="login-button") //Boton Login
	WebElement btnLogin;



	
	//Constructor
	
	
	
public HomePage (WebDriver Driver) {
	PageFactory.initElements(Driver, this);
	
	}



//Acciones sobre los elementos de la pagina


public void IngresarUsuario (String usuario) {
	
	TxtUserName.sendKeys((usuario)); }


public void IngresarPasword (String Contraseña) {

	TxtPasword.sendKeys(Contraseña);

}
	
public void ClickEnLogin () {
	btnLogin.click();

}
	
	
	
	

}
	
	
	
	
	
	
	
	
	



