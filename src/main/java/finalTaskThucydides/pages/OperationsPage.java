package finalTaskThucydides.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Set;
import org.apache.log4j.Logger;

@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")

public class OperationsPage extends PageObject {

    private static final Logger LOG = Logger.getLogger(OperationsPage.class);

    @FindBy(id = "FirstName") private WebElementFacade firstNameField;
    @FindBy (id = "LastName") private WebElementFacade lastNameField;
    @FindBy (xpath = "//input[@value='female']") private WebElementFacade femaleGender;
    @FindBy (xpath = "//input[@value='male']") private WebElementFacade maleGender;
    @FindBy (id = "Add") private WebElementFacade addButton;
    @FindBy (id = "Category") private WebElementFacade listOfCategory;
    @FindBy (id = "count") private WebElementFacade vipCount;
    @FindBy (id = "connection") private WebElementFacade dbCondition;

    public void clickButtonByTitle (String buttonTitle){
        try{
            find(By.xpath("//input[@value='"+buttonTitle+"']")).click();
            LOG.info("Button '" + buttonTitle + "' clicked");
        }catch (org.openqa.selenium.NoSuchElementException e){
            LOG.error("Can't find button with title '" + buttonTitle + "'");
            throw e;
        }
    }

    public String findButtonOnPageByTitle(String buttonTitle){
        try{
            find(By.xpath(".//input[@type='button' and @value='" + buttonTitle + "']"));
            LOG.info("Was found button " + "'"+buttonTitle+"'");
            return buttonTitle;
        }catch (org.openqa.selenium.NoSuchElementException e){
            LOG.error("Can't find button with title " + "'"+buttonTitle+"'");
            throw e;
        }
    }
    
    public String getDataBaseCondition(String expectedCondition) {
        LOG.info("Waiting change data base condition to 'Online'...");
        if("Online".equals(expectedCondition)) waitForAnyTextToAppear(dbCondition,"Online");
        LOG.info("Data base condition is 'Online'");
        return dbCondition.getText();
    }

    public String getDataBaseConditionText() {
        return dbCondition.getText();
    }

    public void fillNewVipData(String firstName, String lastName, String gender, String category){
        firstNameField.type(firstName);
        lastNameField.type(lastName);
        if ("Female".equals(gender)) { femaleGender.click(); }
            if ("Male".equals(gender)) { maleGender.click();}
        listOfCategory.selectByValue(category);
        LOG.info("Fielded VIPs info: " + firstName + " " + lastName + " " + " " + gender + " " + category);
        }
    
    public void fillVipFirstName(String vipFirstName){
        lastNameField.clear();
        LOG.info("VIPs 'Last name' field cleared");
        firstNameField.type(vipFirstName);
        LOG.info("VIPs 'First name' field filled: '" + vipFirstName+"'");
    }
    public void fillVipLastName(String vipLastName){
        firstNameField.clear();
        LOG.info("VIPs 'First name' field cleared");
        lastNameField.type(vipLastName);
        LOG.info("VIPs 'Last name' field filled: '" + vipLastName+"'");
    }

    public String getVipCountCondition(){
        LOG.info("Got VIP count condition is: '" + vipCount.getText() + "'");
        return vipCount.getText();
    }

    public ArrayList<String> getVipDataFromTable() {
        ArrayList<String> allVipData = new ArrayList<String>();
        String vipInfoFromTableString = null;
        int countLinesInVipsTable = getDriver().findElements(By.xpath("//table[@id='VIPs']/tbody/tr")).size();
        int countColumnsInVipsTable = getDriver().findElements(By.xpath("//table[@id='VIPs']/tbody/tr[1]/td")).size();
        for (int a = 2; a <= countLinesInVipsTable; a++) {
            vipInfoFromTableString = "";
            for (int b = 2; b <= countColumnsInVipsTable; b++) {
                vipInfoFromTableString = vipInfoFromTableString + find(By.xpath("//table[@id='VIPs']/tbody/tr[" + a + "]/td[" + b + "]")).getText();
                if (b < countColumnsInVipsTable) {vipInfoFromTableString = vipInfoFromTableString + " "; }
            }
            allVipData.add(vipInfoFromTableString);
            LOG.info("VIPs data has read from table: " + vipInfoFromTableString);
        }
        return allVipData;
    }

