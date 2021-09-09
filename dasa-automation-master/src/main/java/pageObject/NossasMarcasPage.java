package pageObject;

import core.Core;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class NossasMarcasPage extends Core {


    public NossasMarcasPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//select[@name=\"locations\"]")
    private WebElement locationComboLink;

    @FindBy(how = How.XPATH, using = "//h2[text()=\"Nossas Marcas\"]")
    private WebElement nossasMarcasLink;

    @FindBy(how = How.XPATH, using = "//h3[text()=\"São Paulo\"]")
    private WebElement moverElement;

    @FindBy(how = How.XPATH, using = "//picture//ancestor::div[@tabindex=0]/a[contains(@href,'https://delboniauriemo.com.br/')]")
    private WebElement labLink;

    @FindBy(how = How.XPATH, using = "//picture//ancestor::div[@tabindex=0]/a")
    private List<WebElement> listarLab;



    public WebElement getLocationComboLink(){
        return this.locationComboLink;
    }

    public WebElement getNossasMarcasLink(){
        return this.nossasMarcasLink;
    }

    public WebElement getMoverElement(){
        return this.moverElement;
    }

    public WebElement getLabLink(){
        return this.labLink;
    }

    public List<WebElement> getListarLab(){
        return this.listarLab;
    }

}

