package finalTaskThucydides.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.ArrayList;


@DefaultUrl("http://www.ranorex.com/web-testing-examples/vip")

public class OperationsPage extends PageObject {

    @FindBy(id = "FirstName") private WebElementFacade firstNameField;
    @FindBy (id = "LastName") private WebElementFacade lastNameField;
    @FindBy (xpath = "//input[@value='female']") private WebElementFacade femaleGender;
    @FindBy (xpath = "//input[@value='male']") private WebElementFacade maleGender;
    @FindBy (id = "Add") private WebElementFacade addButton;
    @FindBy (id = "Category") private WebElementFacade listOfCategory;
    @FindBy (id = "count") private WebElementFacade vipCount;
    @FindBy (id = "Save") private WebElementFacade saveButton;
    @FindBy (id = "alertTextOK") private WebElementFacade successfulAddVips;
    @FindBy (id = "Load") private WebElementFacade loadButton;
    @FindBy (id = "Delete") private WebElementFacade deleteButton;
    @FindBy (id = "Clear") private WebElementFacade clearButton;
    @FindBy (id = "connect") private WebElementFacade conDiscButton;
    @FindBy (id = "connection") private WebElementFacade dbCondition;
    
    private ArrayList<String> sentVipData = new ArrayList<String>();

    public void conDisconButtonClick() {
        try{
            conDiscButton.click();
        } catch (org.openqa.selenium.NoSuchElementException e){
//            log.error("Element 'Connect/Disconnect button' not found");
            throw e;
        }
    }
    
    public void clickButtonByTitle (String buttonTitle){
        if ("Connect".equals(buttonTitle)){
            conDiscButton.click();
        }
        if ("Disconnect".equals(buttonTitle)){
            conDiscButton.click();
        }
        if ("Save".equals(buttonTitle)){
            saveButton.click();
        }
        if ("Load".equals(buttonTitle)){
            loadButton.click();
        }
        if ("Add".equals(buttonTitle)){
            addButton.click();
        }
        if ("Delete".equals(buttonTitle)){
            deleteButton.click();
        }
    }
    
    public String getDataBaseCondition() {
        return dbCondition.getText();
    }

    public void fillNewVipData(String firstName, String lastName, String gender, String category){
        this.sentVipData.clear();
        firstNameField.type(firstName);
        lastNameField.type(lastName);
            if ("Female".equals(gender)) { femaleGender.click(); }
            if ("Male".equals(gender)) { maleGender.click();}
            if ("Other".equals(category)) {
                listOfCategory.selectByValue("Other");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
            if ("Music".equals(category)) {
                listOfCategory.selectByValue("Music");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
            if ("Movie".equals(category)) {
                listOfCategory.selectByValue("Movie");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
            if ("Science".equals(category)) {
                listOfCategory.selectByValue("Science");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
            if ("Sport".equals(category)) {
                listOfCategory.selectByValue("Sport");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
            if ("Politics".equals(category)) {
                listOfCategory.selectByValue("Politics");
                this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+ category);
            }
        }
    
    public String getVipCountCondition(){
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
//            log.info("VIP data has read from table: " + vipInfoFromTableString);
        }
        return allVipData;
    }


    public String compareListVipsData(ArrayList<String> list1, ArrayList<String> list2 ){
        for (int i=0; i<list1.size(); i++){
            if (!list1.get(i).equals(list2.get(i)))
            {
                return "Gave value: " + list1.get(i) + " is different from got value: " + list2.get(i);
            }
        }
//        log.info("VIPs list are same");
        return "true";
    }
    
    public ArrayList<String> getVipsSentData(){
        return this.sentVipData;
    }
    
    public String findButtonOnPageByTitle(String buttonTitle){
        if ("Delete".equals(buttonTitle) && deleteButton.isPresent() ){ return "Delete"; }
        if ("Load".equals(buttonTitle) && loadButton.isPresent()){ return "Load"; }
        if ("Save".equals(buttonTitle) && saveButton.isPresent()){ return "Save";}
        if("Clear".equals(buttonTitle) && clearButton.isPresent()){return "Clear"; }
        if ("Add".equals(buttonTitle) && addButton.isPresent()){return "Add"; }
        if ("Connect...".equals(buttonTitle) && conDiscButton.isPresent()){ return "Connect..."; }
        if ("Disconnect...".equals(buttonTitle) && conDiscButton.isPresent()){return "Disconnect..."; }
        return "Can't find button with title '" + buttonTitle + "'";
    }
    
    public String getButtonCondition(String buttonTitle){
        if ("Delete".equals(buttonTitle) && deleteButton.isEnabled()){ return "Enabled"; }
        if ("Delete".equals(buttonTitle) && !deleteButton.isEnabled()){ return "Disabled"; }
        if ("Load".equals(buttonTitle) && loadButton.isEnabled()){ return "Enabled"; }
        if ("Load".equals(buttonTitle) && !loadButton.isEnabled()) { return "Disabled"; }
        if ("Save".equals(buttonTitle) && saveButton.isEnabled()){ return "Enabled"; }
        if ("Save".equals(buttonTitle) && !saveButton.isEnabled()) { return "Disabled"; }
        if ("Clear".equals(buttonTitle) && clearButton.isEnabled()){ return "Enabled"; }
        if ("Clear".equals(buttonTitle) && !clearButton.isEnabled()) { return "Disabled"; }
        if ("Add".equals(buttonTitle) && addButton.isEnabled()){ return "Enabled"; }
        if ("Add".equals(buttonTitle) && !addButton.isEnabled()) { return "Disabled"; }
        return "Can't get condition of button with title '" + buttonTitle + "'";
    }


}
