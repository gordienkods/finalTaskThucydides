package finalTaskThucydides.steps;

import finalTaskThucydides.pages.OperationsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
import java.util.ArrayList;

public class TestSteps extends ScenarioSteps {
    
    OperationsPage operationsPage;
    private ArrayList<String> sentVipData = new ArrayList<String>();


    @Step
    public void clickButton(String buttonTitle){
        operationsPage.clickButtonByTitle(buttonTitle);
    }

    
    @Step
    public void checkConditionOfDatabase(String conditionOfDataBase) {
       Assert.assertEquals(operationsPage.getDataBaseCondition(conditionOfDataBase), conditionOfDataBase);
    }

    @Step
    public void fillNewVipData(String firstName, String lastName, String gender, String category){
        operationsPage.fillNewVipData(firstName, lastName, gender, category);
        this.sentVipData.add(firstName+" "+lastName+" "+gender+" "+category);
    }

    @Step
    public void compareVipCountCondition (String expectedVipCountCondition){
        Assert.assertEquals(expectedVipCountCondition, operationsPage.getVipCountCondition());
    }
    
    @Step
    public void compareVipsData(){
        ArrayList<String> actualResult = operationsPage.getVipDataFromTable();
        for (int i=0; i<this.sentVipData.size(); i++) {
            Assert.assertEquals(this.sentVipData.get(i), actualResult.get(i));
        }
    }
    
    @Step
    public void findButtonOnPageByTitle(String buttonTitle){
        String actualResult = operationsPage.findButtonOnPageByTitle(buttonTitle);
        Assert.assertEquals(buttonTitle,actualResult);
    }
    
    @Step
    public void checkConditionOfButton (String buttonTitle, String buttonCondition){
        String actualResult = operationsPage.getButtonCondition(buttonTitle);
        Assert.assertEquals(buttonCondition,actualResult);
    }
    
    @Step
    public void comparePopUpWindowsMessage(String popUpWindowsMessage){
        String actualResult = operationsPage.getPopUpWindowsMessage();
        Assert.assertEquals(popUpWindowsMessage,actualResult);
    }
    
    @Step
    public void checkVipsLineByNumber (int number){
        operationsPage.checkVipsLineByNumber(number);
    }
    
    @Step
    public void compareLineQuantityInVipsTable(int expectedQuantity){
        int actualResult = operationsPage.countLineInVipsTable();
        Assert.assertEquals(expectedQuantity,actualResult);
    }
    
    @Step
    public void checkResultOfDeleteOperation(int deletedVipNumber){
        this.sentVipData.remove(deletedVipNumber-1);
        ArrayList<String> actualResult = operationsPage.getVipDataFromTable();
        for (int i=0; i<this.sentVipData.size(); i++) {
            Assert.assertEquals(this.sentVipData.get(i), actualResult.get(i));
        }
    }
    
    @Step
    public void fillVipFirstName(String firstName){
        operationsPage.fillVipFirstName(firstName);
    }

    @Step
    public void fillVipLastName(String lastName){
        operationsPage.fillVipLastName(lastName);
    }

    @Step
    public void goToMainPage (String requiredDataBaseCondition) {
        operationsPage.open();
            if("Online".equals(requiredDataBaseCondition) && "Offline".equals(operationsPage.getDataBaseConditionText())){
                operationsPage.clickButtonByTitle("Connect...");
            }
            if("Offline".equals(requiredDataBaseCondition) && "Online".equals(operationsPage.getDataBaseConditionText())){
                operationsPage.clickButtonByTitle("Disconnect...");
                waitABit(3000);
            }
        }
            
}
