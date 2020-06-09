package br.ce.wcaquino.tasksfrontend.stepdefinitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class tasks_stepdefinitions {

    public static WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        // WebDriverManager.chromedriver().setup();
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://192.168.0.166:4444/wd/hub"), cap);
        driver.navigate().to("http://192.168.0.166:8001/tasks");
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--headless");
        // WebDriver driver = new ChromeDriver(options);
        // driver.navigate().to("http://localhost:8001/tasks/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Dado("que cliquei em adicionar uma Tarefa")
    public void queCliqueiEmAdicionarUmaTarefa() {
        driver.findElement(By.id("addTodo")).click();
    }

    @Quando("escrevi {string} no nome da tarefa")
    public void escreviNoNomeDaTarefa(String string) {
        driver.findElement(By.id("task")).sendKeys(string);
    }

    @Quando("escrevi {string} na data")
    public void escreviNaData(String string) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("dueDate")).sendKeys(string);
    }

    @Quando("clicar em salvar")
    public void clicarEmSalvar() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("saveButton")).click();
    }

    @Entao("valido que foi salvo com sucesso")
    public void validoQueFoiSalvoComSucesso() {
        // Write code here that turns the phrase above into concrete actions
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals("Success!", message);
    }

    @Entao("clico em remover")
    public void clicoEmRemover() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//a[@class='btn btn-outline-danger btn-sm']")).click();
    }

    @Entao("valido que apresentou a messagem: {string}")
    public void validoQueApresentouAMessagem(String string) {
        String message = driver.findElement(By.id("message")).getText();
        Assert.assertEquals(string, message);
    }

    @After(order = 1)
    public void screenshot(Scenario cenario) {
        try {
            // FileUtils.copyFile(file, new File(pathname));
            cenario.attach(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png",
                    cenario.getName() + UUID.randomUUID().toString().substring(0, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @After(order = 0)
    public void fecharbrowser() {
        driver.quit();
    }

}