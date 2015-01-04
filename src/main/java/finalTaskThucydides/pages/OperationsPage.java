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

    private static final Logger log = Logger.getLogger(OperationsPage.class);
    private ArrayList<String> sentVipData = new ArrayList<String>();

    @FindBy(id = "FirstName") private WebElementFacade firstNameField;
    @FindBy (id = "LastName") private WebElementFacade lastNameField;
    @FindBy (xpath = "//input[@value='female']") private WebElementFacade femaleGender;
    @FindBy (xpath = "//input[@value='male']") private WebElementFacade maleGender;
    @FindBy (id = "Add") private WebElementFacade addButton;
    @FindBy (id = "Category") private WebElementFacade listOfCategory;
    @FindBy (id = "count") private WebElementFacade vipCount;
    @FindBy (id = "Save") private WebElementFacade saveButton;
    @FindBy (id = "Load") private WebElementFacade loadButton;
    @FindBy (id = "Delete") private WebElementFacade deleteButton;
    @FindBy (id = "Clear") private WebElementFacade clearButton;
    @FindBy (id = "connect") private WebElementFacade conDiscButton;
    @FindBy (id = "connection") private WebElementFacade dbCondition;

    public void clickButtonByTitle (String buttonTitle){
        if ("Connect".equals(buttonTitle)){
            conDiscButton.click();
            log.info("User clicks 'Connect' button");
            return;
        }
        if ("Disconnect".equals(buttonTitle)){
            conDiscButton.click();
            log.info("User clicks 'Disconnect' button");
            return;
        }
        if ("Save".equals(buttonTitle)){
            saveButton.click();
            log.info("User clicks 'Save' button");
            return;
        }
        if ("Load".equals(buttonTitle)){
            loadButton.click();
            log.info("User clicks 'Load' button");
            return;
        }
        if ("Add".equals(buttonTitle)){
            addButton.click();
            log.info("User clicks 'Add' button");
            return;
        }
        if ("Delete".equals(buttonTitle)){
            deleteButton.click();
            log.info("User clicks 'Delete' button");
            return;
        }
        if ("Clear".equals(buttonTitle)){
            clearButton.click();
            log.info("User clicks 'Clear' button");
            return;
        }
        log.error("Undefined button title '" + buttonTitle + "'");
    }
    
    public String getDataBaseCondition(String expectedCondition) {
        log.info("Waiting change data base condition to 'Online'...");
        if("Online".equals(expectedCondition)) waitForAnyTextToAppear(dbCondition,"Online");
        log.info("Data base condition is 'Online'");
        return dbCondition.getText();
    }

    public void fillNewVipData(String firstName, String lastName, String gender, String category){
        firstNameField.type(firstName);
        lastNameField.type(lastName);
            if ("Female".equals(gender)) { femaleGender.click(); }
            if ("Male".equals(gender)) { maleGender.click();}
            if ("Other".equals(category)) {
                listOfCategory.selectByValue("Other");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
            if ("Music".equals(category)) {
                listOfCategory.selectByValue("Music");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
            if ("Movie".equals(category)) {
                listOfCategory.selectByValue("Movie");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
            if ("Science".equals(category)) {
                listOfCategory.selectByValue("Science");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
            if ("Sport".equals(category)) {
                listOfCategory.selectByValue("Sport");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
            if ("Politics".equals(category)) {
                listOfCategory.selectByValue("Politics");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
                log.info("User added VIP: " + firstName+" "+lastName+" "+gender+" "+ category);
                return;
            }
        log.error("Undefined VIP category '" +category+"'");
        }
    
    public void fillVipFirstName(String vipFirstName){
        lastNameField.clear();
        log.info("VIPs 'First name' field cleared");
        firstNameField.type(vipFirstName);
        log.info("VIPs 'First name' field filled: " + vipFirstName);
    }
    public void fillVipLastName(String vipLastName){
        firstNameField.clear();
        log.info("VIPs 'Last name' field cleared");
        lastNameField.type(vipLastName);
        log.info("VIPs 'Last name' field filled: " + vipLastName);
    }

    public String getVipCountCondition(){
        log.info("Got VIP count condition is: " + vipCount.getText());
        return vipCount.getText();
    }

    public ArrayList<String> getVipDataFromTable(int i, int j) {
        ArrayList<String> allVipData = new ArrayList<String>();
        String vipInfoFromTableString = null;
        Integer countLinesInVipsTable = 1;
        Integer countColumnsInVipsTable = 1;
        do{
            try{
                find(By.xpath("//table[@id='VIPs']/tbody/tr[" + countLinesInVipsTable + "]"));
            }catch (org.openqa.selenium.NoSuchElementException e){
                break;
            }
            countLinesInVipsTable++;
            System.out.println(countLinesInVipsTable);
        }while (true);
        do{
            try{
                find(By.xpath("//table[@id='VIPs']/tbody/tr[1]/td[" + countColumnsInVipsTable + "]"));
            }catch (org.openqa.selenium.NoSuchElementException e){
                break;
            }
            countColumnsInVipsTable++;
        }while (true);
        for (int a = i; a < countLinesInVipsTable; a++) {
            vipInfoFromTableString = "";
            for (int b = j; b < countColumnsInVipsTable; b++) {

                vipInfoFromTableString = vipInfoFromTableString + find(By.xpath("//table[@id='VIPs']/tbody/tr[" + a + "]/td[" + b + "]")).getText();
                if (b < countColumnsInVipsTable - 1 ) {vipInfoFromTableString = vipInfoFromTableString + " "; }
            }
            allVipData.add(vipInfoFromTableString);
            log.info("VIPs data has read from table: " + vipInfoFromTableString);
        }
        return allVipData;
    }


    public String compareListVipsData(ArrayList<String> list1, ArrayList<String> list2 ){
        for (int i=0; i<list1.size(); i++){
            if (!list1.get(i).equals(list2.get(i)))
            {
                log.info("VIPs lists are not same");
                return "Gave value: " + list1.get(i) + " is different from got value: " + list2.get(i);
            }
        }
        log.info("Result of compare two VIPs lists is 'true'");
        return "true";
    }
    
    public ArrayList<String> getVipsSentData(){
        return this.sentVipData;
    }

    public ArrayList<String> getVipsSentDataWithOutDeletedVip(int number){
        this.sentVipData.remove(number);
        return this.sentVipData;
    }
    
    public String findButtonOnPageByTitle(String buttonTitle){
        if ("Delete".equals(buttonTitle) && deleteButton.isPresent() ){
            log.info("Was found button 'Delete'");
            return "Delete";
        }
        if ("Load".equals(buttonTitle) && loadButton.isPresent()){
            log.info("Was found button 'Load'");
            return "Load";
        }
        if ("Save".equals(buttonTitle) && saveButton.isPresent()){
            log.info("Was found button 'Save'");
            return "Save";
        }
        if("Clear".equals(buttonTitle) && clearButton.isPresent()){
            log.info("Was found button 'Clear'");
            return "Clear";
        }
        if ("Add".equals(buttonTitle) && addButton.isPresent()){
            log.info("Was found button 'Add'");
            return "Add";
        }
        if ("Connect".equals(buttonTitle) && conDiscButton.isPresent()){
            log.info("Was found button 'Connect'");
            return "Connect";
        }
        if ("Disconnect".equals(buttonTitle) && conDiscButton.isPresent()){
            log.info("Was found button 'Disconnect'");
            return "Disconnect";
        }
        log.error("Can't find button with title " + buttonTitle );
        return "Can't find button with title '" + buttonTitle + "'";
    }
    
    public String getButtonCondition(String buttonTitle){
        if ("Delete".equals(buttonTitle) && deleteButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Enabled'");
            return "Enabled";
        }
        if ("Delete".equals(buttonTitle) && !deleteButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Disabled'");
            return "Disabled"; 
        }
        if ("Load".equals(buttonTitle) && loadButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Enabled'");
            return "Enabled";
        }
        if ("Load".equals(buttonTitle) && !loadButton.isEnabled()) {
            log.info("Condition of button '"+buttonTitle+"' is 'Disabled'");
            return "Disabled"; 
        }
        if ("Save".equals(buttonTitle) && saveButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Enabled'");
            return "Enabled";
        }
        if ("Save".equals(buttonTitle) && !saveButton.isEnabled()) {
            log.info("Condition of button '"+buttonTitle+"' is 'Disabled'");
            return "Disabled";
        }
        if ("Clear".equals(buttonTitle) && clearButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Enabled'");
            return "Enabled";
        }
        if ("Clear".equals(buttonTitle) && !clearButton.isEnabled()) {
            log.info("Condition of button '"+buttonTitle+"' is 'Disabled'");
            return "Disabled";
        }
        if ("Add".equals(buttonTitle) && addButton.isEnabled()){
            log.info("Condition of button '"+buttonTitle+"' is 'Enabled'");
            return "Enabled";
        }
        if ("Add".equals(buttonTitle) && !addButton.isEnabled()) {
            log.info("Condition of button '"+buttonTitle+"' is 'Disabled'");
            return "Disabled";
        }
        log.error("Can't get condition of button with title '" + buttonTitle + "'");
        return "Can't get condition of button with title '" + buttonTitle + "'";
    }
    
    public String getPopUpWindowsMessage(){
        String parentWindowHandle = getDriver().getWindowHandle();
        String popupWindowHandle = null;
        String actualMassage = null;
        Set<String> windowSet = null;
        Iterator iterator = null;
        windowSet = getDriver().getWindowHandles();
        iterator = windowSet.iterator();
        while(iterator.hasNext()) {
            popupWindowHandle = iterator.next().toString();
            if(!parentWindowHandle.equals(popupWindowHandle)){
                getDriver().switchTo().window(popupWindowHandle);
                try {
                    actualMassage = find(By.id("alertTextOKCancel")).getText();
                } catch (org.openqa.selenium.NoSuchElementException e){}
                try {
                    actualMassage = find(By.id("alertTextOK")).getText();
                } catch (org.openqa.selenium.NoSuchElementException e){ }
                getDriver().findElement(By.xpath("//button[text()='OK']")).click();
                getDriver().switchTo().window(parentWindowHandle);
                return actualMassage;
            }
        }
        log.error("Can't get message from pop-up window");
        return "Can't get message from pop-up window";
    }

    public void checkVipsLineByNumber (int vipLineNumber){
        find(By.xpath("//table[@id='VIPs']/tbody/tr[" + (vipLineNumber + 1) + "]/td/input[@id='VIP']")).click();
        log.info("VIP number " + (vipLineNumber+1) + " deleted");
    }

    public Integer countLineInVipsTable (){
        Integer countLineInVipsTable = 1;
        do{
            try{
                find(By.xpath("//table[@id='VIPs']/tbody/tr[" + countLineInVipsTable + "]"));
            }catch (org.openqa.selenium.NoSuchElementException e){
                log.info("Count of lines in VIPs table is " + (countLineInVipsTable-1) );
                return countLineInVipsTable-1;
            }
            countLineInVipsTable++;
        }while (true);
    }
}
