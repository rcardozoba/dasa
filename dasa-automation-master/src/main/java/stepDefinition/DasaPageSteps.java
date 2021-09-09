package stepDefinition;

import core.DSL;
import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObject.DasaPage;
import pageObject.NossasMarcasPage;

import java.util.ArrayList;

import static core.DriverFactory.getDriver;
import static org.testng.Assert.assertEquals;

public class DasaPageSteps extends DSL {

    private DasaPage dasaPage;
    private NossasMarcasPage nossasMarcas;


    public DasaPageSteps(){
        super();
        dasaPage = new DasaPage();
        nossasMarcas = new NossasMarcasPage();
    }

    @Dado("^Eu abro o Browser e navego para Dasa website$")
    public void openBrowser() {
        getDriver().get("https://dasa.com.br/");
    }

    @Entao("^Eu checo se o site esta acessível$")
    public void verificarSiteAcessivel () {
        assertEquals(getPageTitle(), "Dasa - A maior rede de Saúde Integrada" );
    }

    @Quando("^Eu navego para menu Somos Dasa e opcao Nossas Marcas$")
    public void navegarMenu ()  {
        wait(dasaPage.getMenuLink(), 10000);
        mouseOver(dasaPage.getMenuLink());
        clickWebElement(dasaPage.getClickNossaMarcaLink());
    }

    @Entao("^Eu listo os laboratorios de Sao Paulo$")
    public void listarLabCidade () {
        wait(nossasMarcas.getNossasMarcasLink(), 10000);
        selectComboOption(nossasMarcas.getLocationComboLink(),"São Paulo");
        System.out.println("**Listando Laboratorios**");
        for (WebElement brand : nossasMarcas.getListarLab()) {
            System.out.println(brand.getAttribute("href"));
        }
    }

    @Entao("^Eu clico no laboratorio DelboniAuriemo$")
    public void clicarLab () {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", nossasMarcas.getMoverElement());
        clickWebElement(nossasMarcas.getLabLink());
    }

    @Quando("^Eu valido o acesso a area do laboratorio")
    public void acessoAreaLab () {
        ArrayList<String> tab = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tab.get(1));
        assertEquals(getPageUrl(),"https://delboniauriemo.com.br/");
        quitBrowser();
    }

}
