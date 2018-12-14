package mx.edu.uacm.bibcientifica.test.cu01;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrarInvestigador {

	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.gecko.driver",
				System.getProperty("user.dir") +
				"/geckoDriver/geckodriver.exe");
		
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:9090/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void registrarUsuario() {
		driver.get("");
	    driver.findElement(By.linkText("Iniciar sesion")).click();
	    driver.findElement(By.name("correo")).click();
	    driver.findElement(By.name("correo")).clear();
	    driver.findElement(By.name("correo")).sendKeys("hugo.gonzalez.dv10@gmail.com");
	    driver.findElement(By.name("contrasena")).click();
	    driver.findElement(By.name("contrasena")).clear();
	    driver.findElement(By.name("contrasena")).sendKeys("hugo.gonzalez.dv10@gmail.com");
	    driver.findElement(By.linkText("Nuevo investigador")).click();
	    driver.findElement(By.name("nombre")).click();
	    driver.findElement(By.name("nombre")).clear();
	    driver.findElement(By.name("nombre")).sendKeys("Juan");
	    driver.findElement(By.name("apellido")).click();
	    driver.findElement(By.name("apellido")).clear();
	    driver.findElement(By.name("apellido")).sendKeys("Hernandez");
	    driver.findElement(By.name("correo")).click();
	    driver.findElement(By.name("correo")).clear();
	    driver.findElement(By.name("correo")).sendKeys("Juanpepe@gmail.com");
	    driver.findElement(By.name("telefono")).click();
	    driver.findElement(By.name("telefono")).clear();
	    driver.findElement(By.name("telefono")).sendKeys("3333333333");
	    driver.findElement(By.name("genero")).click();
	    new Select(driver.findElement(By.name("genero"))).selectByVisibleText("Masculino");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Genero'])[1]/following::option[2]")).click();
	    driver.findElement(By.name("tipoUsuario")).click();
	    new Select(driver.findElement(By.name("tipoUsuario"))).selectByVisibleText("Investigador");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tipo de usuario'])[1]/following::option[2]")).click();
	    driver.findElement(By.name("contrasena")).click();
	    driver.findElement(By.name("contrasena")).clear();
	    driver.findElement(By.name("contrasena")).sendKeys("123456");
	    driver.findElement(By.name("contrasena2")).click();
	    driver.findElement(By.name("contrasena2")).clear();
	    driver.findElement(By.name("contrasena2")).sendKeys("123456");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='El correo ya se registro'])[1]/following::input[1]")).click();
	    driver.findElement(By.linkText("Iniciar sesion")).click();
	    driver.findElement(By.name("correo")).click();
	    driver.findElement(By.name("contrasena")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contraseña'])[1]/following::input[2]")).click();
	    driver.findElement(By.linkText("Nuevo investigador")).click();
	    driver.findElement(By.name("nombre")).click();
	    driver.findElement(By.name("nombre")).clear();
	    driver.findElement(By.name("nombre")).sendKeys("Juan");
	    driver.findElement(By.name("apellido")).clear();
	    driver.findElement(By.name("apellido")).sendKeys("Perez");
	    driver.findElement(By.name("correo")).click();
	    driver.findElement(By.name("correo")).clear();
	    driver.findElement(By.name("correo")).sendKeys("juanco@gmail.com");
	    driver.findElement(By.name("telefono")).click();
	    driver.findElement(By.name("telefono")).clear();
	    driver.findElement(By.name("telefono")).sendKeys("2345678123");
	    driver.findElement(By.name("genero")).click();
	    new Select(driver.findElement(By.name("genero"))).selectByVisibleText("Masculino");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Genero'])[1]/following::option[2]")).click();
	    driver.findElement(By.name("tipoUsuario")).click();
	    new Select(driver.findElement(By.name("tipoUsuario"))).selectByVisibleText("Investigador");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Tipo de usuario'])[1]/following::option[2]")).click();
	    driver.findElement(By.name("contrasena")).click();
	    driver.findElement(By.name("contrasena")).clear();
	    driver.findElement(By.name("contrasena")).sendKeys("123456");
	    driver.findElement(By.name("contrasena2")).click();
	    driver.findElement(By.name("contrasena2")).clear();
	    driver.findElement(By.name("contrasena2")).sendKeys("123456");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='El correo ya se registro'])[1]/following::input[1]")).click();
	  }
	
}