    public String getButtonCondition(String buttonTitle){
        String buttonCondition=null;
        try{
            if(find(By.xpath("//input[@value='"+buttonTitle+"']")).isEnabled()){
                buttonCondition = "Enabled";
            } else{
                buttonCondition = "Disabled";
            }
            LOG.info("Condition of button '"+buttonTitle+"' is '" + buttonCondition + "'");
            return buttonCondition;
        }catch (org.openqa.selenium.NoSuchElementException e){
            LOG.error("Can't get condition of button with title '" + buttonTitle + "'");
            throw e;
        }
    }
    
    public String getInfoFromPopUpWindow(){
        String parentWindowHandle = getDriver().getWindowHandle();
        String popupWindowHandle = null;
        String actualMassage = null;
        Set<String> windowSet = null;
        Iterator<String> iterator = null;
        windowSet = getDriver().getWindowHandles();
        iterator = windowSet.iterator();
        while(iterator.hasNext()) {
            popupWindowHandle = iterator.next();
            if(!parentWindowHandle.equals(popupWindowHandle)){
                getDriver().switchTo().window(popupWindowHandle);
                try {
                    actualMassage = find(By.id("alertTextOK")).getText();
                    LOG.info("Got message from pop up window: " + actualMassage);
                } catch (org.openqa.selenium.NoSuchElementException e){ }
                getDriver().findElement(By.xpath("//button[text()='OK']")).click();
                getDriver().switchTo().window(parentWindowHandle);
                return actualMassage;
            }
        }
        LOG.error("Can't get info message from pop-up window");
        return "Can't get info message from pop-up window";
    }

    public String getQuestionFromPopUpWindow(){
        String parentWindowHandle = getDriver().getWindowHandle();
        String popupWindowHandle = null;
        String actualMassage = null;
        Set<String> windowSet = null;
        Iterator<String> iterator = null;
        windowSet = getDriver().getWindowHandles();
        iterator = windowSet.iterator();
        while(iterator.hasNext()) {
            popupWindowHandle = iterator.next();
            if(!parentWindowHandle.equals(popupWindowHandle)){
                getDriver().switchTo().window(popupWindowHandle);
                try {
                    actualMassage = find(By.id("alertTextOKCancel")).getText();
                    LOG.info("Got message from pop up window: " + actualMassage);
                } catch (org.openqa.selenium.NoSuchElementException e){}
                getDriver().findElement(By.xpath("//button[text()='OK']")).click();
                getDriver().switchTo().window(parentWindowHandle);
                return actualMassage;
            }
        }
        LOG.error("Can't get question from pop-up window");
        return "Can't get question from pop-up window";
    }

    public void checkVipsLineByNumber (int vipLineNumber){
        try {
            find(By.xpath("//table[@id='VIPs']/tbody/tr[" + (vipLineNumber + 1) + "]/td/input[@id='VIP']")).click();
            LOG.info("VIP number " + (vipLineNumber) + " checked");
        } catch (org.openqa.selenium.NoSuchElementException e){
            LOG.error("Can't check VIPs line by number '" + vipLineNumber + "'");
        }
    }

    public Integer countLineInVipsTable (){
        Integer countLineInVipsTable = 1;
        do{
            try{
                find(By.xpath("//table[@id='VIPs']/tbody/tr[" + countLineInVipsTable + "]"));
            }catch (org.openqa.selenium.NoSuchElementException e){
                LOG.info("Count of lines in VIPs table is " + (countLineInVipsTable-2) );
                return countLineInVipsTable-2;
            }
            countLineInVipsTable++;
        }while (true);
    }
}