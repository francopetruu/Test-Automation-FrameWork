package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	//Lista de todos los webelements de la pagina login
	@CacheLookup
	@FindBy(name="uid") 
	private WebElement userIdTextBox; 
	
	@CacheLookup
	@FindBy(name="password")
	private WebElement passTextBox;
	
	@CacheLookup
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	//inicializamos los webelements
	public LoginPage(WebDriver driver) {
		//como hereda de la BasePage, necesitamos declarar explicitamente el driver
		super(driver);
		PageFactory.initElements(driver, this);
		
	} 
	
	//Empezamos a aplicar la logica del programa(loguearse,registrarse,etc)
	public void loginToApp(String username, String pass) {
		
		elementControl.setText(userIdTextBox, "mngr281525");
		elementControl.setText(passTextBox, "vugAvAz");
		elementControl.clickElement(loginButton);
	}

}
