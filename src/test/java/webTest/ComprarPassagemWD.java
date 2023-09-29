// Pacote
package webTest;
// Bibliotecas

// Classe

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComprarPassagemWD  {
// Atributos
    private WebDriver driver;  // Declaramos o objeto do Selenium WebDriver
// Funções e Métodos

// Antes do Teste
@BeforeEach
public void setUp(){
// Declarar o gerenciador para baixar o chrome driver
    WebDriverManager.chromedriver().setup();
// Configuração especificia a partir do Selenium web driver 4.8.1
    ChromeOptions options = new ChromeOptions(); // Instancía o ChromeOptions
// Adicionou ao ChromeOptions a opção de permitir qualquer origem de acesso remoto
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);     // Intancía o Chrome Driver com Options
    driver.manage().window().maximize();           //Maximiza a janela do navegador
}
// Depois do Teste
@AfterEach
public void tearDown(){
    driver.quit();        // Destrói a instância do Selenium WebDriver
}
// O Teste
@Test
    public void comprarPassagemWD(){
    driver.get("https://www.blazedemo.com"); // Abre o endereço alvo
// Selecionar a lista de cidades de origem
    driver.findElement(By.name("fromPort")).click();
// Selecionar a cidade na lista
    {
        WebElement lista = driver.findElement(By.name("fromPort"));
        lista.findElement(By.xpath("//option[. = 'São Paolo']")).click();
    }
// Selecionar a lista de cidades de origem
    driver.findElement(By.name("toPort")).click();
    {
        WebElement lista = driver.findElement(By.name("toPort"));
        lista.findElement(By.xpath("//option[. = 'Berlin']")).click();
    }
// Apertar o botão procurar vôos
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
// Validar a frase que indica o vôo de origem ao destino
    assertEquals("Flights from São Paolo to Berlin:",driver.findElement(By.cssSelector("h3")).getText());

}
}
