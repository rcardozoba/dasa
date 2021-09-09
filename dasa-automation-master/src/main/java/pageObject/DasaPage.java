package pageObject;

import core.Core;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class DasaPage extends Core {


    public DasaPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH, using = "//div/a/div[text()=\"Somos Dasa\"]")
    private WebElement menuLink;

    @FindBy(how = How.XPATH, using = "//a[text()=\"Nossas Marcas\"]")
    private WebElement clickNossaMarcaLink;

    public WebElement getMenuLink(){
        return this.menuLink;
    }

    public WebElement getClickNossaMarcaLink()  {
        return this.clickNossaMarcaLink;
    }

}

